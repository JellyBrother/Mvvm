package com.jelly.mvvm.home.common;

import android.app.Application;

import androidx.fragment.app.Fragment;

import com.jelly.mvvm.base.utils.LogUtil;
import com.jelly.mvvm.bridge.interfaces.IModel;
import com.jelly.mvvm.home.ui.fragment.HomeFra;

import java.util.HashMap;

public class HomeModel implements IModel {
    private static final String TAG = "HomeModel";

    @Override
    public void onApplicationCreate(Application application) {
        LogUtil.getInstance().d(TAG, "onApplicationCreate");
    }

    @Override
    public Fragment getHomeFragment() {
        LogUtil.getInstance().d(TAG, "getHomeFragment");
        return new HomeFra();
    }

    @Override
    public void jumpPage(int jumpCode, HashMap<Object, Object> jumpData) {
        LogUtil.getInstance().d(TAG, "jumpPage");
    }
}
