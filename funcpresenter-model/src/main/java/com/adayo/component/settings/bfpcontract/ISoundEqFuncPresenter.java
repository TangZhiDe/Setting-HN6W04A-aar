/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className IMainBFPContract
 * @date 2018-07-26.
 */
public interface ISoundEqFuncPresenter {

    void getSoundEqMode();

    void setSoundEqMode(int mode);

    void setBassFreqEffect(int value);

    void setMiddleFreqEffect(int value);

    void setTrebleFreqEffect(int value);

    void setLoudnessSwitch(boolean state);

    void getLoudnessSwitch();

    void resetSoundEq();
}
