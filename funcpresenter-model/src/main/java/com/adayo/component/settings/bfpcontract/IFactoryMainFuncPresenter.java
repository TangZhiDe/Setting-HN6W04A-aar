/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className IMainBFPContract
 * @date 2018-07-26.
 */
public interface IFactoryMainFuncPresenter {

    void setAdbSwitch(boolean state);

    void getAdbSwitch();

    void getTouchFirmwareVersion();

    void getBluetoothName();

    void setBluetoothName(String name);

    void getUUID();

    void getDeviceId();

    void getProductionNum();

    void getHardwareVersion();

    void getLogSaveState();

    void setLogSaveState(boolean state);

    void setProductionNum(String text);

    void setDeviceId(String text);

    void setUUID(String text);
}
