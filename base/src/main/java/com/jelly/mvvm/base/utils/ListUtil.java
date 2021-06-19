package com.jelly.mvvm.base.utils;

import java.util.List;

/**
 * Author：Jelly
 * Date：2021.05.29 11:10
 * Description：类描述
 */
public class ListUtil {
    private static final String TAG = "ListUtil";

    public static boolean isEmpty(List list) {
        if (list == null) {
            return true;
        }
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object[] list) {
        if (list == null) {
            return true;
        }
        if (list.length < 1) {
            return true;
        }
        return false;
    }
}
