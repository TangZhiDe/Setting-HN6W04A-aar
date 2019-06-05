package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.adayo.component.settings.bfpcontract.ISoundFieldFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.SoundFieldModel;

/**
 * @author damanz
 * @className SoundFieldFPresenter
 * @date 2018-09-05.
 */
public class SoundFieldFPresenter extends SettingsBaseFPersenter<SoundFieldModel> implements ISoundFieldFuncPresenter {

    public SoundFieldFPresenter(Context context) {
        super(context);
        mModel = SoundFieldModel.getSoundFieldModelInstance(mContext);
    }

    @Override
    public void setFaderBalance(int x, int y) {
        mModel.setFaderBalance(x, y);
        getFaderBalance();
    }

    @Override
    public void getFaderBalance() {
        Log.d(TAG, "getFaderBalance: ");
        int[] faderBalance = mModel.getFaderBalance();
        Bundle bundle = new Bundle();
        bundle.putIntArray(FPConstant.EXTRA_SOUND_FIELD, faderBalance);
        sendMessage(FPConstant.SOUND_FIELD_HANDLER_ID, bundle);
    }
}
