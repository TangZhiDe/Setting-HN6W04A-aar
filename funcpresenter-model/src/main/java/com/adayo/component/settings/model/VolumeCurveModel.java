package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className VolumeCurveModel
 * @date 2018-09-07.
 */
public class VolumeCurveModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + VolumeCurveModel.class.getSimpleName();
    private static VolumeCurveModel mModel = null;
    private Context mContext;

    private VolumeCurveModel(Context context) {
        this.mContext = context;
    }

    public static VolumeCurveModel getVolumeCurveModelInstance(Context context) {
        if (mModel == null) {
            synchronized (VolumeCurveModel.class) {
                if (mModel == null) {
                    mModel = new VolumeCurveModel(context);
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
