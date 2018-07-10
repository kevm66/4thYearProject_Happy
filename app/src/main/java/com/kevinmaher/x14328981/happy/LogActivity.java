package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_log);

        Button btnLogUpdate = (Button) findViewById(R.id.btn_log_update);
//        ImageButton btnFilter = (ImageButton) findViewById(R.id.btn_log_filter);

        btnLogUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogActivity.this, FeedActivity.class));
            }
        });

//        btnFilter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LogActivity.this, FeedActivity.class));
//            }
//        });
    }

}
