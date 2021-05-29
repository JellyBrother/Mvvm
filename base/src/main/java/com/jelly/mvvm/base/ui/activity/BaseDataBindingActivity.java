package com.jelly.mvvm.base.ui.activity;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * 基类
 */
public abstract class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity {
    protected T mBinding;

    @Override
    protected void initContentView() {
        if (getLayoutResId() > 0) {
            mBinding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutResId(), null, false);
            mBinding.setLifecycleOwner(this);
            setContentView(mBinding.getRoot());
        }
    }
}