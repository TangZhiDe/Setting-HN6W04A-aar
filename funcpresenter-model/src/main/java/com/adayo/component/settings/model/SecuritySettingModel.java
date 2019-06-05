package com.adayo.component.settings.model;

import android.content.Context;
import android.provider.Settings;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className SecuritySettingModel
 * @date 2018-09-07.
 */
public class SecuritySettingModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + SecuritySettingModel.class.getSimpleName();
    private static SecuritySettingModel mModel = null;
    private Context mContext;

    private SecuritySettingModel(Context context) {
        this.mContext = context;
    }

    public static SecuritySettingModel getSecuritySettingModelInstance(Context context) {
        if (mModel == null) {
            synchronized (SecuritySettingModel.class) {
                if (mModel == null) {
                    mModel = new SecuritySettingModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    public boolean getInstallUnknowSourceState() {
        int value = Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS, 0);

        return value == 1;
    }

    public void setInstallUnknowSourceState(boolean state) {
        Settings.Secure.putInt(mContext.getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS, state ? 1 : 0);
    }
}
