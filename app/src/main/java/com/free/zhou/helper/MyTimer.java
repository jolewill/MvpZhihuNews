package com.free.zhou.helper;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 11065 on 2016/10/26.
 */

public class MyTimer extends CountDownTimer {

    private Activity activity;
    private Class<? extends AppCompatActivity> EnterActivity;
    private long millisInFuture, countDownInterval;

    public MyTimer(long millisInFuture, long countDownInterval,
                   Activity activity, Class<? extends AppCompatActivity> EnterActivity) {
        super(millisInFuture, countDownInterval);
        this.millisInFuture = millisInFuture;
        this.countDownInterval = countDownInterval;
        this.EnterActivity = EnterActivity;
        this.activity = activity;
    }

    @Override
    public void onTick(long l) {

    }

    @Override
    public void onFinish() {
        ToActivityUtil.toNextActivityAndFinish(activity, EnterActivity);
    }
}
