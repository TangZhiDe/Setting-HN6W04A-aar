package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.adayo.component.settings.bfpcontract.ISoundEqFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.SoundEqModel;
import com.adayo.proxy.settings.utils.LogUtil;

/**
 * @author damanz
 * @className SoundEqFPresenter
 * @date 2018-08-08.
 */
public class SoundEqFPresenter extends SettingsBaseFPersenter<SoundEqModel> implements ISoundEqFuncPresenter {

    public SoundEqFPresenter(Context context) {
        super(context);
        mModel = SoundEqModel.getSoundEqModelInstance(mContext);
    }

    @Override
    public void getSoundEqMode() {
        int eqMode = mModel.getSoundEqMode();
        Log.d(TAG, "getSoundEqMode: "+eqMode);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_EQ_TYPE, eqMode);
        sendMessage(FPConstant.EQ_TYPE_HANDLER_ID, bundle);
        getBassFreqEffect();
        getTrebleFreqEffect();
        getMiddleFreqEffect();
    }

    @Override
    public void setSoundEqMode(int mode) {
        mModel.setSoundEqMode(mode);
        getSoundEqMode();
    }

    private void getBassFreqEffect() {
        int freqEffect = mModel.getBassFreqEffect();
        Log.d(TAG, "getBassFreqEffect: "+freqEffect);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_EQ_TYPE_BASE, formatFreqEffect(freqEffect));
        sendMessage(FPConstant.EQ_TYPE_BASE_HANDLER_ID, bundle);
    }

    private void getMiddleFreqEffect() {
        int freqEffect = mModel.getMiddleFreqEffect();
        Log.d(TAG, "getMiddleFreqEffect: " + freqEffect);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_EQ_TYPE_MIDDLE, formatFreqEffect(freqEffect));
        sendMessage(FPConstant.EQ_TYPE_MIDDLE_HANDLER_ID, bundle);
    }

    private void getTrebleFreqEffect() {
        int freqEffect = mModel.getTrebleFreqEffect();
        Log.d(TAG, "getTrebleFreqEffect: "+freqEffect);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_EQ_TYPE_TREBLE, formatFreqEffect(freqEffect));
        sendMessage(FPConstant.EQ_TYPE_TREBLE_HANDLER_ID, bundle);
    }

    private int formatFreqEffect(int freqEffect){
        if(freqEffect > 15){
            freqEffect = 15;
        }
        if(freqEffect < 1){
            freqEffect = 1;
        }
        return freqEffect;
    }

    @Override
    public void setBassFreqEffect(int value) {
        mModel.setBassFreqEffect(value);
        getBassFreqEffect();
    }

    @Override
    public void setMiddleFreqEffect(int value) {
        mModel.setMiddleFreqEffect(value);
        getMiddleFreqEffect();
    }

    @Override
    public void setTrebleFreqEffect(int value) {
        mModel.setTrebleFreqEffect(value);
        getTrebleFreqEffect();
    }

    @Override
    public void setLoudnessSwitch(boolean state) {
        mModel.setLoudnessSwitch(state);
        getLoudnessSwitch();
    }

    @Override
    public void getLoudnessSwitch() {
        boolean state = mModel.getLoudnessSwitch();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_LOUDNESS,state);
        sendMessage(FPConstant.LOUDNESS_HANDLER_ID,bundle);
    }

    @Override
    public void resetSoundEq() {
        int i = mModel.resetSoundEq();
        getSoundEqMode();
    }
}
