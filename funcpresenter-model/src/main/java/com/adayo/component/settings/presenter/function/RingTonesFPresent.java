package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IRingTonesFuncPresenter;
import com.adayo.component.settings.model.RingTonesModel;

/**
 * @author damanz
 * @className RingTonesFPresent
 * @date 2018-09-19.
 */
public class RingTonesFPresent extends SettingsBaseFPersenter<RingTonesModel> implements IRingTonesFuncPresenter {

    public RingTonesFPresent(Context context) {
        super(context);
        mModel=RingTonesModel.getRingTonesModelInstance(mContext);
    }
}
