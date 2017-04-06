package com.lipy.miniapps.miniappslibrary.http.action;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.lipy.miniapps.miniappslibrary.http.HttpConstants;
import com.lipy.miniapps.miniappslibrary.http.listener.ActionDefaultResponseListener;
import com.lipy.miniapps.miniappslibrary.http.listener.DefaultResponseHandle;
import com.lipy.miniapps.miniappslibrary.http.listener.DownLoadResponseListener;
import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;
import com.lipy.miniapps.miniappslibrary.http.request.BusinessRequest;
import com.lipy.miniapps.miniappslibrary.http.request.DefaultRequest;
import com.lipy.miniapps.miniappslibrary.http.response.DateObj;

import okhttp3.Call;

import static android.app.DownloadManager.Request.NETWORK_MOBILE;
import static android.app.DownloadManager.Request.NETWORK_WIFI;

/**
 * 请求包装类
 * Created by lipy on 2017/3/5.
 */

public class Action<REQ extends DateObj, RES extends DateObj> {

    protected static final String TAG = Action.class.getSimpleName();


    /******
     * 请求方法
     *
     * @param context      上下文
     * @param requestParam 请求参数
     * @param listener     结果回调参数
     */
    public Call requestAction(Context context, REQ requestParam, ActionDefaultResponseListener<RES> listener) {
        return requestAction(context, requestParam, HttpConstants.getUrl(), listener);
    }

    public Call requestAction(Context context, REQ requestParam, String url, ActionDefaultResponseListener<RES> listener) {
        Call requestHandle = null;
        // 判断网络是否可用
        if (getNetworkState(context) == 0) {
            if (listener != null) {
                listener.onFailure(new ActionMessage(HttpConstants.ACTION_ERROR_NET_NO_NETWORK, listener.getRClass().getSimpleName()));
            }
        } else {
            final ActionClient<REQ, RES> action = new ActionClient<>();
            requestHandle = action.postRequest(new BusinessRequest<REQ>().request(requestParam, url), listener);
        }

        return requestHandle;
    }

    public Call download(Context context, String url, String path, DownLoadResponseListener listener) {
        Call requestHandle = null;
        // 判断网络是否可用
        if (getNetworkState(context) == 0) {
            if (listener != null) {
                listener.onFailure(new ActionMessage(HttpConstants.ACTION_ERROR_NET_NO_NETWORK));
            }
        } else {
            final ActionClient<REQ, RES> action = new ActionClient<>();
            requestHandle = action.downloadFile(DefaultRequest.createGetRequest(url, null),
                    new DefaultResponseHandle(listener, path));
        }

        return requestHandle;
    }

    /**
     * 获取网络状态
     *
     * @param context 上下文
     * @return 网络状态0，1，2
     */
    public static int getNetworkState(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        // Wifi
        NetworkInfo.State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return NETWORK_WIFI;
        }

        // 3G
        state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return NETWORK_MOBILE;
        }
        return 0;
    }

}
