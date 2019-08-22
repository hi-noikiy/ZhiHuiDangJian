package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gyf.barlibrary.ImmersionBar;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.TabEntity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.Fgt_Dept_detail;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.Fgt_Meeting_Center;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_PartyBuildingMatrix;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt.Fgt_PartyBuilDingMatrix;

import java.util.ArrayList;

/**
 * @date: 2019-08-22
 * @autror: guojian
 * @description: 会议中心
 */
public class MeetingCenterActivity extends BaseActivity implements View.OnClickListener {
    private final String[] mTitles = {"我的会议", "会议列表", "历史会议"};

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    CommonTabLayout tab;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_meeting_center;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        findViewById(R.id.imgBack).setOnClickListener(this);
        tab = findViewById(R.id.tab);
    }

    MyPagerAdapter mAdapter;

    @Override
    protected void initData() {
        mFragments.clear();
        for (int i=0;i<mTitles.length;i++){
            Fgt_Meeting_Center fgtMeetingCenter = new Fgt_Meeting_Center();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            fgtMeetingCenter.setArguments(bundle);
            mFragments.add(fgtMeetingCenter);
        }

        ViewPager vp = findViewById(R.id.viewPager);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i]));
        }
        tab.setTabData(mTabEntities);
        tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tab.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
