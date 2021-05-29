package com.jelly.mvvm.common;

import android.app.Application;

import com.jelly.mvvm.BuildConfig;
import com.jelly.mvvm.base.common.BaseConstant;

public class AppConstant {
    public static void init(Application application) {
        BaseConstant.Base.application = application;
        BaseConstant.Base.enableLog = BuildConfig.DEBUG;
        BaseConstant.Base.isDebug = BuildConfig.DEBUG;
    }

    public static final class App {
        public static final int LOAD_MORE_STATE_INIT = 0;
    }
}
