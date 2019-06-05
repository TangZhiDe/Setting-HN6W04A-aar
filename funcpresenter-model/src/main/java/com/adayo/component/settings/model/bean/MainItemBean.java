/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model.bean;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * @author damanz
 * @className MainItemBean
 * @date 2018-07-26.
 */
public class MainItemBean implements Parcelable {
    /**
     * 名称
     */
    private String name;
    /**
     * 资源文件（左侧图片）
     */
    private int resNormalId;
    private int resPressedId;
    /**
     * 默认显示值
     */
    private String value;
    private int fragmentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResNormalId() {
        return resNormalId;
    }

    public void setResNormalId(int resNormalId) {
        this.resNormalId = resNormalId;
    }

    public int getResPressedId() {
        return resPressedId;
    }

    public void setResPressedId(int resPressedId) {
        this.resPressedId = resPressedId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MainItemBean() {
    }

    public MainItemBean(String name, int resNormalId, int resPressedId, int fragmentId) {
        this.name = name;
        this.resNormalId = resNormalId;
        this.resPressedId = resPressedId;
        this.fragmentId = fragmentId;
    }

    public int getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(int fragmentId) {
        this.fragmentId = fragmentId;
    }

    public MainItemBean(String name, int resNormalId, int resPressedId) {
        this.name = name;
        this.resNormalId = resNormalId;
        this.resPressedId = resPressedId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.resNormalId);
        dest.writeInt(this.resPressedId);
        dest.writeString(this.value);
        dest.writeInt(this.fragmentId);
    }

    protected MainItemBean(Parcel in) {
        this.name = in.readString();
        this.resNormalId = in.readInt();
        this.resPressedId = in.readInt();
        this.value = in.readString();
        this.fragmentId = in.readInt();
    }

    public static final Creator<MainItemBean> CREATOR = new Creator<MainItemBean>() {
        @Override
        public MainItemBean createFromParcel(Parcel source) {
            return new MainItemBean(source);
        }

        @Override
        public MainItemBean[] newArray(int size) {
            return new MainItemBean[size];
        }
    };
}
