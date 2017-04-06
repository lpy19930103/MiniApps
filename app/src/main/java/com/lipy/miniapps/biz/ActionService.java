package com.lipy.miniapps.biz;


import com.google.gson.reflect.TypeToken;

import com.lipy.miniapps.dto.HomeData;
import com.lipy.miniapps.miniappslibrary.http.action.Action;
import com.lipy.miniapps.miniappslibrary.http.listener.ActionDefaultResponseListener;
import com.lipy.miniapps.miniappslibrary.http.listener.ActionResultListener;
import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;
import com.lipy.miniapps.miniappslibrary.http.response.ServiceResult;

import android.content.Context;

import java.lang.reflect.Type;

import okhttp3.Call;

/**
 * 请求服务
 * Created by lipy on 2017/3/8 0008.
 */
public class ActionService {

    public Call homeDetails(Context context, final ActionResultListener actionResultListener) {
        HomeData text = new HomeData();
        Action<HomeData, HomeData> texttextAction = new Action();
        return texttextAction.requestAction(context, text,
                new ActionDefaultResponseListener<HomeData>(context) {
                    @Override
                    public void onFailure(ActionMessage message) {
                        super.onFailure(message);
                        actionResultListener.onFailure(message);
                    }

                    @Override
                    public void onSuccess(ServiceResult<HomeData> result) {
                        actionResultListener.onSuccess(result);
                    }

                    @Override
                    public Type getType() {
                        return new TypeToken<ServiceResult<HomeData>>() {
                        }.getType();
                    }
                });
    }
}
