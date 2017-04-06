package com.lipy.miniapps.miniappslibrary.http.message;

/**
 * Created by lipy on 2017/3/4.
 */

public class MsgAction extends DefaultMsgAction {

    @Override
    public String loginAnother() {
        clearUseData();
        return super.loginAnother();
    }

    /**
     * ******
     * 清理基本信息
     */
    private void clearUseData() {

    }
}
