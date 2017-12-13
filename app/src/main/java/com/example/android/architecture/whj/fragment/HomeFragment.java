package com.example.android.architecture.whj.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.android.architecture.whj.R;
import com.example.android.architecture.whj.fragment.base.BaseFragment;
import com.example.android.architecture.whj.util.LaunchOperate;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 模块：首页
 * author: 王宏杰
 * date: Created on 2017/12/12.
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.test_tv)
    TextView testTV;

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

    @OnClick(R.id.test_tv)
    public void testClick() {
        LaunchOperate.openTestActivity(getActivity());
    }


}
