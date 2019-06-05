/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className IMainBFPContract
 * @date 2018-07-26.
 */
public interface IVolumeFuncPresenter {
    /**
     * 获取开机音量开关状态
     */
    void getTurnOnVolumeSwitch();

    void setTurnOnVolumeSwitch(boolean state);

    /**
     * 设置音量
     *
     * @param volumeType 音量类型
     * @param volume
     */
    void setVolume(int volumeType, int volume);

    /**
     * 获取音量
     *
     * @param volumeType 音量类型
     */
    void getVolume(int volumeType);

    /**
     * 导航混音播报
     */
    void getNaigationBroadcast();

    void setNaigationBroadcast(int itemMode);

    /**
     * 速度补偿音
     */
    void getSpeedComVolume();

    void setSpeedComVolume(int itemMode);

    /**
     * 获取按键提示音状态
     */
    void getKeyToneSwitch();

    void setKeyToneSwitch(boolean state);

    /**
     * 获取信息提示音状态
     */
    void getNotifySwitch();
    void setNotifySwitch(boolean state);

    /**
     * 获取静音状态
     */
    void getMuteState();
    void setMuteState(boolean state);
}
