package com.example.android.architecture.whj.fragment.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: 王宏杰
 * date: Created on 17/2/24.
 */
public abstract class BaseFragment extends UmengFragment {
    private View mRootLayout;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        mRootLayout = inflater.inflate(getContentResId(), null);
        mUnbinder = ButterKnife.bind(this, mRootLayout);
        return mRootLayout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    protected abstract int getContentResId();

    protected <VG extends View> VG getViewById(int resId) {
        return (VG) mRootLayout.findViewById(resId);
    }

}
