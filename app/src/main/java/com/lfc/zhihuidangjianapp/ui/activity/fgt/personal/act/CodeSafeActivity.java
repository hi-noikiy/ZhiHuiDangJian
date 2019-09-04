package com.lfc.zhihuidangjianapp.ui.activity.fgt.personal.act;

import android.content.Intent;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;

/**
 * @date: 2019-09-04
 * @autror: guojian
 * @description:
 */
public class CodeSafeActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_code_safe;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        initImmersionBar(0);
        setEvent();
    }

    private void setEvent() {
        findViewById(R.id.tvUpdatePwd).setOnClickListener(updatePwd->{
            //TODO 修改密码
            startActivity(new Intent(this, UpdatePasswordActivity.class));
        });
    }

    @Override
    protected void initData() {

    }
}
