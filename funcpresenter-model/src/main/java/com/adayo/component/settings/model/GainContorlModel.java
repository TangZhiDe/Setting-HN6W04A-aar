package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className GainContorlModel
 * @date 2018-09-07.
 */
public class GainContorlModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + GainContorlModel.class.getSimpleName();
    private static GainContorlModel mModel = null;
    private Context mContext;

    private GainContorlModel(Context context) {
        this.mContext = context;
    }

    public static GainContorlModel getGainContorlModelInstance(Context context) {
        if (mModel == null) {
            synchronized (GainContorlModel.class) {
                if (mModel == null) {
                    mModel = new GainContorlModel(context);
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
