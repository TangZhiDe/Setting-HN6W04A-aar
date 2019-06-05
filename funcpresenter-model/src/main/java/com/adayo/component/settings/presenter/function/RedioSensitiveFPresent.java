package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IRedioSensitiveFuncPresenter;
import com.adayo.component.settings.model.RedioSensitiveModel;

/**
 * @author damanz
 * @className RedioSensitiveFPresent
 * @date 2018-09-19.
 */
public class RedioSensitiveFPresent extends SettingsBaseFPersenter<RedioSensitiveModel> implements IRedioSensitiveFuncPresenter {

    public RedioSensitiveFPresent(Context context) {
        super(context);
        mModel = RedioSensitiveModel.getRedioSensitiveModelInstance(mContext);
        mModel.setHandler(mHandler);
    }

    @Override
    public void getRedioSensitive() {
        mModel.getRedioSensitive();
    }

    @Override
    public void setRedioSensitive(int fm_loc_value, int fm_disc_value, int am_loc_value, int am_disc_value) {
        mModel.setRedioSensitive(fm_loc_value, fm_disc_value, am_loc_value, am_disc_value);
        getRedioSensitive();
    }
}
