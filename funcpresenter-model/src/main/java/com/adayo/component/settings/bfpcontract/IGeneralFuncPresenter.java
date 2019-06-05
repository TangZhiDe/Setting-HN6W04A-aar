package com.adayo.component.settings.bfpcontract;

import java.util.Locale;

/**
 * @author damanz
 * @className IGeneralBFPContract
 * @date 2018-08-08.
 */
public interface IGeneralFuncPresenter {

    void setSystemLanguage(Locale locale);

    void getSystemLanguage();

    void getStandbyDisplay();

    void setStandbyDisplay(int itemMode);

    void getAndroidStartApp();

    void getIphoneStartApp();

    void setIphoneStartApp(int itemMode);

    void setAndroidStartApp(int itemMode);

    void setTrafficWatchVideo(boolean state);

    void getTrafficWatchVideo();

    void resetFactorySettings();
}
