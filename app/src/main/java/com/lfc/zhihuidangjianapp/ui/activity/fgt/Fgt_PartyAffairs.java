package com.lfc.zhihuidangjianapp.ui.activity.fgt;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.DividerItemDecoration;
import com.lfc.zhihuidangjianapp.ui.activity.model.NativePartyBody;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * 党务工作
 */
public class Fgt_PartyAffairs extends BaseFragment {

    private RecyclerView recyclerView;

    private int count = 4;

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview_with_appbar;
    }

    @Override
    protected void initView(View rootView) {
        rootView.findViewById(R.id.imgBack).setVisibility(View.GONE);
        TextView title = rootView.findViewById(R.id.tv_title);
        title.setText("党务工作");
        recyclerView = rootView.findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<List<NativePartyBody.PartBody>>(getActivity(), R.layout.item_party, new NativePartyBody().getPartBodys()) {

            @Override
            protected void convert(ViewHolder holder, List<NativePartyBody.PartBody> partBodies, int position) {
                holder.setText(R.id.tv_title, partBodies.get(0).title);
                RecyclerView itemRecyclerView = holder.getConvertView().findViewById(R.id.item_recyclerview);
                setItemRecyclerView(partBodies, itemRecyclerView);
            }

        });
        recyclerView.addItemDecoration(new DividerItemDecoration(
                DividerItemDecoration.VERTICAL_LIST,
                ContextCompat.getColor(getActivity(), R.color.background),
                DispalyUtil.dp2px(getActivity(), 1),
                0, 0, false
        ));
    }

    private void setItemRecyclerView(List<NativePartyBody.PartBody> partBodies, RecyclerView recyclerView){
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), count));
        recyclerView.setAdapter(new CommonAdapter<NativePartyBody.PartBody>(getActivity(), R.layout.item_home_func, partBodies) {

            @Override
            protected void convert(ViewHolder holder, NativePartyBody.PartBody data, int position) {
                holder.setText(R.id.text, data.text);
                holder.setImageDrawable(R.id.icon, getResources().getDrawable(data.imageRes));
            }

        });
    }

}
