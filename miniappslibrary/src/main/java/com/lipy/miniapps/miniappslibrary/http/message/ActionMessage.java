package com.lipy.miniapps.miniappslibrary.http.message;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by lipy on 2017/3/4.
 */

public class ActionMessage<P> implements Serializable{

    private P object;
    private String message;
    private String[] params;
    private int netCode;// 网络和mas返回的错误码
    private String code;// 业务返回的错误码
    private String tranCode;//业务代码，接口名称

    public ActionMessage(String message) {
        this.message = message;
    }

    public ActionMessage(int netCode) {
        this.netCode = netCode;
    }

    public ActionMessage(String messge, int netCode) {
        this.message = messge;
        this.netCode = netCode;
    }

    public ActionMessage(String messge, String... params) {
        this.message = messge;
        this.params = params;
    }

    public ActionMessage(P object, String message, String... params) {
        this.object = object;
        this.message = message;
        this.params = params;
    }

    public ActionMessage(int netCode, String tranCode) {
        this.netCode = netCode;
        this.tranCode = tranCode;
    }

    public ActionMessage(P object, String message, String tranCode) {
        this.object = object;
        this.message = message;
        this.tranCode = tranCode;
    }

    public ActionMessage(P object, String message, int netCode, String code) {
        this.object = object;
        this.message = message;
        this.netCode = netCode;
        this.code = code;
    }

    public ActionMessage(P object, String message, int netCode, String code, String tranCode) {
        this.object = object;
        this.message = message;
        this.netCode = netCode;
        this.code = code;
        this.tranCode = tranCode;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getMessage() {
        if (params == null) return message;
        return String.format(Locale.getDefault(), message, (Object)params);
    }

    public P getObject() {
        return object;
    }

    public int getNetCode() {
        return netCode;
    }

    public String getCode() {
        if (code == null) {
            return "";
        }
        return code;
    }
}
