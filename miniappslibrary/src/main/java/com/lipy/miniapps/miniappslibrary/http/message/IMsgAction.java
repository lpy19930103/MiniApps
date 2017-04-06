package com.lipy.miniapps.miniappslibrary.http.message;

/**
 * Created by lipy on 2017/3/4.
 */

public interface IMsgAction {

    /**
     * 无网络连接提示
     *
     * @return
     */
    String netDisconnected();

    /**
     * 无网络连接提示
     *
     * @return
     */
    String serverSystemBusy();

    /**
     * 超时提示语
     *
     * @return
     */
    String connectTimeout();

    /**
     * 无响应提示语
     *
     * @return
     */
    String noResponse();

    /**
     * session超时提示语
     *
     * @return
     */
    String invalidSession();

    /**
     * 异地登陆
     *
     * @return
     */
    String loginAnother();

    /**
     * 初始化失败
     *
     * @return
     */
    String initFailed();
}
