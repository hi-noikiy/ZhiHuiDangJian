package com.lfc.zhihuidangjianapp.ui.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @date: 2018/8/9
 * @autror: guojian
 * @description:
 */

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter {

    public interface ItemClickListener{
        void itemClick(Object data, View itemView, int position);
    }

    public ItemClickListener mItemClickListener;

    public void setOnItemClicklistener(ItemClickListener itemClicklistener){
        this.mItemClickListener = itemClicklistener;
    }
}
