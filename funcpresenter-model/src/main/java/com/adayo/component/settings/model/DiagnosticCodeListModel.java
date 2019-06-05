package com.adayo.component.settings.model;

import android.content.Context;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.bean.StatusInfo;
import com.adayo.errorcodeproxy.ErrorCode;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damanz
 * @className DiagnosticCodeModel
 * @date 2018-09-07.
 */
public class DiagnosticCodeListModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + DiagnosticCodeModel.class.getSimpleName();
    private static DiagnosticCodeListModel mModel = null;
    private Context mContext;
    private ErrorCode mErrorCode;

    private DiagnosticCodeListModel(Context context) {
        this.mContext = context;
    }

    public static DiagnosticCodeListModel getDiagnosticCodeListModelInstance(Context context) {
        if (mModel == null) {
            synchronized (DiagnosticCodeListModel.class) {
                if (mModel == null) {
                    mModel = new DiagnosticCodeListModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
        mErrorCode = ErrorCode.getInstance();
//        boolean b = mErrorCode.connectErrorCodeServer();
//        Log.d(TAG, "connectErrorCodeServer   errorcode: "+b);
    }

    public void getMPUErrorCodeData() {
        byte[] bytes = new byte[1184];
        boolean errorcode = mErrorCode.getErrorcode(bytes, bytes.length);
        Log.d(TAG, "getMPUErrorCodeData   errorcode: "+errorcode);
        for (int i = 0; i < bytes.length; i+=8) {
            byte[] by = new byte[8];
            System.arraycopy(bytes,i,by,0,8);
            byte b1 = by[0];
            Log.d(TAG, "getMPUErrorCodeData   Head: "+b1);
            if(b1==(byte)0xA1){//MPU

            }else if(b1==(byte)0xAA){//MCU

            }
        }
    }

    public List<StatusInfo> getPowerStatusInfo() {
        List<StatusInfo> infos = new ArrayList<>();
        String[] out = new String[FPConstant.powerStatusInfo.length];
        int i = SettingsContantsDef.RET_NG_NOR;
        while (i == SettingsContantsDef.RET_NG_NOR) {
            i = mSettingsManager.doFunc_PowerStatusInfo(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr,
                    out);
        }
        Log.d(TAG, "getPowerStatusInfo: i   " + i);
        for (int x = 0; x < out.length; x++) {
            StatusInfo info = new StatusInfo(FPConstant.powerStatusInfo[x],out[x]);
            Log.d(TAG, "getPowerStatusInfo: " + info.toString());
            infos.add(info);
        }
        return infos;
    }

    public List<StatusInfo> getCarStatusInfo() {
        List<StatusInfo> infos = new ArrayList<>();
        String[] out = new String[FPConstant.carStatusInfo.length];
        int i = SettingsContantsDef.RET_NG_NOR;
        while (i == SettingsContantsDef.RET_NG_NOR) {
            i = mSettingsManager.doFunc_CarStatusInfo(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr,
                    out);
        }
        Log.d(TAG, "getCarStatusInfo: i   " + i);
        for (int x = 0; x < out.length; x++) {
            StatusInfo info = new StatusInfo(FPConstant.carStatusInfo[x], out[x]);
            Log.d(TAG, "getCarStatusInfo: " + info.toString());
            infos.add(info);
        }
        return infos;
    }

    public List<StatusInfo> getAudioStatusInfo() {
        List<StatusInfo> infos = new ArrayList<>();
        String[] out = new String[FPConstant.mediaStatusInfo.length];
        int i = SettingsContantsDef.RET_NG_NOR;
        while (i == SettingsContantsDef.RET_NG_NOR) {
            i = mSettingsManager.doFunc_AudioStatusInfo(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr,
                    out);
        }
        Log.d(TAG, "getAudioStatusInfo: i   " + i);
        for (int x = 0; x < out.length; x++) {
            StatusInfo info = new StatusInfo(FPConstant.mediaStatusInfo[x], out[x]);
            Log.d(TAG, "getAudioStatusInfo: " + info.toString());
            infos.add(info);
        }
        return infos;
    }
}
