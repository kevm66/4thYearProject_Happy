package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnRecord = (Button) findViewById(R.id.btn_home_record);
        Button btnLog = (Button) findViewById(R.id.btn_home_log);
        Button btnResults = (Button) findViewById(R.id.btn_home_results);
        Button btnMap = (Button) findViewById(R.id.btn_home_map);
        Button btnChat = (Button) findViewById(R.id.btn_home_chat);
        Button btnHelp = (Button) findViewById(R.id.btn_home_help);

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, RecordActivity.class));
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LogActivity.class));
            }
        });

        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ResultsActivity.class));
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MapActivity.class));
            }
        });

//        btnChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(HomeActivity.this, ChatActivity.class));
//            }
//        });

//        btnHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(HomeActivity.this, HelpActivity.class));
//            }
//        });
    }


}
