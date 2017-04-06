package com.lipy.miniapps.miniappslibrary.http.request;

import android.util.Log;

import com.google.gson.Gson;
import com.lipy.miniapps.miniappslibrary.http.HttpConstants;
import com.lipy.miniapps.miniappslibrary.http.response.DateObj;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * build the request
 * Created by lipy on 2017/3/4.
 */

public class BusinessRequest<REQ> {

    public Request request(REQ requestParam, String url) {
        try {
            String[] urladr = requestParam.getClass().getName().split("\\.");
            if (urladr.length > 0) {
                url = url + urladr[urladr.length - 1] + ".json";
            }
            Log.e("lipy", "request url: " + url);
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(JSON, encrypt(requestParam));
            return new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*************
     * 把请求参数合并后返回
     *
     * @param param 请求参数对象
     * @return String
     */
    private String encrypt(REQ param) {
        String str = "";
        try {
            Gson gson = new Gson();
            BusinessRequestParams<DateObj> requestParams = new BusinessRequestParams<>();
            requestParams.setDevType("1");
            requestParams.setFormat("JSON");
            requestParams.setTimestamp(System.currentTimeMillis() + "");
            requestParams.setDto((DateObj) param);
            str = gson.toJson(requestParams);
            // str = URLEncoder.encode(str.substring(0, str.length()), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
