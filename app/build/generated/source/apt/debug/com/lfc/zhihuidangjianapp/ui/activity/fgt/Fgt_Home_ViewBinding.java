// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.widget.MyListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fgt_Home_ViewBinding implements Unbinder {
  private Fgt_Home target;

  private View view2131230802;

  private View view2131231081;

  private View view2131231082;

  private View view2131231083;

  private View view2131231085;

  private View view2131231084;

  private View view2131231237;

  @UiThread
  public Fgt_Home_ViewBinding(final Fgt_Home target, View source) {
    this.target = target;

    View view;
    target.homeListView = Utils.findRequiredViewAsType(source, R.id.homeListView, "field 'homeListView'", MyListView.class);
    target.mRefreshLayout = Utils.findRequiredViewAsType(source, R.id.refreshLayout, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    view = Utils.findRequiredView(source, R.id.banner, "field 'banner' and method 'onImgBannerClicked'");
    target.banner = Utils.castView(view, R.id.banner, "field 'banner'", Banner.class);
    view2131230802 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onImgBannerClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear1, "method 'onLinear1Clicked'");
    view2131231081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear1Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear2, "method 'onLinear2Clicked'");
    view2131231082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear2Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear3, "method 'onLinear3Clicked'");
    view2131231083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear3Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear5, "method 'onLinear5Clicked'");
    view2131231085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear5Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.linear4, "method 'onLinear4Clicked'");
    view2131231084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinear4Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.relativeAnnoun, "method 'onRelativeAnnounClicked'");
    view2131231237 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRelativeAnnounClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Fgt_Home target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.homeListView = null;
    target.mRefreshLayout = null;
    target.banner = null;

    view2131230802.setOnClickListener(null);
    view2131230802 = null;
    view2131231081.setOnClickListener(null);
    view2131231081 = null;
    view2131231082.setOnClickListener(null);
    view2131231082 = null;
    view2131231083.setOnClickListener(null);
    view2131231083 = null;
    view2131231085.setOnClickListener(null);
    view2131231085 = null;
    view2131231084.setOnClickListener(null);
    view2131231084 = null;
    view2131231237.setOnClickListener(null);
    view2131231237 = null;
  }
}
