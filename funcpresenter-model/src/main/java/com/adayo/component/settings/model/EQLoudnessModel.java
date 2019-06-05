package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className EQLoudnessModel
 * @date 2018-09-07.
 */
public class EQLoudnessModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + EQLoudnessModel.class.getSimpleName();
    private static EQLoudnessModel mModel = null;
    private Context mContext;

    private EQLoudnessModel(Context context) {
        this.mContext = context;
    }

    public static EQLoudnessModel getEQLoudnessModelInstance(Context context) {
        if (mModel == null) {
            synchronized (EQLoudnessModel.class) {
                if (mModel == null) {
                    mModel = new EQLoudnessModel(context);
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
