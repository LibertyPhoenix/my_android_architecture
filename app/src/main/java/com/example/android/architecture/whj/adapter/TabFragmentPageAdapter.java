package com.example.android.architecture.whj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * 基类 Tab切换
 */
public abstract class TabFragmentPageAdapter extends FragmentPagerAdapter {
    private List<String> titleList;

    private Fragment currentFragment;

    public TabFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabFragmentPageAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        titleList = titles;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = geFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titleList == null || titleList.size() == 0) {
            return "";
        }
        return titleList.get(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        currentFragment = (Fragment) object;
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    protected abstract Fragment geFragment(int position);

}
