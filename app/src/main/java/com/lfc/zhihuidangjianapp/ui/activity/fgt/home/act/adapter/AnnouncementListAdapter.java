package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean.queryNoticeAnnouncementPageListBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AnnouncementListAdapter extends BaseAdapter {

    private List<queryNoticeAnnouncementPageListBean.DataBean.NoticeAnnouncementListBean.DatasBean> list;
    private Context context;

    public AnnouncementListAdapter(List<queryNoticeAnnouncementPageListBean.DataBean.NoticeAnnouncementListBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_announcementlist, null);
            viewHolder.textTitle = convertView.findViewById(R.id.textTitle);
            viewHolder.textTime = convertView.findViewById(R.id.textTime);
            viewHolder.textContent = convertView.findViewById(R.id.textContent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        queryNoticeAnnouncementPageListBean.DataBean.NoticeAnnouncementListBean.DatasBean datasBean = list.get(position);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        viewHolder.textTitle.setText(datasBean.getAnnouncementTitle());
        viewHolder.textTime.setText(formatter.format(new Date(datasBean.getCreateTime())));
        viewHolder.textContent.setText(datasBean.getDepartment());
        return convertView;
    }

    class ViewHolder {
        TextView textTitle, textTime, textContent;
    }
}
