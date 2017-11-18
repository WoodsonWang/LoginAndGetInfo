package com.example.woodson.loginandgetinfo.Entity;

import java.io.Serializable;

/**
 * Created by Woodson on 2017/11/18.
 */

public class user implements Serializable{
    private String  id;
    private String userName;
    private String passWord;

    public user(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
