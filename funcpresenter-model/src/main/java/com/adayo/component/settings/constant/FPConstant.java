/**
 * Copyright (c) 2015 FORYOU GENERAL ELECTRONICS CO.,LTD. All Rights Reserved.
 */
package com.adayo.component.settings.constant;

import android.net.Uri;

/**
 * @author damanz
 * @className FPConstant
 * @date 2018-07-26.
 */
public final class FPConstant {

    private FPConstant() {

    }

    public static final String TAG = "SETTING_FP_";

    public static final String DATE_TIME_YEAR = "year";
    public static final String DATE_TIME_MONTH = "month";
    public static final String DATE_TIME_DAY = "day";
    public static final String DATE_TIME_HOUR = "hour";
    public static final String DATE_TIME_MINUTE = "minute";
    public static final String DATE_TIME_ISAM = "isAm";

    public static final String VERSION_MCU = "mcu";
    public static final String VERSION_MPU = "mpu";
    public static final String VERSION_OS = "os";
    public static final String VERSION_MODLE = "modle";

    public static final int UPDATE_MODEL_LOCAL=1;
    public static final int UPDATE_MODEL_ONLINE=2;

    public static final String UPDATE_LOCAL_PATH= "com.adayo.fota/com.adayo.fota.view.MainActivity";
    public static final String UPDATE_ONLINE_PATH= "com.adayo.fota/com.adayo.fota.view.FotaActivity";

    public static final String[] emptyArr = new String[1];

    public static final String[] powerStatusInfo = {"电源管理状态(Power.MainPowerState)",
            "电源状态(Power.BatteryState)","Acc状态(Power.Accstate)","开关机状态(Power.PowerOnFactor)"};
    public static final String[] carStatusInfo = {"Bit0:倒车状态", "Bit1:刹车状态" , "Bit2:大灯状态",
            "Bit3:AUX状态", "Bit4:DcdcPwm状态"/*, "Bit5:状态" , "Bit6:状态" , "Bit7:D2Update状态"*/};
    public static final String[] mediaStatusInfo = {"功放mute类型高8位（MuteType）", "音量（Main_Volume)",
            "工作源（Front_Zone.Source)"};

    /**
     * 开机音量
     */
    public static final int VOLUME_TYPE_TURN_ON = 0x24;
    /**
     * 导航音量
     */
    public static final int VOLUME_TYPE_NAVIGATION = 0x25;
    /**
     * 媒体音量
     */
    public static final int VOLUME_TYPE_MEDIA = 0x26;
    /**
     * 蓝牙音量
     */
    public static final int VOLUME_TYPE_BLUETOOTH = 0x27;
    /**
     * 通知音量
     */
    public static final int VOLUME_TYPE_NOTIFY = 0x28;
    /**
     * TTS音量
     */
    public static final int VOLUME_TYPE_TTS = 0x29;


    //--------------------------- 系统常量仅供内部使用（提取出来，保证编译通过）-------------------------------------------
    public static final long MIN_DATE = 1194220800000L;
    public static final String EXTRA_TIME_PREF_24_HOUR_FORMAT =
            "android.intent.extra.TIME_PREF_24_HOUR_FORMAT";
    public static final int EXTRA_TIME_PREF_VALUE_USE_12_HOUR = 0;
    public static final int EXTRA_TIME_PREF_VALUE_USE_24_HOUR = 1;
    public static final String HOURS_12 = "12";
    public static final String HOURS_24 = "24";
    public static final String ACTION_ENABLE_ADB_STATE_CHANGED =
            "com.android.settingslib.development.AbstractEnableAdbController."
                    + "ENABLE_ADB_STATE_CHANGED";

    public static final Uri APN_TABLE_URI = Uri.parse("content://telephony/carriers");
    public static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    public static final Uri CURRENT_APN_URI = Uri.parse("content://telephony/carriers/current");


