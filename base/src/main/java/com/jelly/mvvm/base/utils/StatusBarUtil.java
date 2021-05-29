package com.jelly.mvvm.base.utils;

import android.content.Context;

/**
 * Author：Jelly
 * Date：2021.05.29 11:10
 * Description：类描述
 */
public class StatusBarUtil {
    private static final String TAG = "StatusBarUtil";

    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Throwable e) {
            LogUtil.getInstance().e(TAG, "getStatusBarHeight Throwable:" + e);
        }
        return statusBarHeight;
    }
}
