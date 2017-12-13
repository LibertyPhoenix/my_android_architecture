package com.example.android.architecture.whj.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.android.architecture.whj.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * 作用：无网络请求的BaseActivity
 * author：王宏杰.
 * date：Created on 2017/12/13.
 */
public abstract class BaseActivity extends ToolBarActivity {

    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRootContent();
        getIntentData();
        setListener();
    }

    private void setRootContent() {
        if (getContentResId() > 0) {
            addContent(getContentResId());
            mUnbinder = ButterKnife.bind(this);
        } else if (getFragment() != null) {
            addFragment(getFragment());
        } else {
            throw new NullPointerException("必须实现getContentResId()或者getFragment()方法");
        }
    }


    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.public_layout, fragment);
        transaction.commitAllowingStateLoss();
    }

    protected  int getContentResId() {
        return 0;
    }

    protected  void getIntentData() {}

    protected  void setListener() {}


    @Override
    protected void initTitleBar(HeaderBuilder builder) {

    }

    protected Fragment getFragment() {
        return null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

    }
}
