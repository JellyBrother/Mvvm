package com.jelly.mvvm.base.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * 基类
 */
public abstract class BaseDataBindingFragment<T extends ViewDataBinding> extends BaseFragment {
    protected T mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        log("onCreateView");
        if (getLayoutResId() > 0) {
            mBinding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutResId(), null, false);
            mBinding.setLifecycleOwner(this);
            mRootView = mBinding.getRoot();
            return mRootView;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}