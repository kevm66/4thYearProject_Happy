package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

/**
 * Created by x14328981 on 23/11/2017.
 * Header: How are you feeling?
 */

public class UpdateActivity extends AppCompatActivity {

    private boolean isButtonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final Button btnHappy = (Button) findViewById(R.id.btn_update_happy);
        final Button btnIndifferent = (Button) findViewById(R.id.btn_update_indifferent);
        final Button btnSad = (Button) findViewById(R.id.btn_update_sad);
        Button btnRecord = (Button) findViewById(R.id.btn_record);

        //input field

        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.ic_happy_grey);
                btnIndifferent.setBackgroundResource(R.drawable.ic_indifferent_grey);

                //                startActivity(new Intent(UpdateActivity.this, NavActivity.class));
            }
        });

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateActivity.this, NavActivity.class));
            }
        });
    }
}

//method 1
//        btnHappy.setVisibility(View.INVISIBLE);
//        btnHappyUnselected.setVisibility(View.VISIBLE);
//        btnIndifferent.setVisibility(View.INVISIBLE);
//        btnIndifferentUnselected.setVisibility(View.VISIBLE);
//        btnSad.setVisibility(View.VISIBLE);
//        btnSadUnselected.setVisibility(View.INVISIBLE);

//method 2
//        btnHappy.setBackgroundResource(R.drawable.ic_happy_grey);

//method 3
//          if (view.getId() == R.id.btn_update_sad) {
//                  isButtonClicked = !isButtonClicked; // toggle the boolean flag
//                  view.setBackgroundResource(isButtonClicked ? R.drawable.ic_sad : R.drawable.ic_sad_grey);
//                  }