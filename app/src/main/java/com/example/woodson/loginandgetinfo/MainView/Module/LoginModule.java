package com.example.woodson.loginandgetinfo.MainView.Module;

import com.example.woodson.loginandgetinfo.MainView.Presenter.forBackListener;
import com.example.woodson.loginandgetinfo.MainView.Presenter.registListener;

/**
 * Created by Woodson on 2017/11/18.
 */

public interface LoginModule {
    void login(String username, String password, forBackListener forBackListener);
    void Regist(String username,String password,String rePassword,registListener forBackListener);
}
