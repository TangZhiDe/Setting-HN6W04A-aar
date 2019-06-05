package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className ILocationInfoFuncPresenter
 * @date 2018-09-19.
 */
public interface ILocationInfoFuncPresenter {
    void setLocationType(int itemMode);

    void getGpsLocationType();

    void getGpsServiceState();
    void setGpsServiceState(boolean state);
}
