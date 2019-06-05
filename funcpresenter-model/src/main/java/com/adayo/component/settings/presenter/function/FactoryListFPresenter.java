package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IFactoryListFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.FactoryListModel;
import com.adayo.component.settings.model.bean.FactoryListBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author damanz
 * @className FactoryListFPresenter
 * @date 2018-09-11.
 */
public class FactoryListFPresenter extends SettingsBaseFPersenter<FactoryListModel> implements IFactoryListFuncPresenter {

    public FactoryListFPresenter(Context context) {
        super(context);
        mModel = FactoryListModel.getFactoryListModelInstance(mContext);
    }

    @Override
    public void getSoftwareVersion() {
        List<FactoryListBean> softwareVersion = mModel.getSoftwareVersion();
        sendListMassage((Serializable) softwareVersion);
    }

    @Override
    public void getAppVersion() {
        List<FactoryListBean> appVersion = mModel.getAppVersion();
        sendListMassage((Serializable) appVersion);
    }

    private void sendListMassage(Serializable list) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(FPConstant.EXTRA_FACTORY_LIST, list);
        sendMessage(FPConstant.FACTORY_LIST_HANDLER_ID, bundle);
    }

    @Override
    public void getDiagnosticCode() {
        mModel.getDiagnosticCode();
    }

    @Override
    public void getHiddenApplication() {
        sendListMassage((Serializable) mModel.getHiddenApplication());
    }
}
