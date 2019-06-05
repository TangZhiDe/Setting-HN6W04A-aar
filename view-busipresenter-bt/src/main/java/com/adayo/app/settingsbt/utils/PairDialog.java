package com.adayo.app.settingsbt.utils;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adayo.app.settingsbt.R;


/**
 * @author tzd
 *
 */
public class PairDialog extends Dialog {


    private String TAG = "PairDialog";
    private Context context;
    public static PairDialog instance;
    private ClickListenerInterface clickListenerInterface;
    private String name;
    private String paircode;
    private ImageView pair_loading;
    private static LinearLayout pair_confirm;
    private static LinearLayout pair_pairing;

    public interface ClickListenerInterface {

         void doConfirm();

         void doCancel();
    }

    public static PairDialog getInstance(){
        return instance;
    }

    public PairDialog(Context context, String name,String paircode) {
        super(context, R.style.dialog);
        this.context = context;
        this.name = name;
        this.paircode = paircode;
    }
    public void dismiss1(){
        Log.d(TAG, "dismiss1: " );
        dismiss();
        if(instance != null){
            instance = null;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        init();
        this.instance = this;
    }


    public static void setView(){
            pair_confirm.setVisibility(View.GONE);
            pair_pairing.setVisibility(View.VISIBLE);

    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pairdialog_layout, null);
        view.setBackgroundResource(R.drawable.popup_bg2);
        setContentView(view);
        TextView pair_bt_name = view.findViewById(R.id.pair_bt_name);
        TextView pair_paircode = view.findViewById(R.id.pair_paircode);

        pair_confirm = view.findViewById(R.id.pair_confirm);
        pair_loading = view.findViewById(R.id.pair_loading);
        pair_pairing = view.findViewById(R.id.pair_pairing);
        pair_bt_name.setText(name);
        pair_paircode.setText(paircode);
        pair_confirm.setVisibility(View.VISIBLE);
        pair_pairing.setVisibility(View.GONE);
        startRotate();
        Window dialogWindow = getWindow();
        dialogWindow.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = 640;
        lp.height = 330;
        lp.x = -250;
        lp.y = 50;
//        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
    }
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