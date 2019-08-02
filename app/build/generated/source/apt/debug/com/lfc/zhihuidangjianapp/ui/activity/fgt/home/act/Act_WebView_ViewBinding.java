// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_WebView_ViewBinding implements Unbinder {
  private Act_WebView target;

  private View view2131231015;

  @UiThread
  public Act_WebView_ViewBinding(Act_WebView target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_WebView_ViewBinding(final Act_WebView target, View source) {
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
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.textTitle, "field 'textTitle'", TextView.class);
    target.webView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'webView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_WebView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.textTitle = null;
    target.webView = null;

    view2131231015.setOnClickListener(null);
    view2131231015 = null;
  }
}
