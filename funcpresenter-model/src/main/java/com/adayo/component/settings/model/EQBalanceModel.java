package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className EQBalanceModel
 * @date 2018-09-07.
 */
public class EQBalanceModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + EQBalanceModel.class.getSimpleName();
    private static EQBalanceModel mModel = null;
    private Context mContext;

    private EQBalanceModel(Context context) {
        this.mContext = context;
    }

    public static EQBalanceModel getEQBalanceModelInstance(Context context) {
        if (mModel == null) {
            synchronized (EQBalanceModel.class) {
                if (mModel == null) {
                    mModel = new EQBalanceModel(context);
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
