package com.adayo.component.settings.bfpcontract;

import com.adayo.component.settings.model.bean.UsersAccountInfo;

/**
 * @author damanz
 * @className IAccountSettingFuncPresenter
 * @date 2018-09-19.
 */
public interface IAccountSettingFuncPresenter {
    void getUsersAccountInfo();

    void exitLogin();

    void login(UsersAccountInfo info);
}
