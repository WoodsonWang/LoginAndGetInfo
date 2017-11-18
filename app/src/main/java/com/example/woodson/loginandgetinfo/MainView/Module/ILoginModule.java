package com.example.woodson.loginandgetinfo.MainView.Module;

import android.util.Log;

import com.example.woodson.loginandgetinfo.Entity.StringResult;
import com.example.woodson.loginandgetinfo.Entity.user;
import com.example.woodson.loginandgetinfo.MainView.Presenter.forBackListener;
import com.example.woodson.loginandgetinfo.MainView.Presenter.registListener;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Woodson on 2017/11/18.
 */

public class ILoginModule implements LoginModule {
    OkHttpClient okHttpClient = new OkHttpClient();
    Gson gson = new Gson();
    @Override
    public void login(String username, String password, final forBackListener listener) {


        final Request request = new Request.Builder()
                .url("http://139.129.203.32/StudentSystem/Login?name="+username+"&pwd="+password)
                .build();
        Log.i("hello", "login: ");
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                listener.onError();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String s = response.body().string();
                Log.i("hello", "login: "+s);

               StringResult result =  gson.fromJson(s, StringResult.class);
                if ("success".equals(result.getResult())){
                    listener.onSuccess();
                }else {
                    listener.onError();
                }
            }
        });
    }

    @Override
    public void Regist(final String username, final String password, String rePassword, final registListener forBackListener) {
        Request request = new Request.Builder()
                .url("http://139.129.203.32/StudentSystem/Register?name="+username+"&pwd="+password)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                forBackListener.error();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String s = response.body().string();

                StringResult result = gson.fromJson(s,StringResult.class);
                if ("success".equals(result.getResult())){
                    forBackListener.success(new user(username,password));
                    return;
                }
                forBackListener.error();
            }
        });
    }


}
