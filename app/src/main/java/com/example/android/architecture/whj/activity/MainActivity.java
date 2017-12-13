/**
 *  create by wanghongjie on 2017-12-12
 */

package com.example.android.architecture.whj.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.architecture.whj.R;
import com.example.android.architecture.whj.activity.base.BaseActivity;
import com.example.android.architecture.whj.adapter.TabFragmentPageAdapter;
import com.example.android.architecture.whj.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.BindViews;


public class MainActivity extends BaseActivity {

    private int count = 0;

    @BindView(R.id.activity_main_vp)
    ViewPager tabVP;
    @BindViews({R.id.tab_rb_1,R.id.tab_rb_2,R.id.tab_rb_3,R.id.tab_rb_4})
    List<RadioButton> mRadioButtonList;
    @BindView(R.id.tab_rg_menu)
    RadioGroup tabRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHeaderBuilder.goneToolbar();
        initViewPager();
    }

    private void initViewPager() {

        List<String> title = new ArrayList<>();
        title.add("");
        title.add("");
        title.add("");
        title.add("");
        TabFragmentPageAdapter pageAdapter = new TabFragmentPageAdapter(getSupportFragmentManager
                (), title) {
            @Override
            protected Fragment geFragment(int position) {
                switch (position) {
                    case 0:
                        return HomeFragment.newInstance();
                    case 1:
                        return HomeFragment.newInstance();
                    case 2:
                        return HomeFragment.newInstance();
                    case 3:
                        return HomeFragment.newInstance();
                }
                return null;
            }
        };
        tabVP.setAdapter(pageAdapter);

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_main;
    }


    @Override
    protected void setListener() {

        tabVP.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mRadioButtonList.get(position).setChecked(true);
            }
        });
        tabRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab_rb_1:
                        tabVP.setCurrentItem(0);
                        break;
                    case R.id.tab_rb_2:
                        tabVP.setCurrentItem(1);
                        break;
                    case R.id.tab_rb_3:
                        tabVP.setCurrentItem(2);
                        break;
                    case R.id.tab_rb_4:
                        tabVP.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
            }
        });
    }

//  点击两次退出App
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            count++;
            if (count == 1) {
                Toast.makeText(this, "再点一次返回键退出App", Toast.LENGTH_SHORT).show();
            }
            Timer timer = new Timer();
            timer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            count = 0;
                        }
                    }, 2000
            );

            if (count == 2) {
                finish();
            }
        }
        return false;
    }

}
