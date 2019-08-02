// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Fgt_Personal_ViewBinding implements Unbinder {
  private Fgt_Personal target;

  @UiThread
  public Fgt_Personal_ViewBinding(Fgt_Personal target, View source) {
    this.target = target;

    target.minHader = Utils.findRequiredViewAsType(source, R.id.min_hader, "field 'minHader'", CircleImageView.class);
    target.view = Utils.findRequiredView(source, R.id.view, "field 'view'");
    target.minName = Utils.findRequiredViewAsType(source, R.id.min_name, "field 'minName'", TextView.class);
    target.minName1 = Utils.findRequiredViewAsType(source, R.id.min_naem1, "field 'minName1'", TextView.class);
    target.minSex = Utils.findRequiredViewAsType(source, R.id.min_sex, "field 'minSex'", TextView.class);
    target.minMinzu = Utils.findRequiredViewAsType(source, R.id.min_minzu, "field 'minMinzu'", TextView.class);
    target.minShenri = Utils.findRequiredViewAsType(source, R.id.min_shenri, "field 'minShenri'", TextView.class);
    target.minXueli = Utils.findRequiredViewAsType(source, R.id.min_xueli, "field 'minXueli'", TextView.class);
    target.minGuanji = Utils.findRequiredViewAsType(source, R.id.min_guanji, "field 'minGuanji'", TextView.class);
    target.minGangwei = Utils.findRequiredViewAsType(source, R.id.min_gangwei, "field 'minGangwei'", TextView.class);
    target.minZhiwu = Utils.findRequiredViewAsType(source, R.id.min_zhiwu, "field 'minZhiwu'", TextView.class);
    target.minAddr = Utils.findRequiredViewAsType(source, R.id.min_addr, "field 'minAddr'", TextView.class);
    target.minPhone = Utils.findRequiredViewAsType(source, R.id.min_phone, "field 'minPhone'", TextView.class);
    target.min_Total = Utils.findRequiredViewAsType(source, R.id.min_Total, "field 'min_Total'", TextView.class);
    target.min_Total1 = Utils.findRequiredViewAsType(source, R.id.min_Total1, "field 'min_Total1'", TextView.class);
    target.min_starPartyMember = Utils.findRequiredViewAsType(source, R.id.min_starPartyMember, "field 'min_starPartyMember'", TextView.class);
    target.min_left = Utils.findRequiredViewAsType(source, R.id.min_left, "field 'min_left'", ImageView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.drawlayout, "field 'drawerLayout'", DrawerLayout.class);
    target.lefit = Utils.findRequiredViewAsType(source, R.id.lefit, "field 'lefit'", LinearLayout.class);
    target.profile_image = Utils.findRequiredViewAsType(source, R.id.profile_image, "field 'profile_image'", CircleImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Fgt_Personal target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.minHader = null;
    target.view = null;
    target.minName = null;
    target.minName1 = null;
    target.minSex = null;
    target.minMinzu = null;
    target.minShenri = null;
    target.minXueli = null;
    target.minGuanji = null;
    target.minGangwei = null;
    target.minZhiwu = null;
    target.minAddr = null;
    target.minPhone = null;
    target.min_Total = null;
    target.min_Total1 = null;
    target.min_starPartyMember = null;
    target.min_left = null;
    target.progressBar = null;
    target.drawerLayout = null;
    target.lefit = null;
    target.profile_image = null;
  }
}
