package com.linear.sharedpre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity  {

    private EditText etName,etPassword;
    private Button btnLogin;

    private UserLocalDatabase userLocalDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLocalDatabase = new UserLocalDatabase(getApplicationContext());

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String password = etPassword.getText().toString();

                if(name.equals("user") && password.equals("123456")){
                    userLocalDatabase.setLogin(true);
                    userLocalDatabase.setUserName(name);
                    finish();
                }
            }
        });
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.user_name);
        etPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);
    }
}
