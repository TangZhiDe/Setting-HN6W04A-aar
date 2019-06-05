package com.adayo.component.settings.model;

import android.content.Context;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.bean.UsersAccountInfo;
import com.adayo.component.settings.utils.SPUtils;
import com.google.gson.Gson;

/**
 * @author damanz
 * @className AccountSettingModel
 * @date 2018-09-07.
 */
public class AccountSettingModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + AccountSettingModel.class.getSimpleName();
    private static AccountSettingModel mModel = null;
    private Context mContext;

    private AccountSettingModel(Context context) {
        this.mContext = context;
    }

    public static AccountSettingModel getAccountSettingModelInstance(Context context) {
        if (mModel == null) {
            synchronized (AccountSettingModel.class) {
                if (mModel == null) {
                    mModel = new AccountSettingModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    public UsersAccountInfo getUsersAccountInfo() {
        try {
            String userInfo = SPUtils.getString(mContext, FPConstant.EXTRA_ACCOUNT_INFO, "");
            return new Gson().fromJson(userInfo, UsersAccountInfo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setUsersAccountInfo(UsersAccountInfo info) {
        String json = new Gson().toJson(info);
        SPUtils.put(mContext, FPConstant.EXTRA_ACCOUNT_INFO, json);
    }

    public void exitLogin() {
        SPUtils.put(mContext, FPConstant.EXTRA_ACCOUNT_INFO, "");
    }
}