    //--------------------------- 华阳定义字段---------------------------------------------------------
    /**
     * 机型信息
     */
    public static final byte SYS_CONFIG_MODLE = 0x00;
    /**
     * MPU版本
     */
    public static final byte SYS_CONFIG_MPU = 0x01;
    /**
     * MCU版本
     */
    public static final byte SYS_CONFIG_MCU = 0x02;
    /**
     * OS版本
     */
    public static final byte SYS_CONFIG_OS = 0x03;
    /**
     * UUID版本
     */
    public static final byte SYS_CONFIG_UUID = 0x04;
    /**
     * Device Id
     */
    public static final byte SYS_CONFIG_DEVID = 0x05;
    /**
     * 序列号
     */
    public static final byte SYS_CONFIG_SERNUM = 0x06;
    /**
     * 硬件版本
     */
    public static final byte SYS_CONFIG_HARDVER = 0x07;
    /**
     * 触屏固件版本
     */
    public static final byte SYS_CONFIG_TOUCHVER = 0x08;
    /**
     * MCU SVN路径
     */
    public static final byte SYS_CONFIG_MCUSVNVER = 0x09;
    /**
     * BSP 版本
     */
    public static final byte SYS_CONFIG_BSPVER = 0x0A;
    /**
     * BSP SVN路径
     */
    public static final byte SYS_CONFIG_BSPSVNVER = 0x0B;
    public static final byte SYS_CONFIG_MPUSVNVER = 0x0C;
    public static final byte SYS_CONFIG_MCU_MPUVER = 0x0D;
    /**
     * mcu setting字段值
     */
    public static final byte SYS_MODLE_SETTING = 0x04;

//--------------------------- 所有的Key值字段定义-------------------------------------------
    /**
     * 时间日期设置 key
     */
    public static final String EXTRA_UPDATE_DATE_TIME = "update_date_time";
    /**
     * 时间模式 key
     */
    public static final String EXTRA_TIME_TYPE_MODE = "time_type_mode";
    /**
     * 自动对时
     */
    public static final String EXTRA_AUTO_GPS= "extra_auto_gps";
    public static final String EXTRA_AUTO_NET= "extra_auto_net";
    /**
     * 亮度调节模式 key
     */
    public static final String EXTRA_SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
    /**
     * 亮度值 key
     */
    public static final String EXTRA_BRIGHTNESS_PROGRESS = "brightness_progress";
    /**
     * 屏幕显示状态 key
     */
    public static final String EXTRA_SCREEN_DISPLAY_STATE = "screen_display_state";

