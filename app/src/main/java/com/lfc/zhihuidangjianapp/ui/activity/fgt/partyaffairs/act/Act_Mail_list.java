package com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.act;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.hjq.toast.ToastUtils;
import com.hyphenate.chatuidemo.conference.ConferenceActivity;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.bean.SortModel;
import com.lfc.zhihuidangjianapp.net.http.HttpHelper;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean.queryNoticeAnnouncementPageListBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.adapter.SortAdapter;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.bean.queryUserListByFirstPinYinBean;
import com.lfc.zhihuidangjianapp.utlis.PinyinComparator;
import com.lfc.zhihuidangjianapp.utlis.PinyinUtils;
import com.lfc.zhihuidangjianapp.view.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 通讯录
 */
public class Act_Mail_list extends BaseActivity implements View.OnClickListener {

    private TextView title[] = new TextView[4];
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.sideBar) SideBar sideBar;
    @BindView(R.id.dialog) TextView dialog;
    @BindView(R.id.textInvite) TextView textInvite;
    LinearLayoutManager manager;
    private PinyinComparator pinyinComparator;

    private ArrayList<SortModel> selectListName = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.act_mail_list;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        initImmersionBar(0);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        findViewById(R.id.imgBack).setOnClickListener(this);
        findViewById(R.id.ll_title1).setOnClickListener(this);
        findViewById(R.id.ll_title2).setOnClickListener(this);
        findViewById(R.id.ll_title3).setOnClickListener(this);
        findViewById(R.id.ll_title4).setOnClickListener(this);
        textInvite.setOnClickListener(this);
        title[0] = findViewById(R.id.tv_title1);
        title[1] = findViewById(R.id.tv_title2);
        title[2] = findViewById(R.id.tv_title3);
        title[3] = findViewById(R.id.tv_title4);
        pinyinComparator = new PinyinComparator();
        //RecyclerView社置manager
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setNestedScrollingEnabled(false);
        sideBar.setTextView(dialog);
        //设置右侧SideBar触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    manager.scrollToPositionWithOffset(position, 0);
                }
            }
        });
    }

    private SortAdapter adapter;

    @Override
    protected void initData() {
        swiche(0);
        partyPosts = "deptNumber";
        loding.show();
        queryUserListByFirstPinYin();
    }

    /**
     * 沉浸式状态栏
     */
    @Override
    protected void initImmersionBar(int type) {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this).statusBarDarkFont(statusBarDarkFont())    //默认状态栏字体颜色为黑色
            .keyboardEnable(false, WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
        //必须设置View树布局变化监听，否则软键盘无法顶上去，还有模式必须是SOFT_INPUT_ADJUST_PAN
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        if (type == 0) {
            initImmersionBarBlack();
        } else {
            initImmersionBarWhite();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.ll_title1:
                swiche(0);
                partyPosts = "deptNumber";
                loding.show();
                queryUserListByFirstPinYin();
                break;
            case R.id.ll_title2:
                swiche(1);
                partyPosts = "sealName";
                loding.show();
                queryUserListByFirstPinYin();
                break;
            case R.id.ll_title3:
                swiche(2);
                partyPosts = "firstPinYin";
                loding.show();
                queryUserListByFirstPinYin();
                break;
            case R.id.ll_title4:
                swiche(3);
                break;
            case R.id.textInvite:
                if (selectListName.isEmpty() || SourceDateList.isEmpty()) {
                    return;
                }


                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("INTENT_MEMBER", selectListName);
                ConferenceActivity.startConferenceCall(getActivity(), null, bundle);
                break;
            default:
        }
    }

    private int indext = 0;

    public void swiche(int page) {
        title[indext].setSelected(false);
        title[page].setSelected(true);
        indext = page;
    }

    private String partyPosts = "";

    /**
     * 通讯录-按首字母查询
     */
    public void queryUserListByFirstPinYin() {
        HttpHelper.queryUserListByFirstPinYin(partyPosts, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                queryUserListByFirstPinYinBean entity = gson.fromJson(succeed, queryUserListByFirstPinYinBean.class);
                if (entity.getCode() == 0) {
                    List<String> HotCities = new ArrayList<>();
                    List<String> imList = new ArrayList<>();
                    for (int i = 0; i < entity.getData().getUserList().size(); i++) {
                        HotCities.add(entity.getData().getUserList().get(i).getSealName());
                        imList.add(entity.getData().getUserList().get(i).getLoginName());
                    }
                    SourceDateList = filledData(HotCities, imList);// 根据a-z进行排序源数据
                    Collections.sort(SourceDateList, pinyinComparator);
                    //                    for (int i=0;i<entity.getData().getUserList().size();i++){
                    //                              for (int j=0;j<SourceDateList.size();j++){
                    //                                  if(entity.getData().getUserList().get(i).get)
                    //
                    //                              }
                    //                    }
                    adapter = new SortAdapter(Act_Mail_list.this, SourceDateList, selectListName);
                    adapter.setOnItemClickListener(new SortAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            if (adapter.getItem(position) instanceof SortModel) {

                                if (selectListName.contains(((SortModel) adapter.getItem(position)))) {
                                    selectListName.remove(((SortModel) adapter.getItem(position)));
                                } else {
                                    selectListName.add(((SortModel) adapter.getItem(position)));
                                }

                                adapter.notifyDataSetChanged();

                                if (selectListName.isEmpty()) {
                                    textInvite.setVisibility(View.GONE);
                                } else {
                                    textInvite.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                    });
                    mRecyclerView.setAdapter(adapter);
                    Log.e("aa", "----------------succeed==" + entity.getData().getUserList().size() + "------------"
                        + MyApplication.getLoginBean().getToken());
                } else {
                    ToastUtils.show(entity.getMsg());
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                ToastUtils.show(error);
            }
        });
    }

    private List<SortModel> SourceDateList;

    /**
     * 为RecyclerView填充数据
     */
    private List<SortModel> filledData(List<String> date, List<String> imList) {
        List<SortModel> mSortList = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date.get(i));
            sortModel.setImName(imList.get(i));
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(date.get(i));
            String sortString = pinyin.substring(0, 1).toUpperCase();
            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setLetters(sortString.toUpperCase());
            } else {
                sortModel.setLetters("#");
            }
            mSortList.add(sortModel);
        }
        return mSortList;
    }
}
