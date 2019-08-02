// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_AnnouncementList_ViewBinding implements Unbinder {
  private Act_AnnouncementList target;

  private View view2131231015;

  private View view2131231018;

  @UiThread
  public Act_AnnouncementList_ViewBinding(Act_AnnouncementList target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_AnnouncementList_ViewBinding(final Act_AnnouncementList target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imgBack, "field 'imgBack' and method 'onImgBackClicked'");
    target.imgBack = Utils.castView(view, R.id.imgBack, "field 'imgBack'", ImageView.class);
    view2131231015 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onImgBackClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.imgSearch, "field 'imgSearch' and method 'onImgSearchClicked'");
    target.imgSearch = Utils.castView(view, R.id.imgSearch, "field 'imgSearch'", ImageView.class);
    view2131231018 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onImgSearchClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_AnnouncementList target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.imgSearch = null;

    view2131231015.setOnClickListener(null);
    view2131231015 = null;
    view2131231018.setOnClickListener(null);
    view2131231018 = null;
  }
}
