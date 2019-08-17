package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.DividerItemDecoration;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dept;
import com.lfc.zhihuidangjianapp.ui.activity.model.FriendList;
import com.lfc.zhihuidangjianapp.ui.activity.model.MailList;
import com.lfc.zhihuidangjianapp.ui.activity.model.User;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 通讯录列表
 */
public class Act_Friend_list extends BaseActivity {

    private RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;

    private String deptNumber;

    private ArrayList<User> selectUsers = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview_with_appbar;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back -> finish());
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("通讯录");
        recyclerView = findViewById(R.id.recyclerView);

    }

    @Override
    protected void initData() {
        deptNumber = getIntent().getStringExtra("deptNumber");
        Map<String, Object> map = new HashMap<>();
        map.put("deptNumber", deptNumber);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryUserListByFirstPinYin(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<FriendList>(getActivity()) {

                    @Override
                    protected void onNext(FriendList response) {
                        if (response == null) return;
                        Log.e("onNext= ", response.toString());
                        setRecyclerView(response);
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }

    private void setRecyclerView(FriendList response) {
        //TODO 初始化操作
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new CommonAdapter<User>(MyApplication.getAppContext(), R.layout.item_friend_list, response.getUserList()) {
            @Override
            protected void convert(ViewHolder holder, User data, int position) {
                holder.setText(R.id.tv_name, data.getSealName());
                ImageView image = holder.getConvertView().findViewById(R.id.iv_head);
                Glide.with(holder.getConvertView().getContext()).load(ApiConstant.ROOT_URL+data.getImgAddress()).into(image);
                holder.setText(R.id.tv_content, data.getSubordinatePartyGroup());
                holder.setText(R.id.tv_tell, data.getMobileNumber());
                holder.getConvertView().setOnClickListener(meeting->{
                    if(selectUsers.contains(data)){
                        selectUsers.remove(data);
                    }else{
                        selectUsers.add(data);
                    }
                    if(selectUsers.isEmpty()){
                        return;
                    }
                    Intent intent = new Intent(getActivity(), Act_Meeting_Start.class);
                    intent.putParcelableArrayListExtra("users", selectUsers);
                    intent.putExtra("type", Act_Meeting_Start.TYPE_CREATE);
                    startActivity(intent);
                });
            }

        });
        recyclerView.addItemDecoration(new DividerItemDecoration(
                DividerItemDecoration.VERTICAL_LIST,
                ContextCompat.getColor(getActivity(), R.color.background),
                DispalyUtil.dp2px(getActivity(), 1),
                0, 0, false
        ));
    }

}
