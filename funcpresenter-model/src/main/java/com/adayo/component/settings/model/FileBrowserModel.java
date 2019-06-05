package com.adayo.component.settings.model;

import android.content.Context;
import android.util.Log;

import com.adayo.component.settings.constant.FPConstant;
import com.adayo.component.settings.model.bean.FileBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author damanz
 * @className FileBrowserModel
 * @date 2018-09-14.
 */
public class FileBrowserModel extends BaseModel {
    public static final String TAG = FPConstant.TAG + FileBrowserModel.class.getSimpleName();
    private static FileBrowserModel mModel = null;
    private Context mContext;

    private FileBrowserModel(Context context) {
        this.mContext = context;
    }

    public static FileBrowserModel getFileBrowserModelInstance(Context context) {
        if (mModel == null) {
            synchronized (FileBrowserModel.class) {
                if (mModel == null) {
                    mModel = new FileBrowserModel(context);
                }
            }
        }
        return mModel;
    }

    @Override
    public void init() {
        super.init();
    }

    public List<FileBean> getFileRootPath(String path) {
        Log.d(TAG, "getFileRootPath: " + path);
        List<FileBean> list = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            list.add(new FileBean(f.getName(), f.getParentFile(), f.isDirectory()));
        }
        for (FileBean bean : list) {
            Log.d(TAG, "getFileRootPath: " + bean.toString());
        }
        return list;
    }
}
