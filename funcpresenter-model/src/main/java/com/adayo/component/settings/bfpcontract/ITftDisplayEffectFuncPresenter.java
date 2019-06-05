package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className ITftDisplayEffectFuncPresenter
 * @date 2018-09-19.
 */
public interface ITftDisplayEffectFuncPresenter {
    void getBrightness();
    void setBrightness(int value);

    void getContrastRatio();
    void setContrastRatio(int value);

    void getSaturation();
    void setSaturation(int value);

    void getChroma();
    void setChroma(int value);

    void getSharpness();
    void setSharpness(int value);
}
