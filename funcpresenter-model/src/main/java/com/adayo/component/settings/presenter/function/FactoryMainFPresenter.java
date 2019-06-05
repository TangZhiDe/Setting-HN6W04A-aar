package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IFactoryMainFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.FactoryMainModel;

/**
 * @author damanz
 * @className FactoryMainFPresenter
 * @date 2018-09-04.
 */
public class FactoryMainFPresenter extends SettingsBaseFPersenter<FactoryMainModel> implements IFactoryMainFuncPresenter {

    public FactoryMainFPresenter(Context context) {
        super(context);
        mModel = FactoryMainModel.getFactoryMainModelInstance(mContext);
    }

    @Override
    public void setAdbSwitch(boolean state) {
        mModel.setAdbSwitch(state);
        getAdbSwitch();
    }

    @Override
    public void getAdbSwitch() {
        boolean state = mModel.getAdbSwitch();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_ADB_SWITCH, state);
        sendMessage(FPConstant.ADB_SWITCH_HANDLER_ID, bundle);
    }

    @Override
    public void getTouchFirmwareVersion() {
        String touchVersion = mModel.getTouchFirmwareVersion();
        Bundle bundle = new Bundle();
        bundle.putString(FPConstant.EXTRA_TOUCH_VERSION, touchVersion);
        sendMessage(FPConstant.TOUCH_VERSION_HANDLER_ID, bundle);
    }

    @Override
    public void getBluetoothName() {
        String bluetoothName = mModel.getBluetoothName();
        Bundle bundle = new Bundle();
        bundle.putString(FPConstant.EXTRA_BLUETOOTH_NAME, bluetoothName);
        sendMessage(FPConstant.BLUETOOTH_NAME_HANDLER_ID, bundle);
    }

    @Override
    public void setBluetoothName(String name) {
        mModel.setBluetoothName(name);
    }

    @Override
    public void getUUID() {
        String uuid = mModel.getUUID();
        Bundle bundle = new Bundle();
        bundle.putString(FPConstant.EXTRA_UUID, uuid);
        sendMessage(FPConstant.UUID_HANDLER_ID, bundle);
    }

    @Override
    public void getDeviceId() {
        String deviceId = mModel.getDeviceId();
        Bundle bundle = new Bundle();
        bundle.putString(FPConstant.EXTRA_DEVICE_ID, deviceId);
        sendMessage(FPConstant.DEVICE_ID_HANDLER_ID, bundle);
    }

    @Override
    public void getProductionNum() {
        String productionNum = mModel.getProductionNum();
        Bundle bundle = new Bundle();
        bundle.putString(FPConstant.EXTRA_PRODUCTION_NUM, productionNum);
        sendMessage(FPConstant.PRODUCTION_NUM_HANDLER_ID, bundle);
    }

    @Override
    public void getHardwareVersion() {
        String hardwareVersion = mModel.getHardwareVersion();
        Bundle bundle = new Bundle();
        bundle.putString(FPConstant.EXTRA_HARDWARE_VERSION, hardwareVersion);
        sendMessage(FPConstant.HARDWARE_VERSION_HANDLER_ID, bundle);
    }

    @Override
    public void getLogSaveState() {
        boolean state=mModel.getLogSaveState();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_LOG_SAVE, state);
        sendMessage(FPConstant.LOG_SAVE_HANDLER_ID, bundle);
    }

    @Override
    public void setLogSaveState(boolean state) {
        mModel.setLogSaveState(state);
        getLogSaveState();
    }

    @Override
    public void setProductionNum(String text) {
        mModel.setProductionNum(text);
        getProductionNum();
    }

    @Override
    public void setDeviceId(String text) {
        mModel.setDeviceId(text);
        getDeviceId();
    }

    @Override
    public void setUUID(String text) {
        mModel.setUUID(text);
        getUUID();
    }
}
