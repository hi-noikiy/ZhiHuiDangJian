package com.lfc.zhihuidangjianapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class SortModel implements Parcelable {

    private String name;
    private String letters;//显示拼音的首字母
    private String ImgURl;
    private String imName;

    public String getImgURl() {
        return ImgURl;
    }

    public void setImgURl(String imgURl) {
        ImgURl = imgURl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getImName() {
        return imName;
    }

    public void setImName(String imName) {
        this.imName = imName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortModel sortModel = (SortModel) o;
        return Objects.equals(imName, sortModel.imName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imName);
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.letters);
        dest.writeString(this.ImgURl);
        dest.writeString(this.imName);
    }

    public SortModel() {}

    protected SortModel(Parcel in) {
        this.name = in.readString();
        this.letters = in.readString();
        this.ImgURl = in.readString();
        this.imName = in.readString();
    }

    public static final Parcelable.Creator<SortModel> CREATOR = new Parcelable.Creator<SortModel>() {
        @Override
        public SortModel createFromParcel(Parcel source) {return new SortModel(source);}

        @Override
        public SortModel[] newArray(int size) {return new SortModel[size];}
    };
}
