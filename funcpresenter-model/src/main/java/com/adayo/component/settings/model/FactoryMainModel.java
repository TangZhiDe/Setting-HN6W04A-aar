package com.adayo.component.settings.model;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.utils.SPUtils;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

/**
 * @author damanz
 * @className FactoryMainModel
 * @date 2018-09-04.
 */
public class FactoryMainModel extends BaseModel {

    public static final String TAG = FPConstant.TAG + FactoryMainModel.class.getSimpleName();
    private static FactoryMainModel mModel = null;
    private Context mContext;
    //private SystemServiceManager mSystemService;


    public FactoryMainModel(Context context) {
        this.mContext = context;
    }

    public static FactoryMainModel getFactoryMainModelInstance(Context context) {
        if (mModel == null) {
            synchronized (FactoryMainModel.class) {
                if (mModel == null) {
                    mModel = new FactoryMainModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    public void setAdbSwitch(boolean state) {
        Settings.Global.putInt(mContext.getContentResolver(),
                Settings.Global.ADB_ENABLED, state ? 1 : 0);
        //状态栏广播
        LocalBroadcastManager.getInstance(mContext)
                .sendBroadcast(new Intent(FPConstant.ACTION_ENABLE_ADB_STATE_CHANGED));
    }


    public boolean getAdbSwitch() {
        int intState = Settings.Global.getInt(mContext.getContentResolver(), Settings.Global.ADB_ENABLED, 1);
        return intState == 1;
    }

    public String getTouchFirmwareVersion() {
        String[] out_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out_pream, new byte[]{FPConstant.SYS_CONFIG_TOUCHVER});
        return out_pream[0];
    }

    public String getBluetoothName() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return bluetoothAdapter.getName();
    }

    public void setBluetoothName(final String name) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean b = bluetoothAdapter.setName(name);
        Log.d(TAG, "setBluetoothName: " + b);
    }

    public String getUUID() {
        String[] out_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out_pream, new byte[]{FPConstant.SYS_CONFIG_UUID});
        return out_pream[0];
    }

    public String getDeviceId() {
        String[] out_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out_pream, new byte[]{FPConstant.SYS_CONFIG_DEVID});
        return out_pream[0];
    }

    public String getProductionNum() {
        String[] out_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out_pream, new byte[]{FPConstant.SYS_CONFIG_SERNUM});
        return out_pream[0];
    }

    public String getHardwareVersion() {
        String[] out_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out_pream, new byte[]{FPConstant.SYS_CONFIG_HARDVER});
        return out_pream[0];
    }

    public boolean getLogSaveState() {
        return SPUtils.getBoolean(mContext, FPConstant.EXTRA_LOG_SAVE, true);
    }

    public void setLogSaveState(boolean state) {
        SPUtils.put(mContext, FPConstant.EXTRA_LOG_SAVE, state);
    }

    public void setProductionNum(String text) {
        String[] in_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_SET,
                in_pream, FPConstant.emptyArr, new byte[]{FPConstant.SYS_CONFIG_SERNUM});
        if(nRef==SettingsContantsDef.RET_NG_NOR){
            Toast.makeText(mContext,"修改生产序列号失败",Toast.LENGTH_SHORT).show();
        }
    }

    public void setDeviceId(String text) {
        String[] in_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_SET,
                in_pream, FPConstant.emptyArr, new byte[]{FPConstant.SYS_CONFIG_DEVID});
        if(nRef==SettingsContantsDef.RET_NG_NOR){
            Toast.makeText(mContext,"修改设备ID失败",Toast.LENGTH_SHORT).show();
        }
    }

    public void setUUID(String text) {
        String[] in_pream = new String[1];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_SET,
                in_pream, FPConstant.emptyArr, new byte[]{FPConstant.SYS_CONFIG_UUID});
        if(nRef==SettingsContantsDef.RET_NG_NOR){
            Toast.makeText(mContext,"修改UUID失败",Toast.LENGTH_SHORT).show();
        }
    }
}
