package com.example.android.architecture.whj.util;

import android.content.Context;

/**
 * 作用：获取上下文
 * author：王宏杰.
 * date：Created on 2017/2/24.
 */
public class ContextUtils {
    private static Context sContext;

    private ContextUtils() {

    }

    public static void init(Context context) {
        sContext = context;
    }

    public static Context getInstance() {
        if (sContext == null) {
            throw new NullPointerException("the context is null,please init ContextUtils in Application first.");
        }
        return sContext;
    }
}
