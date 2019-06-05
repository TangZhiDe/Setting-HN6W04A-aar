package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcelable;

import com.adayo.component.settings.bfpcontract.IApplicationListFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.ApplicationListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damanz
 * @className ApplicationListFPresent
 * @date 2018-09-19.
 */
public class ApplicationListFPresent extends SettingsBaseFPersenter<ApplicationListModel> implements IApplicationListFuncPresenter {

    public ApplicationListFPresent(Context context) {
        super(context);
        mModel = ApplicationListModel.getApplicationListModelInstance(mContext);
    }

    @Override
    public void getAppList() {
        List<PackageInfo> appList = mModel.getAppList();
        Bundle b = new Bundle();
        b.putParcelableArrayList(FPConstant.EXTRA_APP_LIST, (ArrayList<? extends Parcelable>) appList);
        sendMessage(FPConstant.APP_LIST_HANDLER_ID, b);
    }

    @Override
    public void cleanCache(PackageInfo info) {
        mModel.cleanCache(info);
    }

    @Override
    public void uninstall(PackageInfo info) {
        mModel.uninstall(info);
    }
}
