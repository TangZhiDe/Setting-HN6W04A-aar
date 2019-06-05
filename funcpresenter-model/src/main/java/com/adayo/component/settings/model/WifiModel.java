package com.adayo.component.settings.model;

import android.content.Context;

/**
 * Created by Administrator on 2018/12/13 0013.
 */

public class WifiModel extends  BaseModel {

    private final Context mContex;
   public static WifiModel mModel = null;

    public WifiModel(Context context){
        this.mContex = context;

    }

  public static   WifiModel getWifiModelInstance(Context context){
    if(mModel == null) {
        synchronized (WifiModel.class){
             if(mModel == null) {
                 mModel = new WifiModel(context);
             }
        }
    }
        return mModel;
    }


}
