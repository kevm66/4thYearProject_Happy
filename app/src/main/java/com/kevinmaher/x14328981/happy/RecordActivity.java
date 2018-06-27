package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by x14328981 on 23/11/2017.
 * Header: How are you feeling?
 */

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Button btnHappy = (Button) findViewById(R.id.btn_happy);
        Button btnIndifferent = (Button) findViewById(R.id.btn_indifferent);
        Button btnSad = (Button) findViewById(R.id.btn_sad);
        Button btnRecord = (Button) findViewById(R.id.btn_record);

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecordActivity.this, ResultsActivity.class));
            }
        });

        btnIndifferent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecordActivity.this, ResultsActivity.class));
            }
        });

        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecordActivity.this, ResultsActivity.class));
            }
        });

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecordActivity.this, ResultsActivity.class));
            }
        });
    }
}
