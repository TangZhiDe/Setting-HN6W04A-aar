/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className IMainBFPContract
 * @date 2018-07-26.
 */
public interface IDateTimeFuncPresenter {

        void updateDateTime(int year, int month, int day, int hour, int minute);

        void setTimeType(boolean isHour24);

        void getTimeType();

        void setSumerTimeSwitch(boolean state);

        void getSumerTimeSwitch();

        void setDateType(int mode);

        void getDateType();

        void getTimeZone();

        void setTimeZone(int itemMode);

        void getShutdownShow();

        void setShutdownShow(boolean state);

        void setAutoTimeType(int type, boolean switchButtonState);

        void getAutoTimeState();
}
