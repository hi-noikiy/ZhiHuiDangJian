package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
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
 * @date: 2019-08-09
 * @autror: guojian
 * @description:
 */
public class Fgt_Dept_detail extends BaseFragment {

    TextView tvDeptTitle;
    TextView tvBriefIntrodection;
    TextView tvAddress;
    RecyclerView recyclerView;

    private String deptNumber;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dept_detail;
    }

    @Override
    protected void initView(View rootView) {
        tvDeptTitle = rootView.findViewById(R.id.tv_dept_title);
        tvBriefIntrodection = rootView.findViewById(R.id.tv_brief_introduction);
        tvAddress = rootView.findViewById(R.id.tv_address);
        recyclerView = rootView.findViewById(R.id.rv_group);
    }

    @Override
    protected void initData() {
        deptNumber = getArguments().getString("deptNumber");
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
//        ButterKnife.bind(this);
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
