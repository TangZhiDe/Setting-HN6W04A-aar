/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.proxy.audio.AudioDspManager;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class Network4GModel extends BaseModel  {
    public static final String TAG = FPConstant.TAG + Network4GModel.class.getSimpleName();
    private static Network4GModel mModel = null;
    private Context mContext;
    private AudioDspManager mAudioDspManager;
    private AudioManager mAudioManager;
    private ConnectivityManager mConnectivityManager;
    private TelephonyManager mTelephonyManager;

    private Network4GModel(Context context) {
        this.mContext = context;
    }

    public static Network4GModel getNetwork4GModelInstance(Context context) {
        if (mModel == null) {
            synchronized (Network4GModel.class) {
                if (mModel == null) {
                    mModel = new Network4GModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
        mConnectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public boolean getMobileNetworkSwitch() {
//        return mTelephonyManager.isDataEnabled();
        return false;
    }

    public void setMobileNetworkSwitch(boolean state) {
        Log.d(TAG, "setMobileNetworkSwitch: " + state);
       // mTelephonyManager.enableDataConnectivity();
//        mTelephonyManager.setDataEnabled(state);
    }

    public boolean getDataRoamingSwitch() {
       return mTelephonyManager.isNetworkRoaming();
    }

    public void setDataRoamingSwitch(boolean state) {
//        mTelephonyManager.setNetworkRoaming(state);
    }

    public String getNetworkOperator() {
      return  mTelephonyManager.getNetworkOperator();
    }
}
