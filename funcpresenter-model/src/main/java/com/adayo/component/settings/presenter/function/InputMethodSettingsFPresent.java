package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.inputmethod.InputMethodInfo;

import com.adayo.component.settings.bfpcontract.IInputMethodSettingsFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.InputMethodSettingsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damanz
 * @className InputMethodSettingsFPresent
 * @date 2018-09-19.
 */
public class InputMethodSettingsFPresent extends SettingsBaseFPersenter<InputMethodSettingsModel> implements IInputMethodSettingsFuncPresenter {

    public InputMethodSettingsFPresent(Context context) {
        super(context);
        mModel=InputMethodSettingsModel.getInputMethodSettingsModelInstance(mContext);
    }

    @Override
    public void getInputMethod() {
        List<InputMethodInfo> inputMethod = mModel.getInputMethod();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FPConstant.EXTRA_INPUT_METHOD, (ArrayList<? extends Parcelable>) inputMethod);
        sendMessage(FPConstant.INPUT_METHOD_HANDLER_ID,bundle);
    }

    @Override
    public void setDisableTouchTone(boolean state) {
        mModel.setDisableTouchTone(state);
        getDisableTouchTone();
    }

    @Override
    public void getDisableTouchTone() {
        boolean state = mModel.getDisableTouchTone();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_DISABLE_TOUCH_TONE,state);
        sendMessage(FPConstant.DISABLE_TOUCH_TONE_HANDLER_ID,bundle);
    }
}
