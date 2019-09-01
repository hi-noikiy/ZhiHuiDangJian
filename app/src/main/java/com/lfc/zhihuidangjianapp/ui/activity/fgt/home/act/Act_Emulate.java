package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Craftsman_Training;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Strong_Study_Experience;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fragment.HomeStudyFragment;
import com.lfc.zhihuidangjianapp.ui.activity.model.AppConfigLists;
import com.lfc.zhihuidangjianapp.ui.activity.model.DeptDetailUser;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseStudyStrong;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyStrongBureau;
import com.lfc.zhihuidangjianapp.widget.MyListView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 学习强局
 */
public class Act_Emulate extends BaseActivity {

    private RecyclerView rvStudyStrong, rvStudyStrongVideo, rv_study_forest;

    private TextView tvCraft;

    @Override
    protected int getLayoutId() {
        return R.layout.act_emulate;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        tvCraft = findViewById(R.id.tv_craft);
        setEvent();
    }

    private void setEvent() {
        tvCraft.setOnClickListener(act_craft->{
            startActivity(new Intent(this, Act_Craftsman_Training.class));
        });
    }

    @Override
    protected void initData() {
        getSupportFragmentManager().beginTransaction().add(R.id.rv_study_forest, HomeStudyFragment.getInstance(0)).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.rv_study_strong, HomeStudyFragment.getInstance(1)).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.rv_study_strong_video, HomeStudyFragment.getInstance(2)).commit();

    }

}
