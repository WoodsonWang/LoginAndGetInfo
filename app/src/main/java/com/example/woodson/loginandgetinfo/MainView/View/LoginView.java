package com.example.woodson.loginandgetinfo.MainView.View;

import android.view.View;

import com.example.woodson.loginandgetinfo.Entity.user;

/**
 * Created by Woodson on 2017/11/18.
 */

public interface LoginView extends View.OnClickListener{
    user getUser();
    void goToActivity();
    void showError();
}
