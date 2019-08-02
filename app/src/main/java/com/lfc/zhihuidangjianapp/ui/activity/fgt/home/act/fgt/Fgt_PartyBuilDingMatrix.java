package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt;

import android.view.View;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.widget.MyListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fgt_PartyBuilDingMatrix extends BaseFragment {
    private String mTitle;
    @BindView(R.id.haah)
    TextView haah;
    public static Fgt_PartyBuilDingMatrix getInstance(String title) {
        Fgt_PartyBuilDingMatrix sf = new Fgt_PartyBuilDingMatrix();
        sf.mTitle = title;
        return sf;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fgt_partybuildingmatrix;
    }
    Unbinder unbinder;
    @Override
    protected void initView(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
        haah.setText(mTitle);
    }

    @Override
    protected void initData() {

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
