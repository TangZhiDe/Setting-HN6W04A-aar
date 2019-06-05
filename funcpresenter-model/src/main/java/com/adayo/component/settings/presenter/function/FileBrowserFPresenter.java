package com.adayo.component.settings.presenter.function;

import android.content.Context;
import android.os.Bundle;

import com.adayo.component.settings.bfpcontract.IFileBrowserFuncPresenter;
import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.FileBrowserModel;
import com.adayo.component.settings.model.bean.FileBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author damanz
 * @className FileBrowserFPresenter
 * @date 2018-09-14.
 */
public class FileBrowserFPresenter extends SettingsBaseFPersenter<FileBrowserModel> implements IFileBrowserFuncPresenter {

    public FileBrowserFPresenter(Context context) {
        super(context);
        mModel=FileBrowserModel.getFileBrowserModelInstance(mContext);
    }

    @Override
    public void getFileRootPath(String path) {
        List<FileBean> list = mModel.getFileRootPath(path);
        Bundle bundle = new Bundle();
        bundle.putSerializable(FPConstant.EXTRA_FILE_BROWSER, (Serializable) list);
        sendMessage(FPConstant.FILE_BROWSER_HANDLER_ID,bundle);
    }
}
