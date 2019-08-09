package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dynamic;
import com.lfc.zhihuidangjianapp.ui.activity.model.DynamicDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLife;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLifeDetail;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-04
 * @autror: guojian
 * @description: 党建动态详情
 */
public class Act_Organizational_Life_Detail extends BaseActivity {

    private String organizationalLifeId;

    private TextView tvTitle, tvAuthor, tvContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_orgnization_life_detail;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        tvTitle = findViewById(R.id.tv_title);
        tvAuthor = findViewById(R.id.tv_author);
        tvContent = findViewById(R.id.tv_content);
    }

    @Override
    protected void initData() {
        organizationalLifeId = getIntent().getStringExtra("organizationalLifeId");
        Map<String, Object> map = new HashMap<>();
        map.put("organizationalLifeId", organizationalLifeId);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryOrganizationalLifeDetail(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<OrganizationalLifeDetail>(getActivity()) {

                    @Override
                    protected void onNext(OrganizationalLifeDetail response) {
                        Log.e("onNext= ", response.toString());
                        if(response==null)return;
                        OrganizationalLife dynamic = response.getOrganizationalLife();
                        tvTitle.setText(dynamic.getTitle());
                        tvAuthor.setText(dynamic.getAuthor());
                        tvContent.setText(Html.fromHtml(dynamic.getComment()));
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }
}
