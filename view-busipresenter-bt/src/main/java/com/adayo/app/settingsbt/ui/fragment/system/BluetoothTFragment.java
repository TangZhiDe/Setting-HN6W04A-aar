package com.adayo.app.settingsbt.ui.fragment.system;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adayo.adayosource.AdayoSource;
import com.adayo.app.base.BaseFragment;
import com.adayo.app.settingsbt.R;
import com.adayo.app.settingsbt.adapter.BTRecyclerAdapter;
import com.adayo.app.settingsbt.bean.BluetoothBean;
import com.adayo.app.settingsbt.presenter.business.system.BtPresenter;
import com.adayo.app.settingsbt.utils.ConfirmDialog;
import com.adayo.app.settingsbt.utils.MyLinearLayoutManager;
import com.adayo.app.settingsbt.utils.PairBroadcastReceiver;
import com.adayo.app.utils.LogUtils;
import com.adayo.proxy.sourcemngproxy.Control.SrcMngSwitchProxy;
import com.nforetek.bt.base.jar.NforeBtBaseJar;
import com.nforetek.bt.res.NfDef;

import java.util.ArrayList;
import java.util.List;

import static com.adayo.app.base.BaseConstant.FRAG_FIRST_PARAM;

/**
 * @author xuefengduan
 * @version 1.0
 * @date 2018/11/8.
 * @desc. 蓝牙Fragment
 */
