package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.proxy.fgerpmsg.FgeRpMsgManager;

/**
 * @author damanz
 * @className TftDisplayEffectModel
 * @date 2018-09-07.
 */
public class TftDisplayEffectModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + TftDisplayEffectModel.class.getSimpleName();
    private static TftDisplayEffectModel mModel = null;
    private Context mContext;
    private FgeRpMsgManager mFgeRpMsgManager;

    private TftDisplayEffectModel(Context context) {
        this.mContext = context;
    }

    public static TftDisplayEffectModel getTftDisplayEffectModelInstance(Context context) {
        if (mModel == null) {
            synchronized (TftDisplayEffectModel.class) {
                if (mModel == null) {
                    mModel = new TftDisplayEffectModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
        mFgeRpMsgManager = FgeRpMsgManager.getFgeRpMsgManager();
        mFgeRpMsgManager.init();
    }

    public int getBrightnessRange() {
        return mFgeRpMsgManager.getBrightnessRange();
    }

    public int getBrightnessValue() {
        return mFgeRpMsgManager.getCurrentBrightnessLevel();
    }

    public void setBrightness(int value) {
        mFgeRpMsgManager.setBrightnessLevel(value);
    }

    public int getContrastRatioRange() {
        return mFgeRpMsgManager.getContrastRange();
    }

    public int getContrastRatioValue() {
        return mFgeRpMsgManager.getCurrentContrastLevel();
    }
   
    public void setContrastRatio(int value) {
        mFgeRpMsgManager.setContrastLevel(value);
    }

    public int getSaturationRange() {
        return mFgeRpMsgManager.getSaturationRange();
    }

    public int getSaturationValue() {
        return mFgeRpMsgManager.getCurrentSaturationLevel();
    }
   
    public void setSaturation(int value) {
        mFgeRpMsgManager.setSaturationLevel(value);
    }

    public int getChromaRange() {
        return mFgeRpMsgManager.getHueRange();
    }

    public int getChromaValue() {
        return mFgeRpMsgManager.getCurrentHueLevel();
    }
   
    public void setChroma(int value) {
        mFgeRpMsgManager.setHueLevel(value);
    }

    public int getSharpnessRange() {
       return mFgeRpMsgManager.getSharpnessRange();
    }

    public int getSharpnessValue() {
        return mFgeRpMsgManager.getCurrentSharpnessLevel();
    }
   
    public void setSharpness(int value) {
        mFgeRpMsgManager.setSharpnessLevel(value);
    }
}
