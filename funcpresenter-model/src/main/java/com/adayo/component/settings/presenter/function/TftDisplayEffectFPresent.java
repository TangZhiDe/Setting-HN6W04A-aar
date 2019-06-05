package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.ITftDisplayEffectFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.TftDisplayEffectModel;

/**
 * @author damanz
 * @className TftDisplayEffectFPresent
 * @date 2018-09-19.
 */
public class TftDisplayEffectFPresent extends SettingsBaseFPersenter<TftDisplayEffectModel> implements ITftDisplayEffectFuncPresenter {

    public TftDisplayEffectFPresent(Context context) {
        super(context);
        mModel=TftDisplayEffectModel.getTftDisplayEffectModelInstance(mContext);
    }

    @Override
    public void getBrightness() {
        int range = mModel.getBrightnessRange();
        int value = mModel.getBrightnessValue();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_BRIGHTNESS,value);
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_BRIGHTNESS_RANGE,range);
        sendMessage(FPConstant.FGERPMSG_BRIGHTNESS_HANDLER_ID,bundle);
    }

    @Override
    public void setBrightness(int value) {
        mModel.setBrightness(value);
        getBrightness();
    }

    @Override
    public void getContrastRatio() {
        int range = mModel.getContrastRatioRange();
        int value = mModel.getContrastRatioValue();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_CONTRAST,value);
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_CONTRAST_RANGE,range);
        sendMessage(FPConstant.FGERPMSG_CONTRAST_HANDLER_ID,bundle);
    }

    @Override
    public void setContrastRatio(int value) {
        mModel.setContrastRatio(value);
        getContrastRatio();
    }

    @Override
    public void getSaturation() {
        int range = mModel.getSaturationRange();
        int value = mModel.getSaturationValue();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_SATURATION,value);
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_SATURATION_RANGE,range);
        sendMessage(FPConstant.FGERPMSG_SATURATION_HANDLER_ID,bundle);
    }

    @Override
    public void setSaturation(int value) {
        mModel.setSaturation(value);
        getSaturation();
    }

    @Override
    public void getChroma() {
        int range = mModel.getChromaRange();
        int value = mModel.getChromaValue();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_HUE,value);
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_HUE_RANGE,range);
        sendMessage(FPConstant.FGERPMSG_HUE_HANDLER_ID,bundle);
    }

    @Override
    public void setChroma(int value) {
        mModel.setChroma(value);
        getChroma();
    }

    @Override
    public void getSharpness() {
        int range = mModel.getSharpnessRange();
        int value = mModel.getSharpnessValue();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_SHARPNESS,value);
        bundle.putInt(FPConstant.EXTRA_FGERPMSG_SHARPNESS_RANGE,range);
        sendMessage(FPConstant.FGERPMSG_SHARPNESS_HANDLER_ID,bundle);
    }

    @Override
    public void setSharpness(int value) {
        mModel.setSharpness(value);
        getSharpness();
    }
}
