package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IVolumeFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.VolumeModel;

/**
 * @author damanz
 * @className VolumeFPresenter
 * @date 2018-08-08.
 */
public class VolumeFPresenter extends SettingsBaseFPersenter<VolumeModel> implements IVolumeFuncPresenter {

    public VolumeFPresenter(Context context) {
        super(context);
        mModel = VolumeModel.getVolumeModelInstance(mContext);
    }

    @Override
    public void getTurnOnVolumeSwitch() {
        boolean state = mModel.getTurnOnVolumeSwitch();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_TURN_ON_VOLUME_SWITCH_STATE, state);
        sendMessage(FPConstant.TURN_ON_VOLUME_SWITCH_STATE_HANDLER_ID, bundle);
    }

    @Override
    public void setTurnOnVolumeSwitch(boolean state) {
        mModel.setTurnOnVolumeSwitch(state);
        getTurnOnVolumeSwitch();
    }

    @Override
    public void setVolume(int volumeType, int volume) {
        mModel.setVolume(volumeType, volume);
        getVolume(volumeType);
    }

    @Override
    public void getVolume(int volumeType) {
        int volume = mModel.getVolume(volumeType);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_VOLUME, volume);
        bundle.putInt(FPConstant.EXTRA_VOLUME_TYPE, volumeType);
        sendMessage(FPConstant.UPDATE_VOLUME_HANDLER_ID, bundle);
    }

    @Override
    public void getNaigationBroadcast() {
        int itemMode = mModel.getNaigationBroadcast();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_NAIGATION_BROADCAST, itemMode);
        sendMessage(FPConstant.NAIGATION_BROADCAST_HANDLER_ID, bundle);
    }

    @Override
    public void setNaigationBroadcast(int itemMode) {
        mModel.setNaigationBroadcast(itemMode);
        getNaigationBroadcast();
    }

    @Override
    public void getSpeedComVolume() {
        int itemMode = mModel.getSpeedComVolume();
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_SPEED_COM_VOLUME, itemMode);
        sendMessage(FPConstant.SPEED_COM_VOLUME_HANDLER_ID, bundle);
    }

    @Override
    public void setSpeedComVolume(int itemMode) {
        mModel.setSpeedComVolume(itemMode);
        getSpeedComVolume();
    }

    @Override
    public void getKeyToneSwitch() {
        boolean state = mModel.getKeyToneSwitch();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_KEY_TONE_SWITCH, state);
        sendMessage(FPConstant.KEY_TONE_SWITCH_HANDLER_ID, bundle);
    }

    @Override
    public void setKeyToneSwitch(boolean state) {
        mModel.setKeyToneSwitch(state);
        getKeyToneSwitch();
    }

    @Override
    public void getNotifySwitch() {
        boolean state = mModel.getNotifySwitch();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_NOTIFY_SWITCH, state);
        sendMessage(FPConstant.KEY_NOTIFY_HANDLER_ID, bundle);
    }

    @Override
    public void setNotifySwitch(boolean state) {
        mModel.setNotifySwitch(state);
        getNotifySwitch();
    }

    @Override
    public void getMuteState() {
        boolean state = mModel.getMuteState();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_MUTE_SWITCH, state);
        sendMessage(FPConstant.KEY_MUTE_HANDLER_ID, bundle);
    }

    @Override
    public void setMuteState(boolean state) {
        mModel.setMuteState(state);
    }
}
