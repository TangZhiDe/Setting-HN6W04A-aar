package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IVolumeCurveFuncPresenter;
import com.adayo.component.settings.model.VolumeCurveModel;

/**
 * @author damanz
 * @className VolumeCurveFPresent
 * @date 2018-09-19.
 */
public class VolumeCurveFPresent extends SettingsBaseFPersenter<VolumeCurveModel> implements IVolumeCurveFuncPresenter {

    public VolumeCurveFPresent(Context context) {
        super(context);
        mModel=VolumeCurveModel.getVolumeCurveModelInstance(mContext);
    }
}
