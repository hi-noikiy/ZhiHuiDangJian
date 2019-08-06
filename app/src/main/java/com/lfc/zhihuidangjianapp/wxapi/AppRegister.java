package com.lfc.zhihuidangjianapp.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lfc.zhihuidangjianapp.pay.WechatApi;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * @date: 2018/8/27
 * @autror: guojian
 * @description:
 */

public class AppRegister extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final IWXAPI api = WXAPIFactory.createWXAPI(context, WechatApi.mAppid,false);
        api.registerApp(WechatApi.mAppid);
    }
}
