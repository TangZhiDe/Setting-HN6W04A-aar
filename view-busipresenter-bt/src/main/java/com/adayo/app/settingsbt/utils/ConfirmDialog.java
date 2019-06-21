package com.adayo.app.settingsbt.utils;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.adayo.app.settingsbt.R;


/**
 * @author tzd
 *
 */
public class ConfirmDialog extends Dialog {

    private Context context;
    private String title;
    private int uiMode;
    private ClickListenerInterface clickListenerInterface;
    private int type; //0:断开蓝牙  1:连接蓝牙  2:删除配对设备

    public interface ClickListenerInterface {

         void doConfirm();

         void doCancel();
    }

    public ConfirmDialog(Context context, String title ,int uiMode,int type) {
        super(context, R.style.dialog);
        this.context = context;
        this.title = title;
        this.uiMode = uiMode;
        this.type = type;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.alertdialog_layout, null);
        Log.d("TAG", "init: uiMode== " +uiMode);
        if(uiMode != 19){
            view.setBackgroundResource(R.drawable.popup_bg1);
        }else {
            view.setBackgroundResource(R.drawable.popup_bg);
        }
        setContentView(view);


        TextView alert_bt_tip = view.findViewById(R.id.alert_bt_tip);
        TextView alert_bt_cancel = view.findViewById(R.id.alert_bt_cancel);
        Button alert_bt_disconnect = view.findViewById(R.id.alert_bt_disconnect);
        TextView alert_bt_name = view.findViewById(R.id.alert_bt_name);
        if(type == 0){
            //断开
            alert_bt_name.setText(context.getResources().getString(R.string.btstring13)+title);
            alert_bt_disconnect.setText(context.getResources().getString(R.string.btstring15));
            alert_bt_tip.setText(context.getResources().getString(R.string.btstring14));
        }else if(type == 1){
            //连接
            alert_bt_name.setText(context.getResources().getString(R.string.btstring17)+title);
            alert_bt_disconnect.setText(context.getResources().getString(R.string.btstring19));
            alert_bt_tip.setText(context.getResources().getString(R.string.btstring18));
        }else if(type == 2){
            //删除
            alert_bt_name.setText(context.getResources().getString(R.string.btstring20)+title);
            alert_bt_disconnect.setText(context.getResources().getString(R.string.btstring22));
            alert_bt_tip.setText(context.getResources().getString(R.string.btstring21));
        }
        alert_bt_disconnect.setOnClickListener(new clickListener());
        alert_bt_cancel.setOnClickListener(new clickListener());
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        dialogWindow.setGravity(Gravity.CENTER | Gravity.START);
        lp.width = 640;
        lp.height = 330;
        lp.x = 360;
//        lp.y = 50;
        lp.gravity = Gravity.CENTER_VERTICAL | Gravity.START;
        dialogWindow.setAttributes(lp);
    }

    public void setClicklistener(ClickListenerInterface clickListenerInterface) {
        this.clickListenerInterface = clickListenerInterface;
    }

    private class clickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            int id = v.getId();
            if (id == R.id.alert_bt_disconnect) {
                clickListenerInterface.doConfirm();

            } else if (id == R.id.alert_bt_cancel) {
                clickListenerInterface.doCancel();

            }
        }

    };

}