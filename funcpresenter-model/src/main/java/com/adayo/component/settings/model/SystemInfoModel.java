/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.content.Context;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.proxy.settings.SettingsManager;
import com.adayo.proxy.settings.contants.SettingsContantsDef;
import com.adayo.proxy.sourcemngproxy.Beans.AppConfigType;
import com.adayo.proxy.sourcemngproxy.Beans.SourceConstants;
import com.adayo.proxy.sourcemngproxy.Beans.SourceInfo;
import com.adayo.proxy.sourcemngproxy.Control.SrcMngSwitchProxy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.adayo.proxy.sourcemngproxy.Beans.AppConfigType.SourceType.UI_AUDIO;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class SystemInfoModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + SystemInfoModel.class.getSimpleName();
    private static SystemInfoModel mModel = null;
    private Context mContext;
    //private SystemServiceManager mSystemService;
    private SrcMngSwitchProxy mSrcMngSwitchProxy;
    private SettingsManager mSettingsManager;

    private SystemInfoModel(Context context) {
        this.mContext = context;
    }

    public static SystemInfoModel getSystemInfoModelInstance(Context context) {
        if (mModel == null) {
            synchronized (SystemInfoModel.class) {
                if (mModel == null) {
                    mModel = new SystemInfoModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
        mSettingsManager = SettingsManager.getSettingsManager();
        mSrcMngSwitchProxy = SrcMngSwitchProxy.getInstance();

    }

    public Map<String, String> getVersionInfo() {
        String[] out_pream = new String[4];
        int nRef = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out_pream, new byte[]{FPConstant.SYS_CONFIG_MODLE, FPConstant.SYS_CONFIG_MPU,
                        FPConstant.SYS_CONFIG_MCU, FPConstant.SYS_CONFIG_OS});
        Log.d(TAG, "getVersionInfo: "+nRef);
        Map<String, String> map = new LinkedHashMap<>();
        map.put(FPConstant.VERSION_MODLE, out_pream[0]);
        map.put(FPConstant.VERSION_MPU, out_pream[1]);
        map.put(FPConstant.VERSION_MCU, out_pream[2]);
        map.put(FPConstant.VERSION_OS, out_pream[3]);
        return map;
    }

    public void initUpdate(int type) {
        Map<String, String> map = new HashMap<>();
        map.put(SourceConstants.SOURCE_FOTA,
                type == FPConstant.UPDATE_MODEL_LOCAL ? FPConstant.UPDATE_LOCAL_PATH : FPConstant.UPDATE_ONLINE_PATH);
        SourceInfo sourceInfo = new SourceInfo(SourceConstants.SOURCE_FOTA, map, AppConfigType.SourceSwitch.APP_ON.getValue(), UI_AUDIO.getValue());
        mSrcMngSwitchProxy.onRequest(sourceInfo);
    }
}
