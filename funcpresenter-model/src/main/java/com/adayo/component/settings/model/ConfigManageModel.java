package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

/**
 * @author damanz
 * @className ConfigManageModel
 * @date 2018-09-07.
 */
public class ConfigManageModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + ConfigManageModel.class.getSimpleName();
    private static ConfigManageModel mModel = null;
    private Context mContext;

    private ConfigManageModel(Context context) {
        this.mContext = context;
    }

    public static ConfigManageModel getConfigManageModelInstance(Context context) {
        if (mModel == null) {
            synchronized (ConfigManageModel.class) {
                if (mModel == null) {
                    mModel = new ConfigManageModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    public String[] getMcuMpuProtocolVersion() {
        byte[] bytes = {FPConstant.SYS_CONFIG_MCU_MPUVER};
        String[] out=new String[bytes.length];
        int i = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr,
                out, bytes);
        return out;
    }

    public String[] getMcuSourcePathVersion() {
        byte[] bytes = {FPConstant.SYS_CONFIG_MCU,FPConstant.SYS_CONFIG_MCUSVNVER};
        String[] out=new String[bytes.length];
        int i = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr,
                out, bytes);
        return out;
    }

    public String[] getMpuSourcePathVersion() {
        byte[] bytes = {FPConstant.SYS_CONFIG_MPU,FPConstant.SYS_CONFIG_MPUSVNVER};
        String[] out=new String[bytes.length];
        int i = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr,
                out, bytes);
        return out;
    }

    public String[] getBspSourcePathVersion() {
        byte[] bytes = {FPConstant.SYS_CONFIG_BSPVER,FPConstant.SYS_CONFIG_BSPSVNVER};
        String[] out=new String[bytes.length];
        int i = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr,
                out, bytes);
        return out;
    }
}
