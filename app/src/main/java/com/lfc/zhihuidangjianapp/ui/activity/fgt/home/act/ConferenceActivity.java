package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;


import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hyphenate.EMConferenceListener;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.EMChatRoom;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConference;
import com.hyphenate.chat.EMConferenceManager;
import com.hyphenate.chat.EMConferenceMember;
import com.hyphenate.chat.EMConferenceStream;
import com.hyphenate.chat.EMStreamParam;
import com.hyphenate.chat.EMStreamStatistics;
import com.hyphenate.chatuidemo.conference.CallFloatWindow;
import com.hyphenate.chatuidemo.conference.ConferenceMemberView;
import com.hyphenate.chatuidemo.conference.DebugPanelView;
import com.hyphenate.chatuidemo.conference.DeskShareWindow;
import com.hyphenate.chatuidemo.conference.MemberViewGroup;
import com.hyphenate.chatuidemo.utils.PhoneStateManager;
import com.hyphenate.chatuidemo.utils.PreferenceManager;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.BaseConferenceActivity;
import com.lfc.zhihuidangjianapp.ui.activity.model.Meeting;
import com.lfc.zhihuidangjianapp.ui.activity.model.User;
import com.lfc.zhihuidangjianapp.ui.activity.model.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-25
 * @autror: guojian
 * @description:
 */
public class ConferenceActivity extends BaseConferenceActivity {
    protected static final String TAG = "ConferenceActivity";
    protected BaseActivity activity;
    public static final int TYPE_CREATE = 0;
    public static final int TYPE_JOIN = 1;

    protected ConferenceListener conferenceListener;
    //view
    protected ConferenceMemberView localView;
    protected MemberViewGroup callConferenceViewGroup;
    protected DebugPanelView debugPanelView;

    //data
    protected List<EMConferenceStream> streamList = new ArrayList<>();
    protected String confId = "";
    protected String password = "";
    protected EMConference conference;
    protected EMStreamParam normalParam;
    protected EMStreamParam desktopParam;

