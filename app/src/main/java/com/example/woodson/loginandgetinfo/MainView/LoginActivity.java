package com.example.woodson.loginandgetinfo.MainView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.woodson.loginandgetinfo.Entity.user;
import com.example.woodson.loginandgetinfo.MainActivity;
import com.example.woodson.loginandgetinfo.MainView.Presenter.LoginPresenter;
import com.example.woodson.loginandgetinfo.MainView.View.LoginView;
import com.example.woodson.loginandgetinfo.R;

public class LoginActivity extends AppCompatActivity implements LoginView{
private LoginPresenter presenter;
    private EditText getUsername,getPwd;
    private Button btnLogin;
    private TextView regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        initData();
    }

    private void initData() {
        getUsername = (EditText) findViewById(R.id.getusername);
        getPwd = (EditText) findViewById(R.id.getpwd);
        btnLogin = (Button) findViewById(R.id.login);
        regist = (TextView) findViewById(R.id.regist);
        regist.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public user getUser() {

        return new user(getUsername.getText().toString().trim(), getPwd.getText().toString().trim());
    }

    @Override
    public void goToActivity() {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
        finish();
    }

    @Override
    public void showError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                user user = getUser();
                presenter.Login(user.getUserName(),user.getPassWord());
                break;
            case R.id.regist:
                Intent intent = new Intent(this,Regist.class);
                startActivity(intent);
                break;

        }
    }
}
