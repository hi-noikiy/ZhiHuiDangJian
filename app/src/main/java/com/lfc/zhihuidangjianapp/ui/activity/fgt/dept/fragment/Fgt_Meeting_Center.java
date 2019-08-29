package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.chat.EazyChatApi;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.MeetingDetailActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.ConferenceActivity;
import com.lfc.zhihuidangjianapp.ui.activity.model.BaseResponse;
import com.lfc.zhihuidangjianapp.ui.activity.model.Meeting;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseMeetingMine;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-22
 * @autror: guojian
 * @description:
 */
public class Fgt_Meeting_Center extends BaseFragment {

    private int type;

    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview;
    }

    @Override
    protected void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        type = getArguments().getInt("type");
        Observable<BaseResponse<ResponseMeetingMine>> observable;
        if(type == 0){
            observable = RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .queryMyMeetingPageList( MyApplication.getLoginBean().getToken());
        }else if(type==1){
            observable = RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .queryMeetingPageList( MyApplication.getLoginBean().getToken());
        }else if(type==2){
            observable = RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .queryMeetingHisPageList( MyApplication.getLoginBean().getToken());
        }else{
            observable = RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .queryMeetingPageList( MyApplication.getLoginBean().getToken());
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<ResponseMeetingMine>(getActivity()) {

                    @Override
                    protected void onNext(ResponseMeetingMine response) {
                        if (response == null) return;
                        Log.e("onNext= ", response.toString());
                        setRecyclerView(response.getMeetingList().getDatas());
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());

    }

    private void setRecyclerView(List<Meeting> response) {
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));
        recyclerView.setAdapter(new CommonAdapter<Meeting>(MyApplication.getAppContext(), R.layout.item_meeting_center, response) {
            @Override
            protected void convert(ViewHolder holder, Meeting data, int position) {
                if(TextUtils.isEmpty(data.getConfrId())&&!data.getCreateCode().equals(MyApplication.getmUserInfo().getUser().getLoginName())){
                    //会议室不存在，不是创建人无权限进入会议
                    toast("会议还没有开始！");
                    return;
                }
                String username = MyApplication.getmUserInfo().getUser().getLoginName();
                String pwd = MyApplication.getmUserInfo().getUser().getImPwd();
                //登录环信
                EazyChatApi.loginChat(username, pwd, (BaseActivity) getActivity(), null);
                holder.setText(R.id.tv_title, data.getTitle());
                holder.setText(R.id.tv_start_time, "会议开始时间："+data.getStartTime());
                holder.setText(R.id.tv_create_name, "会议创建人："+data.getSendPerson());
                holder.setText(R.id.tv_title, data.getTitle());
                holder.setText(R.id.tv_title, data.getTitle());
                holder.getConvertView().findViewById(R.id.tv_join_meeting).setOnClickListener(confe->{
                    //进入会议
                    Intent intent = new Intent(getActivity(), ConferenceActivity.class);
                    intent.putExtra("Meeting", data);
                    intent.putExtra("enterType", ConferenceActivity.TYPE_JOIN);
                    startActivity(intent);
                });
                holder.getConvertView().findViewById(R.id.tv_meeting_detail).setOnClickListener(confe->{
                    //会议详情
                    Intent intent = new Intent(getActivity(), MeetingDetailActivity.class);
                    intent.putExtra("Meeting", data);
                    startActivity(intent);
                });
            }

        });
    }


}
