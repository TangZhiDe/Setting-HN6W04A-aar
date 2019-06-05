package com.adayo.component.settings.model;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;

import com.adayo.component.settings.constant.FPConstant;

import java.util.List;

/**
 * @author damanz
 * @className InputMethodSettingsModel
 * @date 2018-09-07.
 */
public class InputMethodSettingsModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + InputMethodSettingsModel.class.getSimpleName();
    private static InputMethodSettingsModel mModel = null;
    private Context mContext;

    private InputMethodSettingsModel(Context context) {
        this.mContext = context;
    }

    public static InputMethodSettingsModel getInputMethodSettingsModelInstance(Context context) {
        if (mModel == null) {
            synchronized (InputMethodSettingsModel.class) {
                if (mModel == null) {
                    mModel = new InputMethodSettingsModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();

    }

    public List<InputMethodInfo> getInputMethod() {
        //读取默认输入法
        String current = Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD);
        Log.d(TAG, String.format("current default: %s", current));
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.getInputMethodList();
    }

    public void setDisableTouchTone(boolean state) {
        String key = Settings.System.SOUND_EFFECTS_ENABLED;//"sound_effects_enabled"
        int value = state ? 0 : 1;//0禁用 1启用
        Settings.System.putInt(mContext.getContentResolver(), key, value);
    }

    public boolean getDisableTouchTone() {
        String key = Settings.System.SOUND_EFFECTS_ENABLED;//"sound_effects_enabled"
        int value = Settings.System.getInt(mContext.getContentResolver(), key, 0);
        return value == 0;
    }
}
