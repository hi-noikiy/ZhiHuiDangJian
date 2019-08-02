// Generated code from Butter Knife. Do not modify!
package com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lfc.zhihuidangjianapp.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Act_Party_membershipDues_ViewBinding implements Unbinder {
  private Act_Party_membershipDues target;

  @UiThread
  public Act_Party_membershipDues_ViewBinding(Act_Party_membershipDues target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Act_Party_membershipDues_ViewBinding(Act_Party_membershipDues target, View source) {
    this.target = target;

    target.imgBack = Utils.findRequiredViewAsType(source, R.id.imgBack, "field 'imgBack'", ImageView.class);
    target.MyOrganization = Utils.findRequiredViewAsType(source, R.id.My_organization, "field 'MyOrganization'", TextView.class);
    target.profileImage = Utils.findRequiredViewAsType(source, R.id.profile_image, "field 'profileImage'", CircleImageView.class);
    target.profileName = Utils.findRequiredViewAsType(source, R.id.profile_name, "field 'profileName'", TextView.class);
    target.profile_guanli = Utils.findRequiredViewAsType(source, R.id.profile_guanli, "field 'profile_guanli'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Act_Party_membershipDues target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.MyOrganization = null;
    target.profileImage = null;
    target.profileName = null;
    target.profile_guanli = null;
  }
}
