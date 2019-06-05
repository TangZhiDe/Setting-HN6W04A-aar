package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcelable;

import com.adayo.component.settings.bfpcontract.ITrafficDataFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.TrafficDataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damanz
 * @className TrafficDataFPresent
 * @date 2018-09-19.
 */
public class TrafficDataFPresent extends SettingsBaseFPersenter<TrafficDataModel> implements ITrafficDataFuncPresenter {

    public TrafficDataFPresent(Context context) {
        super(context);
        mModel=TrafficDataModel.getTrafficDataModelInstance(mContext);
    }

    @Override
    public void getAppList() {
        List<PackageInfo> appList = mModel.getAppList();
        //Intent intent = new Intent();
        //Bundle b = new Bundle();
       // b.putParcelableArrayList(FPConstant.EXTRA_APP_LIST, (ArrayList<? extends Parcelable>) appList);
       // intent.putExtras(b);
      //  sendMessage(FPConstant.APP_LIST_HANDLER_ID, intent);
    }

    @Override
    public void getAppTrafficData(PackageInfo info) {
        long trafficData = mModel.getAppTrafficData(info);
       // Intent intent=new Intent();
       // intent.putExtra(FPConstant.EXTRA_TRAFFIC_DATA,trafficData);
       // sendMessage(FPConstant.TRAFFIC_DATA_HANDLER_ID,intent);
    }
}
