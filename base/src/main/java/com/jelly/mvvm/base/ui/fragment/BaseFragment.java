package com.jelly.mvvm.base.ui.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jelly.mvvm.base.common.BaseConstant;
import com.jelly.mvvm.base.utils.ColumnUtil;
import com.jelly.mvvm.base.utils.LogUtil;
import com.jelly.mvvm.base.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 基类
 */
public abstract class BaseFragment<VM extends BaseViewModel> extends Fragment {
    protected String TAG = "BaseViewModel";
    protected long onCreateTime;
    protected View mRootView;
    private VM mViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        TAG = getClass().getSimpleName();
        onCreateTime = System.currentTimeMillis();
        initColumnSystem();
        log("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        log("onCreateView");
        if (getLayoutResId() > 0) {
            mRootView = inflater.inflate(getLayoutResId(), null, false);
            return mRootView;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        log("onActivityCreated");
        try {
            iniView();
            iniListener();
            setViewSize();
            iniData();
        } catch (Throwable e) {
            LogUtil.getInstance().e(TAG, "onActivityCreated Throwable:" + e);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable  Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        log("onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        log("onSaveInstanceState");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    public void onConfigurationChanged(@NonNull  Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        log("onConfigurationChanged");
        initColumnSystem();
        setViewSize();
    }

    protected void log(String msg) {
        long intervalTime = System.currentTimeMillis() - onCreateTime;
        LogUtil.getInstance().d(BaseConstant.Log.PAGE_LIFE, TAG + " " + msg + ",Interval time:" + intervalTime);
    }


    private Class<VM> getViewModelClass() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return (Class<VM>) parameterizedType.getActualTypeArguments()[0];
        } else {
            throw new RuntimeException();
        }
    }

    protected VM getViewModel() {
        if (mViewModel == null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(this);
            mViewModel = viewModelProvider.get(getViewModelClass());
        }
        return mViewModel;
    }

    protected abstract int getLayoutResId();

    private void initColumnSystem() {
        ColumnUtil.init(getContext());
    }

    protected void iniView() {

    }

    protected void iniListener() {

    }

    protected void setViewSize() {

    }

    protected void iniData() {
        log("iniData");
    }
}