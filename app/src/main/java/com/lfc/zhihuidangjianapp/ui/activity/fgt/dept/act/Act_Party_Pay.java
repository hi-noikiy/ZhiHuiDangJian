package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;

/**
 * @date: 2019-08-05
 * @autror: guojian
 * @description:
 */
public class Act_Party_Pay extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.act_party_pay;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
    }

    @Override
    protected void initData() {

    }
}
