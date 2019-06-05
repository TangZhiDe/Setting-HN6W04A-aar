package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IConfigManageFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.ConfigManageModel;

/**
 * @author damanz
 * @className ConfigManageFPresent
 * @date 2018-09-19.
 */
public class ConfigManageFPresent extends SettingsBaseFPersenter<ConfigManageModel> implements IConfigManageFuncPresenter {

    public ConfigManageFPresent(Context context) {
        super(context);
        mModel=ConfigManageModel.getConfigManageModelInstance(mContext);
    }

    @Override
    public void getMcuMpuProtocolVersion() {
        String[] version = mModel.getMcuMpuProtocolVersion();
        Bundle bundle=new Bundle();
        bundle.putString(FPConstant.EXTRA_CONFIG_VERSION,version[0]);
        sendMessage(FPConstant.MCU_MPU_PROTOCOL_HANDLER_ID,bundle);
    }

    @Override
    public void getMcuSourcePathVersion() {
        String[] pathVersion = mModel.getMcuSourcePathVersion();
        Bundle bundle=new Bundle();
        bundle.putString(FPConstant.EXTRA_CONFIG_VERSION,pathVersion[0]);
        bundle.putString(FPConstant.EXTRA_CONFIG_PATH,pathVersion[1]);
        sendMessage(FPConstant.MCU_SOURCE_PATH_HANDLER_ID,bundle);

    }

    @Override
    public void getMpuSourcePathVersion() {
        String[] pathVersion = mModel.getMpuSourcePathVersion();
        Bundle bundle=new Bundle();
        bundle.putString(FPConstant.EXTRA_CONFIG_VERSION,pathVersion[0]);
        bundle.putString(FPConstant.EXTRA_CONFIG_PATH,pathVersion[1]);
        sendMessage(FPConstant.MPU_SOURCE_PATH_HANDLER_ID,bundle);

    }

    @Override
    public void getBspSourcePathVersion() {
        String[] pathVersion = mModel.getBspSourcePathVersion();
        Bundle bundle=new Bundle();
        bundle.putString(FPConstant.EXTRA_CONFIG_VERSION,pathVersion[0]);
        bundle.putString(FPConstant.EXTRA_CONFIG_PATH,pathVersion[1]);
        sendMessage(FPConstant.BSP_SOURCE_PATH_HANDLER_ID,bundle);
    }
}
