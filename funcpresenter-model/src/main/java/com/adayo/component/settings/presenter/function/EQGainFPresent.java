package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IEQGainFuncPresenter;
import com.adayo.component.settings.model.EQGainModel;

/**
 * @author damanz
 * @className EQGainFPresent
 * @date 2018-09-19.
 */
public class EQGainFPresent extends SettingsBaseFPersenter<EQGainModel> implements IEQGainFuncPresenter {

    public EQGainFPresent(Context context) {
        super(context);
        mModel=EQGainModel.getEQGainModelInstance(mContext);
    }
}
