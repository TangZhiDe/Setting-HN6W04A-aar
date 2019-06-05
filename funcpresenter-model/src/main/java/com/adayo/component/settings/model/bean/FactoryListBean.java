package com.adayo.component.settings.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author damanz
 * @className FactoryListBean
 * @date 2018-09-11.
 */
public class FactoryListBean implements Parcelable {
    private String appName;
    private String appVersion;
    private String packageName;
    private boolean isHidden;

    public FactoryListBean(String appName, String appVersion) {
        this.appName = appName;
        this.appVersion = appVersion;
    }

    public FactoryListBean(String appName, String packageName, boolean isHidden) {
        this.appName = appName;
        this.packageName = packageName;
        this.isHidden = isHidden;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "FactoryListBean{" +
                "appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.appName);
        dest.writeString(this.appVersion);
        dest.writeString(this.packageName);
        dest.writeByte(this.isHidden ? (byte) 1 : (byte) 0);
    }

    protected FactoryListBean(Parcel in) {
        this.appName = in.readString();
        this.appVersion = in.readString();
        this.packageName = in.readString();
        this.isHidden = in.readByte() != 0;
    }

    public static final Creator<FactoryListBean> CREATOR = new Creator<FactoryListBean>() {
        @Override
        public FactoryListBean createFromParcel(Parcel source) {
            return new FactoryListBean(source);
        }

        @Override
        public FactoryListBean[] newArray(int size) {
            return new FactoryListBean[size];
        }
    };
}
