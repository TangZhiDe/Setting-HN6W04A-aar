package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

/**
 * @author damanz
 * @className SoundFieldModel
 * @date 2018-09-05.
 */
public class SoundFieldModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + SoundFieldModel.class.getSimpleName();
    private static SoundFieldModel mModel = null;
    private Context mContext;
   // private AudioDspManager mAudioDspManager;

    private SoundFieldModel(Context context) {
        this.mContext = context;
    }

    public static SoundFieldModel getSoundFieldModelInstance(Context context) {
        if (mModel == null) {
            synchronized (SoundEqModel.class) {
                if (mModel == null) {
                    mModel = new SoundFieldModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
        //mAudioDspManager = AudioDspManager.getShareDataManager();
    }

    public void setFaderBalance(int x, int y) {
        String[] in = {x + "," + y + "," + x + "," + y};
        mSettingsManager.doDb_SoundField(mContext, SettingsContantsDef.MODE_SET, in, FPConstant.emptyArr);
//        int i = mAudioDspManager.setFaderBalance(x, y, x, y);
//        Log.d(TAG, "setFaderBalance: "+i);
    }

    public int[] getFaderBalance() {
        int[] faderBalance = new int[4];
        // Log.d(TAG, "getFaderBalance: " + faderBalance.length);
        String[] out = getDefultString();
        mSettingsManager.doDb_SoundField(mContext, SettingsContantsDef.MODE_GET, FPConstant.emptyArr, out);
        try {
            String[] split = out[0].split(",");
            faderBalance[0] = Integer.parseInt(split[0]);
            faderBalance[1] = Integer.parseInt(split[1]);
            faderBalance[2] = Integer.parseInt(split[2]);
            faderBalance[3] = Integer.parseInt(split[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faderBalance;
    }
}
