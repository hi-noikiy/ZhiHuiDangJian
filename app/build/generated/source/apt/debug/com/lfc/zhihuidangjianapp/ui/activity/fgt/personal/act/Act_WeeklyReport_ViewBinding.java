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

public class Act_WeeklyReport_ViewBinding implements Unbinder {
  private Act_WeeklyReport target;

  private View view2131231012;

  private View view2131231015;

  private View view2131231078;

  private View view2131231079;

  private View view2131231080;

  private View view2131231081;

  @UiThread
  public Act_WeeklyReport_ViewBinding(Act_WeeklyReport target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_WeeklyReport_ViewBinding(final Act_WeeklyReport target, View source) {
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
    view = Utils.findRequiredView(source, R.id.imgSearch, "method 'onImgSearchClicked'");
    view2131231015 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onImgSearchClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear1, "method 'onLinear1Clicked'");
    view2131231078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear1Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear2, "method 'onLinear2Clicked'");
    view2131231079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear2Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear3, "method 'onLinear3Clicked'");
    view2131231080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear3Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear4, "method 'onLinear4Clicked'");
    view2131231081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear4Clicked();
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
    view2131231015.setOnClickListener(null);
    view2131231015 = null;
    view2131231078.setOnClickListener(null);
    view2131231078 = null;
    view2131231079.setOnClickListener(null);
    view2131231079 = null;
    view2131231080.setOnClickListener(null);
    view2131231080 = null;
    view2131231081.setOnClickListener(null);
    view2131231081 = null;
  }
}
