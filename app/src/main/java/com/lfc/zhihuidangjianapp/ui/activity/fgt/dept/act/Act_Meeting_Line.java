package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
import com.lfc.zhihuidangjianapp.ui.activity.model.MailList;
import com.lfc.zhihuidangjianapp.ui.activity.model.User;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 会议连线
 */
public class Act_Meeting_Line extends BaseActivity {

    private RecyclerView recyclerView;

    private ArrayList<User> selectUsers = new ArrayList<>();

    private MeetingAdapter meetingAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_meeting_line;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        selectUsers = getIntent().getParcelableArrayListExtra("users");
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back -> finish());
        recyclerView = findViewById(R.id.recyclerView);
        setRecyclerView(selectUsers);
        setEvent();
    }

    private void setEvent(){
        findViewById(R.id.view_meeting).setOnClickListener(meeting->{
            if(selectUsers.isEmpty()){
                return;
            }
            Intent intent = new Intent(getActivity(), Act_Meeting_Start.class);
            intent.putParcelableArrayListExtra("users", selectUsers);
            startActivity(intent);
        });
    }

    @Override
    protected void initData() {

    }

    private void setRecyclerView(List<User> response) {
        if(response.isEmpty())return;
        //TODO 初始化操作
        recyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getAppContext(), 3));
        meetingAdapter = new MeetingAdapter(getActivity(), R.layout.item_meeting_line, response);
        recyclerView.setAdapter(meetingAdapter);
    }

    class MeetingAdapter extends CommonAdapter<User>{
        public MeetingAdapter(Context context, int layoutId, List<User> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, User data, int position) {
            holder.setText(R.id.tv_name, data.getRoleName());
            CircleImageView imageView = holder.getConvertView().findViewById(R.id.iv_head);
            Glide.with(holder.getConvertView().getContext()).load(ApiConstant.ROOT_URL+data.getImgAddress()).into(imageView);
            holder.getConvertView().findViewById(R.id.iv_clear).setOnClickListener(clear->{
                if(selectUsers.contains(data)){
                    selectUsers.remove(data);
                    meetingAdapter.getDatas().remove(data);
                    meetingAdapter.notifyDataSetChanged();
                }
            });
        }
    }

}
