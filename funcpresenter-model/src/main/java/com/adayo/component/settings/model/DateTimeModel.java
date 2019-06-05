/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.model;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.Log;

import com.adayo.component.settings.constant.EnumConstant;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

/**
 * @author damanz
 * @className SettingsMainModel
 * @date 2018-07-26.
 */
public class DateTimeModel extends BaseModel {
    public static final String TAG = "DateTimeModel";
    private static DateTimeModel mModel = null;
    private Context mContext;
     private AlarmManager mAlarmManager;

    private DateTimeModel(Context context) {
        this.mContext = context;
    }

    public static DateTimeModel getDateTimeModelInstance(Context context) {
        if (mModel == null) {
            synchronized (DateTimeModel.class) {
                if (mModel == null) {
                    mModel = new DateTimeModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
         mAlarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
    }

    /**
     * 设置时间日期
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @return
     */
    public boolean updateDateTime(int year, int month, int day, int hour, int minute) {
        Log.d(TAG, "updateDateTime: " + year + "-" + month + "-" + day + " " + hour + ":" + minute);
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, year);
//        c.set(Calendar.MONTH, month - 1);
//        c.set(Calendar.DAY_OF_MONTH, day);
//        c.set(Calendar.HOUR_OF_DAY, hour);
//        c.set(Calendar.MINUTE, minute);
//        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND, 0);
//        long when = Math.max(c.getTimeInMillis(), FPConstant.MIN_DATE);
//
//        try {
//            if (when / 1000 < Integer.MAX_VALUE) {
//                mAlarmManager.setTime(when);
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
        String[] date = new String[6];
        date[0] = String.valueOf(year);
        date[1] = String.valueOf(month);
        date[2] = String.valueOf(day);
        date[3] = String.valueOf(hour);
        date[4] = String.valueOf(minute);
        date[5] = String.valueOf(0);
        int i = mSettingsManager.doFunc_UpdateDateTime(mContext, SettingsContantsDef.MODE_SET, date, FPConstant.emptyArr);
        return i == SettingsContantsDef.RET_OK;
    }

    /**
     * 获取当前时间制式
     */
    public boolean getTimeType() {
        return DateFormat.is24HourFormat(mContext);
    }

    public void setTimeType(boolean is24Hour) {
        Intent timeChanged = new Intent(Intent.ACTION_TIME_CHANGED);
        int timeFormatPreference =
                is24Hour ? FPConstant.EXTRA_TIME_PREF_VALUE_USE_24_HOUR
                        : FPConstant.EXTRA_TIME_PREF_VALUE_USE_12_HOUR;
        timeChanged.putExtra(FPConstant.EXTRA_TIME_PREF_24_HOUR_FORMAT, timeFormatPreference);
        mContext.sendBroadcast(timeChanged);
        Settings.System.putString(mContext.getContentResolver(),
                Settings.System.TIME_12_24,
                is24Hour ? FPConstant.HOURS_24 : FPConstant.HOURS_12);
    }

    public boolean getSumerTimeSwitch() {
        String[] out = getDefultString();
        mSettingsManager.doDb_SummerTimeSwitch(mContext,SettingsContantsDef.MODE_GET,FPConstant.emptyArr,out);
        return formatBooleanData(out[0],false);
    }

    public void setSumerTimeSwitch(boolean state) {
        mSettingsManager.doDb_SummerTimeSwitch(mContext,SettingsContantsDef.MODE_SET,
                getBoolenString(state),FPConstant.emptyArr);
    }

    public void setDateType(int mode) {
        Log.d(TAG, "setDateType: mode "+mode);
        String value = EnumConstant.DATE_DISPLAY.getStringValue(mode);
        mSettingsManager.doDb_DateMode(mContext,SettingsContantsDef.MODE_SET,
                new String[]{value},FPConstant.emptyArr);
    }

    public int getDateType() {
        String[] out = getDefultString();
        mSettingsManager.doDb_DateMode(mContext,SettingsContantsDef.MODE_GET,FPConstant.emptyArr,out);
        Log.d(TAG, "getDateType: " + out[0]);
        return EnumConstant.DATE_DISPLAY.getIntValue(out[0]);
    }

    public int getTimeZone() {
        String[] out = getDefultString();
        mSettingsManager.doDb_TimeZone(mContext,SettingsContantsDef.MODE_GET,FPConstant.emptyArr,out);
        Log.d(TAG, "getTimeZone: "+out[0]);
        String displayName = EnumConstant.TIME_ZONE.getDisplayName(out[0]);
        Log.d(TAG, "getTimeZone: displayName  "+displayName);
        return EnumConstant.TIME_ZONE.getIntValue(displayName);
    }

    public void setTimeZone(int itemMode) {
        String zoneValue = EnumConstant.TIME_ZONE.getZoneValue(itemMode);
        Log.d(TAG, "setTimeZone: "+ zoneValue);
        mSettingsManager.doDb_TimeZone(mContext,SettingsContantsDef.MODE_SET,
               new String[]{zoneValue},FPConstant.emptyArr);
    }

    public void setShutdownShow(boolean state) {
        mSettingsManager.doDb_AccOffClockSwitch(mContext,SettingsContantsDef.MODE_SET,
               getBoolenString(state), FPConstant.emptyArr);
    }


    public boolean getShutdownShow() {
        String[] out = getDefultString();
        mSettingsManager.doDb_AccOffClockSwitch(mContext,SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr,out);
        return formatBooleanData(out[0],true);
    }

    public void setAutoTimeType(int type, boolean state) {
        if (type == 1) {
            Log.d(TAG, "setAutoTimeType: state = "+state);
            mSettingsManager.doDb_AutoSyncTimeGps(mContext, SettingsContantsDef.MODE_SET,
                    getBoolenString(state), FPConstant.emptyArr);
            if (state) {
                mSettingsManager.doDb_AutoSyncTimeNetWork(mContext, SettingsContantsDef.MODE_SET,
                        getBoolenString(false), FPConstant.emptyArr);
            }
        } else if (type == 2) {
            Log.d(TAG, "setAutoTimeType: state = "+state);
            mSettingsManager.doDb_AutoSyncTimeNetWork(mContext, SettingsContantsDef.MODE_SET,
                    getBoolenString(state), FPConstant.emptyArr);
            if (state) {
                mSettingsManager.doDb_AutoSyncTimeGps(mContext, SettingsContantsDef.MODE_SET,
                        getBoolenString(false), FPConstant.emptyArr);
            }
        }
    }

    public boolean getGpsAutoTimeState() {
        Log.d(TAG, "getGpsAutoTimeState: ====");
        String[] out = getDefultString();
        mSettingsManager.doDb_AutoSyncTimeGps(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out);
        return formatBooleanData(out[0], false);
    }

    public boolean getNetAutoTimeState() {
        String[] out = getDefultString();
        mSettingsManager.doDb_AutoSyncTimeNetWork(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out);
        return formatBooleanData(out[0], false);
    }
}
