package com.jelly.mvvm.base.common;

import android.app.Application;

/**
 * Description：常量类
 */
public class BaseConstant {

    public static final class Base {
        // 跳转点击限制时间间隔
        public static final int INTERVAL_TIME_START_ACTIVITY = 1000;
        // 搜索点击限制时间间隔
        public static final int INTERVAL_TIME_SEARCH = 500;
        // Application
        public static Application application;
        // 日志打印
        public static boolean enableLog = false;
        public static boolean isDebug = false;
    }

    public static final class Log {
        public static final String PAGE_LIFE = "pageLife";
    }

    public static final class Column {
        public static final int COUNT_1 = 1;
        public static final int COUNT_2 = 2;
        public static final int COUNT_4 = 4;
        public static final int COUNT_6 = 6;
        public static final int COUNT_8 = 8;
        public static final int COUNT_9 = 9;
        public static final int COUNT_12 = 12;
    }
}
