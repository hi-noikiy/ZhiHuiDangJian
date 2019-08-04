package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.widget.MyListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 学习强局
 */
public class Act_Emulate extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.act_emulate;
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
