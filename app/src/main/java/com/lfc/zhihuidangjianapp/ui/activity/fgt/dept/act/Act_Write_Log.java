package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyStrongBureau;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.Arrays;

/**
 * @date: 2019-08-10
 * @autror: guojian
 * @description:
 */
public class Act_Write_Log extends BaseActivity {

    private RecyclerView recyclerView;

    private String[] titles = {"一、参加组织生活情况：","二、参加学习教育情况：",
    "三、承诺践诺完成情况（含党员示范岗、党员责任区的完成情况）：","四、其他需报告党组织事宜："};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_write_log;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        initImmersionBar(0);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<String>(Act_Write_Log.this, R.layout.item_write_log, Arrays.asList(titles)) {
            @Override
            protected void convert(ViewHolder holder, String data, int position) {
                holder.setText(R.id.tv_title, data);
            }

        });
    }

    @Override
    protected void initData() {

    }
}
