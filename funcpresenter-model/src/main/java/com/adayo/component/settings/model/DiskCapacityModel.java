package com.adayo.component.settings.model;

import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;

import com.adayo.component.settings.constant.FPConstant;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author damanz
 * @className DiskCapacityModel
 * @date 2018-09-07.
 */
public class DiskCapacityModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + DiskCapacityModel.class.getSimpleName();
    private static DiskCapacityModel mModel = null;
    private Context mContext;
    private StorageManager storageManager;

    private DiskCapacityModel(Context context) {
        this.mContext = context;
    }

    public static DiskCapacityModel getDiskCapacityModelInstance(Context context) {
        if (mModel == null) {
            synchronized (DiskCapacityModel.class) {
                if (mModel == null) {
                    mModel = new DiskCapacityModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    /**
     * 获得APP总大小
     *
     * @return
     */
    public long getAppTotalSize() {
        long total = 0;
        StorageStatsManager storageManager = (StorageStatsManager) mContext.getSystemService(Context.STORAGE_STATS_SERVICE);
        PackageManager packageManager = mContext.getPackageManager();
        List<ApplicationInfo> applications = packageManager.getInstalledApplications(0);
        for (ApplicationInfo info : applications) {
            try {
                StorageStats stats = storageManager.queryStatsForUid(info.storageUuid, info.uid);
                total = total + stats.getAppBytes() + stats.getCacheBytes() + stats.getDataBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return total;
    }

    /**
     * 获得SD卡总大小
     *
     * @return
     */
    public long getSDTotalSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return blockSize * totalBlocks;
    }

    /**
     * 获得sd卡剩余容量，即可用大小
     *
     * @return
     */
    public long getSDAvailableSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return blockSize * availableBlocks;
    }
}