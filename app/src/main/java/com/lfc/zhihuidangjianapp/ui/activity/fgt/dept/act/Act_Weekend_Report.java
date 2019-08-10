package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLife;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLifeDetail;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-06
 * @autror: guojian
 * @description:
 */
public class Act_Weekend_Report extends BaseActivity {

    private ImageView create;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weekend_report;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        initImmersionBar(0);
        create = findViewById(R.id.create);

        setEvent();
    }

    private void setEvent() {
        create.setOnClickListener(ceate->{
            startActivity(new Intent(this, Act_Write_Weekend_Log.class));
//            RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
//                    .queryOrganizationalLifeDetail(map, MyApplication.getLoginBean().getToken())
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new ResponseObserver<OrganizationalLifeDetail>(getActivity()) {
//
//                        @Override
//                        protected void onNext(OrganizationalLifeDetail response) {
//                            Log.e("onNext= ", response.toString());
//                            if(response==null)return;
//                            OrganizationalLife dynamic = response.getOrganizationalLife();
//                            tvTitle.setText(dynamic.getTitle());
//                            tvAuthor.setText(dynamic.getAuthor());
//                            tvContent.setText(Html.fromHtml(dynamic.getComment()));
//                        }
//
//                        @Override
//                        protected void onError(Throwable e) {
//                            super.onError(e);
//                            Log.e("Throwable= ", e.getMessage());
//                        }
//                    }.actual());
        });
    }

    @Override
    protected void initData() {

    }
}
