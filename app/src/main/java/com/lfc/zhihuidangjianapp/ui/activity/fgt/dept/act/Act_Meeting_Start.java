package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.ui.activity.model.User;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 会议进行
 */
public class Act_Meeting_Start extends BaseActivity {

    private RecyclerView recyclerView;

    private ArrayList<User> selectUsers = new ArrayList<>();

    private MeetingStartAdapter meetingAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_meeting_start;
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
        findViewById(R.id.view_break).setOnClickListener(meeting->{
            //TODO 断开连接
            finish();
        });
    }

    @Override
    protected void initData() {

    }

    private void setRecyclerView(List<User> response) {
        if(response==null||response.isEmpty())return;
        //TODO 初始化操作
        recyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getAppContext(), 3));
        meetingAdapter = new MeetingStartAdapter(getActivity(), R.layout.item_meeting_line, response);
        recyclerView.setAdapter(meetingAdapter);
    }

    class MeetingStartAdapter extends CommonAdapter<User>{
        public MeetingStartAdapter(Context context, int layoutId, List<User> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, User data, int position) {
            holder.setText(R.id.tv_name, data.getRoleName());
            ImageView imageView = holder.getConvertView().findViewById(R.id.iv_head);
            Glide.with(holder.getConvertView().getContext()).load(ApiConstant.ROOT_URL+data.getImgAddress()).into(imageView);
        }
    }

}
