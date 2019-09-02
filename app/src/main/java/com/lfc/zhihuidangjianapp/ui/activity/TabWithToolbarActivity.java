package com.lfc.zhihuidangjianapp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
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

    private SlidingTabLayout tabLayout;

    private ViewPager viewPager;

    private TextView tvAppText, tvRight;

    @Override
    protected int getLayoutId() {
        return R.layout.tab_viewpager_with_toolbar;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        tvRight = findViewById(R.id.tvRight);
        tvAppText = findViewById(R.id.tv_title);
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
        tabLayout.setViewPager(viewPager, mTitles);
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

    public void setAppText(String text){
        if(tvAppText!=null){
            tvAppText.setText(text);
        }
    }

    public TextView getTvRight() {
        return tvRight;
    }

    public abstract List<Fragment> getFragments();

    public abstract String[] getTitles();

}
