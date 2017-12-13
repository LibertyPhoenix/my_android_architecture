package com.example.android.architecture.whj.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.android.architecture.whj.R;
import com.example.android.architecture.whj.fragment.base.BaseFragment;


/**
 * 模块：课表
 * author: 王宏杰
 * date: Created on 17/2/24.
 */
public class HomeFragment extends BaseFragment {


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected int getContentResId() {
        return R.layout.fragment_home;
    }
}
