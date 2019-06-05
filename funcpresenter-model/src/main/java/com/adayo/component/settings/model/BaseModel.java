package com.adayo.component.settings.model;

import android.os.Handler;

import com.adayo.proxy.settings.SettingsManager;

/**
 * @author damanz
 * @className BaseModel
 * @date 2018-09-12.
 */
public class BaseModel {

    protected Handler mFPHandler;
    protected SettingsManager mSettingsManager;

    public void init() {
        mSettingsManager = SettingsManager.getSettingsManager();
    }

    public void setHandler(Handler handler) {
        mFPHandler=handler;
    }

    public int formatIntData(String[]data ,int defValue){
        if(data==null || data.length==0){
            return defValue;
        }
        return formatIntData(data[0],defValue);
    }

    public int formatIntData(String data,int defValue){
        try{
            return Integer.parseInt(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defValue;
    }

    public boolean formatBooleanData(String[]data ,boolean defValue){
        if(data==null || data.length==0){
            return defValue;
        }
        return formatBooleanData(data[0],defValue);
    }

    public boolean formatBooleanData(String data,boolean defValue){
        try{
            return Boolean.parseBoolean(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defValue;
    }

    public String[] getDefultString(){
        return getOutString(1);
    }

    public String[] getOutString(int size){
        return new String[size];
    }

    public String[] getBoolenString(boolean state) {
        return new String[]{Boolean.toString(state)};
    }

    public String[] getIntString(int value) {
        return new String[]{Integer.toString(value)};
    }
}
