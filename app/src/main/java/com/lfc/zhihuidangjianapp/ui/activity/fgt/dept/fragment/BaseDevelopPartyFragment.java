package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.DividerItemDecoration;
import com.lfc.zhihuidangjianapp.ui.activity.model.NativeDevelopParty;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description:
 */
public abstract class BaseDevelopPartyFragment extends BaseFragment {

    private List<NativeDevelopParty> parties = new ArrayList<>();

    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview;
    }

    @Override
    protected void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        parties = getParties();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<NativeDevelopParty>(getActivity(), R.layout.item_develop_party, parties) {
            @Override
            protected void convert(ViewHolder holder, NativeDevelopParty data, int position) {
                if(data.getStyleId() == 0){
                    holder.getConvertView().findViewById(R.id.input).setVisibility(View.GONE);
                    holder.getConvertView().findViewById(R.id.tvContent).setVisibility(View.VISIBLE);
                }else{
                    holder.getConvertView().findViewById(R.id.input).setVisibility(View.VISIBLE);
                    holder.getConvertView().findViewById(R.id.tvContent).setVisibility(View.GONE);
                }
                holder.setText(R.id.tvTitle, data.getTitle());
            }

        });
        recyclerView.addItemDecoration(new DividerItemDecoration(
                DividerItemDecoration.VERTICAL_LIST,
                ContextCompat.getColor(getActivity(), R.color.background),
                DispalyUtil.dp2px(getActivity(), 1),
                0, 0, false
        ));
    }

    public abstract List<NativeDevelopParty> getParties();

}
