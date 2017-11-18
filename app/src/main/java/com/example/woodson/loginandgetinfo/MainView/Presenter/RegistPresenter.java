package com.example.woodson.loginandgetinfo.MainView.Presenter;

import com.example.woodson.loginandgetinfo.Entity.user;
import com.example.woodson.loginandgetinfo.MainView.Module.ILoginModule;
import com.example.woodson.loginandgetinfo.MainView.View.RegistView;

/**
 * Created by Woodson on 2017/11/18.
 */

public class RegistPresenter implements registListener {
    private ILoginModule module;
    private RegistView view;
    public RegistPresenter(RegistView view){
        this.view = view;
        module = new ILoginModule();

    }

    public void regist(String username,String password,String rePassword){
        module.Regist(username,password,rePassword,this);

    }


    @Override
    public void success(user user) {
        view.isSuccess(user);
    }

    @Override
    public void error() {

    }
}
