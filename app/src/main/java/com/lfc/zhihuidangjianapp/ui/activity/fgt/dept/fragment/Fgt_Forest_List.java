package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.BaseBindViewFragment;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.DividerItemDecoration;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Dept_Dynamic_Detail;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dynamic;
import com.lfc.zhihuidangjianapp.ui.activity.model.Forest;
import com.lfc.zhihuidangjianapp.ui.activity.model.ForestDistrict;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyDynamicList;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-04
 * @autror: guojian
 * @description:
 */
public class Fgt_Forest_List extends BaseBindViewFragment {

    RecyclerView recyclerView;

    private Unbinder unbinder;

    private int partyDynamicType;

    private int layoutId;

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview;
    }

    @Override
    protected void initData() {
        partyDynamicType = getArguments().getInt("leadDemonstrationType", 0);
        if (partyDynamicType == 0) {
            layoutId = R.layout.item_fine_party_group;
        } else {
            layoutId = R.layout.item_forest_list;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("forestDistrictType", partyDynamicType);
        map.put("pageSize", 20);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryForestShowPageList(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<Object>(getActivity()) {

                    @Override
                    protected void onNext(Object response) {
                        Log.e("onNext= ", response.toString());
                        if (response == null) return;
//                        setRecyclerView(response);
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

    private void setRecyclerView(ForestDistrict response) {
        if (partyDynamicType == 0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new CommonAdapter<Forest>(getActivity(), layoutId, response.getForestDistrictList().getDatas()) {
                @Override
                protected void convert(ViewHolder holder, Forest data, int position) {
                    TextView tvContent = holder.getConvertView().findViewById(R.id.tv_content);
                    tvContent.setText(Html.fromHtml(data.getComment()));
                    ImageView image = holder.getConvertView().findViewById(R.id.image);
                    String url = ApiConstant.ROOT_URL + data.getThumbnailUrl();
                    Glide.with(getActivity()).load(url).into(image);
                }

            });
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            recyclerView.setAdapter(new CommonAdapter<Forest>(getActivity(), layoutId, response.getForestDistrictList().getDatas()) {
                @Override
                protected void convert(ViewHolder holder, Forest data, int position) {
                    ImageView image = holder.getConvertView().findViewById(R.id.image);
                    String url = ApiConstant.ROOT_URL + data.getThumbnailUrl();
                    Glide.with(getActivity()).load(url).into(image);
                    holder.setText(R.id.tvName, data.getCreateName());
                    holder.setText(R.id.tvName, data.getCreateName());
                    holder.setText(R.id.tvName, data.getCreateName());
                    holder.setText(R.id.tvName, data.getCreateName());
                    holder.setText(R.id.tvName, data.getCreateName());
                }

            });
        }

        recyclerView.addItemDecoration(new DividerItemDecoration(
                DividerItemDecoration.VERTICAL_LIST,
                ContextCompat.getColor(getActivity(), R.color.background),
                DispalyUtil.dp2px(getActivity(), 1),
                0, 0, false
        ));
    }

}
