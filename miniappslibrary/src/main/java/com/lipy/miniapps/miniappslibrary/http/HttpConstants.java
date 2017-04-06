package com.lipy.miniapps.miniappslibrary.http;

import java.util.ArrayList;

/**
 * Created by lipy on 2017/3/4.
 */

public class HttpConstants {
    private static final boolean where = false;

    public static ArrayList<String> cookieLists;

    /**
     * 网络请求错误列表
     */
    public static final int ACTION_ERROR_NET_NO_NETWORK = 1000; // 没有网络
    public static final int ACTION_ERROR_NET_BUSINESS_ERR = 200; // server有返回，但是有业务错误，会附带错误描述
    public static final int ACTION_ERROR_NET_NO_RESPONSE = 404; // 没有响应
    public static final int ACTION_ERROR_NET_SYSTEM_BUSY = 1; // 系统繁忙
    public static final int ACTION_ERROR_NET_TIMEOUT = 7; // 超时
    public static final int ACTION_ERROR_NET_SINGLE_LOGIN = 409; // 单点登陆错误

//    public final static String HOME_URL = "http://192.168.1.125:8080/miniapps/";
    public final static String HOME_URL = "http://ongeesmn7.bkt.clouddn.com/miniapps/";
//    public final static String OFFIC_URL = "http://192.168.43.234:8080/miniapps/";

    public static String getUrl() {
//        if (where) {
            return HOME_URL;
//        } else {
//            return OFFIC_URL;
//        }
    }

}
