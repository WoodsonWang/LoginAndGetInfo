package com.example.woodson.loginandgetinfo.MainView.Presenter;

import com.example.woodson.loginandgetinfo.Entity.user;

/**
 * Created by Woodson on 2017/11/18.
 */

public interface registListener {
    void success(user user);
    void error();
}
