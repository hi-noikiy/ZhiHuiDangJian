package com.lfc.zhihuidangjianapp.ui.activity.fgt.personal.act;

import android.os.Bundle;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工作周报
 */
public class Act_WeeklyReport extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weekly_reportctivity;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        initImmersionBar(1);
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.imgBack)
    public void onImgBackClicked() {
        finish();
    }

    @OnClick(R.id.imgSearch)
    public void onImgSearchClicked() {
    }

    @OnClick(R.id.linear1)
    public void onLinear1Clicked() {
    }

    @OnClick(R.id.linear2)
    public void onLinear2Clicked() {
    }

    @OnClick(R.id.linear3)
    public void onLinear3Clicked() {
    }

    @OnClick(R.id.linear4)
    public void onLinear4Clicked() {
    }
}
