package com.lipy.miniapps.miniappslibrary.http.response;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.lipy.miniapps.miniappslibrary.http.HttpConstants;
import com.lipy.miniapps.miniappslibrary.http.listener.ActionResultListener;
import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

import static android.content.ContentValues.TAG;
import static org.apache.http.client.protocol.ClientContext.COOKIE_STORE;

/**
 * Created by lipy on 2017/3/7 0007.
 */
public class ActionCallBack<RES extends DateObj> implements Callback {

    private final ActionResultListener<RES> listener;

    private Type type;

    private Handler mDelieverHandler;


    public ActionCallBack(ActionResultListener<RES> listener, Type type) {
        this.listener = listener;
        this.type = type;
        mDelieverHandler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void onFailure(final Call call, final IOException e) {
        Log.e(TAG, "run: onFailure");
        try {
            mDelieverHandler.post(new Runnable() {
                @Override
                public void run() {
//                        if (e.getCause().toString().equals(SocketTimeoutException.class.toString())) {
//                            listener.onFailure(new ActionMessage(HttpConstants.ACTION_ERROR_NET_TIMEOUT));
//                        } else if (e.getCause().toString().equals(ConnectException.class.toString())) {
//                            listener.onFailure(new ActionMessage(HttpConstants.ACTION_ERROR_NET_NO_RESPONSE));
//                        } else {
                    listener.onFailure(new ActionMessage(HttpConstants.ACTION_ERROR_NET_NO_RESPONSE));
//                        }
                }
            });
        } catch (Exception e1) {
            e.printStackTrace();
        }

    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        Log.e(TAG, "run: onResponse:" + response.code());
        final byte[] data = response.body().bytes();
        final int statusCode = response.code();
        HttpConstants.cookieLists = handleCookie(response.headers());
        try {
            mDelieverHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (listener != null) {
                        final ServiceResult<RES> resServiceResult = formatData("", type, data);
                        ActionMessage msg;
                        if (statusCode == HttpConstants.ACTION_ERROR_NET_SINGLE_LOGIN) {
                            msg = new ActionMessage(HttpConstants.ACTION_ERROR_NET_SINGLE_LOGIN);
                            listener.onFailure(msg);//重新登录
                        } else {
                            if (data != null && data.length > 0) {
                                if (resServiceResult.getCode() != null && "0".equals(resServiceResult.getCode())) {
                                    listener.onSuccess(resServiceResult);
                                } else if (resServiceResult.getCode() == null) {
                                    msg = new ActionMessage(HttpConstants.ACTION_ERROR_NET_SYSTEM_BUSY);
                                    listener.onFailure(msg);
                                } else {
                                    listener.onFailure(new ActionMessage(resServiceResult, resServiceResult.getMessage(),
                                            HttpConstants.ACTION_ERROR_NET_BUSINESS_ERR, resServiceResult.getCode()));
                                }
                            } else {
                                msg = new ActionMessage(HttpConstants.ACTION_ERROR_NET_SYSTEM_BUSY);
                                listener.onFailure(msg);
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取cookieLists
     * @param headers
     * @return
     */
    private ArrayList<String> handleCookie(Headers headers) {
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < headers.size(); i++) {
            if (headers.name(i).equalsIgnoreCase(COOKIE_STORE)) {
                tempList.add(headers.value(i));
            }
        }
        return tempList;
    }


    /**
     * 根据指定的类型将报文映射导实体
     *
     * @param str  报文字符串
     * @param type java.lang.reflect.Type;
     */
    private ServiceResult<RES> formatData(String str, Type type,
                                          byte[] data) {
        try {
            // 检测参数有效性
            if (TextUtils.isEmpty(str) && (data == null || data.length < 1)) {
                return null;
            }
            Gson gson = new Gson();
            String s = "";
            if ("".equals(str)) {
                s = deserialize(data);
            } else {
                s = str;
            }
            return gson.fromJson(s, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 覆盖此类可以获得转换为对象前的 byte[] 原始数据
     *
     * @param response response
     * @return REQ
     */
    private String deserialize(byte[] response) throws UnsupportedEncodingException {
        if (response == null) {
            return "";
        }
        String s = new String(response);
        if (null == s || "".equals(s)) {
            s = new String(response);
        }
//        s = URLDecoder.decode(s, "UTF-8");
        return s;
    }
}
