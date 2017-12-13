/**
 *  create by wanghongjie on 2017-12-12
 */

package com.example.android.architecture.whj.activity;

import android.os.Bundle;

import com.example.android.architecture.whj.R;
import com.example.android.architecture.whj.activity.base.BaseActivity;


public class TestActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.setTitle("功能列表");
    }
}
