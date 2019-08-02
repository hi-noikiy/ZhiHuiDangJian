package com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.act;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.adapter.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.lfc.zhihuidangjianapp.adapter.baseadapterL.commonadcpter.ViewHolderHelper;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.SortModel;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;

import java.util.ArrayList;

/**
 * @author zhouyong
 */
public class Act_InviteList extends BaseActivity {

    private ArrayList<SortModel> list;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_invite_list;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        findViewById(R.id.imgBack).setOnClickListener(v -> finish());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        list = getIntent().getParcelableArrayListExtra("INTENT_MEMBER");

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        InviteListAdapter inviteListAdapter = new InviteListAdapter(this);
        recyclerView.setAdapter(inviteListAdapter);
        inviteListAdapter.addAll(list);
    }

    @Override
    protected void initData() {

    }

    class InviteListAdapter extends CommonRecycleViewAdapter<SortModel> {

        InviteListAdapter(Context context) {
            super(context, R.layout.item_invite);
        }

        @Override
        public void convert(ViewHolderHelper helper, SortModel sortModel, int position) {
            helper.getView(R.id.image);
            Glide.with(getContext()).load(sortModel.getImgURl()).into(
                (ImageView) helper.getView(R.id.image));
            TextView textView = helper.getView(R.id.textName);
            textView.setText(sortModel.getName());
            helper.getView(R.id.imgClose).setOnClickListener(v -> {
                getDataList().remove(position);
                notifyDataSetChanged();
            });
        }
    }
}
