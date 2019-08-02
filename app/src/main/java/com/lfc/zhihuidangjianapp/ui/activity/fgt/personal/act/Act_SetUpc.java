package com.lfc.zhihuidangjianapp.ui.activity.fgt.personal.act;

import android.widget.Button;

import com.hjq.toast.ToastUtils;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseActivity;
import com.lfc.zhihuidangjianapp.base.BaseDialog;
import com.lfc.zhihuidangjianapp.base.BaseDialogFragment;
import com.lfc.zhihuidangjianapp.helper.CacheDataManager;
import com.lfc.zhihuidangjianapp.image.ImageLoader;

import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 设置页面
 */
public class Act_SetUpc extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_upctivity;
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

    }

    @OnClick(R.id.imgBack)
    public void onImgBackClicked() {
        finish();
    }

    @OnClick(R.id.relative1)
    public void onRelative1Clicked() {
        new BaseDialogFragment.Builder(this)
                .setContentView(R.layout.dialog_cache)
                .setAnimStyle(BaseDialog.AnimStyle.SCALE)
                //.setText(id, "我是预设置的文本")
                .setOnClickListener(R.id.butOK, new BaseDialog.OnClickListener<Button>() {

                    @Override
                    public void onClick(BaseDialog dialog, Button view) {
                        ImageLoader.clear(Act_SetUpc.this);
                        CacheDataManager.clearAllCache(Act_SetUpc.this);
                        dialog.dismiss();
                        ToastUtils.show("缓存已清理");
                    }
                })
                .setOnClickListener(R.id.butNO, new BaseDialog.OnClickListener<Button>() {

                    @Override
                    public void onClick(BaseDialog dialog, Button view) {
                        dialog.dismiss();
                    }
                })
                .addOnShowListener(new BaseDialog.OnShowListener() {
                    @Override
                    public void onShow(BaseDialog dialog) {
//                        toast("Dialog  显示了");
                    }
                })
                .addOnCancelListener(new BaseDialog.OnCancelListener() {
                    @Override
                    public void onCancel(BaseDialog dialog) {
//                        toast("Dialog 取消了");
                    }
                })
                .addOnDismissListener(new BaseDialog.OnDismissListener() {
                    @Override
                    public void onDismiss(BaseDialog dialog) {
//                        toast("Dialog 销毁了");
                    }
                })
                .show();

    }

    @OnClick(R.id.relative2)
    public void onRelative2Clicked() {
        new BaseDialogFragment.Builder(this)
                .setContentView(R.layout.dialog_upgrade)
                .setAnimStyle(BaseDialog.AnimStyle.SCALE)
                //.setText(id, "我是预设置的文本")
                .setOnClickListener(R.id.butOK, new BaseDialog.OnClickListener<Button>() {

                    @Override
                    public void onClick(BaseDialog dialog, Button view) {
                        dialog.dismiss();
                        ToastUtils.show("开始升级");
                    }
                })
                .setOnClickListener(R.id.butNO, new BaseDialog.OnClickListener<Button>() {

                    @Override
                    public void onClick(BaseDialog dialog, Button view) {
                        dialog.dismiss();
                    }
                })
                .addOnShowListener(new BaseDialog.OnShowListener() {
                    @Override
                    public void onShow(BaseDialog dialog) {
//                        toast("Dialog  显示了");
                    }
                })
                .addOnCancelListener(new BaseDialog.OnCancelListener() {
                    @Override
                    public void onCancel(BaseDialog dialog) {
//                        toast("Dialog 取消了");
                    }
                })
                .addOnDismissListener(new BaseDialog.OnDismissListener() {
                    @Override
                    public void onDismiss(BaseDialog dialog) {
//                        toast("Dialog 销毁了");
                    }
                })
                .show();
    }
}
