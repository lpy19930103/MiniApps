package com.lipy.miniapps.miniappslibrary.http.message;

/**
 * 错误信息
 * Created by lipy on 2017/3/4.
 */

public class DefaultMsgAction implements IMsgAction {
    @Override
    public String netDisconnected() {
        return "网络不给力，请稍后再试";
    }

    @Override
    public String serverSystemBusy() {
        return "系统繁忙，请稍后再试";
    }

    @Override
    public String connectTimeout() {
        return "网络不给力，请稍后再试";
    }

    @Override
    public String noResponse() {
        return "系统繁忙，请稍后再试";
    }

    @Override
    public String invalidSession() {
        return null;
    }

    @Override
    public String loginAnother() {
        return "用户已在别处登录！";
    }

    @Override
    public String initFailed() {
        return null;
    }
}
