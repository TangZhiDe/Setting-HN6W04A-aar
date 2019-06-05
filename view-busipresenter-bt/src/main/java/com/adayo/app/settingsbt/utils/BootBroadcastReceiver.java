package com.adayo.app.settingsbt.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootBroadcastReceiver extends BroadcastReceiver {
    //重写onReceive方法
    @Override
    public void onReceive(Context context, Intent intent) {
        //后边的XXX.class就是要启动的服务
        Log.v("TAG", "开机自动服务自动启动.....");
//        service.setPackage("com.nforetek.bt.phone");
        Intent service = new Intent();
        ComponentName componentName = new ComponentName(context, BtSettingService.class);
        service.setComponent(componentName);
        context.startService(service);
        Log.v("TAG", "开机自动服务自动启动111.....");

    }
}