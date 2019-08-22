package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.BaseResponse;
import com.lfc.zhihuidangjianapp.ui.activity.model.MailList;
import com.lfc.zhihuidangjianapp.ui.activity.model.Meeting;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseMeetingMine;
import com.lfc.zhihuidangjianapp.ui.activity.model.UiName;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                holder.setText(R.id.tv_title, data.getTitle());
                holder.setText(R.id.tv_start_time, "会议开始时间："+data.getStartTime());
                holder.setText(R.id.tv_create_name, "会议创建人："+data.getSendPerson());
                holder.setText(R.id.tv_title, data.getTitle());
                holder.setText(R.id.tv_title, data.getTitle());
            }

        });
    }


}
