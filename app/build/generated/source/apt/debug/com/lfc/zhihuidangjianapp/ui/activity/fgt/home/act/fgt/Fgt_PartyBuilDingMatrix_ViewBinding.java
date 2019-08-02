// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.fgt;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fgt_PartyBuilDingMatrix_ViewBinding implements Unbinder {
  private Fgt_PartyBuilDingMatrix target;

  @UiThread
  public Fgt_PartyBuilDingMatrix_ViewBinding(Fgt_PartyBuilDingMatrix target, View source) {
    this.target = target;

    target.haah = Utils.findRequiredViewAsType(source, R.id.haah, "field 'haah'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Fgt_PartyBuilDingMatrix target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.haah = null;
  }
}
