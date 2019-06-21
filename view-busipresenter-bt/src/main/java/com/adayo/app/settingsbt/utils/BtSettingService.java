package com.adayo.app.settingsbt.utils;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;


public class BtSettingService extends Service {
    protected static String TAG = BtSettingService.class.getCanonicalName();
    private PairBroadcastReceiver pairBroadcastReceiver;
    public static boolean pairFromPhone = true;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerBroadcast();

    }



    private void registerBroadcast() {
        pairBroadcastReceiver = new PairBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_PAIRING_REQUEST);
        intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        registerReceiver(pairBroadcastReceiver, intentFilter);//注册广播接收驱动状态
        Log.d(TAG, "registerBroadcast: 注册蓝牙连接状态广播" );
    }
    private void unRegisterBroadcast(){
        if(pairBroadcastReceiver != null){
            unregisterReceiver(pairBroadcastReceiver);
        }
    }

    public static void setPairFromPhone(boolean pairFromPhone1){
        pairFromPhone = pairFromPhone1;
        Log.d(TAG, "setPairFromPhone: pairFromPhone=="+pairFromPhone );
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: service销毁" );
        unRegisterBroadcast();
    }

}

