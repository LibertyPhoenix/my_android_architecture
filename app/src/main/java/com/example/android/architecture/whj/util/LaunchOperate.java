package com.example.android.architecture.whj.util;

import android.content.Context;
import android.content.Intent;

import com.example.android.architecture.whj.activity.TestActivity;


/**
 * 作用：跳转类工具
 * author: 王宏杰
 * date: Created on 2017/12/12.
 */
public class LaunchOperate {

    /**
     * 跳转 测试页 （功能列表页）
     *
     * @param context
     */
    public static void openTestActivity(Context context) {
        Intent intent = new Intent(context, TestActivity.class);
        context.startActivity(intent);
    }
}
