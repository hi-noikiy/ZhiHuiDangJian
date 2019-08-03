// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.personal.act;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_SetUpc_ViewBinding implements Unbinder {
  private Act_SetUpc target;

  private View view2131231012;

  private View view2131231229;

  private View view2131231230;

  @UiThread
  public Act_SetUpc_ViewBinding(Act_SetUpc target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_SetUpc_ViewBinding(final Act_SetUpc target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imgBack, "method 'onImgBackClicked'");
    view2131231012 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onImgBackClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.relative1, "method 'onRelative1Clicked'");
    view2131231229 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRelative1Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.relative2, "method 'onRelative2Clicked'");
    view2131231230 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRelative2Clicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131231012.setOnClickListener(null);
    view2131231012 = null;
    view2131231229.setOnClickListener(null);
    view2131231229 = null;
    view2131231230.setOnClickListener(null);
    view2131231230 = null;
  }
}
