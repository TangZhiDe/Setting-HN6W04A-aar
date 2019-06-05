package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className IDisplayBFPContract
 * @date 2018-08-08.
 */
public interface IDisplayFuncPresenter {

    void setScreenBrightnessMode(int mode);

    void getScreenBrightnessMode();

    void getBrightnessProgress();

    void setBrightnessProgress(int progress);


    void setScreenDisplayState(boolean isDisplay);

    void getScreenDisplayState();
}
