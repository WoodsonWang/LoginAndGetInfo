package com.example.woodson.loginandgetinfo.Entity;

/**
 * Created by Woodson on 2017/11/18.
 */

public class StringResult {
    private String result;
    private String des;
    private user user;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public com.example.woodson.loginandgetinfo.Entity.user getUser() {
        return user;
    }

    public void setUser(com.example.woodson.loginandgetinfo.Entity.user user) {
        this.user = user;
    }
}
