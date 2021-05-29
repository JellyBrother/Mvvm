package com.jelly.mvvm.ui.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jelly.mvvm.R;
import com.jelly.mvvm.base.common.ARouterConstant;
import com.jelly.mvvm.base.ui.fragment.BaseFragment;
import com.jelly.mvvm.base.viewmodel.BaseViewModel;

public class MainFra extends BaseFragment<BaseViewModel> {
    private TextView tvwTest;

    @Override
    protected int getLayoutResId() {
        return R.layout.main_fra;
    }

    @Override
    protected void iniView() {
        super.iniView();
        tvwTest = mRootView.findViewById(R.id.tvw_test);
    }

    @Override
    protected void iniData() {
        super.iniData();
        tvwTest.setText("MainFra");
    }

    @Override
    protected void iniListener() {
        super.iniListener();
        tvwTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConstant.PostDetail.MAIN).navigation();
            }
        });
    }
}