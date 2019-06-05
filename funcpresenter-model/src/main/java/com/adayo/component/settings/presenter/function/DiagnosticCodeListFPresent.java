package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;

import com.adayo.component.settings.bfpcontract.IDiagnosticCodeListFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.DiagnosticCodeListModel;
import com.adayo.component.settings.model.bean.StatusInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damanz
 * @className DiagnosticCodeFPresent
 * @date 2018-09-19.
 */
public class DiagnosticCodeListFPresent extends SettingsBaseFPersenter<DiagnosticCodeListModel> implements IDiagnosticCodeListFuncPresenter {

    public DiagnosticCodeListFPresent(Context context) {
        super(context);
        mModel= DiagnosticCodeListModel.getDiagnosticCodeListModelInstance(mContext);
    }

    @Override
    public void getMPUErrorCodeData() {
        mModel.getMPUErrorCodeData();
    }

    @Override
    public void getPowerStatusInfo() {
        List<StatusInfo> info = mModel.getPowerStatusInfo();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FPConstant.EXTRA_STATUS_INFO, (ArrayList<? extends Parcelable>) info);
        sendMessage(FPConstant.POWER_STATUS_HANDLER_ID,bundle);
    }

    @Override
    public void getCarStatusInfo() {
        List<StatusInfo> info = mModel.getCarStatusInfo();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FPConstant.EXTRA_STATUS_INFO, (ArrayList<? extends Parcelable>) info);
        sendMessage(FPConstant.CAR_STATUS_HANDLER_ID,bundle);
    }

    @Override
    public void getAudioStatusInfo() {
        List<StatusInfo> info = mModel.getAudioStatusInfo();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FPConstant.EXTRA_STATUS_INFO, (ArrayList<? extends Parcelable>) info);
        sendMessage(FPConstant.AUDIO_STATUS_HANDLER_ID, bundle);
    }
}
