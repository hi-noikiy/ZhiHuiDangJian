package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.text.Html;
import android.util.Log;
import android.view.View;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLife;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLifeDetail;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @date: 2019-08-10
 * @autror: guojian
 * @description:
 */
public class Fgt_Weekend_Report extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weekend_report;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {
            RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .queryWeeklyWorkReportTopPageList( MyApplication.getLoginBean().getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new ResponseObserver<Object>(getActivity()) {

                        @Override
                        protected void onNext(Object response) {
                            Log.e("onNext= ", response.toString());
                            if(response==null)return;
                        }

                        @Override
                        protected void onError(Throwable e) {
                            super.onError(e);
                            Log.e("Throwable= ", e.getMessage());
                        }
                    }.actual());
    }
}
