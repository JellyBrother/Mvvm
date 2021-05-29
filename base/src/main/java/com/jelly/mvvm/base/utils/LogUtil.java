package com.jelly.mvvm.base.utils;

import android.util.Log;

import com.jelly.mvvm.base.common.BaseConstant;

public class LogUtil {

    private static final LogUtil mLogUtil = new LogUtil();

    private LogUtil() {
    }

    public static LogUtil getInstance() {
        return mLogUtil;
    }

    public void v(String tag, String str) {
        if (BaseConstant.Base.enableLog) {
            Log.v(tag, str);
        }
    }

    public void d(String tag, String str) {
        if (BaseConstant.Base.enableLog) {
            Log.d(tag, str);
        }
    }

    public void i(String tag, String str) {
        if (BaseConstant.Base.enableLog) {
            Log.d(tag, str);
        }
    }

    public void w(String tag, String str) {
        if (BaseConstant.Base.enableLog) {
            Log.d(tag, str);
        }
    }

    public void e(String tag, String str) {
        if (BaseConstant.Base.enableLog) {
            Log.d(tag, str);
        }
    }
}