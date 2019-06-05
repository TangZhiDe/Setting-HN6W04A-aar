/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.Log;

import com.adayo.component.settings.constant.EnumConstant;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.utils.SPUtils;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

import static android.media.AudioManager.ADJUST_MUTE;
import static android.media.AudioManager.ADJUST_UNMUTE;
import static com.adayo.proxy.audio.constants.AudioDspConstantsDef.CANCEL_MUTE;
import static com.adayo.proxy.audio.constants.AudioDspConstantsDef.MUTE_ALL;
import static com.adayo.proxy.audio.constants.AudioDspConstantsDef.MUTE_EXCEPT_NAVIGATION;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class VolumeModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + VolumeModel.class.getSimpleName();
    private static final float MAX_VOLUME_VALUE = 40f;
    private static VolumeModel mModel = null;
    private Context mContext;
    //    private AudioDspManager mAudioDspManager;
    private AudioManager mAudioManager;

    private VolumeModel(Context context) {
        this.mContext = context;
    }

    public static VolumeModel getVolumeModelInstance(Context context) {
        if (mModel == null) {
            synchronized (VolumeModel.class) {
                if (mModel == null) {
                    mModel = new VolumeModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
//        mAudioDspManager = AudioDspManager.getShareDataManager();
//        mAudioDspManager.init();
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
    }


    public boolean getTurnOnVolumeSwitch() {
        String[] outPrarm = new String[1];
        int i = mSettingsManager.doDb_SysOnVolumeSwitch(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr, outPrarm);
        Log.d(TAG, "getTurnOnVolumeSwitch: " + i);
        return Boolean.parseBoolean(outPrarm[0]);
    }

    public void setTurnOnVolumeSwitch(boolean state) {
        Log.d(TAG, "setTurnOnVolumeSwitch: " + state);
        String[] inPrarm = new String[]{String.valueOf(state)};
        int i = mSettingsManager.doDb_SysOnVolumeSwitch(mContext, SettingsContantsDef.MODE_SET, inPrarm, FPConstant.emptyArr);
        Log.d(TAG, "setTurnOnVolumeSwitch: " + i);
    }

    public int getVolume(int volumeType) {
        switch (volumeType) {
            case FPConstant.VOLUME_TYPE_TURN_ON:
                if (getTurnOnVolumeSwitch()) {
//                    int[] volume = mAudioDspManager.getMainVolume();
                    return 5;
                } else {
//                    String[] outPrarm = new String[1];
//                    mSettingsManager.doDb_SysOnVolume(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr, outPrarm);
                    return 5;
                }
            case FPConstant.VOLUME_TYPE_NAVIGATION:
                return roundGetVolume(AudioManager.STREAM_NOTIFICATION);
//            case FPConstant.VOLUME_TYPE_BLUETOOTH:
//                return roundGetVolume(AudioManager.STREAM_BLUETOOTH_SCO);
            case FPConstant.VOLUME_TYPE_MEDIA:
                return roundGetVolume(AudioManager.STREAM_MUSIC);
            case FPConstant.VOLUME_TYPE_NOTIFY:
                return roundGetVolume(AudioManager.STREAM_NOTIFICATION);
//            case FPConstant.VOLUME_TYPE_TTS:
//                return roundGetVolume(AudioManager.STREAM_TTS);
            default:
                break;
        }
        return 16;
    }

    public void setVolume(int volumeType, int volume) {
        switch (volumeType) {
            case FPConstant.VOLUME_TYPE_TURN_ON:
//                mAudioDspManager.setMainVolume(volume);
//                mAudioDspManager.setNaviVolume(volume);
                if (!getTurnOnVolumeSwitch()) {
                    mSettingsManager.doDb_SysOnVolume(mContext, SettingsContantsDef.MODE_SET, new String[]{String.valueOf(volume)},
                            FPConstant.emptyArr);
                }
                break;
            case FPConstant.VOLUME_TYPE_NAVIGATION:
                mAudioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, roundSetVolume(volume, AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_PLAY_SOUND);
                break;
            case FPConstant.VOLUME_TYPE_BLUETOOTH:
//                mAudioManager.setStreamVolume(AudioManager.STREAM_BLUETOOTH_SCO, roundSetVolume(volume, AudioManager.STREAM_BLUETOOTH_SCO), AudioManager.FLAG_PLAY_SOUND);
                break;
            case FPConstant.VOLUME_TYPE_MEDIA:
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, roundSetVolume(volume, AudioManager.STREAM_MUSIC), AudioManager.FLAG_PLAY_SOUND);
                break;
            case FPConstant.VOLUME_TYPE_NOTIFY:
                mAudioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, roundSetVolume(volume, AudioManager.STREAM_NOTIFICATION), AudioManager.FLAG_PLAY_SOUND);
                break;
            case FPConstant.VOLUME_TYPE_TTS:
//                mAudioManager.setStreamVolume(AudioManager.STREAM_TTS, roundSetVolume(volume, AudioManager.STREAM_TTS), AudioManager.FLAG_PLAY_SOUND);
                break;
            default:
                break;
        }
    }

    private int roundSetVolume(int volume, int type) {
        int max = mAudioManager.getStreamMaxVolume(type);
        int round = Math.round(volume * max / MAX_VOLUME_VALUE);
        Log.d(TAG, "roundSetVolume type: " + type + ", android volume: "
                + round + ", bsp volume: " + volume);
        return round;
    }

    private int roundGetVolume(int type) {
        int volume = mAudioManager.getStreamVolume(type);
        int max = mAudioManager.getStreamMaxVolume(type);
        int round = Math.round(volume * MAX_VOLUME_VALUE / max);
        Log.d(TAG, "roundSetVolume type: " + type + ", android volume: "
                + volume + ", bsp volume: " + round);
        return round;
    }

    public int getNaigationBroadcast() {
        return SPUtils.getInt(mContext, FPConstant.EXTRA_NAIGATION_BROADCAST,
                EnumConstant.NAIGATION_BROADCAST.MIXING.getValue());
    }

    public boolean setNaigationBroadcast(int type) {
        return SPUtils.put(mContext, FPConstant.EXTRA_NAIGATION_BROADCAST, type);
    }

    public int getSpeedComVolume() {
        return SPUtils.getInt(mContext, FPConstant.EXTRA_SPEED_COM_VOLUME,
                EnumConstant.NAIGATION_BROADCAST.MIXING.getValue());
    }

    public boolean setSpeedComVolume(int itemMode) {
        return SPUtils.put(mContext, FPConstant.EXTRA_SPEED_COM_VOLUME, itemMode);
    }

    public boolean getKeyToneSwitch() {
        //0 关  1开
        int beepSound = Settings.System.getInt(mContext.getContentResolver(),
                Settings.System.SOUND_EFFECTS_ENABLED, 0);
        return beepSound == 1;
    }

    public void setKeyToneSwitch(boolean state) {
        if (state) {
            Settings.System.putInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED,
                    1);
            mAudioManager.loadSoundEffects();
        } else {
            Settings.System.putInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED,
                    0);
            mAudioManager.unloadSoundEffects();
        }
    }

    public boolean getNotifySwitch() {
//        return mAudioManager.isStreamMute(AudioManager.STREAM_NOTIFICATION);
        return false;
    }

    public void setNotifySwitch(boolean state) {
        int direction = state ? ADJUST_MUTE : ADJUST_UNMUTE;
        mAudioManager.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, direction, 0);
    }

    public boolean getMuteState() {
//        //获取静音状态
//        int[] muteMode = mAudioDspManager.getMuteMode();
//        boolean isMute = false;
//        if (null != muteMode) {
//            switch (muteMode[0]) {
//                case CANCEL_MUTE:
//                    isMute = false;
//                    break;
//                case MUTE_ALL:
//                case MUTE_EXCEPT_NAVIGATION:
//                    isMute = true;
//                    break;
//                default:
//                    break;
//            }
//        }
        return true;
    }

    public void setMuteState(boolean state) {
        int isMute = state ? MUTE_ALL : CANCEL_MUTE;
//        mAudioDspManager.setMuteMode(isMute);
    }
}
