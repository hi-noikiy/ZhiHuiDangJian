package com.lfc.zhihuidangjianapp.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.ui.activity.Act_Main;

public class LoginOutBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        BaseActivity.activityManagerUtil.finishAllActivity();  // 销毁所有活动
        Intent intent1 = new Intent(context, Act_Main.class);
        context.startActivity(intent1);
    }

}
