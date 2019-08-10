package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.DeptConstants;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.Fgt_Dept_detail;

/**
 * @author guojian
 */
@Route(path = DeptConstants.PATH_DEPT_DETAIL)
public class Act_Dept_Detail extends BaseActivity {

    private String deptNumber;

    FrameLayout contentView;
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dept_detail;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(v -> finish());
        contentView = findViewById(R.id.content);
    }

    @Override
    protected void initData() {
        deptNumber = getIntent().getStringExtra("deptNumber");
        //TODO
        Fgt_Dept_detail fgtDeptDetail = new Fgt_Dept_detail();
        Bundle bundle = new Bundle();
        bundle.putString("deptNumber", deptNumber);
        fgtDeptDetail.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.content, fgtDeptDetail).commit();
    }




}
