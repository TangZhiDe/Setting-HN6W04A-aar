/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.adayo.component.settings.bfpcontract.IDateTimeFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.DateTimeModel;

/**
 * @author damanz
 * @className DateTimeFPresenter
 * @date 2018-07-27.
 */
public class DateTimeFPresenter extends SettingsBaseFPersenter<DateTimeModel> implements IDateTimeFuncPresenter {

    public static final String TAG = "DateTimeFPresenter";

    public DateTimeFPresenter(Context context) {
        super(context);
        mModel = DateTimeModel.getDateTimeModelInstance(context);
    }

    @Override
    public void updateDateTime(int year, int month, int day, int hour, int minute) {
        boolean b = mModel.updateDateTime(year, month, day, hour, minute);
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_UPDATE_DATE_TIME, b);
        sendMessage(FPConstant.UPDATE_DATE_TIME_HANDLER_ID, bundle);
    }

    @Override
    public void getTimeType() {
        boolean timeType = mModel.getTimeType();
        Log.d(TAG, "isHour24: " + timeType);
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_TIME_TYPE_MODE, timeType);
        sendMessage(FPConstant.TIME_TYPE_MODE_HANDLER_ID, bundle);
    }

    @Override
    public void setTimeType(boolean is24Hour) {
        mModel.setTimeType(is24Hour);
        getTimeType();
    }

    @Override
    public void setSumerTimeSwitch(boolean state) {
        mModel.setSumerTimeSwitch(state);
        getSumerTimeSwitch();
    }

    @Override
    public void getSumerTimeSwitch() {
        boolean state = mModel.getSumerTimeSwitch();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_SUMER_TIME_SWITCH, state);
        sendMessage(FPConstant.SUMER_TIME_SWITCH_HANDLER_ID, bundle);
    }

    @Override
    public void setDateType(int mode) {
        mModel.setDateType(mode);
        getDateType();
    }

    @Override
    public void getDateType() {
        int dateType = mModel.getDateType();
        Log.d(TAG, "getDateType: dateType "+dateType);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_DATE_TYPE, dateType);
        sendMessage(FPConstant.DATE_TYPE_HANDLER_ID, bundle);
    }

    @Override
    public void getTimeZone() {
        int value = mModel.getTimeZone();
        Log.d(TAG, "getTimeZone: value  "+value);
        Bundle bundle = new Bundle();
        bundle.putInt(FPConstant.EXTRA_TIME_ZONE, value);
        sendMessage(FPConstant.TIME_ZONE_HANDLER_ID, bundle);
    }

    @Override
    public void setTimeZone(int itemMode) {
        mModel.setTimeZone(itemMode);
        getTimeZone();
    }

    @Override
    public void getShutdownShow() {
        Log.d(TAG, "getShutdownShow: ");
        boolean state = mModel.getShutdownShow();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_SHUTDOWN_SHOW, state);
        sendMessage(FPConstant.SHUTDOWN_SHOW_HANDLER_ID, bundle);
    }

    @Override
    public void setShutdownShow(boolean state) {
        mModel.setShutdownShow(state);
        getShutdownShow();
    }

    @Override
    public void setAutoTimeType(int type, boolean switchButtonState) {
        mModel.setAutoTimeType(type, switchButtonState);
        getAutoTimeState();
    }

    @Override
    public void getAutoTimeState() {
        boolean isOpenGps = mModel.getGpsAutoTimeState();
        boolean isOpenNet = mModel.getNetAutoTimeState();
        Log.d(TAG, "getAutoTimeState: isOpenGps = "+isOpenGps);
        Bundle bundle = new Bundle();
        bundle.putBoolean(FPConstant.EXTRA_AUTO_NET, isOpenNet);
        bundle.putBoolean(FPConstant.EXTRA_AUTO_GPS, isOpenGps);
        sendMessage(FPConstant.AUTO_TIME_HANDLER_ID, bundle);
    }
}
