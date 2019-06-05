package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IApnDataChangedFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.ApnDataChangedModel;
import com.adayo.component.settings.model.bean.Apn;

/**
 * @author damanz
 * @className ApnDataChangedFPresent
 * @date 2018-09-19.
 */
public class ApnDataChangedFPresent extends SettingsBaseFPersenter<ApnDataChangedModel> implements IApnDataChangedFuncPresenter {

    public ApnDataChangedFPresent(Context context) {
        super(context);
        mModel=ApnDataChangedModel.getApnDataChangedModelInstance(mContext);
    }

    @Override
    public void getApnData(String id) {
        Apn apnData = mModel.getApnData(id);
        Bundle bundle = new Bundle();
        bundle.putParcelable(FPConstant.EXTRA_APN_DATA,apnData);
        sendMessage(FPConstant.APN_DATA_HANDLER_ID,bundle);
    }

    @Override
    public void addApn(Apn apn) {
        mModel.addApn(apn);
    }
}
