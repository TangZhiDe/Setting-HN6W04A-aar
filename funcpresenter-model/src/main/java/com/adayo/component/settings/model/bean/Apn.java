package com.adayo.component.settings.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author damanz
 * @className Apn
 * @date 2018-09-24.
 */
public class Apn implements Parcelable {
    private String id;
    private String apnName;
    private String apn;
    private String proxy;
    private String port;
    private String apnUserName;
    private String apnUserPwd;
    private String apnServer;
    private String apnMmsc;
    private String mmsProxy;
    private String mmsPort;
    private String mcc;
    private String mnc;
    private String authentication;
    private String apnType;
    private String apnAgreement;
    private String bearingSystem;
    private String mvnoType;
    private String mvnoValue;
    private String apnDataRoaming;
    private String numeric;
    private String current;
    private boolean enabled;

    public String getApnName() {
        return apnName;
    }

    public void setApnName(String apnName) {
        this.apnName = apnName;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getApnUserName() {
        return apnUserName;
    }

    public void setApnUserName(String apnUserName) {
        this.apnUserName = apnUserName;
    }

    public String getApnUserPwd() {
        return apnUserPwd;
    }

    public void setApnUserPwd(String apnUserPwd) {
        this.apnUserPwd = apnUserPwd;
    }

    public String getApnServer() {
        return apnServer;
    }

    public void setApnServer(String apnServer) {
        this.apnServer = apnServer;
    }

    public String getApnMmsc() {
        return apnMmsc;
    }

    public void setApnMmsc(String apnMmsc) {
        this.apnMmsc = apnMmsc;
    }

    public String getMmsProxy() {
        return mmsProxy;
    }

    public void setMmsProxy(String mmsProxy) {
        this.mmsProxy = mmsProxy;
    }

    public String getMmsPort() {
        return mmsPort;
    }

    public void setMmsPort(String mmsPort) {
        this.mmsPort = mmsPort;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getApnType() {
        return apnType;
    }

    public void setApnType(String apnType) {
        this.apnType = apnType;
    }

    public String getApnAgreement() {
        return apnAgreement;
    }

    public void setApnAgreement(String apnAgreement) {
        this.apnAgreement = apnAgreement;
    }

    public String getBearingSystem() {
        return bearingSystem;
    }

    public void setBearingSystem(String bearingSystem) {
        this.bearingSystem = bearingSystem;
    }

    public String getMvnoType() {
        return mvnoType;
    }

    public void setMvnoType(String mvnoType) {
        this.mvnoType = mvnoType;
    }

    public String getMvnoValue() {
        return mvnoValue;
    }

    public void setMvnoValue(String mvnoValue) {
        this.mvnoValue = mvnoValue;
    }

    public String getApnDataRoaming() {
        return apnDataRoaming;
    }

    public void setApnDataRoaming(String apnDataRoaming) {
        this.apnDataRoaming = apnDataRoaming;
    }

    public String getNumeric() {
        return numeric;
    }

    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Apn() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.apnName);
        dest.writeString(this.apn);
        dest.writeString(this.proxy);
        dest.writeString(this.port);
        dest.writeString(this.apnUserName);
        dest.writeString(this.apnUserPwd);
        dest.writeString(this.apnServer);
        dest.writeString(this.apnMmsc);
        dest.writeString(this.mmsProxy);
        dest.writeString(this.mmsPort);
        dest.writeString(this.mcc);
        dest.writeString(this.mnc);
        dest.writeString(this.authentication);
        dest.writeString(this.apnType);
        dest.writeString(this.apnAgreement);
        dest.writeString(this.bearingSystem);
        dest.writeString(this.mvnoType);
        dest.writeString(this.mvnoValue);
        dest.writeString(this.apnDataRoaming);
        dest.writeString(this.numeric);
        dest.writeString(this.current);
        dest.writeByte(this.enabled ? (byte) 1 : (byte) 0);
    }

    protected Apn(Parcel in) {
        this.id = in.readString();
        this.apnName = in.readString();
        this.apn = in.readString();
        this.proxy = in.readString();
        this.port = in.readString();
        this.apnUserName = in.readString();
        this.apnUserPwd = in.readString();
        this.apnServer = in.readString();
        this.apnMmsc = in.readString();
        this.mmsProxy = in.readString();
        this.mmsPort = in.readString();
        this.mcc = in.readString();
        this.mnc = in.readString();
        this.authentication = in.readString();
        this.apnType = in.readString();
        this.apnAgreement = in.readString();
        this.bearingSystem = in.readString();
        this.mvnoType = in.readString();
        this.mvnoValue = in.readString();
        this.apnDataRoaming = in.readString();
        this.numeric = in.readString();
        this.current = in.readString();
        this.enabled = in.readByte() != 0;
    }

    public static final Creator<Apn> CREATOR = new Creator<Apn>() {
        @Override
        public Apn createFromParcel(Parcel source) {
            return new Apn(source);
        }

        @Override
        public Apn[] newArray(int size) {
            return new Apn[size];
        }
    };

    @Override
    public String toString() {
        return "Apn{" +
                "id='" + id + '\'' +
                ", apnName='" + apnName + '\'' +
                ", apn='" + apn + '\'' +
                ", proxy='" + proxy + '\'' +
                ", port='" + port + '\'' +
                ", apnUserName='" + apnUserName + '\'' +
                ", apnUserPwd='" + apnUserPwd + '\'' +
                ", apnServer='" + apnServer + '\'' +
                ", apnMmsc='" + apnMmsc + '\'' +
                ", mmsProxy='" + mmsProxy + '\'' +
                ", mmsPort='" + mmsPort + '\'' +
                ", mcc='" + mcc + '\'' +
                ", mnc='" + mnc + '\'' +
                ", authentication='" + authentication + '\'' +
                ", apnType='" + apnType + '\'' +
                ", apnAgreement='" + apnAgreement + '\'' +
                ", bearingSystem='" + bearingSystem + '\'' +
                ", mvnoType='" + mvnoType + '\'' +
                ", mvnoValue='" + mvnoValue + '\'' +
                ", apnDataRoaming='" + apnDataRoaming + '\'' +
                ", numeric='" + numeric + '\'' +
                ", current='" + current + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
