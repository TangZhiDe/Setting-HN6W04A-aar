package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IDiagnosticCodeFuncPresenter;
import com.adayo.component.settings.model.DiagnosticCodeModel;

/**
 * @author damanz
 * @className DiagnosticCodeFPresent
 * @date 2018-09-19.
 */
public class DiagnosticCodeFPresent extends SettingsBaseFPersenter<DiagnosticCodeModel> implements IDiagnosticCodeFuncPresenter {

    public DiagnosticCodeFPresent(Context context) {
        super(context);
        mModel=DiagnosticCodeModel.getDiagnosticCodeModelInstance(mContext);
    }
}
