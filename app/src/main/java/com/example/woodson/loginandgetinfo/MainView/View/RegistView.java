package com.example.woodson.loginandgetinfo.MainView.View;

import android.view.View;

import com.example.woodson.loginandgetinfo.Entity.user;

/**
 * Created by Woodson on 2017/11/18.
 */

public interface RegistView extends View.OnClickListener{
    String getUsername();
    String getPassword();
    String getRepassword();
    void isSuccess(user user);
    void showError();
}
