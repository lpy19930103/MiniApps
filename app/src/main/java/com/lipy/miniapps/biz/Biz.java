package com.lipy.miniapps.biz;

import com.lipy.miniapps.miniappslibrary.http.listener.ActionResultListener;
import com.lipy.miniapps.miniappslibrary.http.listener.IResultListener;
import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;
import com.lipy.miniapps.miniappslibrary.http.response.ServiceResult;

import okhttp3.Call;

/**
 * 请求业务
 * Created by lipy on 2017/3/8 0008.
 */
public class Biz {
    private IResultListener mView;
    private ActionService mActionService;

    public Biz(IResultListener view) {
        mView = view;
        mActionService = new ActionService();
    }

    /**
     * 首页数据请求
     * @return
     */
    public Call homeDetails() {
        return mActionService.homeDetails(mView.getReqContext(), new ActionResultListener() {

            @Override
            public void onSuccess(ServiceResult result) {
                mView.onSuccess(result);

            }

            @Override
            public void onFailure(ActionMessage result) {
                super.onFailure(result);
                mView.onFailer(result);
            }
        });
    }


}
