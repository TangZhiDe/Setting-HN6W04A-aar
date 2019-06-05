LOCAL_PATH:= $(call my-dir)

### BUILD Settings funcpresenter-model
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_STATIC_JAVA_LIBRARIES := appbasesettings
LOCAL_STATIC_JAVA_LIBRARIES += systemServicesettings
LOCAL_STATIC_JAVA_LIBRARIES += serviceproxysettings
LOCAL_STATIC_JAVA_LIBRARIES += sourcemngproxysettings
LOCAL_STATIC_JAVA_LIBRARIES += audiodspproxysettings
LOCAL_STATIC_JAVA_LIBRARIES += SettingsServicesettings
LOCAL_STATIC_JAVA_LIBRARIES += mcucommsettings
LOCAL_STATIC_JAVA_LIBRARIES += gsonsettings
LOCAL_STATIC_JAVA_LIBRARIES += errorcodeproxysettings
LOCAL_STATIC_JAVA_LIBRARIES += fgerpmsgproxysettings
LOCAL_STATIC_JAVA_LIBRARIES += android-support-annotations
LOCAL_STATIC_JAVA_LIBRARIES += android-support-v4
LOCAL_STATIC_JAVA_LIBRARIES += android-support-v7-appcompat

LOCAL_REQUIRED_MODULES := libymu836

LOCAL_SRC_FILES := $(call all-java-files-under, src/main/java)
LOCAL_SRC_FILES += $(call all-Iaidl-files-under, src/main)

LOCAL_MANIFEST_FILE := src/main/AndroidManifest.xml
LOCAL_MODULE := settings-funcpresenter-model

LOCAL_CERTIFICATE := platform
#LOCAL_SDK_VERSION := current
LOCAL_PROGUARD_ENABLED := disabled
#LOCAL_PROGUARD_FLAG_FILES := proguard.cfg
#LOCAL_DX_FLAGS := --multi-dex --main-dex-list=$(mainDexList) --minimal-main-dex
#LOCAL_JACK_FLAGS += --multi-dex native

include $(BUILD_STATIC_JAVA_LIBRARY)

### BUILD prebuilt jar
include $(CLEAR_VARS)

ifeq ($(IS_ADAYO_LOCAL),true)
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := appbasesettings:../../../Middleware/libs/jar/appbase.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += errorcodeproxysettings:../../../Middleware/libs/jar/errorcode-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += systemServicesettings:../../../Middleware/libs/jar/systemservice-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += serviceproxysettings:../../../Middleware/libs/jar/service-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += sourcemngproxysettings:../../../Middleware/libs/jar/sourcemng-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += audiodspproxysettings:../../../Middleware/libs/jar/audiodsp-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += SettingsServicesettings:../../../Middleware/libs/jar/SettingsService-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += mcucommsettings:../../../Middleware/libs/jar/mcucomm-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += gsonsettings:../../../Middleware/libs/jar/gson-2.7.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += fgerpmsgproxysettings:../../../Middleware/libs/jar/fgerpmsg-proxy.jar
else
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := appbasesettings:../../../Middleware/libs/jar/appbase.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += errorcodeproxysettings:../../../Middleware/libs/jar/errorcode-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += systemServicesettings:../../../Middleware/libs/jar/systemservice-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += serviceproxysettings:../../../Middleware/libs/jar/service-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += sourcemngproxysettings:../../../Middleware/libs/jar/sourcemng-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += audiodspproxysettings:../../../Middleware/libs/jar/audiodsp-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += SettingsServicesettings:../../../Middleware/libs/jar/SettingsService-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += mcucommsettings:../../../Middleware/libs/jar/mcucomm-proxy.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += gsonsettings:../../../Middleware/libs/jar/gson-2.7.jar
	LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += fgerpmsgproxysettings:../../../Middleware/libs/jar/fgerpmsg-proxy.jar
endif



include $(BUILD_MULTI_PREBUILT)
