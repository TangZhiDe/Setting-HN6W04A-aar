package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IWifiFunPresenter;
import com.adayo.component.settings.model.WifiModel;

/**
 * Created by Administrator on 2018/12/13 0013.
 */

public class WifiFPresenter extends SettingsBaseFPersenter<WifiModel> implements IWifiFunPresenter{


    public WifiFPresenter(Context context) {
        super(context);
        mModel = WifiModel.getWifiModelInstance(context);
    }

    @Override
    public void wifiopen() {
        //与model交互

    }

    @Override
    public void wificlose() {
        //与model交互
    }
}
