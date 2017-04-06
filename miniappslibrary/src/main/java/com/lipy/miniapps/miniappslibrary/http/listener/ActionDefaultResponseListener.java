package com.lipy.miniapps.miniappslibrary.http.listener;

import android.content.Context;
import android.widget.Toast;

import com.lipy.miniapps.miniappslibrary.http.HttpConstants;
import com.lipy.miniapps.miniappslibrary.http.response.DateObj;
import com.lipy.miniapps.miniappslibrary.http.response.ServiceResult;
import com.lipy.miniapps.miniappslibrary.http.message.ActionMessage;
import com.lipy.miniapps.miniappslibrary.http.message.MsgActionFactory;

/**
 * 请求回调 处理错误信息 可自定义
 * Created by lipy on 2017/3/4.
 */

public class ActionDefaultResponseListener<RES extends DateObj> extends ActionResultListener<RES> {

    protected Context mContext;

    private boolean showBusinessError = true;

    private boolean showNetError = true;

    public ActionDefaultResponseListener(Context context) {
        this(context, true);
    }

    public ActionDefaultResponseListener(Context context, boolean showBusinessError) {
        this(context, showBusinessError, true);
    }

    /**
     * @param context           是实现IRequestResultListener
     * @param showBusinessError 业务错误是否toast提示
     * @param showNetError      网络错误是否展示
     */
    public ActionDefaultResponseListener(Context context, boolean showBusinessError, boolean showNetError) {
        this.mContext = context;
        this.showNetError = showNetError;
        this.showBusinessError = showBusinessError;
    }

    @Override
    public void onSuccess(ServiceResult<RES> result) {

    }

    @Override
    public void onFailure(ActionMessage result) {
        super.onFailure(result);
        if (result != null) {
            switch (result.getNetCode()) {
                case HttpConstants.ACTION_ERROR_NET_BUSINESS_ERR:
                    if (showBusinessError) {
                        showWarningMessage(mContext, result.getMessage());
                    }
                    break;
                case HttpConstants.ACTION_ERROR_NET_NO_NETWORK:
                    if (showNetError) {
                        showWarningMessage(mContext, MsgActionFactory.getMsgAction().netDisconnected());
                    }
                    break;
                case HttpConstants.ACTION_ERROR_NET_NO_RESPONSE:
                    if (showNetError) {
                        showWarningMessage(mContext, MsgActionFactory.getMsgAction().noResponse());
                    }
                    break;
                case HttpConstants.ACTION_ERROR_NET_SYSTEM_BUSY:
                    if (showNetError) {
                        showWarningMessage(mContext, MsgActionFactory.getMsgAction().serverSystemBusy());
                    }
                    break;
                case HttpConstants.ACTION_ERROR_NET_TIMEOUT:
                    if (showNetError) {
                        showWarningMessage(mContext, MsgActionFactory.getMsgAction().connectTimeout());
                    }
                    break;
                case HttpConstants.ACTION_ERROR_NET_SINGLE_LOGIN:
                    showWarningMessage(mContext, MsgActionFactory.getMsgAction().loginAnother());
                    break;
                default:
                    break;
            }

        }
    }

    private void showWarningMessage(final Context context, String strMsg) {
        Toast.makeText(context, strMsg, Toast.LENGTH_SHORT).show();
    }
}
