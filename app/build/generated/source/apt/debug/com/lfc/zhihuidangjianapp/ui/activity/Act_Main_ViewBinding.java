// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.widget.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_Main_ViewBinding implements Unbinder {
  private Act_Main target;

  private View view2131231233;

  private View view2131231234;

  private View view2131231235;

  private View view2131231236;

  @UiThread
  public Act_Main_ViewBinding(Act_Main target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_Main_ViewBinding(final Act_Main target, View source) {
    this.target = target;

    View view;
    target.vpHomePager = Utils.findRequiredViewAsType(source, R.id.vp_home_pager, "field 'vpHomePager'", NoScrollViewPager.class);
    target.bvHomeNavigation = Utils.findRequiredViewAsType(source, R.id.bv_home_navigation, "field 'bvHomeNavigation'", BottomNavigationView.class);
    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.v4_drawerlayout, "field 'drawerLayout'", DrawerLayout.class);
    target.imgHead = Utils.findRequiredViewAsType(source, R.id.imgHead, "field 'imgHead'", ImageView.class);
    target.textName = Utils.findRequiredViewAsType(source, R.id.textName, "field 'textName'", TextView.class);
    target.text1 = Utils.findRequiredViewAsType(source, R.id.text1, "field 'text1'", TextView.class);
    target.text2 = Utils.findRequiredViewAsType(source, R.id.text2, "field 'text2'", TextView.class);
    target.text3 = Utils.findRequiredViewAsType(source, R.id.text3, "field 'text3'", TextView.class);
    view = Utils.findRequiredView(source, R.id.relative1, "method 'onRelative1Clicked'");
    view2131231233 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRelative1Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.relative2, "method 'onRelative2Clicked'");
    view2131231234 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRelative2Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.relative3, "method 'onRelative3Clicked'");
    view2131231235 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRelative3Clicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.relative4, "method 'onRelative4Clicked'");
    view2131231236 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRelative4Clicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_Main target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vpHomePager = null;
    target.bvHomeNavigation = null;
    target.drawerLayout = null;
    target.imgHead = null;
    target.textName = null;
    target.text1 = null;
    target.text2 = null;
    target.text3 = null;

    view2131231233.setOnClickListener(null);
    view2131231233 = null;
    view2131231234.setOnClickListener(null);
    view2131231234 = null;
    view2131231235.setOnClickListener(null);
    view2131231235 = null;
    view2131231236.setOnClickListener(null);
    view2131231236 = null;
  }
}
