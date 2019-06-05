package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IGainContorlFuncPresenter;
import com.adayo.component.settings.model.GainContorlModel;

/**
 * @author damanz
 * @className GainContorlFPresent
 * @date 2018-09-19.
 */
public class GainContorlFPresent extends SettingsBaseFPersenter<GainContorlModel> implements IGainContorlFuncPresenter {

    public GainContorlFPresent(Context context) {
        super(context);
        mModel=GainContorlModel.getGainContorlModelInstance(mContext);
    }
}
