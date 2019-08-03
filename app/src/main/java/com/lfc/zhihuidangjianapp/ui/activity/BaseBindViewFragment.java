package com.lfc.zhihuidangjianapp.ui.activity;

import android.view.View;

import com.lfc.zhihuidangjianapp.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date: 2019-08-03
 * @autror: guojian
 * @description:
 */
public abstract class BaseBindViewFragment extends BaseFragment {

    private Unbinder unbinder;

    @Override
    protected void initView(View rootView) {
        //沉浸式状态栏
        unbinder = ButterKnife.bind(getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}
