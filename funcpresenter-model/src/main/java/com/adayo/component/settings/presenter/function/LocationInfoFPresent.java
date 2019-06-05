package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.content.Intent;

import com.adayo.component.settings.bfpcontract.ILocationInfoFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.LocationInfoModel;

/**
 * @author damanz
 * @className LocationInfoFPresent
 * @date 2018-09-19.
 */
public class LocationInfoFPresent extends SettingsBaseFPersenter<LocationInfoModel> implements ILocationInfoFuncPresenter {

    public LocationInfoFPresent(Context context) {
        super(context);
        mModel=LocationInfoModel.getLocationInfoModelInstance(mContext);
    }

    @Override
    public void setLocationType(int itemMode) {
        mModel.setLocationType(itemMode);
        getGpsLocationType();
    }

    @Override
    public void getGpsLocationType() {
        int type = mModel.getGpsLocationType();
        Intent intent = new Intent();
        intent.putExtra(FPConstant.EXTRA_GPS_LOCATION,type);
        //sendMessage(FPConstant.GPS_LOCATION_HANDLER_ID,intent);
    }

    @Override
    public void getGpsServiceState() {
        boolean state = mModel.getGpsServiceState();
        Intent intent = new Intent();
        intent.putExtra(FPConstant.EXTRA_GPS_SERVICE,state);
       // sendMessage(FPConstant.GPS_SERVICE_HANDLER_ID,intent);
    }

    @Override
    public void setGpsServiceState(boolean state) {
        mModel.setGpsServiceState(state);
        getGpsServiceState();
    }
}
