package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IGeneralFuncPresenter;
import com.adayo.component.settings.constant.EnumConstant;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.GeneralModel;

import java.util.Locale;

/**
 * @author damanz
 * @className GeneralFPresenter
 * @date 2018-08-08.
 */
public class GeneralFPresenter extends SettingsBaseFPersenter<GeneralModel> implements IGeneralFuncPresenter {

    public static final String TAG = FPConstant.TAG + GeneralFPresenter.class.getSimpleName();

    public GeneralFPresenter(Context context) {
        super(context);
        mModel = GeneralModel.getCurrencyModelInstance(context);
    }

    @Override
    public void setSystemLanguage(Locale locale) {
        boolean b = mModel.setSystemLanguage(locale);
        if (b) {
            getSystemLanguage();
        } else {
            //
            sendMessage(FPConstant.SYSTEM_LANGUANG_HANDLER_ID, null);
        }
    }

    @Override
    public void getSystemLanguage() {
        Locale locale = mModel.getSystemLanguage();
        int value = EnumConstant.SYSTEM_LANGUAGE.getIntValue(locale);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_SYSTEM_LANGUANG, value);
        sendMessage(FPConstant.SYSTEM_LANGUANG_HANDLER_ID, bundle);
    }

    @Override
    public void getStandbyDisplay() {
        int display = mModel.getStandbyDisplay();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_STANDBY_DISPLAY, display);
        sendMessage(FPConstant.STANDBY_DISPLAY_HANDLER_ID, bundle);
    }

    @Override
    public void setStandbyDisplay(int itemMode) {
        mModel.setStandbyDisplay(itemMode);
        getStandbyDisplay();
    }

    @Override
    public void getAndroidStartApp() {
        int startApp = mModel.getAndroidStartApp();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_ANDROID_SETTINGS, startApp);
        sendMessage(FPConstant.ANDROID_SETTINGS_HANDLER_ID, bundle);
    }

    @Override
    public void getIphoneStartApp() {
        int startApp = mModel.getIphoneStartApp();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_IPHONE_SETTINGS, startApp);
        sendMessage(FPConstant.IPHONE_SETTINGS_HANDLER_ID, bundle);
    }

    @Override
    public void setIphoneStartApp(int itemMode) {
        mModel.setIphoneStartApp(itemMode);
        getIphoneStartApp();
    }

    @Override
    public void setAndroidStartApp(int itemMode) {
        mModel.setAndroidStartApp(itemMode);
        getAndroidStartApp();
    }

    @Override
    public void setTrafficWatchVideo(boolean state) {
        mModel.setTrafficWatchVideo(state);
        getTrafficWatchVideo();
    }

    @Override
    public void getTrafficWatchVideo() {
        boolean state = mModel.getTrafficWatchVideo();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_TRAFFIC_WATCH_VIDEO, state);
        sendMessage(FPConstant.TRAFFIC_WATCH_VIDEO_HANDLER_ID, bundle);
    }

    @Override
    public void resetFactorySettings() {
        mModel.resetFactorySettings();
    }
}
