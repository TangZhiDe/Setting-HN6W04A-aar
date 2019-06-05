/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.constant;

import com.adayo.proxy.audio.constants.AudioDspConstantsDef;

import java.util.Locale;

/**
 * @author damanz
 * @className EnumConstant  枚举常量
 * @date 2018-07-26.
 */
public final class EnumConstant {

    private EnumConstant() {
    }

    /**
     * 导航混音
     * 默认混音
     */
    public enum NAIGATION_BROADCAST {
        MIXING(1, "混音"),
        BRING_DOWN(2, "压低"),
        MUTE(3, "静音");

        private int value;
        private String name;

        NAIGATION_BROADCAST(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (NAIGATION_BROADCAST info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return MIXING.getName();
        }

        public static int getIntValue(String value) {
            for (NAIGATION_BROADCAST info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return MIXING.getValue();
        }
    }


    /**
     * 速度补偿
     * 默认关闭
     */
    public enum SPEED_COM_VOLUME {
        CLOSE(1, "关闭"),
        LOW(2, "低"),
        MIDDLE(3, "中"),
        HIGH(4, "高");

        private int value;
        private String name;

        SPEED_COM_VOLUME(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (SPEED_COM_VOLUME info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return CLOSE.getName();
        }

        public static int getIntValue(String value) {
            for (SPEED_COM_VOLUME info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return CLOSE.getValue();
        }
    }

    /**
     * 系统语言
     * 默认中文
     */
    public enum SYSTEM_LANGUAGE {
        CHINESE(1, Locale.SIMPLIFIED_CHINESE, "简体中文"),
        ENGLISH(2, Locale.ENGLISH, "English");

        private Locale locale;
        private String name;
        private int value;

        SYSTEM_LANGUAGE(int value, Locale locale, String name) {
            this.value = value;
            this.name = name;
            this.locale = locale;
        }

        public Locale getLocale() {
            return locale;
        }

        public void setLocale(Locale locale) {
            this.locale = locale;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public static String getStringValue(int value) {
            for (SYSTEM_LANGUAGE info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return CHINESE.getName();
        }

        public static Locale getLocaleValue(int value) {
            for (SYSTEM_LANGUAGE info : values()) {
                if (info.getValue() == value) {
                    return info.getLocale();
                }
            }
            return CHINESE.getLocale();
        }

        public static int getIntValue(String value) {
            for (SYSTEM_LANGUAGE info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return CHINESE.getValue();
        }

        public static int getIntValue(Locale locale) {
            for (SYSTEM_LANGUAGE info : values()) {
                if (info.getLocale().getLanguage().equals(locale.getLanguage())) {
                    return info.getValue();
                }
            }
            return CHINESE.getValue();
        }
    }

    /**
     * 待机时钟显示
     * 默认数字时钟
     */
    public enum STANDBY_DISPLAY {
        DIGITAL_CLOCK(1, "数字时钟"),
        ANALOG_CLOCK(2, "模拟时钟"),
        BLACK_SCREEN(3, "黑屏");

        private int value;
        private String name;

        STANDBY_DISPLAY(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (STANDBY_DISPLAY info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return DIGITAL_CLOCK.getName();
        }

        public static int getIntValue(String value) {
            for (STANDBY_DISPLAY info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return DIGITAL_CLOCK.getValue();
        }
    }


    /**
     * 时间制式
     * 默认12小时制
     */
    public enum TIME_DISPLAY {
        TWELVE_DISPLAY(1, "12小时制"),
        TWENTY_FOUR_DISPLAY(2, "24小时制");

        private int value;
        private String name;

        TIME_DISPLAY(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (TIME_DISPLAY info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return TWELVE_DISPLAY.getName();
        }

        public static int getIntValue(String value) {
            for (TIME_DISPLAY info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return TWELVE_DISPLAY.getValue();
        }
    }

    /**
     * 时区
     * 默认中国
     */
    public enum TIME_ZONE {
        CHINA(1, "PRC", "中国+8", "GMT+08:00"),
        JAPAN(2, "Japan", "日本+6", "GMT+07:00"),
        AMERICA(3, "US/Alaska", "美国-9", "GMT-09:00");

        private int value;
        private String zoneId;
        private String name;
        private String displayName;

        TIME_ZONE(int value, String zoneId, String name, String displayName) {
            this.value = value;
            this.name = name;
            this.zoneId = zoneId;
            this.displayName = displayName;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getZoneId() {
            return zoneId;
        }

        public void setZoneId(String zoneId) {
            this.zoneId = zoneId;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public static String getStringValue(int value) {
            for (TIME_ZONE info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return CHINA.getName();
        }

        public static int getIntValue(String displayName) {
            for (TIME_ZONE info : values()) {
                if (info.getDisplayName().equals(displayName)) {
                    return info.getValue();
                }
            }
            return CHINA.getValue();
        }

        public static String getZoneValue(int value) {
            for (TIME_ZONE info : values()) {
                if (info.getValue() == value) {
                    return info.getZoneId();
                }
            }
            return CHINA.getZoneId();
        }

        public static String getZoneValue(String value) {
            for (TIME_ZONE info : values()) {
                if (info.getName().equals(value)) {
                    return info.getZoneId();
                }
            }
            return CHINA.getZoneId();
        }

        public static String getDisplayName(int value) {
            for (TIME_ZONE info : values()) {
                if (info.getValue() == value) {
                    return info.getDisplayName();
                }
            }
            return CHINA.getDisplayName();
        }

        public static String getDisplayName(String zoneId) {
            for (TIME_ZONE info : values()) {
                if (info.getZoneId().equals(zoneId)) {
                    return info.getDisplayName();
                }
            }
            return CHINA.getDisplayName();
        }
    }


    /**
     * 日期制式
     * 默认YY/MM/DD
     */
    public enum DATE_DISPLAY {
        DATE_DISPLAY_YMD(1, "yyyy/MM/dd"),
        DATE_DISPLAY_MDY(2, "MM/dd/yyyy");

        private int value;
        private String name;

        DATE_DISPLAY(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (DATE_DISPLAY info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return DATE_DISPLAY_YMD.getName();
        }

        public static int getIntValue(String value) {
            for (DATE_DISPLAY info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return DATE_DISPLAY_YMD.getValue();
        }
    }


    /**
     * 音效模式
     * 默认标准
     */
    public enum SOUND_EFFECT_PATTERN {
        STANDARD(0, AudioDspConstantsDef.EQ_TYPE.flat.mIndex, "标准"),
        POPULAR(1, AudioDspConstantsDef.EQ_TYPE.pop.mIndex, "流行"),
        ROCK_ROLL(2,AudioDspConstantsDef.EQ_TYPE.rock.mIndex, "摇滚"),
        JAZZ(3, AudioDspConstantsDef.EQ_TYPE.jazz.mIndex, "爵士"),
        CLASSICAL(4, AudioDspConstantsDef.EQ_TYPE.classic.mIndex, "古典"),
        STRIKE(5, AudioDspConstantsDef.EQ_TYPE.techno.mIndex, "打击"),
        CUSTOM(6, AudioDspConstantsDef.EQ_TYPE.user.mIndex, "自定义");

        private int index;
        private int value;
        private String name;

        SOUND_EFFECT_PATTERN(int index, int value, String name) {
            this.index = index;
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static String getStringValue(int value) {
            for (SOUND_EFFECT_PATTERN info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return STANDARD.getName();
        }

        public static int getIntValue(String value) {
            for (SOUND_EFFECT_PATTERN info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return STANDARD.getValue();
        }

        public static int getIndex(String value) {
            for (SOUND_EFFECT_PATTERN info : values()) {
                if (info.getName().equals(value)) {
                    return info.getIndex();
                }
            }
            return STANDARD.getIndex();
        }

        public static int getIndex(int value) {
            for (SOUND_EFFECT_PATTERN info : values()) {
                if (info.getValue()==value) {
                    return info.getIndex();
                }
            }
            return STANDARD.getIndex();
        }
    }

    /**
     * 亮度调剂
     * 默认自动
     */
    public enum BRIGHTNESS_CONTROL {
        AUTO(1, "自动"),
        DAY(2, "白天"),
        DAYNIGHT(3, "夜晚");

        private int value;
        private String name;

        BRIGHTNESS_CONTROL(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (BRIGHTNESS_CONTROL info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return AUTO.getName();
        }

        public static int getIntValue(String value) {
            for (BRIGHTNESS_CONTROL info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return AUTO.getValue();
        }
    }

    /**
     * iPhone启动应用
     * 默认Carplay
     */
    public enum IPHONE_START_APP {
        CARPLAY(1, "Carplay"),
        CARLIFE(2, "Carlife"),
        CARBIT(3, "Carbit"),
        NONE(4, "None");

        private int value;
        private String name;

        IPHONE_START_APP(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (IPHONE_START_APP info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return CARPLAY.getName();
        }

        public static int getIntValue(String value) {
            for (IPHONE_START_APP info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return CARPLAY.getValue();
        }
    }

    /**
     * Android启动应用
     * 默认Android Auto
     */
    public enum ANDROID_START_APP {
        ANDROID_AUTO(1, "Android Auto"),
        CARLIFE(2, "Carlife"),
        CARBIT(3, "Carbit");

        private int value;
        private String name;

        ANDROID_START_APP(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (ANDROID_START_APP info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return ANDROID_AUTO.getName();
        }

        public static int getIntValue(String value) {
            for (ANDROID_START_APP info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return ANDROID_AUTO.getValue();
        }
    }

    /**
     * 定位模式
     * 默认高精度
     */
    public enum LOCATION_TYPE {
        HIGHT(1, "高精确度"),
        LOST(2, "低耗电量"),
        ONLY(3, "仅限设备");

        private int value;
        private String name;

        LOCATION_TYPE(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (LOCATION_TYPE info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return HIGHT.getName();
        }

        public static int getIntValue(String value) {
            for (LOCATION_TYPE info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return HIGHT.getValue();
        }
    }

    /**
     * 身份验证
     * 默认无
     */
    public enum AUTHENTICATION_TYPE {
        NONE(1, "无"),
        PAP(2, "PAP"),
        CHAP(3, "CHAP");

        private int value;
        private String name;

        AUTHENTICATION_TYPE(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (AUTHENTICATION_TYPE info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return NONE.getName();
        }

        public static int getIntValue(String value) {
            for (AUTHENTICATION_TYPE info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return NONE.getValue();
        }
    }


    /**
     * 承载系统
     * 默认未指定
     */
    public enum BEARING_SYSTEM {
        LTE(1, "LTE"),
        eHRPD(2, "eHRPD"),
        NONE(3, "未指定");

        private int value;
        private String name;

        BEARING_SYSTEM(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (BEARING_SYSTEM info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return NONE.getName();
        }

        public static int getIntValue(String value) {
            for (BEARING_SYSTEM info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return NONE.getValue();
        }
    }



    /**
     * apn协议
     * 默认IPv4
     */
    public enum APN_AGREEMENT {
        IPv4(1, "IPv4"),
        IPv6(2, "IPv6"),
        IPv4IPv6(3, "IPv4/IPv6");

        private int value;
        private String name;

        APN_AGREEMENT(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (APN_AGREEMENT info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return IPv4.getName();
        }

        public static int getIntValue(String value) {
            for (APN_AGREEMENT info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return IPv4.getValue();
        }
    }


    /**
     * MVNO类型
     * 默认无
     */
    public enum MVNO_TYPE {
        NONE(1, "无"),
        SPN(2, "SPN"),
        IMSI(3, "IMSI"),
        GID(4, "GID");

        private int value;
        private String name;

        MVNO_TYPE(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getStringValue(int value) {
            for (MVNO_TYPE info : values()) {
                if (info.getValue() == value) {
                    return info.getName();
                }
            }
            return NONE.getName();
        }

        public static int getIntValue(String value) {
            for (MVNO_TYPE info : values()) {
                if (info.getName().equals(value)) {
                    return info.getValue();
                }
            }
            return NONE.getValue();
        }
    }
}
