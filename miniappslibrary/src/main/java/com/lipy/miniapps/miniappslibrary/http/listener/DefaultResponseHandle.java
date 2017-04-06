package com.lipy.miniapps.miniappslibrary.http.listener;

/**
 * Created by lipy on 2017/3/4.
 */

public class DefaultResponseHandle {

    public DownLoadResponseListener mDownLoadResponseListener;

    public Class<?> mClass;

    public String mSource;


    public DefaultResponseHandle(DownLoadResponseListener defaultResponseListener) {
        mDownLoadResponseListener = defaultResponseListener;
    }

    public DefaultResponseHandle(DownLoadResponseListener defaultResponseListener, Class clazz) {
        mDownLoadResponseListener = defaultResponseListener;
        mClass = clazz;
    }

    public DefaultResponseHandle(DownLoadResponseListener listener, String source) {
        this.mDownLoadResponseListener = listener;
        this.mSource = source;
    }
}
