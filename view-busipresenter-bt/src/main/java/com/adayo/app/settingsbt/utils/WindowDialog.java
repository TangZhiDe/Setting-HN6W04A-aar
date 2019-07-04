package com.adayo.app.settingsbt.utils;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adayo.app.settingsbt.R;
import com.adayo.app.settingsbt.presenter.business.system.BtPresenter;


public class WindowDialog implements View.OnClickListener{

    private static String TAG = WindowDialog.class.getCanonicalName();
    private WindowManager.LayoutParams wmParams;
    private static WindowManager wm;
    private Context context;
    private View mView;
    private boolean mIsShow = false;
    private int x;
    private int y;
    private static WindowDialog instance;
    private String name;
    private String paircode;
    private ImageView pair_loading;
    private  LinearLayout pair_confirm;
    private  RelativeLayout pair_pairing;
    private BluetoothDevice mDevice;
    private BtPresenter btPresenter;
    private boolean pairFromPhone;



    public static WindowDialog getInstance(Context context){
        if(null == instance){
            Log.d(TAG, "getInstance: 实例化" );
            instance = new WindowDialog(context);
        }
        return instance;
    }

private WindowDialog(Context context){
    this.context = context;
    this.x = 360;
    this.y = 50;
    this.init();
}

public void setParams(boolean pairFromPhone, BluetoothDevice mDevice,String name,String paircode){
    this.name = name;
    this.paircode = paircode;
    this.mDevice = mDevice;
    this.pairFromPhone = pairFromPhone;
    Log.d(TAG, "setParams: pairFromPhone"+pairFromPhone+"  mDevice="+mDevice+"  name="+name+ " paircode"+paircode );
    this.initView();
    show();
}


    private void init() {
        wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wmParams = new WindowManager.LayoutParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        wmParams.format = PixelFormat.TRANSLUCENT;
        wmParams.gravity = Gravity.CENTER_VERTICAL | Gravity.START;
        wmParams.width = 640;
        wmParams.height = 330;
//        wmParams.width = WindowManager.LayoutParams.MATCH_PARENT;
//        wmParams.height = WindowManager.LayoutParams.MATCH_PARENT;
//        wmParams.gravity = Gravity.CENTER;
        wmParams.x = x;
        wmParams.y = y;
    }



    private void initView(){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(pairFromPhone){
            this.mView = inflater.inflate(R.layout.pairdialogfromphone_layout, null);
        }else {
            this.mView = inflater.inflate(R.layout.pairdialog_layout, null);
        }
        this.mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        TextView pair_bt_name = mView.findViewById(R.id.pair_bt_name);
        TextView pair_paircode = mView.findViewById(R.id.pair_paircode);
        pair_confirm = mView.findViewById(R.id.pair_confirm);
        pair_loading = mView.findViewById(R.id.pair_loading);
        pair_pairing = mView.findViewById(R.id.pair_pairing);
        if(pairFromPhone){
            Button pair_bt_pair = mView.findViewById(R.id.pair_bt_pair);
            TextView pair_bt_cancel = mView.findViewById(R.id.pair_bt_cancel);
            pair_bt_pair.setOnClickListener(this);
            pair_bt_cancel.setOnClickListener(this);
        }
        pair_bt_name.setText(name);
        pair_paircode.setText(paircode);
        pair_confirm.setVisibility(View.VISIBLE);
        pair_pairing.setVisibility(View.GONE);
        startRotate();
    }

    public  void setView(){
        pair_confirm.setVisibility(View.GONE);
        pair_pairing.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.pair_bt_pair) {
            setPair();
        } else if (i == R.id.pair_bt_cancel) {
            cancelPair();
        }
    }


    public void setPair(){
        try {
            mDevice.getClass().getMethod("setPairingConfirmation", boolean.class).invoke(mDevice, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "setPair: 配对");
        setView();
    }
    public void cancelPair(){
        try {
            mDevice.getClass().getMethod("cancelBondProcess", boolean.class).invoke(mDevice);
            mDevice.getClass().getMethod("cancelPairingUserInput", boolean.class).invoke(mDevice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "cancelPair: 取消配对");
        dismiss();
    }




    public  void dismiss() {
        Log.d(TAG, "dismiss: wm= +"+wm+"  mIsShow = "+mIsShow+"  mView="+mView );
        if (wm != null && mIsShow) {
            try {
                if (null != mView) {
                    wm.removeView(mView);
                    Log.d(TAG, "dismiss: " );
                    mIsShow = false;
//                    PairBroadcastReceiver.setPairFromPhone(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    public void show() {
        Log.d(TAG, "------------show---------------"+mIsShow);
        if (!mIsShow) {
            if (null != wm && null != mView) {
                    Log.d(TAG, "------------show---------------");
                    wm.addView(mView, wmParams);
                    mIsShow = true;
                    if(!pairFromPhone){
                        Log.d(TAG, "show: 自动配对");

                        myHandler.sendEmptyMessageDelayed(0,1500);

                    }

            }else {
                Log.d(TAG, "------------wm---------mView==null------");
            }
        }
    }



    private Handler myHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what){
                case 0:
                    setPair();
                    break;
            }

            return false;
        }
    });


    /**
     * 开启动画
     */
    public void startRotate() {
        Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.version_image_rotate);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        if (operatingAnim != null) {
            pair_loading.startAnimation(operatingAnim);
        }
    }

    /**
     * 关闭动画
     */
    public void stopRotate() {
        pair_loading.clearAnimation();
    }


}
