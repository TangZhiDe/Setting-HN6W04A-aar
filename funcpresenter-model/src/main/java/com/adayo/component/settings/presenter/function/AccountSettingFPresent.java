package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IAccountSettingFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.AccountSettingModel;
import com.adayo.component.settings.model.bean.UsersAccountInfo;

/**
 * @author damanz
 * @className AccountSettingFPresent
 * @date 2018-09-19.
 */
public class AccountSettingFPresent extends SettingsBaseFPersenter<AccountSettingModel> implements IAccountSettingFuncPresenter {

    public AccountSettingFPresent(Context context) {
        super(context);
        mModel = AccountSettingModel.getAccountSettingModelInstance(mContext);
    }

    @Override
    public void getUsersAccountInfo() {
        UsersAccountInfo info = mModel.getUsersAccountInfo();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_NOT_LOGIN, info == null);
        bundle.putSerializable(FPConstant.EXTRA_ACCOUNT_INFO, info);
        sendMessage(FPConstant.ACCOUNT_SETTING_HANDLER_ID, bundle);
    }

    @Override
    public void exitLogin() {
        mModel.exitLogin();
        getUsersAccountInfo();
    }

    @Override
    public void login(UsersAccountInfo info) {
        mModel.setUsersAccountInfo(info);
        getUsersAccountInfo();
    }
}
