// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_TitleDetails_ViewBinding implements Unbinder {
  private Act_TitleDetails target;

  @UiThread
  public Act_TitleDetails_ViewBinding(Act_TitleDetails target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_TitleDetails_ViewBinding(Act_TitleDetails target, View source) {
    this.target = target;

    target.TitleDetailsBack = Utils.findRequiredViewAsType(source, R.id.TitleDetailsBack, "field 'TitleDetailsBack'", ImageView.class);
    target.TitleDetail_title = Utils.findRequiredViewAsType(source, R.id.TitleDetail_title, "field 'TitleDetail_title'", TextView.class);
    target.titleDetaile_context = Utils.findRequiredViewAsType(source, R.id.titleDetaile_context, "field 'titleDetaile_context'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_TitleDetails target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.TitleDetailsBack = null;
    target.TitleDetail_title = null;
    target.titleDetaile_context = null;
  }
}
