package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by x14328981 on 23/11/2017.
 * Header: How are you feeling?
 */

public class UpdateActivity extends AppCompatActivity {

    public CharSequence mood;
    private boolean isButtonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final Button btnHappy = (Button) findViewById(R.id.btn_update_happy);
        final Button btnIndifferent = (Button) findViewById(R.id.btn_update_indifferent);
        final Button btnSad = (Button) findViewById(R.id.btn_update_sad);
        final Button btnUpdate = (Button) findViewById(R.id.btn_update_update);
        final TextView textViewUpdate = (TextView) findViewById(R.id.textView_update_update);
        final Switch switchUpdateLocation = (Switch) findViewById(R.id.switch_update_location);
        final CheckBox checkBox_update_location =  (CheckBox) findViewById(R.id.checkBox_update_location);

        //make input box and submit button invisible to provide minimal experience
        btnUpdate.setVisibility(View.INVISIBLE);
        checkBox_update_location.setVisibility(View.INVISIBLE);
        switchUpdateLocation.setVisibility(View.INVISIBLE);
        textViewUpdate.setVisibility(View.INVISIBLE);

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.ic_happy_green);
                btnIndifferent.setBackgroundResource(R.drawable.ic_indifferent_grey);
                btnSad.setBackgroundResource(R.drawable.ic_sad_grey);

                textViewUpdate.setVisibility(View.VISIBLE);
                textViewUpdate.setHint("What made you feel happy?");
                checkBox_update_location.setVisibility(View.VISIBLE);
                switchUpdateLocation.setVisibility(View.VISIBLE);
            }
        });

        btnIndifferent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.ic_happy_grey);
                btnIndifferent.setBackgroundResource(R.drawable.ic_indifferent);
                btnSad.setBackgroundResource(R.drawable.ic_sad_grey);

                textViewUpdate.setVisibility(View.VISIBLE);
                textViewUpdate.setHint("What made you feel indifferent?");
                checkBox_update_location.setVisibility(View.VISIBLE);
                switchUpdateLocation.setVisibility(View.VISIBLE);
            }
        });


        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.ic_happy_grey);
                btnIndifferent.setBackgroundResource(R.drawable.ic_indifferent_grey);
                btnSad.setBackgroundResource(R.drawable.ic_sad);

                textViewUpdate.setVisibility(View.VISIBLE);
                textViewUpdate.setHint("What made you feel sad?");
                checkBox_update_location.setVisibility(View.VISIBLE);
                switchUpdateLocation.setVisibility(View.VISIBLE);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = textViewUpdate.getText();
                Toast.makeText(UpdateActivity.this, mood, Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(UpdateActivity.this, NavActivity.class));
            }
        });


        textViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnUpdate.setVisibility(View.VISIBLE);
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