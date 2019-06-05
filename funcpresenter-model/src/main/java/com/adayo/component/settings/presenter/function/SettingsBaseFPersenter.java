package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import com.adayo.app.base.BaseFunctionPresenter;
import com.adayo.component.settings.bfpcontract.IBusinessFuncpresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.BaseModel;

/**
 * @author damanz
 * @className SettingsBaseFPersenter
 * @date 2018-08-08.
 */
public abstract class SettingsBaseFPersenter<M extends BaseModel>
        extends BaseFunctionPresenter<IBusinessFuncpresenter> {

    public static final String TAG = FPConstant.TAG + SettingsBaseFPersenter.class.getSimpleName();
    private static final String HANDLER_THREAD_NAME = "com.adayo.component.settings.SettingsBaseFPersenter";
    private HandlerThread mHandlerThread;
    protected Handler mHandler;
    protected IBusinessFuncpresenter mBPresenter;
    protected Context mContext;
    protected M mModel;

    public SettingsBaseFPersenter(Context context) {
        this.mContext=context;
        mHandlerThread = new HandlerThread(HANDLER_THREAD_NAME);
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.d(TAG, "handleMessage: " + msg.what);
                Log.d(TAG, "handleMessage mBPresenter: " + mBPresenter);
                mBPresenter.handleEvent(msg);
            }
        };
    }

    @Override
    public void registerBusinessPresenter(IBusinessFuncpresenter iBusinessFuncpresenter) {
        mBPresenter=iBusinessFuncpresenter;
    }

    @Override
    public void unregisterBusinessPresenter() {
        mBPresenter = null;
        mHandlerThread.quit();
        if (mHandler != null) {
            mHandler.getLooper().quit();
            mHandler = null;
        }
    }

    @Override
    public void init() {
        mModel.init();
    }

    public void sendMessage(int what, Bundle bundle) {
        mHandler.obtainMessage(what, bundle).sendToTarget();
    }
}
