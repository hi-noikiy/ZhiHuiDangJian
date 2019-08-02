// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.demonstration_leadership.fgt;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fgt_Demonstration_Leadership_ViewBinding implements Unbinder {
  private Fgt_Demonstration_Leadership target;

  @UiThread
  public Fgt_Demonstration_Leadership_ViewBinding(Fgt_Demonstration_Leadership target,
      View source) {
    this.target = target;

    target.my_RecyclerView = Utils.findRequiredViewAsType(source, R.id.my_RecyclerView, "field 'my_RecyclerView'", RecyclerView.class);
    target.mRefreshLayout = Utils.findRequiredViewAsType(source, R.id.refreshLayout, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    target.item_hader = Utils.findRequiredViewAsType(source, R.id.item_hader, "field 'item_hader'", ImageView.class);
    target.item_title = Utils.findRequiredViewAsType(source, R.id.item_title, "field 'item_title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Fgt_Demonstration_Leadership target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.my_RecyclerView = null;
    target.mRefreshLayout = null;
    target.item_hader = null;
    target.item_title = null;
  }
}
