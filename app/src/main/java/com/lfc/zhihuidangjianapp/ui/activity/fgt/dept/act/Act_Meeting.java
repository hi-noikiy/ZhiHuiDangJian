package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
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
    }

    @Override
    protected void initData() {

    }

    /**
     * 沉浸式状态栏
     */
    @Override
    protected void initImmersionBar(int type) {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                .statusBarDarkFont(statusBarDarkFont())    //默认状态栏字体颜色为黑色
                .keyboardEnable(false, WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                        | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
        //必须设置View树布局变化监听，否则软键盘无法顶上去，还有模式必须是SOFT_INPUT_ADJUST_PAN
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        if (type == 0) {
            initImmersionBarBlack();
        } else {
            initImmersionBarWhite();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                finish();
                break;

            case R.id.relAddMeet:

                Intent intent = new Intent(Act_Meeting.this, Act_Mail_list.class);
                startActivity(intent);

                break;
            case R.id.relJoinMeet:
                break;
            default:
        }
    }


}
