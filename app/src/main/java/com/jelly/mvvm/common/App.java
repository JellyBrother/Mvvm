package com.jelly.mvvm.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jelly.mvvm.base.common.BaseConstant;
import com.jelly.mvvm.bridge.utils.ModelManager;

/**
 * 主程序入口
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppConstant.init(this);
        initARouter(BaseConstant.Base.application);
        ModelManager.init(BaseConstant.Base.application);
        ModelManager.onApplicationCreate(BaseConstant.Base.application);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }

    private void initARouter(Application application) {
        if (BaseConstant.Base.isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
    }
}