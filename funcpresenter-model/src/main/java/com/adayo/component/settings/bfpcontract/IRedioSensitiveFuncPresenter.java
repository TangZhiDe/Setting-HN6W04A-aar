package com.adayo.component.settings.bfpcontract;

/**
 * @author damanz
 * @className IRedioSensitiveFuncPresenter
 * @date 2018-09-19.
 */
public interface IRedioSensitiveFuncPresenter {
    void getRedioSensitive();

    void setRedioSensitive(int fm_loc_value, int fm_disc_value, int am_loc_value, int am_disc_value);
}
