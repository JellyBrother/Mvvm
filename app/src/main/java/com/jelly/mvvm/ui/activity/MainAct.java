package com.jelly.mvvm.ui.activity;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jelly.mvvm.R;
import com.jelly.mvvm.base.common.ARouterConstant;
import com.jelly.mvvm.base.ui.activity.BaseActivity;
import com.jelly.mvvm.bridge.common.ModelConstant;
import com.jelly.mvvm.bridge.utils.ModelManager;
import com.jelly.mvvm.ui.fragment.MainFra;
import com.jelly.mvvm.viewmodel.MainViewModel;

public class MainAct extends BaseActivity<MainViewModel> {
    private TextView tvwTest;

    @Override
    protected int getLayoutResId() {
        return R.layout.main_act;
    }

    @Override
    protected void iniView() {
        super.iniView();
        tvwTest = findViewById(R.id.tvw_test);
    }

    @Override
    protected void iniData() {
        super.iniData();
        tvwTest.setText("MainActivity");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        MainFra mainFra = new MainFra();
//        fragmentTransaction.replace(R.id.fly_content, mainFra).commit();

        Fragment homeFragment = ModelManager.getModel(ModelConstant.JELLY_MVVM_HOME).getHomeFragment();
        fragmentTransaction.replace(R.id.fly_content, homeFragment).commit();
        getViewModel().getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvwTest.setText(s);
            }
        });
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