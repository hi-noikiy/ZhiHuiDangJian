package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act;

import android.util.Log;
import android.widget.EditText;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @date: 2019-08-10
 * @autror: guojian
 * @description:
 */
public class Act_Write_Report extends BaseActivity {

    private EditText etTheme, etContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_write_report;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        findViewById(R.id.imgBack).setOnClickListener(back->finish());
        initImmersionBar(0);
        etTheme = findViewById(R.id.et_theme);
        etContent = findViewById(R.id.et_content);

        setEvent();
    }

    private void setEvent() {
        findViewById(R.id.tv_submit).setOnClickListener(submit->{
            if(etTheme.getText().toString().trim().isEmpty()){
                showTextToast("请填写主题");
                return;
            }
            if(etContent.getText().toString().trim().isEmpty()){
                showTextToast("请填写内容");
                return;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("studyStrongBureauType", 2);
            map.put("title", etTheme.getText().toString().trim());
            map.put("comment", etContent.getText().toString().trim());
            RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .insertStudyStrongBureau( map, MyApplication.getLoginBean().getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new ResponseObserver<Object>(getActivity()) {

                        @Override
                        protected void onNext(Object response) {
                            Log.e("onNext= ", response.toString());
                            if(response==null)return;
                            showTextToast("发布成功");
                            finish();
                        }

                        @Override
                        protected void onError(Throwable e) {
                            super.onError(e);
                            Log.e("Throwable= ", e.getMessage());
                        }
                    }.actual());
        });
    }

    @Override
    protected void initData() {

    }
}
