package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.TabEntity;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.FragPagerAdapter;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.Fgt_Study_Report;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.Fgt_Weekend_Report;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019-08-06
 * @autror: guojian
 * @description: 学习心得
 */
public class Act_Study_Report extends BaseActivity {

    private ImageView create;

    private CommonTabLayout tab;

    private ViewPager viewPager;

    private String[] mTitles = {"党委","党总支", "党支部", "党员"};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private List<Fragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_study_report;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        initImmersionBar(0);
        create = findViewById(R.id.create);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        fragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i]));
            Fgt_Study_Report fgt_study_report = new Fgt_Study_Report();
            Bundle bundle = new Bundle();
            bundle.putInt("studyStrongBureauType", i);
            fgt_study_report.setArguments(bundle);
            fragments.add(fgt_study_report);
        }
        tab.setTabData(mTabEntities);
        tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        FragPagerAdapter fpa = new FragPagerAdapter(getSupportFragmentManager());
        fpa.setFragmentList(fragments);
        viewPager.setAdapter(fpa);

        setEvent();
    }

    private void setEvent() {
        create.setOnClickListener(ceate->{
            startActivity(new Intent(this, Act_Write_Study_Report.class));
        });
    }

    @Override
    protected void initData() {

    }
}