    private int enterType;
    //会议信息
    private Meeting meeting;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_conference;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        activity = this;
        init();
        conferenceListener = new ConferenceListener();
        EMClient.getInstance().conferenceManager().addConferenceListener(conferenceListener);
        initLocalConferenceView();

    }

    @Override
    protected void initData() {
        meeting = (Meeting) getIntent().getSerializableExtra("Meeting");
        enterType = getIntent().getIntExtra("enterType", 0);
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
        }
    }

    private void init() {
        callConferenceViewGroup = (MemberViewGroup) findViewById(R.id.surface_view_group);
        debugPanelView = (DebugPanelView) findViewById(R.id.layout_debug_panel);

        normalParam = new EMStreamParam();
        normalParam.setStreamType(EMConferenceStream.StreamType.NORMAL);
        normalParam.setVideoOff(true);
        normalParam.setAudioOff(false);

        desktopParam = new EMStreamParam();
        desktopParam.setAudioOff(true);
        desktopParam.setVideoOff(true);
        desktopParam.setStreamType(EMConferenceStream.StreamType.DESKTOP);
    }

    /**
     * 初始化多人音视频画面管理控件
     */
    private void initLocalConferenceView() {
        localView = new ConferenceMemberView(this);
        localView.setVideoOff(normalParam.isVideoOff());
        localView.setAudioOff(normalParam.isAudioOff());
        localView.setUsername(EMClient.getInstance().getCurrentUser());
        EMClient.getInstance().conferenceManager().setLocalSurfaceView(localView.getSurfaceView());

        callConferenceViewGroup.addView(localView);
    }

    /**
     * 作为创建者创建并加入会议
     */
    private void createAndJoinConference(final EMValueCallBack<EMConference> callBack) {
        boolean record = PreferenceManager.getInstance().isRecordOnServer();
        boolean merge = PreferenceManager.getInstance().isMergeStream();
        EMClient.getInstance().conferenceManager().createAndJoinConference(EMConferenceManager.EMConferenceType.LargeCommunication,
                password, record, merge, new EMValueCallBack<EMConference>() {
                    @Override
                    public void onSuccess(final EMConference value) {
                        EMLog.e(TAG, "create and join conference success");
                        conference = value;
                        startAudioTalkingMonitor();
                        publish();
                        createFinish(value.getConferenceId(), value.getPassword());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(activity, "Create and join conference success", Toast.LENGTH_SHORT).show();
                                if (callBack != null) {
                                    callBack.onSuccess(value);
                                }
                            }
                        });
                    }

                    @Override
                    public void onError(final int error, final String errorMsg) {
                        EMLog.e(TAG, "Create and join conference failed error " + error + ", msg " + errorMsg);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (callBack != null) {
                                    callBack.onError(error, errorMsg);
                                }
                            }
                        });
                    }
                });
    }

    /**
     * 作为成员直接根据 confId 和 password 加入会议
     */
    protected void joinConference() {
        EMClient.getInstance().conferenceManager().joinConference(confId, password, new EMValueCallBack<EMConference>() {
            @Override
            public void onSuccess(EMConference value) {
                conference = value;
                startAudioTalkingMonitor();
                publish();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "Join conference success", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onError(final int error, final String errorMsg) {
                EMLog.e(TAG, "join conference failed error " + error + ", msg " + errorMsg);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "Join conference failed " + error + " " + errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * 开始推自己的数据
     */
    private void publish() {
        addSelfToList();

        EMClient.getInstance().conferenceManager().publish(normalParam, new EMValueCallBack<String>() {
            @Override
            public void onSuccess(String value) {
                conference.setPubStreamId(value, EMConferenceStream.StreamType.NORMAL);
                localView.setStreamId(value);

                streamList.get(0).setStreamId(value);
                debugPanelView.setStreamListAndNotify(streamList);

                // Start to watch the phone call state.
                PhoneStateManager.get(ConferenceActivity.this).addStateCallback(phoneStateCallback);
            }

            @Override
            public void onError(int error, String errorMsg) {
                EMLog.e(TAG, "publish failed: error=" + error + ", msg=" + errorMsg);
            }
        });
    }


    private void addSelfToList() {
        EMConferenceStream localStream = new EMConferenceStream();
        localStream.setUsername(EMClient.getInstance().getCurrentUser());
        localStream.setStreamId("local-stream");
        streamList.add(localStream);
    }

    protected void startAudioTalkingMonitor() {
        EMClient.getInstance().conferenceManager().startMonitorSpeaker(300);
    }

    protected void stopAudioTalkingMonitor() {
        EMClient.getInstance().conferenceManager().stopMonitorSpeaker();
    }

    /**
     * 更新成员
     */
    private void updateConferenceMembers() {
        List<EMConferenceMember> members = EMClient.getInstance().conferenceManager().getConferenceMemberList();
        String count = members.size() > 0 ? "(" + members.size() + ")" : "";
        //TODO 更新成员
//        String membersStr = getMembersStr(members);
//
//        membersTV.setText(membersStr);
//        memberCountTV.setText(count);
//
//        membersTVMain.setText(membersStr);
//        memberCountTVMain.setText(count);
    }

    /**
     * 添加一个展示远端画面的 view
     */
    private void addConferenceView(EMConferenceStream stream) {
        EMLog.d(TAG, "add conference view -start- " + stream.getMemberName());
        streamList.add(stream);
        final ConferenceMemberView memberView = new ConferenceMemberView(this);
        callConferenceViewGroup.addView(memberView);
        memberView.setUsername(stream.getUsername());
        memberView.setStreamId(stream.getStreamId());
        memberView.setAudioOff(stream.isAudioOff());
        memberView.setVideoOff(stream.isVideoOff());
        memberView.setDesktop(stream.getStreamType() == EMConferenceStream.StreamType.DESKTOP);
        subscribe(stream, memberView);
        EMLog.d(TAG, "add conference view -end-" + stream.getMemberName());
        debugPanelView.setStreamListAndNotify(streamList);
    }

    /**
     * 订阅指定成员 stream
     */
    private void subscribe(EMConferenceStream stream, final ConferenceMemberView memberView) {
        EMClient.getInstance().conferenceManager().subscribe(stream, memberView.getSurfaceView(), new EMValueCallBack<String>() {
            @Override
            public void onSuccess(String value) {
                Log.e(TAG, "subscribe = onSuccess: "+value);
            }

            @Override
            public void onError(int error, String errorMsg) {
                Log.e(TAG, "subscribe = onError: "+errorMsg);
            }
        });
    }

    /**
     * 更新指定 View
     */
    protected void updateConferenceMemberView(EMConferenceStream stream) {
        int position = streamList.indexOf(stream);
        ConferenceMemberView conferenceMemberView = (ConferenceMemberView) callConferenceViewGroup.getChildAt(position);
        conferenceMemberView.setAudioOff(stream.isAudioOff());
        conferenceMemberView.setVideoOff(stream.isVideoOff());

        // 悬浮窗显示规则: 若有其他成员加入会议,则显示第一个加入会议的其他成员;若无,则显示自己.
        if (position != 1) {
            return;
        }
        CallFloatWindow.getInstance(getApplicationContext()).update(stream);
    }

    /**
     * 创建会议上报
     */
    private void createFinish(String confId, String password) {
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
                .subscribe(new ResponseObserver<Object>(getActivity()) {

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

    /**
     * 更新当前说话者
     */
    private void currSpeakers(List<String> speakers) {
        for (int i = 0; i < callConferenceViewGroup.getChildCount(); i++) {
//            if (talkingLayout.getVisibility() == View.VISIBLE) {
//                // full screen mode.
//                if (speakers.size() == 0) {
//                    talkingImage.setVisibility(View.GONE);
//                    talkerTV.setText("");
//                } else {
//                    talkingImage.setVisibility(View.VISIBLE);
//                    String lastStreamId = speakers.get(speakers.size() - 1);
//                    EMLog.i("currSpeakers", "currSpeakers: " + lastStreamId);
//                    String speaker = null;
//                    for (EMConferenceStream stream : streamList) {
//                        EMLog.i("currSpeakers", "stream: " + stream.getStreamId());
//                        if (stream.getStreamId().equals(lastStreamId)) {
//                            speaker = stream.getUsername();
//                            break;
//                        }
//                    }
//                    talkerTV.setText(speaker);
//                }
//            }

            ConferenceMemberView view = (ConferenceMemberView) callConferenceViewGroup.getChildAt(i);
            view.setTalking(speakers.contains(view.getStreamId()));
        }
    }

    class ConferenceListener implements EMConferenceListener {
        @Override
        public void onMemberJoined(EMConferenceMember emConferenceMember) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    updateConferenceMembers();
                }
            });
        }

        @Override
        public void onMemberExited(EMConferenceMember emConferenceMember) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, " removed conference!", Toast.LENGTH_SHORT).show();
                    updateConferenceMembers();
                }
            });
        }

        @Override
        public void onStreamAdded(EMConferenceStream emConferenceStream) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, emConferenceStream.getUsername() + " stream add!", Toast.LENGTH_SHORT)
                            .show();
                    addConferenceView(emConferenceStream);

