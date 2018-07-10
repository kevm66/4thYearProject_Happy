package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnRecord = (Button) findViewById(R.id.btn_support_websites);
        Button btnLog = (Button) findViewById(R.id.btn_home_log);
        Button btnResults = (Button) findViewById(R.id.btn_home_results);
        Button btnMap = (Button) findViewById(R.id.btn_home_map);
        Button btnChat = (Button) findViewById(R.id.btn_home_chat);
        Button btnSupport = (Button) findViewById(R.id.btn_home_support);

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, UpdateActivity.class));
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
                startActivity(new Intent(HomeActivity.this, FeedActivity.class));
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MapActivity.class));
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ChatActivity.class));
            }
        });

        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SupportActivity.class));
            }
        });
    }

    //menu button
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_more, menu);
            return true;
        }

        //menu button
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_settings:
                    startActivity(new Intent(this, SettingsActivity.class));
                    return true;
                case R.id.menu_support:
                    startActivity(new Intent(this, SupportActivity.class));
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
    }


}
