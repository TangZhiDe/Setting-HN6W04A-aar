package com.adayo.component.settings.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

import com.adayo.component.settings.constant.EnumConstant;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.bean.Apn;

/**
 * @author damanz
 * @className ApnDataChangedModel
 * @date 2018-09-07.
 */
public class ApnDataChangedModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + ApnDataChangedModel.class.getSimpleName();
    private static ApnDataChangedModel mModel = null;
    private Context mContext;

    private ApnDataChangedModel(Context context) {
        this.mContext = context;
    }

    public static ApnDataChangedModel getApnDataChangedModelInstance(Context context) {
        if (mModel == null) {
            synchronized (ApnDataChangedModel.class) {
                if (mModel == null) {
                    mModel = new ApnDataChangedModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }


    public Apn getApnData(String id) {
        Apn apn = new Apn();
        if (TextUtils.equals("", id)) {//新增
            apn.setMcc("460");
            apn.setMnc("01");
            apn.setAuthentication(EnumConstant.AUTHENTICATION_TYPE.NONE.getName());
            apn.setBearingSystem(EnumConstant.BEARING_SYSTEM.NONE.getName());
            apn.setApnAgreement(EnumConstant.APN_AGREEMENT.IPv4.getName());
            apn.setMvnoType(EnumConstant.MVNO_TYPE.NONE.getName());
        } else {
            String projection[] = {"_id"};
            Cursor cr = mContext.getContentResolver().query(FPConstant.APN_TABLE_URI, projection, null, null, null);
            int i = 0;
            while (cr != null && cr.moveToNext()) {
                String _id = cr.getString(cr.getColumnIndex("_id"));
                if (TextUtils.equals(_id, id)) {
                    apn.setId(cr.getString(cr.getColumnIndex("_id")));
                    apn.setApnName(cr.getString(cr.getColumnIndex("name")));
                    apn.setApn(cr.getString(cr.getColumnIndex("apn")));
                    apn.setProxy(cr.getString(cr.getColumnIndex("proxy")));
                    apn.setPort(cr.getString(cr.getColumnIndex("port")));
                    apn.setApnUserName(cr.getString(cr.getColumnIndex("user")));
                    apn.setApnUserPwd(cr.getString(cr.getColumnIndex("password")));
                    apn.setApnServer(cr.getString(cr.getColumnIndex("server")));
                    apn.setApnMmsc(cr.getString(cr.getColumnIndex("mmsc")));
                    apn.setMmsProxy(cr.getString(cr.getColumnIndex("mmsproxy")));
                    apn.setMmsPort(cr.getString(cr.getColumnIndex("mmsport")));
                    apn.setMcc(cr.getString(cr.getColumnIndex("mcc")));
                    apn.setMnc(cr.getString(cr.getColumnIndex("mnc")));
                    apn.setAuthentication(cr.getString(cr.getColumnIndex("authtype")));
                    apn.setApnType(cr.getString(cr.getColumnIndex("type")));
                    apn.setApnAgreement(cr.getString(cr.getColumnIndex("protocol")));
                    apn.setBearingSystem(cr.getString(cr.getColumnIndex("bearer")));
                    apn.setMvnoType(cr.getString(cr.getColumnIndex("mvno_type")));
                    apn.setMvnoValue(cr.getString(cr.getColumnIndex("mvno_match_data")));
                    apn.setApnDataRoaming(cr.getString(cr.getColumnIndex("roaming_protocol")));
                    apn.setNumeric(cr.getString(cr.getColumnIndex("numeric")));
                    apn.setCurrent(cr.getString(cr.getColumnIndex("current")));
                    apn.setEnabled(cr.getInt(cr.getColumnIndex("carrier_enabled")) == 1);
//                    apn.setEnabled("1".equals(apn.getCurrent()));

                    break;
                }
            }

        }
        Log.d(TAG, "getApnData: " + apn.toString());
        return apn;
    }

    public void addApn(Apn apn) {
        String projection[] = {"_id"};
        Cursor cr = mContext.getContentResolver().query(FPConstant.APN_TABLE_URI, projection, null, null, null);
        int i = 0;
        while (cr != null && cr.moveToNext()) {
            String _id = cr.getString(cr.getColumnIndex("_id"));
            if (TextUtils.equals(_id, apn.getId())) {
                Log.d(TAG, "addApn: delete");
                mContext.getContentResolver().delete(FPConstant.APN_TABLE_URI,
                        "_id",new String[]{apn.getId()});
                break;
            }
        }
        ContentValues values = new ContentValues();
        values.put("name",apn.getApnName());
        values.put("apn", apn.getApn());
        values.put("proxy",apn.getProxy());
        values.put("port", apn.getPort());
        values.put("user",apn.getApnUserName());
        values.put("password", apn.getApnUserPwd());
        values.put("server",apn.getApnServer());
        values.put("mmsc",apn.getApnMmsc());
        values.put("mmsproxy",apn.getMmsProxy());
        values.put("mmsport",apn.getMmsPort());
        values.put("mcc",apn.getMcc());
        values.put("mnc",apn.getMnc());
        values.put("authtype",apn.getAuthentication());
        values.put("type",apn.getApnType());
        values.put("protocol",apn.getApnAgreement());
        values.put("bearer",apn.getBearingSystem());
        values.put("mvno_type",apn.getMvnoType());
        values.put("mvno_match_data",apn.getMvnoValue());
        values.put("roaming_protocol",apn.getApnDataRoaming());
        values.put("numeric",apn.getNumeric());
        values.put("current",apn.getCurrent());
        values.put("carrier_enabled",apn.getEnabled());
        mContext.getContentResolver().insert(FPConstant.APN_TABLE_URI,values);
    }
}
