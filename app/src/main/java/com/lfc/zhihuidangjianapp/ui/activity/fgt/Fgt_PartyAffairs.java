package com.lfc.zhihuidangjianapp.ui.activity.fgt;

import android.content.Intent;
import android.view.View;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.act.Act_Mail_list;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.act.Act_Meeting;

/**
 * 党务工作
 */
public class Fgt_PartyAffairs extends BaseFragment implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_party_affairs;
    }

    @Override
    protected void initView(View rootView) {
        rootView.findViewById(R.id.Meeting).setOnClickListener(this);
        rootView.findViewById(R.id.Mail_list).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Meeting://会议
                startActivity(new Intent(getContext(), Act_Meeting.class));
                break;
            case R.id.Mail_list://通讯录
                startActivity(new Intent(getContext(), Act_Mail_list.class));
                break;
        }
    }
}