//                    if (CallFloatWindow.getInstance(getApplicationContext()).isShowing()) { // 通话悬浮窗显示中...
//                        int position = streamList.indexOf(stream);
//                        if (position == 1) { // 会议中加入第一个成员,需要把正在显示的悬浮窗从自己更新到这个第一个加入会议的成员.
//                            showFloatWindow();
//                        }
//                    }
                }
            });
        }

        @Override
        public void onStreamRemoved(EMConferenceStream stream) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, stream.getUsername() + " stream removed!", Toast.LENGTH_SHORT).show();
                    if (streamList.contains(stream)) {
                        int position = streamList.indexOf(stream);
//                        removeConferenceView(stream);

                        if (CallFloatWindow.getInstance(getApplicationContext()).isShowing()) { // 通话悬浮窗显示中...
                            if (position == 1) { // 正在显示悬浮窗的成员退出聊天室
//                                showFloatWindow();
                            }
                        }
                    }
                }
            });
        }

        @Override
        public void onStreamUpdate(EMConferenceStream emConferenceStream) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, emConferenceStream.getUsername() + " stream update!", Toast.LENGTH_SHORT).show();
                    updateConferenceMemberView(emConferenceStream);
                }
            });
        }

        @Override
        public void onPassiveLeave(int i, String error) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "Passive exit " + error + ", message" + error, Toast.LENGTH_SHORT).show();
                    // 隐藏悬浮窗
                    CallFloatWindow.getInstance(getApplicationContext()).dismiss();
                    DeskShareWindow.getInstance(getApplicationContext()).dismiss();
                    // 退出当前界面
                    finish();
                }
            });
        }

        @Override
        public void onConferenceState(ConferenceState conferenceState) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "State=" + conferenceState, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onStreamStatistics(EMStreamStatistics statistics) {
            EMLog.i(TAG, "onStreamStatistics" + statistics.toString());
            debugPanelView.onStreamStatisticsChange(statistics);
        }

        @Override
        public void onStreamSetup(String streamId) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (streamId.equals(conference.getPubStreamId(EMConferenceStream.StreamType.NORMAL))
                            || streamId.equals(conference.getPubStreamId(EMConferenceStream.StreamType.DESKTOP))) {
                        Toast.makeText(activity, "Publish setup streamId=" + streamId, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(activity, "Subscribe setup streamId=" + streamId, Toast.LENGTH_SHORT).show();
                    }
                }
            });

            streamList.get(0).setStreamId(streamId);
            debugPanelView.setStreamListAndNotify(streamList);
        }

        @Override
        public void onSpeakers(List<String> speakers) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    currSpeakers(speakers);
                }
            });
        }

        @Override
        public void onReceiveInvite(String s, String s1, String s2) {

        }

        @Override
        public void onRoleChanged(EMConferenceManager.EMConferenceRole emConferenceRole) {

        }
    }

    // 当前设备通话状态监听器
    PhoneStateManager.PhoneStateCallback phoneStateCallback = new PhoneStateManager.PhoneStateCallback() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:   // 电话响铃
                    break;
                case TelephonyManager.CALL_STATE_IDLE:      // 电话挂断
                    // resume current voice conference.
                    if (normalParam.isAudioOff()) {
                        try {
                            EMClient.getInstance().callManager().resumeVoiceTransfer();
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                        }
                    }
                    if (normalParam.isVideoOff()) {
                        try {
                            EMClient.getInstance().callManager().resumeVideoTransfer();
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:   // 来电接通 或者 去电，去电接通  但是没法区分
                    // pause current voice conference.
                    if (!normalParam.isAudioOff()) {
                        try {
                            EMClient.getInstance().callManager().pauseVoiceTransfer();
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!normalParam.isVideoOff()) {
                        try {
                            EMClient.getInstance().callManager().pauseVideoTransfer();
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    };

}
