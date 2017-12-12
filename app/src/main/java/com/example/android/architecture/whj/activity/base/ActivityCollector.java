package com.example.android.architecture.whj.activity.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用：
 * author：田楠楠.
 * date：Created on 2017/2/8.
 */
public class ActivityCollector {
    public static List<Activity> activityList = new ArrayList<>();

    //将Activity加入集合
    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    //将Activity移除集合
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    //关闭所有Activity
    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    //关闭除了自身以外的所有Activity
    public static void finishAllWithoutMyself() {
        for (int i = 0; i < activityList.size() - 1; i++) {
            if (!activityList.get(i).isFinishing()) {
                activityList.get(i).finish();
            }
        }
    }
}
