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
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyDynamicList;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-04
 * @autror: guojian
 * @description: 党建动态详情
 */
public class Act_Dept_Dynamic_Detail extends BaseActivity {

    private String partyDynamicId;

    private TextView tvTitle, tvAuthor, tvContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dept_dynamic_detail;
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
        partyDynamicId = getIntent().getStringExtra("partyDynamicId");
        Map<String, Object> map = new HashMap<>();
        map.put("partyDynamicId", partyDynamicId);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryPartyDynamicDetail(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<DynamicDetail>(getActivity()) {

                    @Override
                    protected void onNext(DynamicDetail response) {
                        Log.e("onNext= ", response.toString());
                        if(response==null)return;
                        Dynamic dynamic = response.getPartyDynamic();
                        tvTitle.setText(dynamic.getTitle());
                        tvAuthor.setText(dynamic.getCreate_name());
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
