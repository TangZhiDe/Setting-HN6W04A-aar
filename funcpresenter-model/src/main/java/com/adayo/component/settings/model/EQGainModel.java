package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className EQGainModel
 * @date 2018-09-07.
 */
public class EQGainModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + EQGainModel.class.getSimpleName();
    private static EQGainModel mModel = null;
    private Context mContext;

    private EQGainModel(Context context) {
        this.mContext = context;
    }

    public static EQGainModel getEQGainModelInstance(Context context) {
        if (mModel == null) {
            synchronized (EQGainModel.class) {
                if (mModel == null) {
                    mModel = new EQGainModel(context);
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
