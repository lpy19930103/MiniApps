package com.lipy.miniapps.miniappslibrary.http.listener;

import com.google.gson.reflect.TypeToken;
import com.lipy.miniapps.miniappslibrary.http.response.DateObj;
import com.lipy.miniapps.miniappslibrary.http.response.ServiceResult;
import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;

import java.lang.reflect.Type;

import java.lang.reflect.ParameterizedType;

/**
 * Created by lipy on 2017/3/4.
 */

public abstract class ActionResultListener<DTO extends DateObj> {

    public abstract void onSuccess(ServiceResult<DTO> result);

    public void onFailure(ActionMessage result) {

    }

    public Class getRClass() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Type getType() {
        return new TypeToken<ServiceResult<DateObj>>() {
        }.getType();
    }

}
