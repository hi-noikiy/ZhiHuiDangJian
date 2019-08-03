package com.lfc.zhihuidangjianapp.ui.activity.fgt;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.bean.QueryHomeNoticeAnnouncementPageListBean;
import com.lfc.zhihuidangjianapp.net.http.HttpHelper;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_Announcement;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_AnnouncementList;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_Demonstration_Leadership;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_Emulate;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_PartyBuildingMatrix;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_Party_membershipDues;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.Act_WebView;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.adapter.HomeAdapter;
import com.lfc.zhihuidangjianapp.ui.activity.item.BannerViewHolder;
import com.lfc.zhihuidangjianapp.ui.activity.model.AppConfigLists;
import com.lfc.zhihuidangjianapp.widget.MyListView;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Fgt_Home extends BaseFragment {
    @BindView(R.id.homeListView)
    MyListView homeListView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    private ArrayList<QueryHomeNoticeAnnouncementPageListBean.DataBean.NoticeAnnouncementListBean.DatasBean> list = new ArrayList<>();
    private HomeAdapter homeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
        homeAdapter = new HomeAdapter(list, getActivity());
        homeListView.setAdapter(homeAdapter);
        homeListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getActivity(), Act_Announcement.class);
            intent.putExtra("id", list.get(position).getNoticeAnnouncementId() + "");
            startActivity(intent);
        });
        ImmersionBar.with(this).statusBarDarkFont(true).init();

    }

    @Override
    protected void initData() {
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        //内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(getContext()).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            queryHomeNoticeAnnouncementPageList();
            list.clear();
            queryAppConfigList();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        queryHomeNoticeAnnouncementPageList();
        queryAppConfigList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void startWebView(String title, String url) {
        Intent intent = new Intent(getActivity(), Act_WebView.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        getActivity().startActivity(intent);
    }

    @OnClick(R.id.banner)
    public void onImgBannerClicked() {
        String imgPath = "";
        startWebView("详情", imgPath);
    }

    @OnClick(R.id.linear1)//党建矩阵
    public void onLinear1Clicked() {
        startActivity(new Intent(getContext(), Act_PartyBuildingMatrix.class));
    }

    @OnClick(R.id.linear2)//学习强局
    public void onLinear2Clicked() {
        startActivity(new Intent(getContext(), Act_Emulate.class));
    }

    @OnClick(R.id.linear3)
    public void onLinear3Clicked() {
    }

    @OnClick(R.id.linear5)//党费缴纳
    public void onLinear5Clicked() {
        startActivity(new Intent(getContext(), Act_Party_membershipDues.class));
    }

    @OnClick(R.id.linear4)//专题专栏
    public void onLinear4Clicked() {
        startActivity(new Intent(getContext(), Act_Demonstration_Leadership.class));
    }

    @OnClick(R.id.relativeAnnoun)//公告公示
    public void onRelativeAnnounClicked() {
        getActivity().startActivity(new Intent(getActivity(), Act_AnnouncementList.class));
    }

    /**
     * 获取公告列表
     */
    public void queryHomeNoticeAnnouncementPageList() {
        HttpHelper.queryHomeNoticeAnnouncementPageList(new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                QueryHomeNoticeAnnouncementPageListBean entity = gson.fromJson(succeed, QueryHomeNoticeAnnouncementPageListBean.class);
                if (entity.getCode() == 0) {
                    list.addAll(entity.getData().getNoticeAnnouncementList().getDatas());
                    homeAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String error) {
            }
        });
    }

    public void queryAppConfigList() {
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryAppConfigList(MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<AppConfigLists>(getActivity()) {

                    @Override
                    protected void onNext(AppConfigLists response) {
                        setBanner(response);
                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ",e.getMessage());
                    }
                }.actual());
    }

    private void setBanner(AppConfigLists response){
        banner.setImages(response.getAppConfigList().getDatas()).setImageLoader(new BannerViewHolder()).start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }

}
