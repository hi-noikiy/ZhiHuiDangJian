package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.support.v4.app.Fragment;
import android.view.View;

import com.lfc.zhihuidangjianapp.ui.activity.TabWithToolbarActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop.ApplyEducationPartyFragment;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop.ApplyPartyFragment;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop.DevelopConfirmFragment;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop.PrepareMainFragment;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop.PrepareReceiveFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description: 发展党员
 */
public class DevelopPartyActivity extends TabWithToolbarActivity {

    private String[] mTitles = {"申请入党阶段", "申请积极分子的确定和培养教育阶段","发展对象的确定和考察阶段", "预备党员的接收阶段", "预备党员的教育考察和转正阶段"};

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public List<Fragment> getFragments() {
        initFragments();
        return fragments;
    }

    private void initFragments(){
        fragments.clear();
        fragments.add(new ApplyPartyFragment());//申请入党阶段
        fragments.add(new ApplyEducationPartyFragment());//申请积极分子的确定和培养教育阶段
        fragments.add(new DevelopConfirmFragment());//发展对象的确定和考察阶段
        fragments.add(new PrepareReceiveFragment());//预备党员的接收阶段
        fragments.add(new PrepareMainFragment());//预备党员的教育考察和转正
    }

    @Override
    public String[] getTitles() {
        return mTitles;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initData() {
        setAppText("发展党员");
        getTvRight().setVisibility(View.VISIBLE);
        getTvRight().setOnClickListener(submit->{
            //TODO 提交
        });
    }
}
