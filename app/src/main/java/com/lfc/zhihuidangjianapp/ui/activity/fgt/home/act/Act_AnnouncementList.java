package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.google.gson.Gson;
import com.hjq.toast.ToastUtils;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.BaseBean;
import com.lfc.zhihuidangjianapp.bean.NoticeAnnouncementsListBean;
import com.lfc.zhihuidangjianapp.bean.QueryHomeNoticeAnnouncementPageListBean;
import com.lfc.zhihuidangjianapp.net.http.HttpHelper;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.adapter.AnnouncementListAdapter;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean.queryNoticeAnnouncementPageListBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 公告公示
 */
public class Act_AnnouncementList extends BaseActivity {
    @BindView(R.id.imgBack)
    ImageView imgBack;
    @BindView(R.id.imgSearch)
    ImageView imgSearch;
    private PtrClassicFrameLayout ptrClassicFrameLayout;
    private ArrayList<NoticeAnnouncementsListBean.NoticeAnnouncementListBean.DatasBean> list = new ArrayList<>();
    private AnnouncementListAdapter announcementListAdapter;
    private int page = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_announcement_list;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        initImmersionBar(1);
        ptrClassicFrameLayout = findViewById(R.id.ptrClassicFrameLayout);
        ListView announcementListView = findViewById(R.id.announcementListView);
        announcementListAdapter = new AnnouncementListAdapter(datas, this);
        announcementListView.setAdapter(announcementListAdapter);
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                datas.clear();
                page = 1;
                queryNoticeAnnouncementPageList();
                announcementListAdapter.notifyDataSetChanged();
                frame.refreshComplete();
            }
        });
        ptrClassicFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                queryNoticeAnnouncementPageList();
                ptrClassicFrameLayout.loadMoreComplete(true);
                page++;
            }
        });
        announcementListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getActivity(), Act_Announcement.class);
            intent.putExtra("id", datas.get(position).getNoticeAnnouncementId() + "");
            startActivity(intent);
        });
    }

    @Override
    protected void initData() {
        queryNoticeAnnouncementPageList();
    }


    @OnClick(R.id.imgBack)
    public void onImgBackClicked() {
        finish();
    }

    @OnClick(R.id.imgSearch)
    public void onImgSearchClicked() {
    }

    List<queryNoticeAnnouncementPageListBean.DataBean.NoticeAnnouncementListBean.DatasBean> datas = new ArrayList<>();

    /**
     * 分页公告信息
     */
    public void queryNoticeAnnouncementPageList() {
        HttpHelper.queryNoticeAnnouncementPageList(new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                queryNoticeAnnouncementPageListBean entity = gson.fromJson(succeed, queryNoticeAnnouncementPageListBean.class);
                if (entity.getCode() == 0) {
                    for (int i = 0; i < entity.getData().getNoticeAnnouncementList().getDatas().size(); i++) {
                        datas.add(entity.getData().getNoticeAnnouncementList().getDatas().get(i));
                    }
                    announcementListAdapter.notifyDataSetChanged();
                } else {
                    ToastUtils.show(entity.getMsg());
                }
            }

            @Override
            public void onError(String error) {
                ToastUtils.show(error);
            }
        });
    }
}
