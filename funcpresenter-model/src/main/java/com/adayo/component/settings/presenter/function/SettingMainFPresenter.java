/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.ISettingsMainFuncPresenter;
import com.adayo.component.settings.model.SettingsMainModel;

/**
 * @author damanz
 * @className SettingMainFPresenter
 * @date 2018-07-26.
 */
public class SettingMainFPresenter extends SettingsBaseFPersenter<SettingsMainModel> implements ISettingsMainFuncPresenter {

    public SettingMainFPresenter(Context context) {
        super(context);
        mModel = SettingsMainModel.getMainModelInstance(context);
    }
}
