package com.adayo.component.settings.bfpcontract;

import android.content.pm.PackageInfo;

/**
 * @author damanz
 * @className IApplicationListFuncPresenter
 * @date 2018-09-19.
 */
public interface IApplicationListFuncPresenter {
    void getAppList();

    void cleanCache(PackageInfo info);

    void uninstall(PackageInfo info);
}
