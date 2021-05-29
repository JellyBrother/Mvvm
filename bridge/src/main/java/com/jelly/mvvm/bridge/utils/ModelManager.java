package com.jelly.mvvm.bridge.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.jelly.mvvm.base.utils.LogUtil;
import com.jelly.mvvm.bridge.common.ModelConstant;
import com.jelly.mvvm.bridge.interfaces.IModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ModelManager {
    private static final String TAG = "ModelManager";
    private static HashMap<String, IModel> modelMap = new HashMap<>();
    private static HashSet<String> modelInterfaceCodeList = new HashSet();

    public static void init(Application app) {
        modelInterfaceCodeList.clear();
        modelInterfaceCodeList.add(ModelConstant.JELLY_MVVM_HOME);

        try {
            ApplicationInfo applicationInfo = app.getPackageManager().getApplicationInfo(app.getPackageName(), PackageManager.GET_META_DATA);
            putModel(applicationInfo, ModelConstant.JELLY_MVVM_HOME);
        } catch (Throwable e) {
            LogUtil.getInstance().e(TAG, "init Throwable:" + e);
        }
    }


    public static IModel getModel(String modelCode) {
        if (!modelInterfaceCodeList.contains(modelCode)) {
            return null;
        }
        return modelMap.get(modelCode);
    }

    public static void putModel(ApplicationInfo info, String code) throws Exception {
        String classPath = info.metaData.getString(code);
        Class<?> clazz = Class.forName(classPath);
        Object homeModel = clazz.newInstance();
        if (homeModel instanceof IModel) {
            putModel(ModelConstant.JELLY_MVVM_HOME, (IModel) homeModel);
        }
    }

    public static void putModel(String modelCode, IModel model) {
        if (!modelInterfaceCodeList.contains(modelCode)) {
            return;
        }
        modelMap.put(modelCode, model);
    }

    public static void onApplicationCreate(Application application) {
        for (Map.Entry<String, IModel> entry : modelMap.entrySet()) {
            String mapKey = entry.getKey();
            IModel mapValue = entry.getValue();
            mapValue.onApplicationCreate(application);
        }
    }
}
