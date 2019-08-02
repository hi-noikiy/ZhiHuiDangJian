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
    }

    @Override
    protected void initData() {
        noticeAnnouncementId = getIntent().getStringExtra("id");
        queryNoticeAnnouncementDetail();
//        PresenterAboutMain presenterAboutMain = new PresenterAboutMain(this);
//        Map<String, Object> map = new HashMap<>();
//        map.put("noticeAnnouncementId", getIntent().getStringExtra("id"));
//        presenterAboutMain.apiAppApiQueryNoticeAnnouncementDetail(map, new MainAboutMain.IView() {
//            @Override
//            public void Success(int type, Object bean) {
//                BaseBean<NoticeAnnouncementsBean> noticeAnnouncementsBeanBaseBean = (BaseBean<NoticeAnnouncementsBean>) bean;
//                textTitle.setText(noticeAnnouncementsBeanBaseBean.getData().getNoticeAnnouncement().getAnnouncementTitle());
//                webView.loadDataWithBaseURL(null, noticeAnnouncementsBeanBaseBean.getData().getNoticeAnnouncement().getAnnouncementComtent(), "text/html", "UTF-8", null);
//            }
//
//            @Override
//            public void Failed(int type, String e) {
//                ToastUtils.show(e);
//            }
//        });
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
                    textTitle.setText(entity.getData().getNoticeAnnouncement().getAnnouncementTitle());
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
