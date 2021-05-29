package com.jelly.mvvm.base.viewmodel;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;

import com.jelly.mvvm.base.utils.LogUtil;

/**
 * 基类
 */
public class BaseViewModel extends ViewModel {
    protected String TAG = "BaseViewModel";

    public BaseViewModel() {
        try {
            TAG = getClass().getSimpleName();
            iniData();
        } catch (Throwable e) {
            LogUtil.getInstance().e(TAG, "BaseViewModel Throwable:" + e);
        }
    }

    protected void iniData() {

    }
}