package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.hyphenate.chatuidemo.conference.ConferenceActivity;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.Meeting;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-25
 * @autror: guojian
 * @description:
 */
public class ConferenceActivity1 extends ConferenceActivity {
    public static final int TYPE_CREATE = 0;
    public static final int TYPE_JOIN = 1;
    protected String confId = "";
    protected String password = "";

    @Override
    public void onCreate( Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        if (enterType == TYPE_JOIN) {
            //加入会议
            confId = meeting.getConfrId();
            password = meeting.getPassword();
            //如果是创建者需要创建会议室
            if (TextUtils.isEmpty(meeting.getConfrId()) && meeting.getCreateCode().equals(MyApplication.getmUserInfo().getUser().getLoginName())) {
                createAndJoinConference(null);
            } else {//加入会议室
                joinConference();
            }
//            incomingCallView.setVisibility(View.GONE);
        }
    }

    /**
     * 创建会议上报
     */
    @Override
    public void createFinish(String confId, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("roomName", meeting.getCreateName());
        map.put("videoPwd", password);
        map.put("confrId", confId);
        map.put("meetingId", meeting.getMeetingId());
        map.put("userNumberList", meeting.getUsers());
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .createChatroom(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<Object>(this) {

                    @Override
                    protected void onNext(Object response) {
                        Log.e("onNext= ", response.toString());
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }

}
