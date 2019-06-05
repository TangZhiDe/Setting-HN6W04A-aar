package com.adayo.component.settings.model;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.mcucommproxy.IMcuCommCallback;
import com.adayo.mcucommproxy.McuCommCmd0x0500;
import com.adayo.mcucommproxy.McuCommCmd0x0501;
import com.adayo.mcucommproxy.McuCommManager;
import com.adayo.struct.JavaStruct;
import com.adayo.struct.StructException;

/**
 * @author damanz
 * @className RedioSensitiveModel
 * @date 2018-09-07.
 */
public class RedioSensitiveModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + RedioSensitiveModel.class.getSimpleName();
    private static RedioSensitiveModel mModel = null;
    private Context mContext;
    private McuCommManager mMcuCommManager;
    private int mGetCount;
    private int mLastGetCount;

    private RedioSensitiveModel(Context context) {
        this.mContext = context;
    }

    public static RedioSensitiveModel getRedioSensitiveModelInstance(Context context) {
        if (mModel == null) {
            synchronized (RedioSensitiveModel.class) {
                if (mModel == null) {
                    mModel = new RedioSensitiveModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
        mMcuCommManager = McuCommManager.getInstance();
        boolean b = mMcuCommManager.connectMcuCommServer();
        Log.d(TAG, "init: McuCommManager is connect " + b);
        mMcuCommManager.registMcuCommCallback(new IMcuCommCallback() {
            @Override
            public void mcuCommCallback(byte[] bytes, char c) {
                Log.d(TAG, "mcuCommCallback: c " + (int) c);
//                if (mGetCount - mLastGetCount != 1) {
//                    mGetCount = 0;
//                    mLastGetCount = 0;
//                    return;
//                }
//                mLastGetCount = mGetCount;
                int lenth = c;
                if (bytes[0] == (byte) 0x85 && bytes[1] == 0x01) {
                    Log.d(TAG, "mcuCommCallback: 8501");
                    if (lenth == 6) {
                        Bundle intent = new Bundle();
                        //FM近程
                        intent.putInt(FPConstant.EXTRA_FM_LOC_VALUE, bytes[2] & 0xFF);
                        //FM远程
                        intent.putInt(FPConstant.EXTRA_FM_DISC_VALUE, bytes[3] & 0xFF);

                        intent.putInt(FPConstant.EXTRA_AM_LOC_VALUE, bytes[4] & 0xFF);
                        intent.putInt(FPConstant.EXTRA_AM_DISC_VALUE, bytes[5] & 0xFF);
                        mFPHandler.obtainMessage(FPConstant.FM_AM_VALUE_HANDLER_ID, intent).sendToTarget();
                    }
                }
            }
        }, (byte) 0x05);
    }

    public void setRedioSensitive(int fm_loc_value, int fm_disc_value, int am_loc_value, int am_disc_value) {
        McuCommCmd0x0500 cmd = new McuCommCmd0x0500((byte)fm_loc_value,(byte)fm_disc_value,
                (byte)am_loc_value,(byte)am_disc_value);
        try {
            byte[] bytes = JavaStruct.pack(cmd);
            boolean b = mMcuCommManager.mcuCommSendcmd(bytes, (char) bytes.length);
            Log.d(TAG, "mcuCommSendcmd 0500 : " + b);
        } catch (StructException e) {
            e.printStackTrace();
        }
    }

    public void getRedioSensitive() {
        Log.d(TAG, "getRedioSensitive: ");
        McuCommCmd0x0501 cmd = new McuCommCmd0x0501();
        try {
            byte[] bytes = JavaStruct.pack(cmd);
            boolean b = mMcuCommManager.mcuCommSendcmd(bytes, (char) bytes.length);
            mGetCount++;

            Log.d(TAG, "mcuCommSendcmd 0501 : " + b);
        } catch (StructException e) {
            e.printStackTrace();
        }
    }
}
