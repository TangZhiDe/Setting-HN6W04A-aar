package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;

/**
 * @author damanz
 * @className DeveloperOptionsModel
 * @date 2018-09-11.
 */
public class DeveloperOptionsModel extends BaseModel  {
    public static final String TAG = FPConstant.TAG + ApnModel.class.getSimpleName();
    private static DeveloperOptionsModel mModel = null;
    private Context mContext;

    private DeveloperOptionsModel(Context context) {
        this.mContext = context;
    }

    public static DeveloperOptionsModel getDeveloperOptionsModelInstance(Context context) {
        if (mModel == null) {
            synchronized (DeveloperOptionsModel.class) {
                if (mModel == null) {
                    mModel = new DeveloperOptionsModel(context);
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
