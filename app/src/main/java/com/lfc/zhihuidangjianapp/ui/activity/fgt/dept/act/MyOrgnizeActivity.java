package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.util.Log;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.Payment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-09-03
 * @autror: guojian
 * @description: 代缴党费我的组织
 */
public class MyOrgnizeActivity extends BaseActivity {

    private TextView tvDeptName, tvPayCount, tvDescription, tvPay;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_orgnize;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        tvDeptName = findViewById(R.id.tvDeptName);
        tvPayCount = findViewById(R.id.tvPayCount);
        tvDescription = findViewById(R.id.tvDescription);
        tvPay = findViewById(R.id.tvPay);
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        initImmersionBar(0);
    }

    @Override
    protected void initData() {
        queryMyPartyPaymentHis();
    }

    /**
     * 查询党费缴费记录信息-我的组织
     */
    private void queryMyPartyPaymentHis(){
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryMyPartyPaymentHis( MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<Payment>(getActivity()) {

                    @Override
                    protected void onNext(Payment response) {
                        Log.e("onNext= ", response.toString());
                        if(response==null) return;
                        tvDeptName.setText(response.getDeptName());
                        tvPayCount.setText(response.getMoney());
                        tvDescription.setText("党组织内有"+response.getPersonTotalCount()+"人，"+response.getYearMonth()+"需交党费"+response.getMoney()+
                                "元"+response.getPaidCount()+"人已交，"+response.getUnPaidCount()+"人未缴。");
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }

}
