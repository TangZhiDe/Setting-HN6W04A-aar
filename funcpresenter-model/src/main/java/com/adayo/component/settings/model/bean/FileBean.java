package com.adayo.component.settings.model.bean;

import java.io.File;
import java.io.Serializable;

/**
 * @author damanz
 * @className FileBean
 * @date 2018-09-17.
 */
public class FileBean implements Serializable {
    private String pathName;
    private File parentFile;
    private boolean isDirectory;

    public FileBean() {
    }

    public FileBean(String pathName, File parentFile, boolean isDirectory) {
        this.pathName = pathName;
        this.parentFile = parentFile;
        this.isDirectory = isDirectory;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public File getParentFile() {
        return parentFile;
    }

    public void setParentFile(File parentFile) {
        this.parentFile = parentFile;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "pathName='" + pathName + '\'' +
                ", parentFile=" + parentFile +
                ", isDirectory=" + isDirectory +
                '}';
    }
}
