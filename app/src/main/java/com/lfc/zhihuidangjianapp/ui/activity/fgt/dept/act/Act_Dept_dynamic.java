package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.TabEntity;
import com.lfc.zhihuidangjianapp.ui.activity.BaseBindViewActivity;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.FragPagerAdapter;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt.Fgt_Dept_dynamic;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @date: 2019-08-03
 * @autror: guojian
 * @description:
 */
public class Act_Dept_dynamic extends BaseBindViewActivity {

    private String[] mTitles = {"党建动态", "群团统战", "廉政建设"};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private List<Fragment> fragments;

    @BindView(R.id.tab)
    CommonTabLayout tab;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dept_dynamic;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        super.initView();
        FragPagerAdapter fpa = new FragPagerAdapter(getSupportFragmentManager());
        fpa.setFragmentList(list());
        viewPager.setOffscreenPageLimit(mTitles.length);
        viewPager.setAdapter(fpa);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i]));
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
        setEvent();
    }

    private void setEvent() {
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
    }

    private List<Fragment> list(){
        fragments = new ArrayList<>();
        for (int i=0;i<mTitles.length;i++){
            Fgt_Dept_dynamic fgtDeptDynamic = new Fgt_Dept_dynamic();
            Bundle bundle = new Bundle();
            bundle.putInt("partyDynamicType", i);
            fgtDeptDynamic.setArguments(bundle);
            fragments.add(fgtDeptDynamic);
        }
        return fragments;
    }

    @Override
    protected void initData() {

    }
}
