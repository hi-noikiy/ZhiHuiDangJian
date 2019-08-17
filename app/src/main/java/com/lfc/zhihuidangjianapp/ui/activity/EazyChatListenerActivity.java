package com.lfc.zhihuidangjianapp.ui.activity;

import android.content.Intent;
import android.util.Log;

import com.hyphenate.EMConferenceListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMConferenceManager;
import com.hyphenate.chat.EMConferenceMember;
import com.hyphenate.chat.EMConferenceStream;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMStreamStatistics;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Meeting_Start;

import java.util.List;

/**
 * @date: 2019-08-17
 * @autror: guojian
 * @description:
 */
public abstract class EazyChatListenerActivity extends BaseActivity {

    protected EMConferenceListener emConferenceListener = new EMConferenceListener() {
        @Override
        public void onMemberJoined(EMConferenceMember emConferenceMember) {
            Log.e("onMemberJoined=", "有成员加入");
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

    /**
     * 接受message
     */
    protected EMMessageListener emMessageListener = new EMMessageListener() {
        @Override
        public void onMessageReceived(List<EMMessage> list) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (list != null && list.size() != 0) {
                        EMMessage emMessage = list.get(0);
                        if (emMessage.getChatType() == EMMessage.ChatType.Chat) {
                            startActivity(new Intent(getActivity(), Act_Meeting_Start.class));
//                            conversation.markAllMessagesAsRead();
                        }
                    }
                }
            });
        }

        @Override
        public void onCmdMessageReceived(List<EMMessage> list) {

        }

        @Override
        public void onMessageRead(List<EMMessage> list) {

        }

        @Override
        public void onMessageDelivered(List<EMMessage> list) {

        }

        @Override
        public void onMessageRecalled(List<EMMessage> list) {

        }

        @Override
        public void onMessageChanged(EMMessage emMessage, Object o) {

        }
    };

}
