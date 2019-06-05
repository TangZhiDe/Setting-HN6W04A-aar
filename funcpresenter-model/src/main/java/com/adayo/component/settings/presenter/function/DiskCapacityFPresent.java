package com.adayo.component.settings.presenter.function;

import android.content.Context;

import com.adayo.component.settings.bfpcontract.IDiskCapacityFuncPresenter;
import com.adayo.component.settings.model.DiskCapacityModel;

/**
 * @author damanz
 * @className DiskCapacityFPresent
 * @date 2018-09-19.
 */
public class DiskCapacityFPresent extends SettingsBaseFPersenter<DiskCapacityModel> implements IDiskCapacityFuncPresenter  {

    public DiskCapacityFPresent(Context context) {
        super(context);
        mModel=DiskCapacityModel.getDiskCapacityModelInstance(mContext);
    }

    @Override
    public void getDiskCapacity() {
        long sdTotalSize = mModel.getSDTotalSize();
        long sdAvailableSize = mModel.getSDAvailableSize();
        long appTotalSize = mModel.getAppTotalSize();
//        Intent intent = new Intent();
//        intent.putExtra(FPConstant.EXTRA_DISK_CAPACITY_TOTAL,sdTotalSize);
//        intent.putExtra(FPConstant.EXTRA_DISK_CAPACITY_AVAILABLE,sdAvailableSize);
//        intent.putExtra(FPConstant.EXTRA_DISK_CAPACITY_APP,appTotalSize);
//        sendMessage(FPConstant.DISK_CAPACITY_TYPE_HANDLER_ID, intent);
    }
}
