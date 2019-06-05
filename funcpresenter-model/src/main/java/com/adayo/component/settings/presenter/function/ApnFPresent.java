package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IApnFuncPresenter;
import com.adayo.component.settings.model.ApnModel;

/**
 * @author damanz
 * @className ApnFPresent
 * @date 2018-09-07.
 */
public class ApnFPresent extends SettingsBaseFPersenter<ApnModel> implements IApnFuncPresenter{

    public ApnFPresent(Context context) {
        super(context);
        mModel=ApnModel.getApnModelInstance(mContext);
    }
}
