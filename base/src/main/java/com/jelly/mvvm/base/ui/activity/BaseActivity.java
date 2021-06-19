package com.jelly.mvvm.base.ui.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jelly.mvvm.base.common.BaseConstant;
import com.jelly.mvvm.base.utils.ColumnUtil;
import com.jelly.mvvm.base.utils.LogUtil;
import com.jelly.mvvm.base.utils.StatusBarUtil;
import com.jelly.mvvm.base.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 基类
 */
public abstract class BaseActivity<VM extends BaseViewModel> extends FragmentActivity {
    protected String TAG = "BaseViewModel";
    private final String BUNDLE_KEY_ISONSAVEINSTANCE = "Bundle_key_IsOnSaveInstance";
    protected long onCreateTime;
    private VM mViewModel;
    protected boolean mIsOnSaveInstance = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            TAG = getClass().getSimpleName();
            onCreateTime = System.currentTimeMillis();
            log("onCreate");
            setStatusBar();
            initColumnSystem();
            setOrientation();
            initIntent(savedInstanceState);
            initContentView();
        } catch (Throwable e) {
            LogUtil.getInstance().e(TAG, "onCreate Throwable:" + e);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        log("onCreateView");
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        try {
            log("onContentChanged");
            iniView();
            iniListener();
            setViewSize();
            iniData();
        } catch (Throwable e) {
            LogUtil.getInstance().e(TAG, "onContentChanged Throwable:" + e);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        log("onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
        mIsOnSaveInstance = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        log("onSaveInstanceState");
        outState.putBoolean(BUNDLE_KEY_ISONSAVEINSTANCE, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        log("onConfigurationChanged");
        initColumnSystem();
        setViewSize();
    }

    protected void log(String msg) {
        long intervalTime = System.currentTimeMillis() - onCreateTime;
        LogUtil.getInstance().d(BaseConstant.Log.PAGE_LIFE, TAG + " " + msg + ",Interval time:" + intervalTime);
    }

    private void setStatusBar() {
        Window window = getWindow();
        /** 没有标题 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /** 没有状态栏 */
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (showStatusBar()) {
            View decorView = window.getDecorView();
            decorView.setPadding(decorView.getLeft(), decorView.getTop() + StatusBarUtil.getStatusBarHeight(this),
                    decorView.getRight(), decorView.getBottom());
        }
    }

    private void initColumnSystem() {
        ColumnUtil.init(this, getDefinition());
    }

    private void setOrientation() {
        if (ColumnUtil.columnCount > BaseConstant.Column.COUNT_4) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    protected void initIntent(Bundle bundle) {
        if (bundle != null) {
            mIsOnSaveInstance = bundle.getBoolean(BUNDLE_KEY_ISONSAVEINSTANCE, false);
        }
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

    protected void initContentView() {
        int layoutResId = getLayoutResId();
        if (layoutResId > 0) {
            View view = getLayoutInflater().inflate(layoutResId, null);
            setContentView(view);
        }
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

    protected boolean showStatusBar() {
        return true;
    }

    protected String getDefinition() {
        return ColumnUtil.DEFAULT_DEFINITION;
    }
}