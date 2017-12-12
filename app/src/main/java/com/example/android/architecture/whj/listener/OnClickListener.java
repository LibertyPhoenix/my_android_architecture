package com.example.android.architecture.whj.listener;

import android.view.View;

/**
 * author: 王宏杰
 * date: Created on 17/2/24.
 */
public abstract class OnClickListener implements View.OnClickListener {
    private long lastestClickTime = 0;
    private long period = 500;

    public OnClickListener(){}

    public OnClickListener(long millsecond){
        this.period = millsecond;
    }

    @Override
    public void onClick(View v) {
        long clickTime = System.currentTimeMillis();
        if (Math.abs(clickTime - lastestClickTime) < period){
            lastestClickTime = clickTime;
            return;
        }
        lastestClickTime = clickTime;
        clickOperate();
    }

    protected abstract void clickOperate();
}
