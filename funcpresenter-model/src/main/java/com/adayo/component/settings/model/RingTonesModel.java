package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className RingTonesModel
 * @date 2018-09-07.
 */
public class RingTonesModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + RingTonesModel.class.getSimpleName();
    private static RingTonesModel mModel = null;
    private Context mContext;

    private RingTonesModel(Context context) {
        this.mContext = context;
    }

    public static RingTonesModel getRingTonesModelInstance(Context context) {
        if (mModel == null) {
            synchronized (RingTonesModel.class) {
                if (mModel == null) {
                    mModel = new RingTonesModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {

    }
}
