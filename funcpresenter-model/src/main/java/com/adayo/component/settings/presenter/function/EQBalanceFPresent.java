package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IEQBalanceFuncPresenter;
import com.adayo.component.settings.model.EQBalanceModel;

/**
 * @author damanz
 * @className EQBalanceFPresent
 * @date 2018-09-19.
 */
public class EQBalanceFPresent extends SettingsBaseFPersenter<EQBalanceModel> implements IEQBalanceFuncPresenter {

    public EQBalanceFPresent(Context context) {
        super(context);
        mModel=EQBalanceModel.getEQBalanceModelInstance(mContext);
    }
}
