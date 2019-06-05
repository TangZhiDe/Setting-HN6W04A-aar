package com.adayo.component.settings.model;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.os.RemoteException;
import android.telephony.TelephonyManager;

import com.adayo.component.settings.constant.FPConstant;

import java.util.Calendar;
import java.util.List;

/**
 * @author damanz
 * @className TrafficDataModel
 * @date 2018-09-07.
 */
public class TrafficDataModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + TrafficDataModel.class.getSimpleName();
    private static TrafficDataModel mModel = null;
    private Context mContext;

    private TrafficDataModel(Context context) {
        this.mContext = context;
    }

    public static TrafficDataModel getTrafficDataModelInstance(Context context) {
        if (mModel == null) {
            synchronized (TrafficDataModel.class) {
                if (mModel == null) {
                    mModel = new TrafficDataModel(context);
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
        return ApplicationListModel.getApplicationListModelInstance(mContext).getAppList();
    }

    public long getAppTrafficData(PackageInfo info) {
        NetworkStatsManager networkStatsManager = (NetworkStatsManager) mContext.getSystemService(Context.NETWORK_STATS_SERVICE);
        // 获取subscriberId
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        long summaryRx = 0;
        long summaryTx = 0;
        long summaryTotal = 0;
        try {
            String subId = tm.getSubscriberId();
            NetworkStats summaryStats;
            NetworkStats.Bucket summaryBucket = new NetworkStats.Bucket();
            summaryStats = networkStatsManager.querySummary(ConnectivityManager.TYPE_MOBILE, subId, getTimesMonthMorning(), System.currentTimeMillis());
            do {
                summaryStats.getNextBucket(summaryBucket);
                int summaryUid = summaryBucket.getUid();
                if (info.applicationInfo.uid == summaryUid) {
                    summaryRx += summaryBucket.getRxBytes();
                    summaryTx += summaryBucket.getTxBytes();
                }
                summaryTotal += summaryRx + summaryTx;
            } while (summaryStats.hasNextBucket());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return summaryTotal;
    }

    public static long getTimesMonthMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }
}
