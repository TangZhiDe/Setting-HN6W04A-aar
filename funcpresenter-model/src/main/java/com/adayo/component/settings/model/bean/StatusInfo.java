package com.adayo.component.settings.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author damanz
 * @className StatusInfo
 * @date 2018-10-24.
 */
public class StatusInfo implements Parcelable {
    private String center;
    private String left;
    private String right;

    public StatusInfo() {
    }

    public StatusInfo(String center, String right) {
        this.center = center;
        this.right = right;
    }

    public StatusInfo(String left, String center, String right) {
        this.center = center;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "StatusInfo{" +
                "center='" + center + '\'' +
                ", left='" + left + '\'' +
                ", right='" + right + '\'' +
                '}';
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }


    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.center);
        dest.writeString(this.left);
        dest.writeString(this.right);
    }

    protected StatusInfo(Parcel in) {
        this.center = in.readString();
        this.left = in.readString();
        this.right = in.readString();
    }

    public static final Creator<StatusInfo> CREATOR = new Creator<StatusInfo>() {
        @Override
        public StatusInfo createFromParcel(Parcel source) {
            return new StatusInfo(source);
        }

        @Override
        public StatusInfo[] newArray(int size) {
            return new StatusInfo[size];
        }
    };
}
