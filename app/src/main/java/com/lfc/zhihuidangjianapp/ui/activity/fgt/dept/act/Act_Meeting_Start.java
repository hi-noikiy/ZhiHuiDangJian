package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyphenate.EMConferenceListener;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConference;
import com.hyphenate.chat.EMConferenceManager;
import com.hyphenate.chat.EMConferenceMember;
import com.hyphenate.chat.EMConferenceStream;
import com.hyphenate.chat.EMStreamStatistics;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.chat.EazyChatApi;
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

    private TextView tvTitle;

    private ImageView ivCreateUser;

    private ArrayList<User> selectUsers = new ArrayList<>();

    private MeetingStartAdapter meetingAdapter;

    private String password = "password";

    public static final int TYPE_CREATE = 1;
    public static final int TYPE_JOIN = 0;

    private int enter;
    //被邀请会议id
    private String conferenceId;
    //邀请人
    private User createUser;

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
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back -> finish());
        recyclerView = findViewById(R.id.recyclerView);
        tvTitle = findViewById(R.id.tv_title);
        ivCreateUser = findViewById(R.id.iv_create_user);
        setRecyclerView(selectUsers);
        setEvent();
        EMClient.getInstance().conferenceManager().addConferenceListener(emConferenceListener);

        enter = getIntent().getIntExtra("type", 0);
        if (enter == TYPE_CREATE) {
            //创建者
            tvTitle.setText("正在连接");
            findViewById(R.id.tv_join).setVisibility(View.GONE);
//            selectUsers.add(MyApplication.getmUserInfo().getUser());
            selectUsers = getIntent().getParcelableArrayListExtra("users");
            nofityAdapter();
            createMeeting();
        }else {
            //加入会议
            createUser = getIntent().getParcelableExtra("user");
            if(createUser!=null){
                tvTitle.setText(createUser.getRoleName()+"邀请你加入会议");
                selectUsers.add(createUser);
                nofityAdapter();
            }
        }
    }

    private void setEvent() {
        findViewById(R.id.view_break).setOnClickListener(meeting -> {
            //TODO 断开连接
            finish();
        });
        //加入会议
        findViewById(R.id.tv_join).setOnClickListener(join -> {
            if (enter == TYPE_JOIN) {
                conferenceId = getIntent().getStringExtra("conferenceId");
                if (conferenceId != null) {
                    joinMeeting(conferenceId);
                }
            }
        });
    }


    @Override
    protected void initData() {

    }

    private void nofityAdapter(){
        meetingAdapter.getDatas().clear();
        meetingAdapter.getDatas().addAll(selectUsers);
        meetingAdapter.notifyDataSetChanged();
    }

    /**
     * 加入会议室
     */
    private void joinMeeting(String conferenceId) {
        EMClient.getInstance().conferenceManager().joinConference(conferenceId, password, new
                EMValueCallBack<EMConference>() {
                    @Override
                    public void onSuccess(EMConference value) {
                        // 返回当前会议对象实例 value
                        // 可进行推流等相关操作
                        // 运行在子线程中，勿直接操作UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                findViewById(R.id.tv_join).setVisibility(View.GONE);
                                tvTitle.setText("已连接");
                            }
                        });
                    }

                    @Override
                    public void onError(int error, String errorMsg) {
                        // 运行在子线程中，勿直接操作UI
                    }
                });
    }

    private void createMeeting() {
        //批量邀请成员创建会议室
        EMClient.getInstance().conferenceManager().createAndJoinConference(EMConferenceManager.EMConferenceType.LargeCommunication,
                password, new EMValueCallBack<EMConference>() {
                    @Override
                    public void onSuccess(EMConference value) {
                        // 返回当前会议对象实例 value
                        // 可进行推流等相关操作
                        // 运行在子线程中，勿直接操作UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("Act_Meeting_Start=", value.toString());
                                if (selectUsers == null || selectUsers.isEmpty()) {
                                    return;
                                }
                                EazyChatApi.sendMeeting(selectUsers, value.getConferenceId());
                            }
                        });
                    }

                    @Override
                    public void onError(int error, String errorMsg) {
                        // 运行在子线程中，勿直接操作UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("Act_Meeting_Start=", errorMsg + "=" + error);
                            }
                        });
                    }
                });
    }

    private void setRecyclerView(List<User> response) {
        //TODO 初始化操作
        recyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getAppContext(), 3));
        meetingAdapter = new MeetingStartAdapter(getActivity(), R.layout.item_meeting_line, response);
        recyclerView.setAdapter(meetingAdapter);
    }

    class MeetingStartAdapter extends CommonAdapter<User> {
        public MeetingStartAdapter(Context context, int layoutId, List<User> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder holder, User data, int position) {
            holder.setText(R.id.tv_name, data.getRoleName());
            ImageView imageView = holder.getConvertView().findViewById(R.id.iv_head);
            Glide.with(holder.getConvertView().getContext()).load(ApiConstant.ROOT_URL + data.getImgAddress()).into(imageView);
        }
    }

    protected EMConferenceListener emConferenceListener = new EMConferenceListener() {
        @Override
        public void onMemberJoined(EMConferenceMember emConferenceMember) {
            Log.e("onMemberJoined=", "有成员加入");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showTextToast(emConferenceMember.memberId+"加入会议室");
                }
            });
        }

        @Override
        public void onMemberExited(EMConferenceMember emConferenceMember) {
            Log.e("onMemberExited=", "有成员退出");
        }

        @Override
        public void onStreamAdded(EMConferenceStream emConferenceStream) {

        }

        @Override
        public void onStreamRemoved(EMConferenceStream emConferenceStream) {

        }

        @Override
        public void onStreamUpdate(EMConferenceStream emConferenceStream) {

        }

        @Override
        public void onPassiveLeave(int i, String s) {
            Log.e("onPassiveLeave=", "被踢");
        }

        @Override
        public void onConferenceState(ConferenceState conferenceState) {
            Log.e("onConferenceState=", "会议室状态");
        }

        @Override
        public void onStreamStatistics(EMStreamStatistics emStreamStatistics) {

        }

        @Override
        public void onStreamSetup(String s) {

        }

        @Override
        public void onSpeakers(List<String> list) {

        }

        @Override
        public void onReceiveInvite(String confId, String password, String extension) {
            Log.e("onReceiveInvite=", "收到会议邀请");
        }

        @Override
        public void onRoleChanged(EMConferenceManager.EMConferenceRole emConferenceRole) {

        }
    };

}