    /**
     * 音量
     */
    public static final String EXTRA_VOLUME = "extra_volume";
    /**
     * 音量类型
     */
    public static final String EXTRA_VOLUME_TYPE = "extra_volume_type";
    /**
     * 开机音量开关状态
     */
    public static final String EXTRA_TURN_ON_VOLUME_SWITCH_STATE = "extra_turn_on_volume_switch_state";
    /**
     * 开机音量值
     */
    public static final String EXTRA_TURN_ON_VOLUME = "extra_turn_on_volume";
    /**
     * 背光状态
     */
    public static final String EXTRA_UPDATE_DISPLAY_STATUS = "extra_update_display_status";
    /**
     * 混音播报
     */
    public static final String EXTRA_NAIGATION_BROADCAST = "extra_naigation_broadcast";
    /**
     * 速度补偿音
     */
    public static final String EXTRA_SPEED_COM_VOLUME = "extra_speed_com_volume";
    /**
     * 按键提示音
     */
    public static final String EXTRA_KEY_TONE_SWITCH = "extra_key_tone_switch";
    /**
     * 通知提示音
     */
    public static final String EXTRA_NOTIFY_SWITCH = "extra_notify_switch";
    /**
     * 静音
     */
    public static final String EXTRA_MUTE_SWITCH = "extra_mute_switch";
    /**
     * 系统语言
     */
    public static final String EXTRA_SYSTEM_LANGUANG = "extra_system_languang";
    /**
     * 待机显示模式
     */
    public static final String EXTRA_STANDBY_DISPLAY = "extra_standby_display";
    /**
     * 夏令时
     */
    public static final String EXTRA_SUMER_TIME_SWITCH = "extra_sumer_time_switch";
    /**
     * 时区
     */
    public static final String EXTRA_TIME_ZONE = "extra_time_zone";
    /**
     * 日期模式
     */
    public static final String EXTRA_DATE_TYPE = "extra_date_type";
    /**
     * 关机显示时钟
     */
    public static final String EXTRA_SHUTDOWN_SHOW = "extra_shutdown_show";
    /**
     * 版本信息
     */
    public static final String EXTRA_VERSION_INFO = "extra_version_info";
    /**
     * 移动网络
     */
    public static final String EXTRA_MOBILE_NETWORK_SWITCH = "extra_mobile_network_switch";
    /**
     * EQ模式
     */
    public static final String EXTRA_EQ_TYPE = "extra_eq_type";
    /**
     * EQ 低
     */
    public static final String EXTRA_EQ_TYPE_BASE = "extra_eq_type_base";
    /**
     * EQ 中
     */
    public static final String EXTRA_EQ_TYPE_MIDDLE = "extra_eq_type_middle";
    /**
     * EQ 高
     */
    public static final String EXTRA_EQ_TYPE_TREBLE = "extra_eq_type_treble";
    /**
     * 声场
     */
    public static final String EXTRA_SOUND_FIELD = "extra_sound_field";
    /**
     * 等响度
     */
    public static final String EXTRA_LOUDNESS = "extra_loudness";
    /**
     * 数据漫游
     */
    public static final String EXTRA_DATA_ROAMING = "extra_data_roaming";
    /**
     * 网络运营商
     */
    public static final String EXTRA_NETWORK_OPERATOR = "extra_network_operator";
    /**
     * adb开关
     */
    public static final String EXTRA_ADB_SWITCH = "extra_adb_switch";
    /**
     * factory list
     */
    public static final String EXTRA_FACTORY_LIST = "extra_factory_list";
    /**
     * factory list
     */
    public static final String EXTRA_FACTORY_LIST_TYPE = "extra_factory_list_type";
    /**
     * 触摸固件版本
     */
    public static final String EXTRA_TOUCH_VERSION = "extra_touch_version";
    /**
     * BT name
     */
    public static final String EXTRA_BLUETOOTH_NAME = "extra_bluetooth_name";
    /**
     * 文件浏览器
     */
    public static final String EXTRA_FILE_BROWSER = "extra_file_browser";
    /**
     * uuid
     */
    public static final String EXTRA_UUID = "extra_uuid";
    /**
     * 设备ID
     */
    public static final String EXTRA_DEVICE_ID = "extra_device_id";
    /**
     * 生产序列号
     */
    public static final String EXTRA_PRODUCTION_NUM = "extra_production_num";
    /**
     * 硬件版本号
     */
    public static final String EXTRA_HARDWARE_VERSION = "extra_hardware_version";
    /**
     * Iphone启动设置
     */
    public static final String EXTRA_IPHONE_SETTINGS = "extra_iphone_settings";
    /**
     * Android启动设置
     */
    public static final String EXTRA_ANDROID_SETTINGS = "extra_android_settings";
    /**
     * log保存
     */
    public static final String EXTRA_LOG_SAVE = "extra_log_save";
    /**
     * 诊断码
     */
    public static final String EXTRA_DIAGNOSTIC_CODE_TYPE = "extra_diagnostic_code_type";
    /**
     * 磁盘容量
     */
    public static final String EXTRA_DISK_CAPACITY_TOTAL = "extra_disk_capacity_total";
    public static final String EXTRA_DISK_CAPACITY_AVAILABLE = "extra_disk_capacity_available";
    public static final String EXTRA_DISK_CAPACITY_APP = "extra_disk_capacity_app";
    /**
     * APP列表
     */
    public static final String EXTRA_APP_LIST = "extra_app_list";
    /**
     * 流量数据
     */
    public static final String EXTRA_TRAFFIC_DATA = "extra_traffic_data";
    /**
     * gps
     */
    public static final String EXTRA_GPS_SERVICE = "extra_gps_service";
    public static final String EXTRA_GPS_LOCATION = "extra_gps_location";
    /**
     * 输入法
     */
    public static final String EXTRA_INPUT_METHOD = "extra_input_method";
    /**
     * 触摸按键音
     */
    public static final String EXTRA_DISABLE_TOUCH_TONE = "extra_disable_touch_tone";
    /**
     * 账号信息
     */
    public static final String EXTRA_ACCOUNT_INFO = "extra_account_info";
    public static final String EXTRA_NOT_LOGIN = "extra_not_login";
    /**
     * apn
     */
    public static final String EXTRA_APN_ID = "extra_apn_id";
    public static final String EXTRA_APN_DATA = "extra_apn_data";
    /**
     * 安装未知应用
     */
    public static final String EXTRA_INSTALL_UNKNOW_SOURCE = "extra_install_unknow_source";
    /**
     * 收音调试
     */
    public static final String EXTRA_FM_LOC_VALUE = "extra_fm_loc_value";
    public static final String EXTRA_FM_DISC_VALUE = "extra_fm_disc_value";
    public static final String EXTRA_AM_LOC_VALUE = "extra_am_loc_value";
    public static final String EXTRA_AM_DISC_VALUE = "extra_am_disc_value";
    /**
     * 显示效果--亮度
     */
    public static final String EXTRA_FGERPMSG_BRIGHTNESS = "extra_fgerpmsg_brightness";
    public static final String EXTRA_FGERPMSG_BRIGHTNESS_RANGE = "extra_fgerpmsg_brightness_range";
    /**
     * 显示效果--对比度
     */
    public static final String EXTRA_FGERPMSG_CONTRAST = "extra_fgerpmsg_contrast";
    public static final String EXTRA_FGERPMSG_CONTRAST_RANGE = "extra_fgerpmsg_contrast_range";
    /**
     * 显示效果--饱和度
     */
    public static final String EXTRA_FGERPMSG_SATURATION = "extra_fgerpmsg_saturation";
    public static final String EXTRA_FGERPMSG_SATURATION_RANGE = "extra_fgerpmsg_saturation_range";
    /**
     * 显示效果--色度
     */
    public static final String EXTRA_FGERPMSG_HUE = "extra_fgerpmsg_hue";
    public static final String EXTRA_FGERPMSG_HUE_RANGE = "extra_fgerpmsg_hue_range";
    /**
     * 显示效果--锐度
     */
    public static final String EXTRA_FGERPMSG_SHARPNESS = "extra_fgerpmsg_sharpness";
    public static final String EXTRA_FGERPMSG_SHARPNESS_RANGE = "extra_fgerpmsg_sharpness_range";
    /**
     * 行车观看视频
     */
    public static final String EXTRA_TRAFFIC_WATCH_VIDEO = "extra_traffic_watch_video";

