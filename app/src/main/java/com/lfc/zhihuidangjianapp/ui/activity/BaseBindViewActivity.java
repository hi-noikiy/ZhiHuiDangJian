package com.lfc.zhihuidangjianapp.ui.activity;

import com.lfc.zhihuidangjianapp.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date: 2019-08-03
 * @autror: guojian
 * @description:
 */
public abstract class BaseBindViewActivity extends BaseActivity {

    private Unbinder unbinder;

    @Override
    protected void initView() {
        //沉浸式状态栏
        initImmersionBar(0);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}

