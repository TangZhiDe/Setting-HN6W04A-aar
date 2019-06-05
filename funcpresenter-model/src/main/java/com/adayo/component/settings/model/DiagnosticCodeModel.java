package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className DiagnosticCodeModel
 * @date 2018-09-07.
 */
public class DiagnosticCodeModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + DiagnosticCodeModel.class.getSimpleName();
    private static DiagnosticCodeModel mModel = null;
    private Context mContext;

    private DiagnosticCodeModel(Context context) {
        this.mContext = context;
    }

    public static DiagnosticCodeModel getDiagnosticCodeModelInstance(Context context) {
        if (mModel == null) {
            synchronized (DiagnosticCodeModel.class) {
                if (mModel == null) {
                    mModel = new DiagnosticCodeModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }
}
