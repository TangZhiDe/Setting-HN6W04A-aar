package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.content.Intent;

import com.adayo.component.settings.bfpcontract.ISecuritySettingFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.SecuritySettingModel;

/**
 * @author damanz
 * @className SecuritySettingFPresent
 * @date 2018-09-19.
 */
public class SecuritySettingFPresent extends SettingsBaseFPersenter<SecuritySettingModel> implements ISecuritySettingFuncPresenter {

    public SecuritySettingFPresent(Context context) {
        super(context);
        mModel = SecuritySettingModel.getSecuritySettingModelInstance(mContext);
    }

    @Override
    public void getInstallUnknowSourceState() {
        boolean sourceState = mModel.getInstallUnknowSourceState();
       // Intent intent = new Intent();
       // intent.putExtra(FPConstant.EXTRA_INSTALL_UNKNOW_SOURCE, sourceState);
       // sendMessage(FPConstant.INSTALL_UNKNOW_SOURCE_HANDLER_ID, intent);
    }

    @Override
    public void setInstallUnknowSourceState(boolean state) {
        mModel.setInstallUnknowSourceState(state);
        getInstallUnknowSourceState();
    }
}