    /**
     * 配置管理
     */
    public static final String EXTRA_CONFIG_VERSION = "extra_config_version";
    public static final String EXTRA_CONFIG_PATH = "extra_config_path";
    /**
     * 状态信息
     */
    public static final String EXTRA_STATUS_INFO= "extra_status_info";


//--------------------------- handler Id (501-1000)-------------------------------------------
    /**
     * 更新时间日期
     */
    public static final int UPDATE_DATE_TIME_HANDLER_ID = 0x501;
    /**
     * 时间模式
     */
    public static final int TIME_TYPE_MODE_HANDLER_ID = 0x502;
    /**
     * 亮度模式
     */
    public static final int SCREEN_BRIGHTNESS_MODE_HANDLER_ID = 0x503;
    /**
     * 亮度调节
     */
    public static final int BRIGHTNESS_PROGRESS_HANDLER_ID = 0x504;
    /**
     * 开机音量
     */
    public static final int TURN_ON_VOLUME_SWITCH_STATE_HANDLER_ID = 0x505;
    /**
     * 更新音量
     */
    public static final int UPDATE_VOLUME_HANDLER_ID = 0x506;
    /**
     * 背光状态
     * 功能删除 弃用
     */
    @Deprecated
    public static final int UPDATE_DISPLAY_STATUS_HANDLER_ID = 0x507;
    /**
     * 导航混音
     */
    public static final int NAIGATION_BROADCAST_HANDLER_ID = 0x508;
    /**
     * 速度补偿
     */
    public static final int SPEED_COM_VOLUME_HANDLER_ID = 0x509;
    /**
     * 按键提示音
     */
    public static final int KEY_TONE_SWITCH_HANDLER_ID = 0x510;
    /**
     * 系统语言
     */
    public static final int SYSTEM_LANGUANG_HANDLER_ID = 0x511;
    /**
     * 待机显示模式
     */
    public static final int STANDBY_DISPLAY_HANDLER_ID = 0x512;
    /**
     * 夏令时
     */
    public static final int SUMER_TIME_SWITCH_HANDLER_ID = 0x513;
    /**
     * 时区
     */
    public static final int TIME_ZONE_HANDLER_ID = 0x514;
    /**
     * 日期模式
     */
    public static final int DATE_TYPE_HANDLER_ID = 0x515;
    /**
     * 关机显示时钟
     */
    public static final int SHUTDOWN_SHOW_HANDLER_ID = 0x516;
    /**
     * 版本信息
     */
    public static final int VERSION_INFO_HANDLER_ID = 0x517;
    /**
     * 移动网络
     */
    public static final int MOBILE_NETWORK_SWITCH_HANDLER_ID = 0x518;
    /**
     * EQ模式
     */
    public static final int EQ_TYPE_HANDLER_ID = 0x519;
    /**
     * EQ 低
     */
    public static final int EQ_TYPE_BASE_HANDLER_ID = 0x520;
    /**
     * EQ 中
     */
    public static final int EQ_TYPE_MIDDLE_HANDLER_ID = 0x521;
    /**
     * EQ 高
     */
    public static final int EQ_TYPE_TREBLE_HANDLER_ID = 0x522;
    /**
     * 声场
     */
    public static final int SOUND_FIELD_HANDLER_ID = 0x523;
    /**
     * 等响度
     */
    public static final int LOUDNESS_HANDLER_ID = 0x524;
    /**
     * 数据漫游
     */
    public static final int DATA_ROAMING_HANDLER_ID = 0x525;
    /**
     * 网络运营商
     */
    public static final int NETWORK_OPERATOR_HANDLER_ID = 0x526;
    /**
     * 恢复出厂
     */
    public static final int RESTORE_FACTORY_HANDLER_ID = 0x527;
    /**
     * adb开关
     */
    public static final int ADB_SWITCH_HANDLER_ID = 0x528;
    /**
     * Factory List
     */
    public static final int FACTORY_LIST_HANDLER_ID = 0x529;
    /**
     * Factory List
     */
    public static final int FACTORY_LIST_TYPE_HANDLER_ID = 0x530;
    /**
     * 触摸固件版本
     */
    public static final int TOUCH_VERSION_HANDLER_ID = 0x531;
    /**
     * BT name
     */
    public static final int BLUETOOTH_NAME_HANDLER_ID = 0x532;
    /**
     * 文件浏览器
     */
    public static final int FILE_BROWSER_HANDLER_ID = 0x533;
    /**
     * 返回按钮
     */
    public static final int ACTIVITY_BACK_HANDLER_ID = 0x534;
    /**
     * uuid
     */
    public static final int UUID_HANDLER_ID = 0x535;
    /**
     * 设备ID
     */
    public static final int DEVICE_ID_HANDLER_ID = 0x536;
    /**
     * 生产序列号
     */
    public static final int PRODUCTION_NUM_HANDLER_ID = 0x537;
    /**
     * 硬件版本号
     */
    public static final int HARDWARE_VERSION_HANDLER_ID = 0x538;
    /**
     * Iphone启动设置
     */
    public static final int IPHONE_SETTINGS_HANDLER_ID = 0x539;
    /**
     * Android启动设置
     */
    public static final int ANDROID_SETTINGS_HANDLER_ID = 0x540;
    /**
     * log保存
     */
    public static final int LOG_SAVE_HANDLER_ID = 0x541;
    /**
     * 诊断码
     */
    public static final int DIAGNOSTIC_CODE_TYPE_HANDLER_ID = 0x542;
    /**
     * 磁盘容量
     */
    public static final int DISK_CAPACITY_TYPE_HANDLER_ID = 0x543;
    /**
     * APP列表
     */
    public static final int APP_LIST_HANDLER_ID = 0x544;
    /**
     * 流量数据
     */
    public static final int TRAFFIC_DATA_HANDLER_ID = 0x545;
    /**
     * gps
     */
    public static final int GPS_SERVICE_HANDLER_ID = 0x546;
    public static final int GPS_LOCATION_HANDLER_ID = 0x547;
    /**
     * 输入法
     */
    public static final int INPUT_METHOD_HANDLER_ID = 0x548;
    /**
     * 触摸按键音
     */
    public static final int DISABLE_TOUCH_TONE_HANDLER_ID = 0x549;
    /**
     * 触摸按键音
     */
    public static final int ACCOUNT_SETTING_HANDLER_ID = 0x550;
    /**
     * APN isAdd
     */
    public static final int APN_ISADD_HANDLER_ID = 0x551;
    public static final int APN_DATA_HANDLER_ID = 0x552;
    /**
     * 安装未知应用
     */
    public static final int INSTALL_UNKNOW_SOURCE_HANDLER_ID = 0x523;
    /**
     * 收音调试
     */
    public static final int FM_AM_VALUE_HANDLER_ID = 0x524;
    /**
     * 重置声场
     */
    public static final int RESET_FADER_BALANCE_HANDLER_ID = 0x525;
    /**
     * 显示效果--亮度
     */
    public static final int FGERPMSG_BRIGHTNESS_HANDLER_ID = 0x526;
    /**
     * 显示效果--对比度
     */
    public static final int FGERPMSG_CONTRAST_HANDLER_ID = 0x527;
    /**
     * 显示效果--饱和度
     */
    public static final int FGERPMSG_SATURATION_HANDLER_ID = 0x528;
    /**
     * 显示效果--色度
     */
    public static final int FGERPMSG_HUE_HANDLER_ID = 0x529;
    /**
     * 显示效果--锐度
     */
    public static final int FGERPMSG_SHARPNESS_HANDLER_ID = 0x530;
    /**
     * 行车观看视频
     */
    public static final int TRAFFIC_WATCH_VIDEO_HANDLER_ID = 0x531;
    /**
     * MCU MPU通讯版本
     */
    public static final int MCU_MPU_PROTOCOL_HANDLER_ID = 0x532;

    public static final int MCU_SOURCE_PATH_HANDLER_ID = 0x533;

    public static final int MPU_SOURCE_PATH_HANDLER_ID = 0x534;

    public static final int BSP_SOURCE_PATH_HANDLER_ID = 0x535;
    /**
     * 电源状态信息
     */
    public static final int POWER_STATUS_HANDLER_ID= 0x536;
    public static final int CAR_STATUS_HANDLER_ID= 0x537;

    /**
     * 通知提示音
     */
    public static final int KEY_NOTIFY_HANDLER_ID = 0x538;

    /**
     * 静音
     */
    public static final int KEY_MUTE_HANDLER_ID = 0x539;

    /**
     * 屏幕显示状态
     */
    public static final int KEY_SCREEN_DISPLAY_HANDLER_ID = 0x540;

    public static final int AUDIO_STATUS_HANDLER_ID= 0x541;

    /**
     * 自动对时
     */
    public static final int AUTO_TIME_HANDLER_ID= 0x569;
}
