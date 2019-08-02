package com.lfc.zhihuidangjianapp.adapter.baseadapterL.commonadcpter;

public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
