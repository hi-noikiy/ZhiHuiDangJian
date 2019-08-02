package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.demonstration_leadership.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.demonstration_leadership.bean.QueryLeadDemonstrationPageListBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class Demonstration_LeadershipAdapter extends BaseQuickAdapter<QueryLeadDemonstrationPageListBean.DataBean.LeadDemonstrationListBean.DatasBean, BaseViewHolder> {
    Context mContext;

    public Demonstration_LeadershipAdapter(Context context, @Nullable List<QueryLeadDemonstrationPageListBean.DataBean.LeadDemonstrationListBean.DatasBean> data) {
        super(R.layout.item_demonstration_leadership, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, QueryLeadDemonstrationPageListBean.DataBean.LeadDemonstrationListBean.DatasBean item) {
        Glide.with(mContext).load(ApiConstant.ROOT_URL + item.getThumbnailUrl()).into((RoundedImageView) helper.getView(R.id.item_demonstration_img));
        helper.setText(R.id.item_demonstration_title, item.getTitle());
        helper.setText(R.id.item_demonstration_context, Html.fromHtml(item.getComment()));
        helper.addOnClickListener(R.id.demonstration_item);
    }
}
