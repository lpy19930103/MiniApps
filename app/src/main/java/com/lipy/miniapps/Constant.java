package com.lipy.miniapps;

import android.os.Environment;

/**
 * Created by Administrator on 2017/3/6.
 */

public class Constant {

    //整个应用文件下载保存路径
    public static String APP_PHOTO_DIR = Environment.
            getExternalStorageDirectory().getAbsolutePath().
            concat("/mini_app/photo/");
}
