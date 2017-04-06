package com.lipy.miniapps.miniappslibrary.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * log utils
 * Created by lipy on 2017/3/8 0008.
 */
public class Log {
    public static boolean openLog = AppConfig.LOG_PRINT;

    public static boolean fileLog = AppConfig.FILE_LOG_PRINT;

    public static String TAG = "MINI_APP";

    public static void d(String msg) {
        d(null, msg);
    }

    public static void d(String tag, String msg) {
        d(tag, msg, null);
    }


    public static void d(String msg, Throwable tr) {
        d(null, msg, tr);

    }

    public static void d(String tag, String msg, Throwable tr) {
        if (openLog) {
            dealMsg(LogType.d, dealTag(tag), msg + getErrorInfo(tr));
        }
    }

    public static void e(String msg) {
        e(null, msg);
    }

    public static void e(String tag, String msg) {
        e(tag, msg, null);

    }

    public static void e(String msg, Throwable tr) {
        e(null, msg, tr);

    }

    public static void e(String tag, String msg, Throwable tr) {
        if (openLog) {
            dealMsg(LogType.e, dealTag(tag), msg + getErrorInfo(tr));
        }
    }

    public static void i(String msg) {
        i(null, msg);
    }

    public static void i(String tag, String msg) {
        i(tag, msg, null);
    }

    public static void i(String msg, Throwable tr) {
        i(null, msg, tr);

    }

    public static void i(String tag, String msg, Throwable tr) {
        if (openLog) {
            dealMsg(LogType.i, dealTag(tag), msg + getErrorInfo(tr));
        }
    }

    public static void v(String msg) {
        v(null, msg);
    }

    public static void v(String tag, String msg) {
        v(tag, msg, null);

    }

    public static void v(String msg, Throwable tr) {
        v(null, msg, tr);

    }

    public static void v(String tag, String msg, Throwable tr) {
        if (openLog) {
            dealMsg(LogType.v, dealTag(tag), msg + getErrorInfo(tr));
        }
    }

    public static void w(String msg) {
        w(null, msg);
    }

    public static void w(String tag, String msg) {
        w(tag, msg, null);
    }

    public static void w(String msg, Throwable tr) {
        w(null, msg, tr);

    }

    public static void w(String tag, String msg, Throwable tr) {
        if (openLog) {
            dealMsg(LogType.w, dealTag(tag), msg + getErrorInfo(tr));
        }
    }

    public static void wtf(String msg) {
        wtf(null, msg);
    }

    public static void wtf(String tag, String msg) {
        wtf(tag, msg, null);
    }

    public static void wtf(String msg, Throwable tr) {
        wtf(null, msg, tr);

    }

    public static void wtf(String tag, String msg, Throwable tr) {
        if (openLog) {
            dealMsg(LogType.wtf, dealTag(tag), msg + getErrorInfo(tr));
        }
    }

    /**
     * 解决报文过长，打印不全的问题！
     */
    private static void dealMsg(LogType logType, String tag, String msg) {
        int length = msg.length();
        int offset = 3000;
        if (length > offset) {
            int n = 0;
            for (int i = 0; i < length; i += offset) {
                n += offset;
                if (n > length) {
                    n = length;
                }
                printMsg(logType, tag, msg.substring(i, n));
            }
        } else {
            printMsg(logType, tag, msg);
        }
    }

    private static String dealTag(String tag) {
        return (TextUtils.isEmpty(tag)) ? TAG : tag;

    }

    private static void printMsg(LogType logType, String tag, String msg) {
        log2File(tag + ":" + msg);

        switch (logType) {
            case d:
                android.util.Log.d(tag, msg);
                break;
            case i:
                android.util.Log.i(tag, msg);
                break;
            case e:
                android.util.Log.e(tag, msg);
                break;
            case v:
                android.util.Log.v(tag, msg);
                break;
            case w:
                android.util.Log.w(tag, msg);
                break;
            case wtf:
                android.util.Log.wtf(tag, msg);
                break;

        }

    }


    private enum LogType {
        d, i, e, v, w, wtf
    }

    /**
     * 记录日志到文件中。
     */
    public static void log2File(String msg) {
        if (fileLog) {
            log2File("mini_app_log.txt", getTime() + ":" + msg);
        }
    }

    private static String getErrorInfo(Throwable tr) {
        if (tr == null) {
            return "";
        }
        Writer writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        tr.printStackTrace(pw);
        pw.close();
        String error = writer.toString();
        return "\n" + error;
    }

    public static void log2File(String var0, String var1) {
        try {
            File var2 = Environment.getExternalStorageDirectory();
            File var5 = new File(var2, var0);

            try {
                if(!var5.exists()) {
                    var5.createNewFile();
                }
            } catch (Exception var3) {
                var3.printStackTrace();
                return;
            }

            FileWriter var6 = new FileWriter(var5, true);
            BufferedWriter var7;
            (var7 = new BufferedWriter(var6)).write(var1);
            var7.write("\n");
            var7.flush();
            var7.close();
            var6.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return localSimpleDateFormat.format(date);
    }
}
