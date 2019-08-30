package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.HomeHead;
import com.lfc.zhihuidangjianapp.ui.activity.model.HomeHeadLines;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-29
 * @autror: guojian
 * @description:
 */
public class HomeHeadLinesFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview;
    }

    @Override
    protected void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);
    }

    private void setRecyclerView(HomeHeadLines response){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<HomeHead>(recyclerView.getContext(), R.layout.item_home_head, response.getExamineList()) {
            @Override
            protected void convert(ViewHolder holder, HomeHead data, int position) {
                holder.setText(R.id.tv_title, data.getTitle());
                holder.setText(R.id.tv_content, data.getReleaseDate());
                ImageView image = holder.getConvertView().findViewById(R.id.image);
                Glide.with(image.getContext()).load(ApiConstant.ROOT_URL+data.getUrl());
            }

        });
    }

    @Override
    protected void initData() {
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryHomeHeadLinesList(MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<HomeHeadLines>(getActivity()) {

                    @Override
                    protected void onNext(HomeHeadLines response) {
                        Log.e("onNext= ", response.toString());
                        setRecyclerView(response);
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }
}
