package com.lfc.zhihuidangjianapp.app;

import android.content.Context;

import com.hjq.toast.ToastUtils;
import com.hyphenate.chatuidemo.DemoApplication;
import com.hyphenate.chatuidemo.DemoHelper;
import com.lfc.zhihuidangjianapp.bean.LoginBean;
import com.lfc.zhihuidangjianapp.image.ImageLoader;

public class MyApplication extends DemoApplication {

    private volatile static MyApplication sBaseApplication;
    private static MyApplication app;
    public static MyApplication getApp() {
        return app;
    }
    public static LoginBean.DataBean loginBean;

    public static LoginBean.DataBean getLoginBean() {
        return loginBean;
    }

    public static void setLoginBean(LoginBean.DataBean loginBean) {
        MyApplication.loginBean = loginBean;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        sBaseApplication = this;
        // 初始化吐司工具类
        ToastUtils.init(this);
        // 初始化图片加载器
        ImageLoader.init(this);

        // 环信初始化
        DemoHelper.getInstance().init(app);
    }
    public static Context getAppContext() {
        if (sBaseApplication == null) {
            synchronized (MyApplication.class) {
                if (sBaseApplication == null) {
                    sBaseApplication = new MyApplication();
                }
            }
        }
        return sBaseApplication;
    }

    public static MyApplication getApplication() {
        return sBaseApplication;
    }
}