@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class BluetoothTFragment extends BaseFragment<BtPresenter> implements
        BtPresenter.UiBluetoothServiceConnectedListener,
        BtPresenter.UiBluetoothSettingChangeListerer {

    private static final String TAG = BluetoothTFragment.class.getCanonicalName();
    private ImageView setting_bt_auto_answer;
    private ImageView setting_bt_auto_connect;
    private ImageView setting_bt_switch;
    private RecyclerView history_matching_list;
    //    private ImageView history_matching_refresh;
    private TextView history_matching_tip;
    private TextView setting_bt_name;
    private RecyclerView search_list;
    private ImageView search_refresh;
    private TextView search_tip;
    private List<BluetoothBean> pairedList = new ArrayList<>();
    private List<BluetoothBean> searchList = new ArrayList<>();
    private ArrayList<String> device_founded_list = new ArrayList<String>();
    private BTRecyclerAdapter pairedAdapter;
    private BTRecyclerAdapter searchAdapter;
    private BtPresenter mBPresenter;
    private String currAddress = "";
    List<BluetoothBean> beanList = new ArrayList<>();
    private Activity myActicity;
    private LinearLayout setting_zi;
    private TextView setting_bt;
    private TextView setting_atuo;
    private TextView setting_tbtxl;
    private TextView setting_sbm;
    private TextView setting_lspd;
    private TextView setting_ssxsb;
    private BtLanguageChange languageReceive;
    private int currentNightMode = 19;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.iL(TAG, "onCreateView");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        LogUtils.iL(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        LogUtils.iL(TAG, "onHiddenChanged");
        super.onHiddenChanged(hidden);
        if (!hidden) {
            try {
                if (mBPresenter != null && mBPresenter.isBtEnabled()) {
                    Log.d(TAG, "onHiddenChanged: 搜索");
                    searchBt();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            SrcMngSwitchProxy.getInstance().notifyServiceUIChange(AdayoSource.ADAYO_SOURCE_BT_SETTING);
        }
    }

    @Override
    public void onResume() {
        LogUtils.iL(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtils.iL(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        LogUtils.iL(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        LogUtils.iL(TAG, "onDestroy");
        if (mBPresenter != null) {
            mBPresenter.unregisterServiceListener();
        }
//        if(languageReceive != null){
//            getActivity().unregisterReceiver(languageReceive);
//        }
        currAddress = "";
        super.onDestroy();
    }

    /**
     * 初始化数据,主要对 BusinessPresenter 的注册和初始化,以及一些其他相关工具的初始化。
     */
    @Override
    public void initData() {
        LogUtils.iL(TAG, "initData");
    }

    @Override
    public void setBPresenter(BtPresenter btPresenter) {
        this.mBPresenter = btPresenter;
        Log.d(TAG, "setBPresenter:1.91 ");


        if (mBPresenter == null) {
            Log.d(TAG, "setBPresenter: ==null");
        }
        if (getActivity() == null) {
            Log.d(TAG, "getActivity: ==null");
        }
        if (getMContext() == null) {
            Log.d(TAG, "getMContext: ==null");
        }


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myActicity = (Activity) context;
        mBPresenter.registerServiceListener(myActicity);
        mBPresenter.registerUiBluetoothServiceConnectedListener(this);
        mBPresenter.registerUiBluetoothSettingChangeListerer(this);
    }

    @Override
    public View getContentView() {
        LogUtils.iL(TAG, "getContentView");
        return super.getContentView();
    }

    @Override
    public Context getMContext() {
        LogUtils.iL(TAG, "getMContext");
        return super.getMContext();
    }

    /**
     * Fragment实例化方法，用于向自身传送数据
     */
    public static BluetoothTFragment newInstance(String param) {
        BluetoothTFragment fragment = new BluetoothTFragment();
        Bundle args = new Bundle();
        args.putString(FRAG_FIRST_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 获取该 Fragment 布局控件 ID。
     */
    @Override
    public int getLayout() {
        LogUtils.iL(TAG, "getLayout");
        return R.layout.fragment_setting;
    }

    /**
     * 初始化该 Fragment 布局内的 UI 控件。
     */
    @Override
    public void initView() {
        LogUtils.iL(TAG, "initView");
        currentNightMode = getResources().getConfiguration().uiMode;
        Log.d(TAG, "initView: currAddress == " + currAddress);
        init();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: uiMode===" + newConfig.uiMode + "---locale=" + newConfig.locale.toString());
        currentNightMode = newConfig.uiMode;
        if (newConfig.uiMode == 19 || newConfig.uiMode == 35) {
            myHandler.sendEmptyMessage(0x00);
            updateText();
        }

        if (newConfig.locale.toString().equals("zh_CN") || newConfig.locale.toString().equals("en")) {
            updateText();
        }

    }

    private void registerReceiver() {
        languageReceive = new BtLanguageChange();
        IntentFilter intent = new IntentFilter(Intent.ACTION_LOCALE_CHANGED);
        getActivity().registerReceiver(languageReceive, intent);
    }


    class BtLanguageChange extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED)) {
                Log.d("LocaleChangeReceiver", "Language change");
                updateText();
            }
        }
    }

    public boolean isFromBtPhone = false;

    public void setIsFromBtPhone(boolean isFromBtPhone) {
        this.isFromBtPhone = isFromBtPhone;
        Log.d(TAG, "setIsFromBtPhone: " + isFromBtPhone);
    }

    public void updateText() {
        Log.d(TAG, "updateText: ");
        setting_bt.setText(getMContext().getResources().getString(R.string.btstring1));
        setting_atuo.setText(getMContext().getResources().getString(R.string.btstring2));
        setting_tbtxl.setText(getMContext().getResources().getString(R.string.btstring3));
        setting_sbm.setText(getMContext().getResources().getString(R.string.btstring4));
        setting_lspd.setText(getMContext().getResources().getString(R.string.btstring5));
        setting_ssxsb.setText(getMContext().getResources().getString(R.string.btstring7));
        history_matching_tip.setText(getMContext().getResources().getString(R.string.btstring6));
        search_tip.setText(getMContext().getResources().getString(R.string.btstring8));
        pairedAdapter.notifyDataSetChanged();
        searchAdapter.notifyDataSetChanged();
        setting_bt.setTextColor(getMContext().getResources().getColor(R.color.bt_normal_color));
        setting_atuo.setTextColor(getMContext().getResources().getColor(R.color.bt_normal_color));
        setting_tbtxl.setTextColor(getMContext().getResources().getColor(R.color.bt_normal_color));
        setting_sbm.setTextColor(getMContext().getResources().getColor(R.color.bt_normal_color));
        setting_lspd.setTextColor(getMContext().getResources().getColor(R.color.bt_normal_color));
        setting_ssxsb.setTextColor(getMContext().getResources().getColor(R.color.bt_normal_color));
        history_matching_tip.setTextColor(getMContext().getResources().getColor(R.color.bt_unselect_color));
        search_tip.setTextColor(getMContext().getResources().getColor(R.color.bt_unselect_color));
    }


    private void init() {
//        registerReceiver();
        //自动接听switch
        setting_bt_auto_answer = getContentView().findViewById(R.id.setting_bt_auto_answer);
        //自动连接switch
        setting_bt_auto_connect = getContentView().findViewById(R.id.setting_bt_auto_connect);
        //蓝牙是否打开
        setting_bt_switch = getContentView().findViewById(R.id.setting_bt_switch);
        //历史配对list
        history_matching_list = getContentView().findViewById(R.id.setting_bt_history_matching_list);
        //历史配对刷新按钮
//        history_matching_refresh = getContentView().findViewById(R.id.setting_bt_history_matching_refresh);
        //历史配对tip
        history_matching_tip = getContentView().findViewById(R.id.setting_bt_history_matching_tip);
        //本地蓝牙名称
        setting_bt_name = getContentView().findViewById(R.id.setting_bt_name);
        //搜索蓝牙list
        search_list = getContentView().findViewById(R.id.setting_bt_search_list);
        //搜索蓝牙按钮
        search_refresh = getContentView().findViewById(R.id.setting_bt_search_refresh);
        //搜索蓝牙tip
        search_tip = getContentView().findViewById(R.id.setting_bt_search_tip);
        //子功能
        setting_zi = getContentView().findViewById(R.id.setting_zi);
        setting_bt = getContentView().findViewById(R.id.setting_bt);
        setting_atuo = getContentView().findViewById(R.id.setting_atuo);
        setting_tbtxl = getContentView().findViewById(R.id.setting_tbtxl);
        setting_sbm = getContentView().findViewById(R.id.setting_sbm);
        setting_lspd = getContentView().findViewById(R.id.setting_lspd);
        setting_ssxsb = getContentView().findViewById(R.id.setting_ssxsb);


        //设置自动下载通话记录
        setting_bt_auto_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mBPresenter != null) {
                        Log.d(TAG, "onClick: getBtAutoAnswerState" + mBPresenter.getBtAutoDownState());
//                        if(mBPresenter.getBtAutoAnswerState()){
//                            mBPresenter.setBtAutoAnswerEnable(false);
//                            setting_bt_auto_answer.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
//                        }else {
//                            mBPresenter.setBtAutoAnswerEnable(true);
//                            setting_bt_auto_answer.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
//                        }
                        if (mBPresenter.getBtAutoDownState()) {
                            mBPresenter.setBtAutoDownEnable(false);
                            setting_bt_auto_answer.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
                        } else {
                            mBPresenter.setBtAutoDownEnable(true);
                            setting_bt_auto_answer.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
                        }
                    }

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置自动连接
        setting_bt_auto_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if (mBPresenter != null) {
                        Log.d(TAG, "onClick: isBtAutoConnectEnable" + mBPresenter.isBtAutoConnectEnable());
                        int condition = mBPresenter.getBtAutoConnectCondition();
                        //NfDef.AUTO_CONNECT_WHEN_OOR  NfDef.AUTO_CONNECT_DISABLE
                        if (condition == 7) {
                            mBPresenter.setBtAutoConnect(NfDef.AUTO_CONNECT_DISABLE, 0);
                            Log.d(TAG, "onClick: setBtAutoConnect == AUTO_CONNECT_DISABLE");
                            setting_bt_auto_connect.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
                        } else {
//                            mBPresenter.setBtAutoConnect(NfDef.AUTO_CONNECT_WHEN_OOR,0);
                            mBPresenter.setBtAutoConnect(7, 0);
                            Log.d(TAG, "onClick: setBtAutoConnect == AUTO_CONNECT_WHEN_BT_ON");
                            setting_bt_auto_connect.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
                        }
                    }

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置蓝牙开关
        setting_bt_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (mBPresenter != null) {
                        Log.d(TAG, "onClick: isBtEnabled" + mBPresenter.isBtEnabled());
                        if (mBPresenter.isBtEnabled()) {
//                            pairedList.clear();
//                            searchList.clear();
//                            currAddress = "";
//                            device_founded_list.clear();
//                            myHandler.sendEmptyMessage(0x01);
//                            myHandler.sendEmptyMessage(0x02);
                            mBPresenter.setBtEnable(false);
//                            setting_bt_switch.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
                        } else {
                            mBPresenter.setBtEnable(true);
//                            setting_bt_switch.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        pairedAdapter = new BTRecyclerAdapter(getMContext(), pairedList, 0);
        MyLinearLayoutManager linearLayoutManager = new MyLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        history_matching_list.setLayoutManager(linearLayoutManager);

        history_matching_list.setAdapter(pairedAdapter);

        pairedAdapter.setOnItemClickLenster(new BTRecyclerAdapter.OnItemClickLenster() {
            @Override
            public void itemClick(int position, View view) {
                //连接
                //                    mCommand.cancelBtDiscovery();
                if (mBPresenter == null)
                    return;
                if (pairedList == null || pairedList.size() == 0) {
                    Log.d(TAG, "itemClick: pairedList.size() " + pairedList.size());
                    myHandler.sendEmptyMessage(0x01);
                    return;
                }
                final BluetoothBean bean = pairedList.get(position);
                Log.d(TAG, "history_matching_list  onItemClick: state ==" + bean.getState());
                Log.d(TAG, "history_matching_list  onItemClick: state ==" + bean.getState());
                if (bean.getState() == 1) {
//                        mBPresenter.reqBtConnectHfpA2dp(bean.getAddress());//连接
                    final ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), bean.getName() + "?", currentNightMode, 1);
                    confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
                        @Override
                        public void doConfirm() {
                            try {
                                Log.d(TAG, "doConfirm: 连接");
                                mBPresenter.reqBtConnectHfpA2dp(bean.getAddress());//连接
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                            confirmDialog.dismiss();
                        }

                        @Override
                        public void doCancel() {
                            confirmDialog.dismiss();
                        }
                    });
                    confirmDialog.show();
                } else if (bean.getState() == 2) {
                    final ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), bean.getName() + "?", currentNightMode, 0);

                    confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
                        @Override
                        public void doConfirm() {
                            try {
                                Log.d(TAG, "doConfirm: 断开连接");
                                mBPresenter.reqBtDisconnectAll();//断开连接
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                            confirmDialog.dismiss();
                        }

                        @Override
                        public void doCancel() {
                            confirmDialog.dismiss();
                        }
                    });
                    confirmDialog.show();

                }

            }
        });
        pairedAdapter.setOnPairedDeleteListener(new BTRecyclerAdapter.OnPairedDeleteListener() {
            @Override
            public void deleteDevice(final int position, final String address) {
                //删除配对历史中的设备
                if (mBPresenter == null)
                    return;
                if (pairedList == null || pairedList.size() == 0) {
                    Log.d(TAG, "itemClick: pairedList.size() " + pairedList.size());
                    myHandler.sendEmptyMessage(0x01);
                    return;
                }
                BluetoothBean bean = pairedList.get(position);
                final ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), bean.getName() + "?", currentNightMode, 2);

                confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
                    @Override
                    public void doConfirm() {
                        try {
                            if (mBPresenter.reqBtUnpair(address)) {
                                beanList.clear();
                                pairedList.remove(position);
                                if (address.equals(currAddress)) {
                                    currAddress = "";
                                }
                                for (int i = 0; i < searchList.size(); i++) {
                                    BluetoothBean bluetoothBean = searchList.get(i);
                                    if (address.equals(bluetoothBean.getAddress())) {
                                        searchList.remove(i);
                                    }
                                }
                                myHandler.sendEmptyMessage(0x01);
                                myHandler.sendEmptyMessage(0x02);
                                Log.d(TAG, "deleteDevice: mBPresenter.reqBtUnpair(address)==true");
                            } else {
                                Log.d(TAG, "deleteDevice: mBPresenter.reqBtUnpair(address)==false");
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        confirmDialog.dismiss();
                    }

                    @Override
                    public void doCancel() {
                        confirmDialog.dismiss();
                    }
                });
                confirmDialog.show();

            }
        });
        searchAdapter = new BTRecyclerAdapter(getMContext(), searchList, 1);
        MyLinearLayoutManager linearLayoutManager1 = new MyLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        search_list.setLayoutManager(linearLayoutManager1);
        search_list.setAdapter(searchAdapter);
        searchAdapter.setOnItemClickLenster(new BTRecyclerAdapter.OnItemClickLenster() {
            @Override
            public void itemClick(final int position, View view) {
                // 配对 连接
                try {
                    if (mBPresenter == null)
                        return;
                    if (searchList == null || searchList.size() == 0) {
                        Log.d(TAG, "itemClick: searchList.size() " + searchList.size());
                        myHandler.sendEmptyMessage(0x02);
                        return;
                    }
                    final BluetoothBean bean = searchList.get(position);
                    mBPresenter.cancelBtDiscovery();
                    Log.d(TAG, "search_list  onItemClick: state ==" + bean.getState());
                    if (bean.getState() == 0) {
                        final ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), bean.getName() + "?", currentNightMode, 1);

                        confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
                            @Override
                            public void doConfirm() {
                                try {
                                    if (currAddress != "") {
                                        Log.d(TAG, "doConfirm: 先断开，在配对");
                                        mBPresenter.reqBtDisconnectAll(currAddress);//断开连接
                                    }
                                    Log.d(TAG, "doConfirm: 配对");
                                    mBPresenter.reqBtPair(bean.getAddress());//配对
                                    PairBroadcastReceiver.setPairFromPhone(false);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                                confirmDialog.dismiss();
                            }

                            @Override
                            public void doCancel() {
                                confirmDialog.dismiss();
                            }
                        });
                        confirmDialog.show();

                    } else if (bean.getState() == 1) {
                        final ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), bean.getName() + "?", currentNightMode, 1);

                        confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
                            @Override
                            public void doConfirm() {
                                try {
                                    Log.d(TAG, "doConfirm: 配对");
                                    mBPresenter.reqBtConnectHfpA2dp(bean.getAddress());//连接
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                                confirmDialog.dismiss();
                            }

                            @Override
                            public void doCancel() {
                                confirmDialog.dismiss();
                            }
                        });
                        confirmDialog.show();

                    } else if (bean.getState() == 2) {
                        final ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), bean.getName() + "?", currentNightMode, 0);

                        confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
                            @Override
                            public void doConfirm() {
                                try {
                                    Log.d(TAG, "doConfirm: 断开连接");
                                    mBPresenter.reqBtDisconnectAll();//断开连接
//                                    getConnectAddress();
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                                confirmDialog.dismiss();
                            }

                            @Override
                            public void doCancel() {
                                confirmDialog.dismiss();
                            }
                        });
                        confirmDialog.show();
                    }


                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //刷新历史配对列表
