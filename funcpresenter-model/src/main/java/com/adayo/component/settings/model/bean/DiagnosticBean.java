package com.adayo.component.settings.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author damanz
 * @className DiagnosticBean
 * @date 2018-09-19.
 */
public class DiagnosticBean implements Parcelable{
    private String errorCode;
    private String decs;
    private int count;
    private String time;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.errorCode);
        dest.writeString(this.decs);
        dest.writeInt(this.count);
        dest.writeString(this.time);
    }

    public DiagnosticBean() {
    }

    protected DiagnosticBean(Parcel in) {
        this.errorCode = in.readString();
        this.decs = in.readString();
        this.count = in.readInt();
        this.time = in.readString();
    }

    public static final Creator<DiagnosticBean> CREATOR = new Creator<DiagnosticBean>() {
        @Override
        public DiagnosticBean createFromParcel(Parcel source) {
            return new DiagnosticBean(source);
        }

        @Override
        public DiagnosticBean[] newArray(int size) {
            return new DiagnosticBean[size];
        }
    };
}
