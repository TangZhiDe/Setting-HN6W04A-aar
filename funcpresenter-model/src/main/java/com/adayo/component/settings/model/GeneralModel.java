/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.app.ActivityManager;
//import android.app.IActivityManager;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.LocaleList;
import android.os.RemoteException;
import android.util.Log;

import com.adayo.component.settings.constant.EnumConstant;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.utils.SPUtils;
import com.adayo.proxy.settings.contants.SettingsContantsDef;
import com.adayo.proxy.sourcemngproxy.Control.SrcMngSwitchProxy;

import java.util.Locale;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class GeneralModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + GeneralModel.class.getSimpleName();
    private static GeneralModel mModel = null;
    private Context mContext;


    private GeneralModel(Context context) {
        this.mContext = context;
    }

    public static GeneralModel getCurrencyModelInstance(Context context) {
        if (mModel == null) {
            synchronized (GeneralModel.class) {
                if (mModel == null) {
                    mModel = new GeneralModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    public boolean setSystemLanguage(Locale language) {
//        try {
//            final IActivityManager am = ActivityManager.getService();
//            final Configuration config = am.getConfiguration();
//
//            config.setLocales(new LocaleList(language));
//            config.userSetLocale = true;
//
//            am.updatePersistentConfiguration(config);
//            // Trigger the dirty bit for the Settings Provider.
//            BackupManager.dataChanged("com.android.providers.settings");
//
//            //更改应用语言
//            Configuration configuration = mContext.getResources().getConfiguration();
//            configuration.setLocale(language);
//            mContext.getResources().updateConfiguration(configuration,
//                    mContext.getResources().getDisplayMetrics());
//            return true;
//        } catch (RemoteException e) {
//            // Intentionally left blank
//            Log.d(TAG, "setSystemLanguage: 语言设置失败");
//            e.printStackTrace();
//        }

        return false;
    }

    public Locale getSystemLanguage() {
        LocaleList locales = mContext.getResources().getConfiguration().getLocales();
        return locales.get(0);
    }

    public int getStandbyDisplay() {
        return SPUtils.getInt(mContext, FPConstant.EXTRA_STANDBY_DISPLAY,
                EnumConstant.STANDBY_DISPLAY.DIGITAL_CLOCK.getValue());
    }

    public void setStandbyDisplay(int itemMode) {
        SPUtils.put(mContext, FPConstant.EXTRA_STANDBY_DISPLAY, itemMode);
    }

    public int getAndroidStartApp() {
        String[] out=new String[1];
        int i = mSettingsManager.doDb_AndroidStartApp(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr,out);
        Log.d(TAG, "getAndroidStartApp: "+i+"  out[0] "+out[0]);
        return Integer.parseInt(out[0]);
    }

    public int getIphoneStartApp() {
        String[] out=new String[1];
        int i = mSettingsManager.doDb_IphoneStartApp(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr,out);
        Log.d(TAG, "getIphoneStartApp: "+i+"  out[0] "+out[0]);
        return Integer.parseInt(out[0]);
    }

    public void setAndroidStartApp(int itemMode) {
        String[] in=new String[]{String.valueOf(itemMode)};
        int i = mSettingsManager.doDb_AndroidStartApp(mContext, SettingsContantsDef.MODE_SET, in,
                FPConstant.emptyArr);
        Log.d(TAG, "setIphoneStartApp: "+i);
    }

    public void setIphoneStartApp(int itemMode) {
        String[] in=new String[]{String.valueOf(itemMode)};
        int i = mSettingsManager.doDb_IphoneStartApp(mContext, SettingsContantsDef.MODE_SET, in,
                FPConstant.emptyArr);
        Log.d(TAG, "setIphoneStartApp: "+i);
    }

    public void setTrafficWatchVideo(boolean state) {
        String[] in = new String[]{String.valueOf(state)};
        int i = mSettingsManager.doDb_DrivingWatchVideoSwitch(mContext, SettingsContantsDef.MODE_SET,
                in, FPConstant.emptyArr);
        Log.d(TAG, "setTrafficWatchVideo: " + i);
    }

    public boolean getTrafficWatchVideo() {
        String[] out = new String[1];
        int i = mSettingsManager.doDb_DrivingWatchVideoSwitch(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out);
        Log.d(TAG, "getTrafficWatchVideo  i:" + i + "     state: " + out[0]);
        return Boolean.parseBoolean(out[0]);
    }

    public void resetFactorySettings() {
        //1.禁止切源
        SrcMngSwitchProxy.getInstance().pauseSwitchSource();
        mSettingsManager.doDb_ResetFactorySetting(mContext);
        //2.屏蔽返回键、home键、菜单键、【无此按键，替换成空调底栏】
//        isRestoreFactory = true;
        //3.发送Broadcast屏蔽通知栏下滑
//        sendBroadcast(new Intent("com.adayo.app.settings.ACTION_FACTORY_RESET"));
        //4.恢复出厂
//                    Intent intent = new Intent(Intent.ACTION_FACTORY_RESET);
//                    intent.setPackage("android");
//                    intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);
//                    intent.putExtra(Intent.EXTRA_REASON, "MasterClearConfirm");
//                    //是否擦除SDCard数据、ESIM数据
//                    intent.putExtra(Intent.EXTRA_WIPE_EXTERNAL_STORAGE, true);
//                    intent.putExtra(Intent.EXTRA_WIPE_ESIMS, true);
//                    sendBroadcast(intent);
    }
}
