package com.lfc.zhihuidangjianapp.ui.activity.fgt.partyaffairs.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author zhouyong
 */
public class InviteMember implements Parcelable {

    /**
     * 用户名字
     */
    private String memBerName;

    /**
     * 用户头像
     */
    private String memBerImag;

    /**
     * 登录名字
     */
    private String imnName;

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.memBerName);
        dest.writeString(this.memBerImag);
        dest.writeString(this.imnName);
    }

    public InviteMember() {}

    protected InviteMember(Parcel in) {
        this.memBerName = in.readString();
        this.memBerImag = in.readString();
        this.imnName = in.readString();
    }

    public static final Parcelable.Creator<InviteMember> CREATOR = new Parcelable.Creator<InviteMember>() {
        @Override
        public InviteMember createFromParcel(Parcel source) {return new InviteMember(source);}

        @Override
        public InviteMember[] newArray(int size) {return new InviteMember[size];}
    };
}
