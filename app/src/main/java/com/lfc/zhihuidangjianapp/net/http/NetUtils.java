package com.lfc.zhihuidangjianapp.net.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.lfc.zhihuidangjianapp.app.MyApplication;


public class NetUtils {
    public static boolean isConnected() {
        Context context = MyApplication.getAppContext();
        if(null != context){
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
