package com.lipy.miniapps;

import android.app.Application;

/**
 * Created by Administrator on 2017/3/2.
 */

public class MiniApp extends Application {

    private static MiniApp miniApp;

    @Override
    public void onCreate() {
        super.onCreate();
        miniApp = this;
    }

    public static MiniApp getInstance() {
        return miniApp;
    }
}
