package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dept;
import com.lfc.zhihuidangjianapp.ui.activity.model.Depts;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
import com.lfc.zhihuidangjianapp.widget.MyListView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 党建矩阵fragment
 */
public class Fgt_PartyBuilDingMatrix extends BaseFragment {
    private int deptNumber = 1;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static Fgt_PartyBuilDingMatrix getInstance(int arg) {
        Fgt_PartyBuilDingMatrix sf = new Fgt_PartyBuilDingMatrix();
        Bundle bundle = new Bundle();
        bundle.putInt("deptNumber", arg);
        sf.setArguments(bundle);
        return sf;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fgt_partybuildingmatrix;
    }

    Unbinder unbinder;

    @Override
    protected void initView(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
        deptNumber = getArguments().getInt("deptNumber");
    }

    private void loadData() {
        Map<String, Object> map = new HashMap<>();
        map.put("deptNumber", "1000" + deptNumber);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryDeptList(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<Depts>(getActivity()) {

                    @Override
                    protected void onNext(Depts response) {
                        Log.e("onNext= ", response.toString());
                        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
                        recyclerView.setAdapter(new CommonAdapter<Dept>(getActivity(), R.layout.item_dept, response.getDeptList()) {
                            @Override
                            protected void convert(ViewHolder holder, Dept dept, int position) {
                                holder.setText(R.id.tv_dept, dept.getAbbreviation());
                                ImageView image = holder.getView(R.id.image);
                                image.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                                    @Override
                                    public void onGlobalLayout() {
                                        image.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                        setViewSize(image, image.getWidth(), image.getWidth());
                                    }
                                });
                            }

                        });
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }

    private void setViewSize(View view, int targetWidth, int targetHeight) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = targetWidth;
        params.height = targetHeight;
        view.setLayoutParams(params);
    }

    @Override
    protected void initData() {
        loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
