package com.kevinmaher.x14328981.happy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by x14328981 on 23/11/2017.
 * Header: How are you feeling?
 */

//below method is depreciated
//textViewUpdate.setBackgroundTintList(context.getResources().getColorStateList(R.color.indifferent));

//not depreciated
//textViewUpdate.setTextColor(Color.parseColor("#669900"));



public class UpdateActivity extends AppCompatActivity {

    public CharSequence mood;
    public CharSequence locationInfo = "Location info: About";
    public CharSequence location = "Location set: Leixlip";
    private boolean isButtonClicked = false;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final Button btnHappy = (Button) findViewById(R.id.btn_update_happy);
        final Button btnIndifferent = (Button) findViewById(R.id.btn_update_indifferent);
        final Button btnSad = (Button) findViewById(R.id.btn_update_sad);
        final Button btnUpdate = (Button) findViewById(R.id.btn_update_update);
        final Button btnUpdateLocationInfo = (Button) findViewById(R.id.btn_update_location_info);
        final TextView textViewUpdate = (TextView) findViewById(R.id.textView_update_update);
        final Switch switchUpdateLocation = (Switch) findViewById(R.id.switch_update_location);


        //make input box and submit button invisible to provide minimal experience
        btnUpdate.setVisibility(View.INVISIBLE);
        btnUpdateLocationInfo.setVisibility(View.INVISIBLE);
        textViewUpdate.setVisibility(View.INVISIBLE);
        switchUpdateLocation.setVisibility(View.INVISIBLE);

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.ic_happy_green);
                btnIndifferent.setBackgroundResource(R.drawable.ic_indifferent_grey);
                btnSad.setBackgroundResource(R.drawable.ic_sad_grey);

                textViewUpdate.setVisibility(View.VISIBLE);
                textViewUpdate.setTextColor(ContextCompat.getColorStateList(context, R.color.happy));
                //set colour of textbox underline
                textViewUpdate.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.happy));

                textViewUpdate.setHint("What made you feel happy?");
                btnUpdateLocationInfo.setVisibility(View.VISIBLE);
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
                textViewUpdate.setTextColor(ContextCompat.getColorStateList(context, R.color.indifferent));
                textViewUpdate.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.indifferent));

                textViewUpdate.setHint("What made you feel indifferent?");
                btnUpdateLocationInfo.setVisibility(View.VISIBLE);
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
//                all below methods work
//                textViewUpdate.setBackgroundTintList(context.getResources().getColorStateList(R.color.happy));
//                textViewUpdate.setTextColor(Color.parseColor("#ffff4444")); //works
//                textViewUpdate.setTextColor(context.getResources().getColorStateList(R.color.sad)); //works
//                textViewUpdate.setTextColor(context.getResources().getColor(R.color.sad)); //works
//                textViewUpdate.setTextColor(getResources().getColor(R.color.sad)); //works
//                textViewUpdate.setTextColor(ContextCompat.getColor(context, R.color.sad)); //works
//                textViewUpdate.setTextColor(ContextCompat.getColorStateList(context, R.color.sad)); //works
                textViewUpdate.setTextColor(ContextCompat.getColorStateList(context, R.color.sad));
//                textViewUpdate.setBackgroundTintList(context.getResources().getColorStateList(R.color.sad)); //works
                textViewUpdate.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.sad));

                textViewUpdate.setHint("What made you feel sad?");
                btnUpdateLocationInfo.setVisibility(View.VISIBLE);
                switchUpdateLocation.setVisibility(View.VISIBLE);

//                switchUpdateLocation.setTextColor(Color.parseColor("#f669900"));

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

        btnUpdateLocationInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = textViewUpdate.getText();
                Toast.makeText(UpdateActivity.this, locationInfo, Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(UpdateActivity.this, NavActivity.class));
            }
        });

        switchUpdateLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, location, Toast.LENGTH_SHORT).show();
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