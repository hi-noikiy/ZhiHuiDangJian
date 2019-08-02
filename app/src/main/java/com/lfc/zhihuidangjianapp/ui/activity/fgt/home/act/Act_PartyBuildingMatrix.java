package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt.Fgt_PartyBuilDingMatrix;

import java.util.ArrayList;

/**
 * 党建矩阵
 */
public class Act_PartyBuildingMatrix extends BaseActivity implements View.OnClickListener {
    SlidingTabLayout tabLayout_4;

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
        findViewById(R.id.imgBack).setOnClickListener(this);
        tabLayout_4 = findViewById(R.id.tl_4);
    }
    MyPagerAdapter mAdapter;
    @Override
    protected void initData() {
        for (String title : mTitles) {
            mFragments.add(Fgt_PartyBuilDingMatrix.getInstance(title));
        }
        ViewPager vp =findViewById( R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        tabLayout_4.setViewPager(vp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
        }
    }
    private final String[] mTitles = {"党委", "党总支", "党支部", "党小组"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

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
