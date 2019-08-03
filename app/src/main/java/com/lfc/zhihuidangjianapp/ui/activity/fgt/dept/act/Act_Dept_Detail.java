package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.DeptConstants;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dept;
import com.lfc.zhihuidangjianapp.ui.activity.model.DeptDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.DeptDetailUser;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author guojian
 */
@Route(path = DeptConstants.PATH_DEPT_DETAIL)
public class Act_Dept_Detail extends BaseActivity {

    private String deptNumber;

    @BindView(R.id.tv_dept_title)
    TextView tvDeptTitle;
    @BindView(R.id.tv_brief_introduction)
    TextView tvBriefIntrodection;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rv_group)
    RecyclerView recyclerView;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dept_detail;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        findViewById(R.id.imgBack).setOnClickListener(v -> finish());
    }

    @Override
    protected void initData() {
        deptNumber = getIntent().getStringExtra("deptNumber");
        Map<String, Object> map = new HashMap<>();
        map.put("deptNumber", deptNumber);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryDeptDetail(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<DeptDetail>(getActivity()) {

                    @Override
                    protected void onNext(DeptDetail response) {
                        Log.e("DeptDetail= ", response.toString());
                        if(response==null){
                            return;
                        }
                        initDeptDetail(response);
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }

    private void initDeptDetail(DeptDetail response){
        Dept dept = response.getDept();
        if(dept==null){
            return;
        }
        ButterKnife.bind(this);
        tvDeptTitle.setText(dept.getDeptName());
        tvBriefIntrodection.setText(dept.getBriefIntroduction());
        tvAddress.setText(dept.getDeptAddress());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<DeptDetailUser>(getActivity(), R.layout.item_dept_user, response.getUserlist()) {
            @Override
            protected void convert(ViewHolder holder, DeptDetailUser data, int position) {
                holder.setText(R.id.tv_name, data.getDisplayName());
                holder.setText(R.id.tv_content, data.getSubordinatePartyGroup());
                holder.setText(R.id.tv_tell, data.getMobileNumber());
            }

        });
    }



}
