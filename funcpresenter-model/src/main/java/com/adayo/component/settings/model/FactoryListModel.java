package com.adayo.component.settings.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.bean.FactoryListBean;
import com.adayo.proxy.settings.contants.SettingsContantsDef;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damanz
 * @className FactoryListModel
 * @date 2018-09-11.
 */
public class FactoryListModel extends BaseModel  {

    public static final String TAG = FPConstant.TAG + FactoryListModel.class.getSimpleName();
    private static FactoryListModel mModel = null;
    private Context mContext;


    public FactoryListModel(Context context) {
        this.mContext = context;
    }

    public static FactoryListModel getFactoryListModelInstance(Context context) {
        if (mModel == null) {
            synchronized (FactoryListModel.class) {
                if (mModel == null) {
                    mModel = new FactoryListModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
      super.init();
    }

    public List<FactoryListBean> getSoftwareVersion() {
        List<FactoryListBean> list = new ArrayList<>();
        byte[] bytes = new byte[]{FPConstant.SYS_CONFIG_MCU,FPConstant.SYS_CONFIG_OS,
                FPConstant.SYS_CONFIG_MODLE,FPConstant.SYS_CONFIG_MPU};
        String[] out = new String[bytes.length];
        int i = mSettingsManager.doFunc_SystemConfigInfo(mContext, SettingsContantsDef.MODE_GET,
                FPConstant.emptyArr, out, bytes);
        list.add(new FactoryListBean("MCU",out[0]));
        list.add(new FactoryListBean("OS",out[1]));
        list.add(new FactoryListBean("MODEL",out[2]));
        list.add(new FactoryListBean("MPU",out[3]));
        logList(list);
        return list;
    }

    public List<FactoryListBean> getAppVersion() {
        List<FactoryListBean> list = new ArrayList<>();
        PackageManager packageManager = mContext.getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            CharSequence label = packageManager.getApplicationLabel(info.applicationInfo);
            Log.d(TAG, "getAppVersion: "+label);
            list.add(new FactoryListBean(info.applicationInfo.loadLabel(packageManager).toString(),
                    info.versionName));
        }
        logList(list);
        return list;
    }

    private void logList(List<FactoryListBean> list) {
        for (FactoryListBean listBean : list) {
            Log.d(TAG, "logList: " + listBean.toString());
        }
    }

    public List<FactoryListBean> getDiagnosticCode() {
        List<FactoryListBean> list = new ArrayList<>();
//        boolean b = mErrorCode.connectErrorCodeServer();
//        if(b){
//            byte[] bytes = new byte[1124];
//            boolean errorcode = mErrorCode.getErrorcode(bytes, bytes.length);
//        }
        return list;
    }

    public List<FactoryListBean> getHiddenApplication() {
        List<FactoryListBean> list = new ArrayList<>();
        PackageManager packageManager = mContext.getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            list.add(new FactoryListBean(info.applicationInfo.loadLabel(packageManager).toString(),
                    info.packageName,false));
        }
        logList(list);
        return list;
    }
}
