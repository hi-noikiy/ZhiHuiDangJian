package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.huawei.hms.api.Api;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.BaseBindViewFragment;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.DividerItemDecoration;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dynamic;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyDynamicList;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
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
 * @date: 2019-08-04
 * @autror: guojian
 * @description:
 */
public class Fgt_Dept_dynamic extends BaseBindViewFragment {

    RecyclerView recyclerView;

    private Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview;
    }

    @Override
    protected void initData() {
        Map<String, Object> map = new HashMap<>();
        map.put("partyDynamicType", 1);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryPartyDynamicPageList(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<ResponsePartyDynamicList>(getActivity()) {

                    @Override
                    protected void onNext(ResponsePartyDynamicList response) {
                        Log.e("onNext= ", response.toString());
                        if(response==null)return;
                        setRecyclerView(response);
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        recyclerView = rootView.findViewById(R.id.recyclerView);
    }

    private void setRecyclerView(ResponsePartyDynamicList response){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<Dynamic>(getActivity(), R.layout.item_dept_dynamic, response.getPartyDynamicList().getDatas()) {
            @Override
            protected void convert(ViewHolder holder, Dynamic data, int position) {
                holder.setText(R.id.tv_title, data.getTitle());
                TextView tvContent = holder.getConvertView().findViewById(R.id.tv_content);
                tvContent.setText(Html.fromHtml(data.getComment()));
                ImageView image = holder.getConvertView().findViewById(R.id.image);
                String url = ApiConstant.ROOT_URL+data.getThumbnail_url();
                Glide.with(getActivity()).load(url).into(image);
            }

        });
        recyclerView.addItemDecoration(new DividerItemDecoration(
                DividerItemDecoration.VERTICAL_LIST,
                ContextCompat.getColor(getActivity(), R.color.divider_list),
                DispalyUtil.dp2px(getActivity(), 5),
                0, 0, false
        ));
    }

}
