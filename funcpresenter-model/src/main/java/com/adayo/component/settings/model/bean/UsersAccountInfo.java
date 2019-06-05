package com.adayo.component.settings.model.bean;

import java.io.Serializable;

/**
 * @author damanz
 * @className UsersAccountInfo
 * @date 2018-09-21.
 */
public class UsersAccountInfo implements Serializable {
    private String userName;
    private String passWord;
    private String eMailAddress;

    public UsersAccountInfo() {
    }

    public UsersAccountInfo(String userName, String passWord, String eMailAddress) {
        this.userName = userName;
        this.passWord = passWord;
        this.eMailAddress = eMailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }
}
