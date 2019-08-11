package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hjq.toast.ToastUtils;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.BaseBean;
import com.lfc.zhihuidangjianapp.bean.NoticeAnnouncementsBean;
import com.lfc.zhihuidangjianapp.bean.QueryHomeNoticeAnnouncementPageListBean;
import com.lfc.zhihuidangjianapp.net.http.HttpHelper;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean.queryNoticeAnnouncementDetailBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 公告详情
 */
public class Act_Announcement extends BaseActivity {
    @BindView(R.id.imgBack)
    ImageView imgBack;
    @BindView(R.id.textTitle)
    TextView textTitle;
    @BindView(R.id.imgSearch)
    ImageView imgSearch;
    @BindView(R.id.webView)
    WebView webView;
    TextView tvTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_announcement;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        initImmersionBar(1);
        tvTitle = findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        noticeAnnouncementId = getIntent().getStringExtra("id");
        queryNoticeAnnouncementDetail();
    }

    @OnClick(R.id.imgBack)
    public void onImgBackClicked() {
        finish();
    }

    @OnClick(R.id.imgSearch)
    public void onImgSearchClicked() {
    }
    String noticeAnnouncementId = "";
    /**
     * 查看公告详情信息
     */
    public void queryNoticeAnnouncementDetail() {
        loding.show();
        HttpHelper.queryNoticeAnnouncementDetail(noticeAnnouncementId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                queryNoticeAnnouncementDetailBean entity = gson.fromJson(succeed, queryNoticeAnnouncementDetailBean.class);
                if (entity.getCode() == 0) {
                    tvTitle.setText(entity.getData().getNoticeAnnouncement().getAnnouncementTitle());
                    webView.loadDataWithBaseURL(null, entity.getData().getNoticeAnnouncement().getAnnouncementComtent(), "text/html", "UTF-8", null);
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
            }
        });
    }
}
