package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.adayo.component.settings.bfpcontract.INetwork4GFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.Network4GModel;

/**
 * @author damanz
 * @className Network4GFPresenter
 * @date 2018-08-08.
 */
public class Network4GFPresenter extends SettingsBaseFPersenter<Network4GModel> implements INetwork4GFuncPresenter {

    public static final String TAG = FPConstant.TAG + Network4GFPresenter.class.getSimpleName();

    public Network4GFPresenter(Context context) {
        super(context);
        mModel = Network4GModel.getNetwork4GModelInstance(mContext);
    }

    @Override
    public void getMobileNetworkSwitch() {
        boolean state = mModel.getMobileNetworkSwitch();
        Log.d(TAG, "getMobileNetworkSwitch: " + state);
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_MOBILE_NETWORK_SWITCH, state);
        sendMessage(FPConstant.MOBILE_NETWORK_SWITCH_HANDLER_ID, bundle);
    }

    @Override
    public void setMobileNetworkSwitch(boolean state) {
        mModel.setMobileNetworkSwitch(state);
        getMobileNetworkSwitch();
    }

    @Override
    public void setDataRoamingSwitch(boolean state) {
        mModel.setDataRoamingSwitch(state);
        getDataRoamingSwitch();
    }

    @Override
    public void getDataRoamingSwitch() {
        boolean dataRoamingSwitch = mModel.getDataRoamingSwitch();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_DATA_ROAMING,dataRoamingSwitch);
        sendMessage(FPConstant.DATA_ROAMING_HANDLER_ID, bundle);
    }

    @Override
    public void getNetworkOperator() {
        String operator = mModel.getNetworkOperator();
        Bundle bundle = new Bundle();
        bundle.putString(FPConstant.EXTRA_NETWORK_OPERATOR,operator);
        sendMessage(FPConstant.NETWORK_OPERATOR_HANDLER_ID, bundle);
    }
}
