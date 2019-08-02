// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.act;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.view.SideBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_Mail_list_ViewBinding implements Unbinder {
  private Act_Mail_list target;

  @UiThread
  public Act_Mail_list_ViewBinding(Act_Mail_list target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_Mail_list_ViewBinding(Act_Mail_list target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.sideBar = Utils.findRequiredViewAsType(source, R.id.sideBar, "field 'sideBar'", SideBar.class);
    target.dialog = Utils.findRequiredViewAsType(source, R.id.dialog, "field 'dialog'", TextView.class);
    target.textInvite = Utils.findRequiredViewAsType(source, R.id.textInvite, "field 'textInvite'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_Mail_list target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.sideBar = null;
    target.dialog = null;
    target.textInvite = null;
  }
}
