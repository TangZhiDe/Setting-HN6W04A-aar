package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.ISystemInfoFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.SystemInfoModel;

import java.io.Serializable;
import java.util.Map;

/**
 * @author damanz
 * @className SystemInfoFPresenter
 * @date 2018-08-08.
 */
public class SystemInfoFPresenter extends SettingsBaseFPersenter<SystemInfoModel> implements ISystemInfoFuncPresenter {

    public SystemInfoFPresenter(Context context) {
        super(context);
        mModel = SystemInfoModel.getSystemInfoModelInstance(context);
    }

    @Override
    public void getVersionInfo() {
        Map<String, String> versionInfo = mModel.getVersionInfo();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FPConstant.EXTRA_VERSION_INFO, (Serializable) versionInfo);
        sendMessage(FPConstant.VERSION_INFO_HANDLER_ID,bundle);
    }

    @Override
    public void initUpdate(int type) {
        mModel.initUpdate(type);
    }
}
