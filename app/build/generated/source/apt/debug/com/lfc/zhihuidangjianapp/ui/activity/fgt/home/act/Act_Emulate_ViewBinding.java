// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_Emulate_ViewBinding implements Unbinder {
  private Act_Emulate target;

  @UiThread
  public Act_Emulate_ViewBinding(Act_Emulate target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_Emulate_ViewBinding(Act_Emulate target, View source) {
    this.target = target;

    target.textTitle = Utils.findRequiredViewAsType(source, R.id.textTitle, "field 'textTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_Emulate target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textTitle = null;
  }
}
