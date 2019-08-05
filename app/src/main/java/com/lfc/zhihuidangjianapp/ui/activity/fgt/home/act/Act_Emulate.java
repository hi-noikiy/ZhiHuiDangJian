package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private RecyclerView rvStudyStrong, rvStudyStrongVideo;

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
        rvStudyStrong = findViewById(R.id.rv_study_strong);
        rvStudyStrongVideo = findViewById(R.id.rv_study_strong_video);
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
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryStudyStrongBureauVideoPageList(MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<ResponseStudyStrong>(getActivity()) {

                    @Override
                    protected void onNext(ResponseStudyStrong response) {
                        Log.e("onNext= ",response.toString());
                        setRecyclerView(response);
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ",e.getMessage());
                    }
                }.actual());
    }

    private void setRecyclerView(ResponseStudyStrong response){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //工匠培养
        rvStudyStrong.setLayoutManager(linearLayoutManager);
        rvStudyStrong.setAdapter(new CommonAdapter<StudyStrongBureau>(getActivity(), R.layout.item_study_strong
                , response.getStudyStrongBureauList().getDatas()) {
            @Override
            protected void convert(ViewHolder holder, StudyStrongBureau data, int position) {
                holder.setText(R.id.tv_title, data.getTitle());
                ImageView image = holder.getConvertView().findViewById(R.id.image);
                Glide.with(getContext()).load(ApiConstant.ROOT_URL+data.getThumbnailUrl()).into(image);
                holder.getConvertView().setOnClickListener(Act_Strong_Study_Experience->{
                    Intent intent = new Intent(getActivity(), com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Strong_Study_Experience.class);
                    intent.putExtra("studyStrongBureauId", data.getStudyStrongBureauId()+"");
                    startActivity(intent);
                });
            }

        });
        //学习心得
        rvStudyStrongVideo.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvStudyStrongVideo.setAdapter(new CommonAdapter<StudyStrongBureau>(getActivity(), R.layout.item_stuty_strong_video
                , response.getStudyStrongBureauList().getDatas()) {
            @Override
            protected void convert(ViewHolder holder, StudyStrongBureau data, int position) {
                ImageView image = holder.getConvertView().findViewById(R.id.image);
                Glide.with(getContext()).load(ApiConstant.ROOT_URL+data.getThumbnailUrl()).into(image);
                holder.getConvertView().setOnClickListener(Act_Strong_Study_Experience->{
                    Intent intent = new Intent(getActivity(), com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Strong_Study_Experience.class);
                    intent.putExtra("studyStrongBureauId", data.getStudyStrongBureauId()+"");
                    startActivity(intent);
                });
            }

        });
    }
}
