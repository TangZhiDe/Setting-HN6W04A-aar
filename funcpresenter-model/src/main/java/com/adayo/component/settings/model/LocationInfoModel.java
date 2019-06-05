package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.EnumConstant;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.utils.SPUtils;

/**
 * @author damanz
 * @className LocationInfoModel
 * @date 2018-09-07.
 */
public class LocationInfoModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + LocationInfoModel.class.getSimpleName();
    private static LocationInfoModel mModel = null;
    private Context mContext;

    private LocationInfoModel(Context context) {
        this.mContext = context;
    }

    public static LocationInfoModel getLocationInfoModelInstance(Context context) {
        if (mModel == null) {
            synchronized (LocationInfoModel.class) {
                if (mModel == null) {
                    mModel = new LocationInfoModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();

    }

    public void setLocationType(int itemMode) {
        SPUtils.put(mContext, FPConstant.EXTRA_GPS_LOCATION,itemMode);
    }

    public int getGpsLocationType() {
        return SPUtils.getInt(mContext, FPConstant.EXTRA_GPS_LOCATION, EnumConstant.LOCATION_TYPE.HIGHT.getValue());
    }

    public boolean getGpsServiceState() {
        return SPUtils.getBoolean(mContext, FPConstant.EXTRA_GPS_SERVICE, true);
    }

    public void setGpsServiceState(boolean state) {
        SPUtils.put(mContext, FPConstant.EXTRA_GPS_SERVICE,state);
    }
}
