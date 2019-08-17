package com.lfc.zhihuidangjianapp.ui.activity;

import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.hyphenate.EMConferenceListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMConferenceManager;
import com.hyphenate.chat.EMConferenceMember;
import com.hyphenate.chat.EMConferenceStream;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMStreamStatistics;
import com.hyphenate.exceptions.HyphenateException;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Meeting_Start;
import com.lfc.zhihuidangjianapp.ui.activity.model.User;

import java.util.List;

/**
 * @date: 2019-08-17
 * @autror: guojian
 * @description:
 */
public abstract class EazyChatListenerActivity extends BaseActivity {

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
                            try {
                                Intent intent = new Intent(getActivity(), Act_Meeting_Start.class);
                                String userJson = emMessage.getStringAttribute("user");
                                intent.putExtra("type", Act_Meeting_Start.TYPE_JOIN);
                                intent.putExtra("conferenceId", emMessage.getStringAttribute("conferenceId"));
                                intent.putExtra("user", new Gson().fromJson(userJson, User.class));
                                startActivity(intent);
                            } catch (HyphenateException e) {
                                e.printStackTrace();
                            }
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
