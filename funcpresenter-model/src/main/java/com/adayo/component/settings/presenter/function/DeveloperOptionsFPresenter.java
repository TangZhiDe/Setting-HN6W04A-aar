package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IDeveloperOptionsFuncPresenter;
import com.adayo.component.settings.model.DeveloperOptionsModel;

/**
 * @author damanz
 * @className DeveloperOptionsFPresenter
 * @date 2018-09-11.
 */
public class DeveloperOptionsFPresenter extends SettingsBaseFPersenter<DeveloperOptionsModel> implements IDeveloperOptionsFuncPresenter {

    public DeveloperOptionsFPresenter(Context context) {
        super(context);
        mModel=DeveloperOptionsModel.getDeveloperOptionsModelInstance(mContext);
    }
}
