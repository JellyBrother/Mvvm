package com.jelly.mvvm.post.publish.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jelly.mvvm.base.common.ARouterConstant;
import com.jelly.mvvm.base.ui.activity.BaseActivity;
import com.jelly.mvvm.base.viewmodel.BaseViewModel;
import com.jelly.mvvm.post.publish.R;

@Route(path = ARouterConstant.PostPublish.MAIN)
public class PostPublishAct extends BaseActivity<BaseViewModel> {
    private TextView tvwTest;

    @Override
    protected int getLayoutResId() {
        return R.layout.atc_post_publish;
    }

    @Override
    protected void iniView() {
        super.iniView();
        tvwTest = findViewById(R.id.tvw_test);
    }

    @Override
    protected void iniData() {
        super.iniData();
        tvwTest.setText("PostPublishAct");
    }

    @Override
    protected void iniListener() {
        super.iniListener();
        tvwTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}