/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.content.Context;
import android.text.format.Time;

import com.adayo.component.settings.constant.EnumConstant;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.utils.SPUtils;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class DisplayModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + DisplayModel.class.getSimpleName();
    private static final String CLOSE_SCREEN_BRIGHTNESS = "0";
    private static final String CLOSE_SCREEN_BRIGHTNESS_DEFAULT = "6";

    private static DisplayModel mModel = null;
    private Context mContext;

    public DisplayModel(Context context) {
        this.mContext = context;
    }

    public static DisplayModel getDisplayModelInstance(Context context) {
        if (mModel == null) {
            synchronized (DisplayModel.class) {
                if (mModel == null) {
                    mModel = new DisplayModel(context);
                }
            }
        }
        return mModel;
    }

    public boolean setScreenBrightnessMode(int mode) {
        boolean b = SPUtils.put(mContext, FPConstant.EXTRA_SCREEN_BRIGHTNESS_MODE, mode);
        if (b) {
            if (mode == EnumConstant.BRIGHTNESS_CONTROL.AUTO.getValue()) {
                Time t = new Time();
                t.setToNow();
                if (t.hour >= 18 || t.hour < 6) {
                    setBrightnessProgress(3);
                } else {
                    setBrightnessProgress(6);
                }
            } else if (mode == EnumConstant.BRIGHTNESS_CONTROL.DAY.getValue()) {
                setBrightnessProgress(6);
            } else if (mode == EnumConstant.BRIGHTNESS_CONTROL.DAYNIGHT.getValue()) {
                setBrightnessProgress(3);
            }
        }
        return b;
    }

    public int getScreenBrightnessMode() {
        return SPUtils.getInt(mContext, FPConstant.EXTRA_SCREEN_BRIGHTNESS_MODE,
                EnumConstant.BRIGHTNESS_CONTROL.AUTO.getValue());
    }

    public int getBrightnessProgress() {
        String[] out = new String[1];
        int i = mSettingsManager.doDb_BacklightControl(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr,out);
        return Integer.parseInt(out[0]);
    }

    public void setBrightnessProgress(int progress) {
        int i = mSettingsManager.doDb_BacklightControl(mContext, SettingsContantsDef.MODE_SET,
                new String[]{String.valueOf(progress)}, FPConstant.emptyArr);
    }

    public void setScreenDisplayState(boolean isDisplay) {
        // TODO: 2018/11/26 待确认如何恢复屏幕亮度后再调整到0
        String brightness = CLOSE_SCREEN_BRIGHTNESS + 1;

        if (isDisplay){
            brightness = CLOSE_SCREEN_BRIGHTNESS_DEFAULT;
        }

        mSettingsManager.doDb_BacklightControl(mContext, SettingsContantsDef.MODE_SET,
                new String[]{brightness}, FPConstant.emptyArr);
    }

    public boolean getScreenDisplayState() {
        int brightness = getBrightnessProgress();
        return brightness != 0;
    }

    @Override
    public void init() {
        super.init();
    }
}
