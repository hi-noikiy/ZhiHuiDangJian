package com.lfc.zhihuidangjianapp.ui.activity.model;

/**
 * @date: 2018/8/21
 * @autror: guojian
 * @description:
 */

public class WechatPay {
    private String prepayid;
    private String appId;
    private String nonceStr;
    private String timestamp;
    private String packageName;
    private String sign;
    private String orderId;
    private String partnerId;

    public String getPrepayid() {
        return prepayid;
    }

    public String getAppId() {
        return appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getSign() {
        return sign;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPartnerId() {
        return partnerId;
    }
}
