package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IEQLoudnessFuncPresenter;
import com.adayo.component.settings.model.EQLoudnessModel;

/**
 * @author damanz
 * @className EQLoudnessFPresent
 * @date 2018-09-19.
 */
public class EQLoudnessFPresent extends SettingsBaseFPersenter<EQLoudnessModel> implements IEQLoudnessFuncPresenter {

    public EQLoudnessFPresent(Context context) {
        super(context);
        mModel=EQLoudnessModel.getEQLoudnessModelInstance(mContext);
    }
}
