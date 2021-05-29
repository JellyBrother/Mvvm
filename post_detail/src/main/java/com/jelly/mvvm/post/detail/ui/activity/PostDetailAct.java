package com.jelly.mvvm.post.detail.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jelly.mvvm.base.common.ARouterConstant;
import com.jelly.mvvm.base.ui.activity.BaseActivity;
import com.jelly.mvvm.base.viewmodel.BaseViewModel;
import com.jelly.mvvm.post.detail.R;


@Route(path = ARouterConstant.PostDetail.MAIN)
public class PostDetailAct extends BaseActivity<BaseViewModel> {
    private TextView tvwTest;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_post_detail;
    }

    @Override
    protected void iniView() {
        super.iniView();
        tvwTest = findViewById(R.id.tvw_test);
    }

    @Override
    protected void iniData() {
        super.iniData();
        tvwTest.setText("PostDetailAct");
    }

    @Override
    protected void iniListener() {
        super.iniListener();
        tvwTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterConstant.PostPublish.MAIN).navigation();
            }
        });
    }
}