/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.content.Context;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class SettingsMainModel extends BaseModel {

    public static final String TAG = FPConstant.TAG + SettingsMainModel.class.getSimpleName();

    private static SettingsMainModel mSettingsMainModel = null;
    private Context mContext;

    private SettingsMainModel(Context context) {
        Log.d(TAG, "SettingsMainModel: ");
        this.mContext=context;
    }

    public static SettingsMainModel getMainModelInstance(Context context) {
        if (mSettingsMainModel == null) {
            synchronized (SettingsMainModel.class) {
                if (mSettingsMainModel == null) {
                    mSettingsMainModel = new SettingsMainModel(context);
                }
            }
        }
        return mSettingsMainModel;
    }

    @Override
    public void init() {
        super.init();
//        boolean b = SettingsManager.getDemoManager().getServiceConnection();
//        if (b) {
//            Log.d(TAG, "init: getServiceConnection is success");
//            String name = SettingsManager.getDemoManager().getServiceName();
//            Log.d(TAG, "initView: name " + name);
//
//            int value = SettingsManager.getDemoManager().getSettingsValue();
//            Log.d(TAG, "initView: value " + value);
//
//            SettingsManager.getDemoManager().setSettingsValue(2222);
//        }else {
//            Log.d(TAG, "init: getServiceConnection is fail");
//        }
    }
}
