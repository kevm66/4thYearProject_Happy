package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by x14328981 on 23/11/2017.
 */

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_feed);

        Button btnSeeMap = (Button) findViewById(R.id.btn_feed_map);
//        ImageButton btnFilter = (ImageButton) findViewById(R.id.btn_results_filter);

        btnSeeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FeedActivity.this, MapActivity.class));
            }
        });

//        btnFilter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(FeedActivity.this, FeedActivity.class));
//            }
//        });

    }
}
