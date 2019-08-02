// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_Login_ViewBinding implements Unbinder {
  private Act_Login target;

  private View view2131230812;

  @UiThread
  public Act_Login_ViewBinding(Act_Login target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_Login_ViewBinding(final Act_Login target, View source) {
    this.target = target;

    View view;
    target.editAccountNumber = Utils.findRequiredViewAsType(source, R.id.editAccountNumber, "field 'editAccountNumber'", EditText.class);
    target.editPassword = Utils.findRequiredViewAsType(source, R.id.editPassword, "field 'editPassword'", EditText.class);
    target.ivCode = Utils.findRequiredViewAsType(source, R.id.iv_code, "field 'ivCode'", ImageView.class);
    target.etCode = Utils.findRequiredViewAsType(source, R.id.et_code, "field 'etCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnLoginCommit, "method 'onBtnLoginCommitClicked'");
    view2131230812 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnLoginCommitClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_Login target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editAccountNumber = null;
    target.editPassword = null;
    target.ivCode = null;
    target.etCode = null;

    view2131230812.setOnClickListener(null);
    view2131230812 = null;
  }
}
