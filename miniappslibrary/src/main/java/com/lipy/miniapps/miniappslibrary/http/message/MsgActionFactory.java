package com.lipy.miniapps.miniappslibrary.http.message;

/**
 * Created by lipy on 2017/3/4.
 */

public class MsgActionFactory {

    public static IMsgAction getMsgAction() {
        return new MsgAction();
    }
}
