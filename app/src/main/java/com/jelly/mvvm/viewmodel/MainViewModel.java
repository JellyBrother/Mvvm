package com.jelly.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.jelly.mvvm.base.viewmodel.BaseViewModel;

/**
 * 基类
 */
public class MainViewModel extends BaseViewModel {
    private MutableLiveData<String> mText;

    @Override
    protected void iniData() {
        super.iniData();
        getText().setValue("MainViewModel");
    }

    public MutableLiveData<String> getText() {
        if ((mText == null)) {
            mText = new MutableLiveData<>();
        }
        return mText;
    }
}