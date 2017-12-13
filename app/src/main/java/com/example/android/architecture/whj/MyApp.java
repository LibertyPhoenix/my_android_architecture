package com.example.android.architecture.whj;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.android.architecture.whj.util.ContextUtils;
import com.example.android.architecture.whj.util.ScreenUtils;

/**
 * 作用：Application类
 * author：王宏杰
 * date：Created on 2017/2/24.
 */
public class MyApp extends MultiDexApplication {

    private static Context mApplicationContext;
    private static MyApp mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mApplicationContext = this;
        MultiDex.install(this);
        ContextUtils.init(this);
        ScreenUtils.init(this);
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return mApplicationContext;
    }

    public static MyApp getInstance() {
        return mContext;
    }
}
