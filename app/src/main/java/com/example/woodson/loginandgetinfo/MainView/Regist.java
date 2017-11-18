package com.example.woodson.loginandgetinfo.MainView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.woodson.loginandgetinfo.Entity.user;
import com.example.woodson.loginandgetinfo.MainView.Presenter.RegistPresenter;
import com.example.woodson.loginandgetinfo.MainView.View.RegistView;
import com.example.woodson.loginandgetinfo.R;

public class Regist extends AppCompatActivity implements RegistView{
private RegistPresenter registPresenter;
    private Button btnRegist;
    private EditText edUsername,edPassword,edRePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        registPresenter = new RegistPresenter(this);
        initData();
    }

    private void initData() {
        btnRegist= (Button) findViewById(R.id.regist);
        edUsername = (EditText) findViewById(R.id.getusername);
        edPassword = (EditText) findViewById(R.id.getupassword);
        edRePassword = (EditText) findViewById(R.id.getrepwd);
        btnRegist.setOnClickListener(this);
    }

    @Override
    public String getUsername() {
        return edUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return edPassword.getText().toString().trim();
    }

    @Override
    public String getRepassword() {
        return edRePassword.getText().toString().trim();
    }

    @Override
    public void isSuccess(final user user) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(Regist.this,LoginActivity.class);
                in.putExtra("user",user);
                startActivity(in);
                finish();
            }
        });
    }


    @Override
    public void showError() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regist:
                registPresenter.regist(getUsername(),getPassword(),getRepassword());
                break;
        }
    }
}
