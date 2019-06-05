package com.adayo.component.settings.bfpcontract;

import com.adayo.component.settings.model.bean.Apn;

/**
 * @author damanz
 * @className IApnDataChangedFuncPresenter
 * @date 2018-09-19.
 */
public interface IApnDataChangedFuncPresenter {
    void getApnData(String id);

    void addApn(Apn apn);
}
