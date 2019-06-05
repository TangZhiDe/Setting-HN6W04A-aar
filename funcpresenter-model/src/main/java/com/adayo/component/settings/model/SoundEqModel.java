/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.content.Context;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.proxy.audio.AudioDspManager;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class SoundEqModel extends BaseModel {
    public static final String TAG = "SoundEqModel";
    private static SoundEqModel mModel = null;
    private Context mContext;
//    private AudioDspManager mAudioDspManager;

    private SoundEqModel(Context context) {
        this.mContext = context;
    }

    public static SoundEqModel getSoundEqModelInstance(Context context) {
        if (mModel == null) {
            synchronized (SoundEqModel.class) {
                if (mModel == null) {
                    mModel = new SoundEqModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
//        mAudioDspManager = AudioDspManager.getShareDataManager();
//        mAudioDspManager.init();
    }

    public int getSoundEqMode() {
        String[] out = getDefultString();
        mSettingsManager.doDb_SoundEffect(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out);
        Log.d(TAG, "getSoundEqMode: i  " + formatIntData(out, 0));
        return formatIntData(out, 0);
    }

    public void setSoundEqMode(int mode) {
        String[] in = getIntString(mode);
        int i = mSettingsManager.doDb_SoundEffect(mContext, SettingsContantsDef.MODE_SET, in, FPConstant.emptyArr);
    }

    public int getTrebleFreqEffect() {
        String[] out = getDefultString();
        mSettingsManager.doDb_SoundTrebleFreqEffect(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out);
        return formatIntData(out, 0);
    }

    public int getMiddleFreqEffect() {
        String[] out = getDefultString();
        mSettingsManager.doDb_SoundMiddleFreqEffect(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out);
        return formatIntData(out, 0);
    }

    public int getBassFreqEffect() {
        String[] out = getDefultString();
        mSettingsManager.doDb_SoundBassFreqEffect(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out);
        return formatIntData(out, 0);
    }


    public void setTrebleFreqEffect(int value) {
        mSettingsManager.doDb_SoundTrebleFreqEffect(mContext, SettingsContantsDef.MODE_SET,
                getIntString(value), FPConstant.emptyArr);
    }

    public void setMiddleFreqEffect(int value) {
        mSettingsManager.doDb_SoundMiddleFreqEffect(mContext, SettingsContantsDef.MODE_SET,
                getIntString(value), FPConstant.emptyArr);
    }

    public void setBassFreqEffect(int value) {

        mSettingsManager.doDb_SoundBassFreqEffect(mContext, SettingsContantsDef.MODE_SET,
                getIntString(value), FPConstant.emptyArr);
    }

    public boolean getLoudnessSwitch() {
        String[] out = getDefultString();
        int i = mSettingsManager.doDb_LoudnessSwitch(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr, out);
        return formatBooleanData(out, false);
    }

    public void setLoudnessSwitch(boolean state) {
//        SPUtils.put(mContext,FPConstant.EXTRA_LOUDNESS,state);
        int i = mSettingsManager.doDb_LoudnessSwitch(mContext, SettingsContantsDef.MODE_SET, getBoolenString(state), FPConstant.emptyArr);
    }

    public int resetSoundEq() {
        return mSettingsManager.doDb_ResetSound(mContext);
    }
}
