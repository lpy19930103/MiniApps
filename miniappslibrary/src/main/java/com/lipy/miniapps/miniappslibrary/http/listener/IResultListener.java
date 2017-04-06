package com.lipy.miniapps.miniappslibrary.http.listener;

import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;
import com.lipy.miniapps.miniappslibrary.http.response.ServiceResult;

import android.content.Context;

/**
 * Created by lipy on 2017/3/8 0008.
 */
public interface IResultListener {

    Context getReqContext();

     void onSuccess(ServiceResult result);

     void onFailer(ActionMessage result);
}
