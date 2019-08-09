package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_PartyBuildingMatrix;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt.Fgt_PartyBuilDingMatrix;

import java.util.ArrayList;

/**
 * @date: 2019-08-06
 * @autror: guojian
 * @description: 组织生活
 */
public class Act_Party_Life extends BaseActivity {
    private final String[] mTitles = {"党委", "党总支", "党支部"};

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    SlidingTabLayout tabLayout_4;

    private int deptNumber = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_party_building_matrix;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        tabLayout_4 = findViewById(R.id.tl_4);
    }
    MyPagerAdapter mAdapter;
    @Override
    protected void initData() {
        mFragments.clear();
        for (int i=0;i<mTitles.length;i++) {
            mFragments.add(Fgt_PartyBuilDingMatrix.getInstance(i+1));
        }
        ViewPager vp =findViewById( R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        tabLayout_4.setViewPager(vp);

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
