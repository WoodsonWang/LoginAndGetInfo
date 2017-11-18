package com.example.woodson.loginandgetinfo.MainView.Presenter;

import com.example.woodson.loginandgetinfo.MainView.Module.ILoginModule;
import com.example.woodson.loginandgetinfo.MainView.Module.LoginModule;
import com.example.woodson.loginandgetinfo.MainView.View.LoginView;

/**
 * Created by Woodson on 2017/11/18.
 */

public class LoginPresenter implements forBackListener{
    private LoginModule loginModule;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView){
        loginModule = new ILoginModule();
        this.loginView = loginView;
    }

    public void Login(String username,String pwd){
        loginModule.login(username,pwd,this);
    }

    @Override
    public void onSuccess() {
        loginView.goToActivity();
    }

    @Override
    public void onError() {
        loginView.showError();
    }
}
