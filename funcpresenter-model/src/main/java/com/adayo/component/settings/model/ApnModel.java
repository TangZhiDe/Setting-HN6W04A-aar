package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className ApnModel
 * @date 2018-09-07.
 */
public class ApnModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + ApnModel.class.getSimpleName();
    private static ApnModel mModel = null;
    private Context mContext;

    private ApnModel(Context context) {
        this.mContext = context;
    }

    public static ApnModel getApnModelInstance(Context context) {
        if (mModel == null) {
            synchronized (ApnModel.class) {
                if (mModel == null) {
                    mModel = new ApnModel(context);
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
