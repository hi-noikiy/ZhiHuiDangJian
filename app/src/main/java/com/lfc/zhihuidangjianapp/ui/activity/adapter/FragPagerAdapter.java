package com.lfc.zhihuidangjianapp.ui.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;


public class FragPagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;

    public void setFragmentList(List<Fragment> fragmentList) {
        if (this.fragmentList != null) {
            this.fragmentList.clear();
        }
        this.fragmentList = fragmentList;
    }

    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