//        history_matching_refresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    if (mBPresenter == null || !mBPresenter.isBtEnabled())
//                        return;
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
////                getConnectAddress();
//                try {
//                    mBPresenter.reqBtPairedDevices();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
        //搜索蓝牙
        search_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mBPresenter == null || !mBPresenter.isBtEnabled())
                        return;
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "onClick: search_refresh");
                searchBt();
            }
        });

        myHandler.sendEmptyMessage(0x00);
    }

    private void searchBt() {
//        getConnectAddress();
        try {
            Log.d(TAG, "search_refresh onClick: isBtDiscovering===" + mBPresenter.isBtDiscovering());
            if (!mBPresenter.isBtDiscovering()) {
                Log.d(TAG, "search_refresh onClick: 开始扫描蓝牙...");
                mBPresenter.startBtDiscovery();
            } else {
                mBPresenter.cancelBtDiscovery();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    private List<BluetoothBean> paixu(List<BluetoothBean> list) {
        //对搜索到的蓝牙排序
        if (list != null && list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.size() - i - 1; j++) {
                    BluetoothBean bluetoothBean = list.get(j);
                    BluetoothBean bluetoothBean1 = list.get(j + 1);
                    if (bluetoothBean.getState() < bluetoothBean1.getState()) {
                        BluetoothBean temp = bluetoothBean;
                        list.remove(j);
                        list.add(j, bluetoothBean1);
                        list.remove(j + 1);
                        list.add(j + 1, temp);
                    }
                }
            }
        }
        return list;
    }

    private Handler myHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0x00:
                    if (mBPresenter == null) {
                        Log.d(TAG, "handleMessage:0x00 mBPresenter=====null");
                        break;
                    }

                    Log.d(TAG, "handleMessage setBPresenter:1.91 ");
                    try {
                        if (mBPresenter.getHfpConnectionState() == NfDef.STATE_CONNECTED) {
                            currAddress = mBPresenter.getHfpConnectedAddress();
                        }
                        mBPresenter.reqBtPairedDevices();
//                        boolean btAutoAnswerState = mBPresenter.getBtAutoAnswerState();
                        //20:3c:ae:3e:b2:68
//                        String btLocalAddress = mBPresenter.getBtLocalAddress();
//                        String s = btLocalAddress.replaceAll(":", "");
//                        String substring = s.substring(4);
                        boolean btAutoDownState = mBPresenter.getBtAutoDownState();
                        int condition = mBPresenter.getBtAutoConnectCondition();
                        boolean btEnabled = mBPresenter.isBtEnabled();
                        Log.d(TAG, "handleMessage: btAutoDownState==" + btAutoDownState + " ===btEnabled=" + btEnabled + "  ===condition" + condition);
                        setting_bt_name.setText(mBPresenter.getBtLocalName());
                        if (btAutoDownState) {
                            setting_bt_auto_answer.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
                        } else {
                            setting_bt_auto_answer.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
                        }
                        if (condition == 7) {
                            setting_bt_auto_connect.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
                        } else {
                            setting_bt_auto_connect.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
                        }
                        if (btEnabled) {
                            setting_bt_switch.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
                        } else {
                            setting_bt_switch.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
                            setting_zi.setVisibility(View.GONE);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0x01:
                    pairedList.addAll(beanList);
                    beanList.clear();
                    if (pairedList.size() > 0) {
                        pairedList = paixu(pairedList);
                        history_matching_list.setVisibility(View.VISIBLE);
                        history_matching_tip.setVisibility(View.GONE);
                    } else {
                        history_matching_list.setVisibility(View.GONE);
                        history_matching_tip.setVisibility(View.VISIBLE);
                    }

                    pairedAdapter.notifyDataSetChanged();
                    break;
                case 0x02:
                    Bundle data = message.getData();
                    BluetoothBean bean = (BluetoothBean) data.get("bean");
                    if (bean != null) {
                        searchList.add(bean);
                    }
                    searchList = paixu(searchList);
                    Log.d(TAG, "handleMessage:searchList.size ==" + searchList.size() + "currAddress = " + currAddress);
                    searchAdapter.notifyDataSetChanged();
                    if (searchList.size() > 0) {
                        ViewGroup.LayoutParams lp = search_list.getLayoutParams();
                        if (searchList.size() > 8) {
                            lp.height = 80 * 8;
                        } else {
                            lp.height = 80 * searchList.size();
                        }
                        search_list.setLayoutParams(lp);
                        search_list.setVisibility(View.VISIBLE);
                        search_tip.setVisibility(View.GONE);

                    } else {
                        search_list.setVisibility(View.GONE);
                        search_tip.setVisibility(View.VISIBLE);
                    }

                    break;
                case 0x88:
                    //扫描蓝牙完毕
                    stopRotate();
                    search_refresh.setImageDrawable(getMContext().getDrawable(R.drawable.select_refresh));
                    break;
                case 0x89:
                    //开始扫描蓝牙
                    searchList.clear();
                    device_founded_list.clear();
                    search_refresh.setImageDrawable(getMContext().getDrawable(R.drawable.icon_loading));
                    startRotate();
                    break;
                case 0x03:
                    try {
                        setting_bt_name.setText(mBPresenter.getBtLocalName());
                        mBPresenter.reqBtPairedDevices();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                    setting_bt_switch.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_open));
                    setting_zi.setVisibility(View.VISIBLE);
                    searchBt();
                    break;
                case 0x04:
                    pairedList.clear();
                    searchList.clear();
                    currAddress = "";
                    device_founded_list.clear();
                    myHandler.sendEmptyMessage(0x01);
                    myHandler.sendEmptyMessage(0x02);
                    setting_bt_switch.setImageDrawable(getMContext().getDrawable(R.drawable.bt_setting_btn_close));
                    setting_zi.setVisibility(View.GONE);
                    break;

                case 0x05:
                    if (isFromBtPhone) {
                        isFromBtPhone = false;
                        Log.d(TAG, "handleMessage: 来自电话，finish Settings");
                        getActivity().finish();
                    } else {
                        Log.d(TAG, "handleMessage: 不是来自电话");
                    }
                    break;
            }
            return false;
        }
    });


    @Override
    public void onServiceConnectedChanged(boolean isConnected) {
        if (isConnected) {
            myHandler.sendEmptyMessage(0x00);
        } else {
            Log.d(TAG, "onServiceConnectedChanged: 服务绑定失败");
        }

    }

    @Override
    public void onEnableChanged(boolean b) {
        Log.d(TAG, "onEnableChanged: 蓝牙状态==" + b);
        if (b) {
            //蓝牙打开
            myHandler.sendEmptyMessage(0x03);

        } else {
            myHandler.sendEmptyMessage(0x04);
        }
    }

    @Override
    public void onConnectedChanged(String address, int isConnected) {
        Log.d(TAG, "onConnectedChanged: 蓝牙连接状态" + isConnected);




    }



    @Override
    public void onHfpStateChanged(String address, int isConnected) {
        Log.d(TAG, "onHfpStateChanged: address==" + address + "--isConnected==" + isConnected);
            if (isConnected == NforeBtBaseJar.CONNECT_DISCONNECT) {//蓝牙已断开连接
                //蓝牙已断开连接
                currAddress = "";
                for (int i = 0; i < searchList.size(); i++) {
                    searchList.get(i).setState(1);
                }

            } else if (isConnected == NforeBtBaseJar.CONNECT_SUCCESSED) {//蓝牙连接上了
                currAddress = address;
                for (int i = 0; i < searchList.size(); i++) {
                    if (searchList.get(i).getAddress().equals(address)) {
                        searchList.get(i).setState(2);
                    }else {
                        searchList.get(i).setState(1);
                    }
                }
                myHandler.sendEmptyMessage(0x05);
            }

        Log.d(TAG, "onHfpStateChanged: isConnected==" + isConnected + "===currAddress" + currAddress);
        try {
            mBPresenter.reqBtPairedDevices();//重新获取已配对设备
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //更新设备状态
        myHandler.sendEmptyMessage(0x02);
    }


    @Override
    public void onHfpAudioStateChanged(String s, int i, int i1) {

    }

    @Override
    public void onAvrcpStateChanged(String s, int b) {
        Log.d(TAG, "onAvrcpStateChanged: " + b);
    }

    @Override
    public void onA2dpStateChanged(String s, int b) {
        Log.d(TAG, "onA2dpStateChanged: " + b);
    }

    @Override
    public void onAdapterDiscoveryStarted() {
        Log.d(TAG, "onAdapterDiscoveryStarted: 开始扫描蓝牙");
        myHandler.sendEmptyMessage(0x89);
    }

    @Override
    public void onAdapterDiscoveryFinished() {
        Log.d(TAG, "onAdapterDiscoveryFinished: 蓝牙扫描完毕");
        myHandler.sendEmptyMessage(0x88);
    }

    @Override
    public void retPairedDevices(int elements, String[] address, String[] name, int[] ints) {
        Log.i(TAG, ">>>>>>>>>>>retPairedDevices<<<<<<<<<<<< " + elements);
        //已配对列表
        pairedList.clear();
        beanList.clear();
        if (elements > 0) {
            for (int i = 0; i < elements; i++) {
                Log.d(TAG, "retPairedDevices: name===" + name[i] + "====address[i]==" + address[i]);
                if (name[i] == null) {
                    name[i] = address[i];
                }
                int state = 1;
                if (address[i].equals(currAddress)) {
                    state = 2;
                    Log.d(TAG, "retPairedDevices: currAddress连接");
                }
                Log.d(TAG, "retPairedDevices: name===" + name[i] + "====address[i]==" + address[i] + "===state===" + state + "==currAddress===" + currAddress);
                BluetoothBean bluetoothBean = new BluetoothBean(name[i], state, address[i]);
                beanList.add(bluetoothBean);
//                pairedList.add(bluetoothBean);
            }
        }
        myHandler.sendEmptyMessage(0x01);
//        isGetPaired = false;
//        history_matching_refresh.setImageDrawable(getMContext().getDrawable(R.drawable.select_refresh));
//        stopRotate(history_matching_refresh);
    }

    @Override
    public void onDeviceFound(String address, String name) {
        Log.d(TAG, "------------------onDeviceFound()-------------------- " + address);
        if (!device_founded_list.contains(address) && address != NfDef.DEFAULT_ADDRESS) {
            device_founded_list.add(address);
            int state = 0;//未配对
            if (pairedList.size() > 0) {
                for (int i = 0; i < pairedList.size(); i++) {
                    if (address.equals(pairedList.get(i).getAddress())) {
                        state = 1;//已配对过
                    }
                }
            }
            if (address.equals(currAddress)) {
                state = 2;
            }
            BluetoothBean bean = new BluetoothBean(name, state, address);
            Message message = new Message();
            message.what = 0x02;
            Bundle bundle = new Bundle();
            bundle.putSerializable("bean", bean);
            message.setData(bundle);

            myHandler.sendMessage(message);
            Log.d(TAG, "onDeviceFound: sendMessage");
        }
    }

    @Override
    public void onDeviceBondStateChanged(String address, String name, int i) {
        Log.i(TAG, ">>>>>>>>>>>onDeviceBondStateChanged<<<<<<<配对成功<<<<< ");
        if (i == NfDef.BOND_BONDED) {
            if (mBPresenter == null)
                return;
            try {
                Log.d(TAG, "onDeviceBondStateChanged: 获取已配对设备");
                mBPresenter.reqBtPairedDevices();//重新获取已配对设备
//                mBPresenter.reqBtConnectHfpA2dp(address);//如果配对成功，连接设备
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onLocalAdapterNameChanged(String s) {

    }


    /**
     * 开启动画
     */
    public void startRotate() {
        Log.d(TAG, "bt   startRotate: ");
        Animation operatingAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.version_image_rotate);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        if (operatingAnim != null) {
            search_refresh.startAnimation(operatingAnim);
        }
    }

    /**
     * 关闭动画
     */
    public void stopRotate() {
        Log.d(TAG, "bt  stopRotate: ");
        search_refresh.clearAnimation();
    }


}