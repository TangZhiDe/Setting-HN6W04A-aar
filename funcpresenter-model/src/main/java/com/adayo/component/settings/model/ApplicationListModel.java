package com.adayo.component.settings.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.adayo.component.settings.constant.FPConstant;

import java.util.List;

/**
 * @author damanz
 * @className ApplicationListModel
 * @date 2018-09-07.
 */
public class ApplicationListModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + ApplicationListModel.class.getSimpleName();
    private static ApplicationListModel mModel = null;
    private Context mContext;

    private ApplicationListModel(Context context) {
        this.mContext = context;
    }

    public static ApplicationListModel getApplicationListModelInstance(Context context) {
        if (mModel == null) {
            synchronized (ApplicationListModel.class) {
                if (mModel == null) {
                    mModel = new ApplicationListModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    public List<PackageInfo> getAppList() {
        PackageManager packageManager = mContext.getPackageManager();
        return packageManager.getInstalledPackages(0);
    }

    public void cleanCache(PackageInfo info) {
//        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
//                || !Environment.isExternalStorageRemovable()) {
//            return context.getExternalCacheDir().getPath();
//        } else {
//            return context.getCacheDir().getPath();
//        }
    }

    public void uninstall(PackageInfo info) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + info.packageName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
