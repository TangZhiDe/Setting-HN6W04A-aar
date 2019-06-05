package com.adayo.component.settings.bfpcontract;

import android.content.pm.PackageInfo;

/**
 * @author damanz
 * @className ITrafficDataFuncPresenter
 * @date 2018-09-19.
 */
public interface ITrafficDataFuncPresenter {
    void getAppList();

    void getAppTrafficData(PackageInfo info);
}
