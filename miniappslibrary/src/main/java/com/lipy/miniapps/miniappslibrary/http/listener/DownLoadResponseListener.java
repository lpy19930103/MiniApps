package com.lipy.miniapps.miniappslibrary.http.listener;

/**
 * Created by Administrator on 2017/3/4.
 */

public interface DownLoadResponseListener {

     void onSuccess(Object objects);

     void onFailure(Object objects);

     void onProgress(int progrss);
}
