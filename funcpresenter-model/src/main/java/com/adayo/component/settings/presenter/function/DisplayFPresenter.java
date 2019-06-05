package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IDisplayFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.DisplayModel;

/**
 * @author damanz
 * @className DisplayBPresenter
 * @date 2018-08-08.
 */
public class DisplayFPresenter extends SettingsBaseFPersenter<DisplayModel> implements IDisplayFuncPresenter {

    public static final String TAG = FPConstant.TAG + DisplayFPresenter.class.getSimpleName();

    public DisplayFPresenter(Context context) {
        super(context);
        mModel = DisplayModel.getDisplayModelInstance(mContext);
    }

    @Override
    public void setScreenBrightnessMode(int mode) {
        boolean b = mModel.setScreenBrightnessMode(mode);
        if (b) {
            getScreenBrightnessMode();
            getBrightnessProgress();
        }
    }

    @Override
    public void getScreenBrightnessMode() {
        int mode = mModel.getScreenBrightnessMode();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_TIME_TYPE_MODE, mode);
        sendMessage(FPConstant.SCREEN_BRIGHTNESS_MODE_HANDLER_ID, bundle);
    }

    @Override
    public void getBrightnessProgress() {
        int progress = mModel.getBrightnessProgress();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_BRIGHTNESS_PROGRESS, progress);
        sendMessage(FPConstant.BRIGHTNESS_PROGRESS_HANDLER_ID, bundle);
    }

    @Override
    public void setBrightnessProgress(int progress) {
        mModel.setBrightnessProgress(progress);
        getBrightnessProgress();
    }

    @Override
    public void setScreenDisplayState(boolean isDisplay) {
        mModel.setScreenDisplayState(isDisplay);
        getScreenDisplayState();
    }

    @Override
    public void getScreenDisplayState() {
        boolean isDisplay = mModel.getScreenDisplayState();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_SCREEN_DISPLAY_STATE, isDisplay);
        sendMessage(FPConstant.KEY_SCREEN_DISPLAY_HANDLER_ID, bundle);
    }
}
