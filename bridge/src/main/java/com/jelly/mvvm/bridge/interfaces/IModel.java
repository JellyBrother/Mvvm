package com.jelly.mvvm.bridge.interfaces;

import android.app.Application;

import androidx.fragment.app.Fragment;

import java.util.HashMap;

/**
 * Description：home模块的桥接
 */
public interface IModel {
    void onApplicationCreate(Application application);

    Fragment getHomeFragment();

    void jumpPage(int jumpCode, HashMap<Object, Object> jumpData);
}
