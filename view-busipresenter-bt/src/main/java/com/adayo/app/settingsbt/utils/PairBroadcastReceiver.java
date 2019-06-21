package com.adayo.app.settingsbt.utils;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class PairBroadcastReceiver extends BroadcastReceiver {
    static final String TAG = "PairBroadcastReceiver";
    private static int mPairType = 0;
    private static BluetoothDevice mDevice = null;
    public static WindowDialog instance;

    @Override
    public void onReceive(Context context, Intent intent) {
        instance = WindowDialog.getInstance(context);
        String action = intent.getAction();
        Log.d(TAG, "action: " + action);
        switch (action) {
            case BluetoothDevice.ACTION_PAIRING_REQUEST:
                mDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mPairType = intent.getIntExtra(BluetoothDevice.EXTRA_PAIRING_VARIANT, BluetoothDevice.ERROR);
                Log.d(TAG, "type: " + mPairType);
                int pairingValue = 0;
                if (mPairType == BluetoothDevice.PAIRING_VARIANT_PASSKEY_CONFIRMATION) {
                    Log.d(TAG, "PAIRING_VARIANT_PASSKEY_CONFIRMATION  address:" + mDevice.getAddress() + "  name:" + mDevice.getName());
                    pairingValue = intent.getIntExtra(BluetoothDevice.EXTRA_PAIRING_KEY, BluetoothDevice.ERROR);
                    Log.d(TAG, "pairingValue: " + pairingValue);
                    showDialog(context, mDevice.getName(), "" + pairingValue);
                } else if (mPairType == BluetoothDevice.PAIRING_VARIANT_PIN) {
                    Log.d(TAG, "PAIRING_VARIANT_PIN");
                    pairingValue = Integer.parseInt("0000");
                    Log.d(TAG, "pairingValue: " + pairingValue);
                } else {
                    Log.d(TAG, "Unkown paring type" + mPairType);
                }
                break;
            case BluetoothDevice.ACTION_BOND_STATE_CHANGED:
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String name = device.getName();
                Log.d(TAG, "device name: " + name);
                int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, -1);
//            WindowDialog instance = WindowDialog.getInstance();
                switch (state) {
                    case BluetoothDevice.BOND_NONE:
                        Log.d(TAG, "BOND_NONE 删除配对");
                        instance.dismiss();
                        break;
                    case BluetoothDevice.BOND_BONDING:
                        Log.d(TAG, "BOND_BONDING 正在配对");
                        break;
                    case BluetoothDevice.BOND_BONDED:
                        Log.d(TAG, "BOND_BONDED 配对成功");
                        instance.dismiss();
                        break;
                }
                break;
            case BluetoothDevice.ACTION_ACL_CONNECTED:
//                instance.dismiss();
                Log.d(TAG, "onReceive: 蓝牙连接");
                break;

            case BluetoothDevice.ACTION_ACL_DISCONNECTED:
//                instance.dismiss();
                Log.d(TAG, "onReceive: 蓝牙断开连接");
                break;
        }

    }


    private void showDialog(Context context, String name, String pairingValue) {
        Log.d(TAG, "showDialog:pairFromPhone=+ " + BtSettingService.pairFromPhone);
        instance.setParams(BtSettingService.pairFromPhone, mDevice, name, "" + pairingValue);
        //
        BtSettingService.setPairFromPhone(true);
    }



}
