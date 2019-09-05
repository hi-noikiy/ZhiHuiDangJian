package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.hyphenate.chatuidemo.conference.ConferenceActivity;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;

/**
 * 会议连线
 */
public class Act_Meeting extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.act_meeting;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(this);
        findViewById(R.id.relAddMeet).setOnClickListener(this);
        findViewById(R.id.relJoinMeet).setOnClickListener(this);
        findViewById(R.id.viewChat).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                finish();
                break;

            case R.id.relAddMeet:
                //创建会议
//                Intent intent = new Intent(Act_Meeting.this, Act_Mail_list.class);
//                startActivity(intent);
                startActivity(new Intent(Act_Meeting.this, Act_Create_Meeting.class));

                break;
            case R.id.relJoinMeet:
                //会议中心
//                startActivity(new Intent(getActivity(), Act_Meeting_Start.class));
                startActivity(new Intent(getActivity(), MeetingCenterActivity.class));
                break;
            case R.id.viewChat:
                Intent intent = new Intent(getActivity(), Act_Mail_list.class);
                intent.putExtra("enter", Act_Friend_list.ENTER_SIGLE);
                startActivity(intent);
                break;
            default:
        }
    }


}
