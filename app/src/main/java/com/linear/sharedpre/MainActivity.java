package com.linear.sharedpre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    UserLocalDatabase userLocalDatabase;

    private Button btnLogout;
    private TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userLocalDatabase = new UserLocalDatabase(getApplicationContext());

        btnLogout = (Button) findViewById(R.id.btn_logout);
        tvUserName = (TextView) findViewById(R.id.user_name);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLocalDatabase.setLogin(false);
                userLocalDatabase.setUserName("");
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });



        if(!userLocalDatabase.isLogin()){
            gotoLoginActivity();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        tvUserName.setText(userLocalDatabase.getUserName());

    }

    private void gotoLoginActivity(){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
