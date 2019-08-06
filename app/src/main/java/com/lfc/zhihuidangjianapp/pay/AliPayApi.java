package com.lfc.zhihuidangjianapp.pay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

/**
 * @date: 2018/8/21
 * @autror: guojian
 * @description:支付宝支付
 */

public class AliPayApi {
    private Activity mContext;
    private String orderInfo;  //订单信息

    public AliPayApi(Activity context, String orderInfo) {
        this.mContext = context;
        this.orderInfo = orderInfo;
    }
    private AliPayCalback mAliPayCalback;

    public interface AliPayCalback {
        void success();

        void error(String msg);
    }

    public void onAlipayCallback(AliPayCalback aliPayCalback) {
        this.mAliPayCalback = aliPayCalback;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (mAliPayCalback == null) {
                return;
            }
            PayResult payResult = new PayResult((Map<String, String>) msg.obj);
            if (TextUtils.equals(payResult.getResultStatus(), "9000")) {
                mAliPayCalback.success();
            } else {
                mAliPayCalback.error(payResult.getMemo());
            }
        }
    };


    /**
     * 支付
     */
    public void payV2() {

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(mContext);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Message msg = new Message();
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


}
