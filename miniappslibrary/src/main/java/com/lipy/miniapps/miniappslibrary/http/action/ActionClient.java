package com.lipy.miniapps.miniappslibrary.http.action;

import com.lipy.miniapps.miniappslibrary.http.cookie.SimpleCookieJar;
import com.lipy.miniapps.miniappslibrary.http.https.HttpsUtils;
import com.lipy.miniapps.miniappslibrary.http.listener.ActionResultListener;
import com.lipy.miniapps.miniappslibrary.http.listener.DefaultResponseHandle;
import com.lipy.miniapps.miniappslibrary.http.response.ActionCallBack;
import com.lipy.miniapps.miniappslibrary.http.response.DateObj;
import com.lipy.miniapps.miniappslibrary.http.response.FileCallBack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lipy on 2017/3/4.
 */

public class ActionClient<REQ, RES extends DateObj> {

    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return false;
            }
        });

        /**
         *  为所有请求添加请求头，看个人需求
         */
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("User-Agent", "MiniApps") // 标明发送本次请求的客户端
                        .build();
                return chain.proceed(request);
            }
        });
        builder.cookieJar(new SimpleCookieJar());
        //超时
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.followRedirects(true);

        /**
         * trust all the https point
         */
        builder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager());
        mOkHttpClient = builder.build();
    }

    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    //    /**
//     * 指定cilent信任指定证书
//     *
//     * @param certificates
//     */
//    public static void setCertificates(InputStream... certificates) {
//        mOkHttpClient.newBuilder().sslSocketFactory(HttpsUtils.getSslSocketFactory(certificates, null, null)).build();
//    }


    /**
     * 通过构造好的Request,Callback去发送请求
     */

    public Call postRequest(Request request, ActionResultListener<RES> listener) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new ActionCallBack<RES>(listener, listener.getType()));
        return call;
    }

    public Call downloadFile(Request request, DefaultResponseHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new FileCallBack(handle));
        return call;
    }
}
