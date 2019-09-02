package com.lfc.zhihuidangjianapp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.TabEntity;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.FragPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description:
 */
public abstract class TabWithToolbarActivity extends BaseActivity {

    private String[] mTitles;

    private List<Fragment> mFragnents = new ArrayList<>();

    private CommonTabLayout tabLayout;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.tab_viewpager_with_toolbar;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        mTitles = getTitles();
        mFragnents = getFragments();
        if(mTitles==null||mFragnents==null||mFragnents.isEmpty()||mFragnents.size()!=mTitles.length){

            return;
        }
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        FragPagerAdapter fpa = new FragPagerAdapter(getSupportFragmentManager());
        fpa.setFragmentList(mFragnents);
        viewPager.setOffscreenPageLimit(mTitles.length);
        viewPager.setAdapter(fpa);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tabLayout.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public abstract List<Fragment> getFragments();

    public abstract String[] getTitles();

}
