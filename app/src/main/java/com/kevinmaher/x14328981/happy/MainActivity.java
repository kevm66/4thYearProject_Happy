package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("myTag","DEBUG");
        Log.e("myTag","ERROR");
        Log.i("myTag","INFO");
        Log.v("myTag","VERBOSE");
        Log.e("myTag","WARN");

        Button btnMainLogin = (Button)findViewById(R.id.btn_main_login);
        Button btnMainRegister = (Button)findViewById(R.id.btn_main_register2);;
        Button btnSettings = (Button)findViewById(R.id.btn_main_settings);;

        btnMainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        btnMainRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }
}
