package com.kevinmaher.x14328981.happy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by x14328981 on 23/11/2017.
 * Header: How are you feeling?
 */

//below method is depreciated
//editTextUpdate.setBackgroundTintList(context.getResources().getColorStateList(R.color.indifferent));

//not depreciated
//editTextUpdate.setTextColor(Color.parseColor("#669900"));


public class UpdateActivity extends AppCompatActivity {

    private CharSequence mood;
    private CharSequence locationInfo = "Location info: About";
    private CharSequence location = "Dublin";
    private CharSequence visibilityInfo = "Visibility info: About";
    private CharSequence username = "zebra53";
    private CharSequence usernameInfo = "Username info: About";
    private boolean isButtonClicked = false;
    Context context = this;

    private Button btnHappy;
    private Button btnIndifferent;
    private Button btnSad;

    private EditText editTextUpdate;
    private Button btnUpdateLocationInfo;
    private Button btnUpdateVisibilityInfo;
    private Button btnUpdateUsernameInfo;

    private Switch switchUpdateLocation;
    private Switch switchUpdateVisibility;
    private Switch switchUpdateUsername;

    private TextView textPreview;
    private Button btnFace;
    private TextView textViewMoodTitle;
    private TextView textViewMoodDate;
    private TextView textViewMoodTime;
    private TextView textViewMoodLocation;
    private TextView textViewMoodUsername;
    private Button btnUpdateVisibility;
    private Button btnUpdate;

    private int DEFAULT_MSG_LENGTH_LIMIT = 20;
//        final int DEFAULT_DATE_LENGTH_LIMIT = 29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        //initialize variables
        btnHappy = (Button) findViewById(R.id.btn_update_happy);
        btnIndifferent = (Button) findViewById(R.id.btn_update_indifferent);
        btnSad = (Button) findViewById(R.id.btn_update_sad);

        editTextUpdate = (EditText) findViewById(R.id.editText_update_update);
        btnUpdateLocationInfo = (Button) findViewById(R.id.btn_update_location_info);
        btnUpdateVisibilityInfo = (Button) findViewById(R.id.btn_update_visibility_info);
        btnUpdateUsernameInfo = (Button) findViewById(R.id.btn_update_username_info);

        switchUpdateLocation = (Switch) findViewById(R.id.switch_update_update_location);
        switchUpdateVisibility = (Switch) findViewById(R.id.switch_update_update_visibility);
        switchUpdateUsername = (Switch) findViewById(R.id.switch_update_update_username);

        textPreview = (TextView) findViewById(R.id.text_update_preview);
        btnFace = (Button) findViewById(R.id.btn_update_face);
        textViewMoodTitle = (TextView) findViewById(R.id.textView_update_mood_title);
        textViewMoodDate = (TextView) findViewById(R.id.textView_update_mood_date);
        textViewMoodTime = (TextView) findViewById(R.id.textView_update_mood_time);
        textViewMoodLocation = (TextView) findViewById(R.id.textView_update_mood_location);
        textViewMoodUsername = (TextView) findViewById(R.id.textView_update_username);
        btnUpdateVisibility = (Button) findViewById(R.id.btn_update_visibility);
        btnUpdate = (Button) findViewById(R.id.btn_update_update);

        //make components invisible to provide minimal experience
        editTextUpdate.setVisibility(View.INVISIBLE);
        btnUpdateLocationInfo.setVisibility(View.INVISIBLE);
        btnUpdateVisibilityInfo.setVisibility(View.INVISIBLE);
        btnUpdateUsernameInfo.setVisibility(View.INVISIBLE);

        switchUpdateLocation.setVisibility(View.INVISIBLE);
        switchUpdateVisibility.setVisibility(View.INVISIBLE);
        switchUpdateUsername.setVisibility(View.INVISIBLE);

        textPreview.setVisibility(View.INVISIBLE);
        btnFace.setVisibility(View.INVISIBLE);
        textViewMoodTitle.setVisibility(View.INVISIBLE);
        textViewMoodDate.setVisibility(View.INVISIBLE);
        textViewMoodTime.setVisibility(View.INVISIBLE);
        textViewMoodLocation.setVisibility(View.INVISIBLE);
        textViewMoodUsername.setVisibility(View.INVISIBLE);
        btnUpdateVisibility.setVisibility(View.INVISIBLE);
        btnUpdate.setVisibility(View.INVISIBLE);

        //make everything CAPS AND force textfield character limit
//        editTextUpdate.setFilters(new InputFilter[] {new InputFilter.AllCaps(), new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});

        //force character limit
        editTextUpdate.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});
//        textViewMoodDate.setFilters(new InputFilter[] {new InputFilter.LengthFilter(DEFAULT_DATE_LENGTH_LIMIT)});

        //make first letter caps
        editTextUpdate.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);

        //tick/ok hides keyboard
        editTextUpdate.setImeOptions(EditorInfo.IME_ACTION_DONE);

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.btn_face_happy_selected);
                btnIndifferent.setBackgroundResource(R.drawable.btn_face_indifferent_unselected);
                btnSad.setBackgroundResource(R.drawable.btn_face_sad_unselected);

                editTextUpdate.setVisibility(View.VISIBLE);
                editTextUpdate.setTextColor(ContextCompat.getColorStateList(context, R.color.happy));
                //set colour of textbox underline
                editTextUpdate.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.happy));
                editTextUpdate.setHint("What made you feel happy?");

                //update result section
                btnFace.setBackgroundResource(R.drawable.btn_face_happy_selected);
                textViewMoodTitle.setTextColor(ContextCompat.getColorStateList(context, R.color.happy));
                makeComponentsVisible();
            }
        });

        btnIndifferent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.btn_face_happy_unselected);
                btnIndifferent.setBackgroundResource(R.drawable.btn_face_indifferent_selected);
                btnSad.setBackgroundResource(R.drawable.btn_face_sad_unselected);

                editTextUpdate.setVisibility(View.VISIBLE);
                editTextUpdate.setTextColor(ContextCompat.getColorStateList(context, R.color.indifferent));
                editTextUpdate.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.indifferent));
                editTextUpdate.setHint("What made you feel indifferent?");

                //update result section
                btnFace.setBackgroundResource(R.drawable.btn_face_indifferent_selected);
                textViewMoodTitle.setTextColor(ContextCompat.getColorStateList(context, R.color.indifferent));
                makeComponentsVisible();
            }
        });


        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHappy.setBackgroundResource(R.drawable.btn_face_happy_unselected);
                btnIndifferent.setBackgroundResource(R.drawable.btn_face_indifferent_unselected);
                btnSad.setBackgroundResource(R.drawable.btn_face_sad_selected);

                editTextUpdate.setVisibility(View.VISIBLE);
                editTextUpdate.setTextColor(ContextCompat.getColorStateList(context, R.color.sad));
                editTextUpdate.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.sad));
                editTextUpdate.setHint("What made you feel sad?");

                //update result section
                btnFace.setBackgroundResource(R.drawable.btn_face_sad_selected);
                textViewMoodTitle.setTextColor(ContextCompat.getColorStateList(context, R.color.sad));
                makeComponentsVisible();
            }
        });


        editTextUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnUpdate.setVisibility(View.VISIBLE);
            }
        });

        btnUpdateLocationInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, locationInfo, Toast.LENGTH_SHORT).show();
//                TODO startActivity(new Intent(UpdateActivity.this, NavActivity.class));
            }
        });

        btnUpdateVisibilityInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, visibilityInfo, Toast.LENGTH_SHORT).show();
//                TODO startActivity(new Intent(UpdateActivity.this, NavActivity.class));
            }
        });

        btnUpdateUsernameInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, usernameInfo, Toast.LENGTH_SHORT).show();
//                TODO startActivity(new Intent(UpdateActivity.this, NavActivity.class));
            }
        });

//      location = LOCATION_SERVICE;
        switchUpdateLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewMoodLocation.setText(location);
                    textViewMoodLocation.setVisibility(View.VISIBLE);
//                    btnUpdateVisibilityInfo.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Toast.makeText(UpdateActivity.this, visibilityInfo, Toast.LENGTH_SHORT).show();
//                        }
//                        //                startActivity(new Intent(UpdateActivity.this, NavActivity.class));
//                    });
                } else {
                    textViewMoodLocation.setText(" ");
                    textViewMoodLocation.setVisibility(View.INVISIBLE);
                }
            }
        });

        switchUpdateVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnUpdateVisibility.setBackgroundResource(R.drawable.ic_people_outline_black);
                    btnUpdateVisibility.setVisibility(View.VISIBLE);
                } else {
                    btnUpdateVisibility.setBackgroundResource(R.drawable.ic_person_outline_black);
                    btnUpdateVisibility.setVisibility(View.VISIBLE);
                }
            }
        });

        switchUpdateUsername.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewMoodUsername.setText(username);
                    textViewMoodUsername.setVisibility(View.VISIBLE);
                } else {
                    textViewMoodUsername.setText(" ");
                    textViewMoodUsername.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = editTextUpdate.getText();

//                String test = "Kevin";
//                if (test == "Kevin"){
//                    Toast.makeText(UpdateActivity.this, "String == Kevin", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(UpdateActivity.this, "String != Kevin", Toast.LENGTH_SHORT).show();
//                }

//                mood.toString();
//                mood = "x";
                if (mood.length() <= 0) {
                    Toast.makeText(UpdateActivity.this, "Please enter your mood", Toast.LENGTH_SHORT).show();
                } else {
                    textViewMoodTitle.setText(mood);
                    Toast.makeText(UpdateActivity.this, "Mood updated successfully", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(UpdateActivity.this, NavActivity.class));

                    //TODO refresh data (via recycler view)
//                    notifyDataSetChanged();

                    //TODO Snackbar
//                    Snackbar.make("Mood updated successfully", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdateVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Drawable drawable = btnUpdateVisibility.getBackground();
//                if (drawable == R.drawable.ic_people_outline_black){
//                    btnUpdateVisibility.setBackgroundResource(R.drawable.ic_person_outline_black);
//                }else{
//                    btnUpdateVisibility.setBackgroundResource(R.drawable.ic_people_outline_black);
//                }
            }
        });

        checkTextEntered();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        //exit confirmation dialog
        mood = editTextUpdate.getText();
        if (mood.length() > 0) {
            Toast.makeText(UpdateActivity.this, "Are you sure you want to exit?", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkTextEntered(){
        mood = editTextUpdate.getText();
        if (mood.length() > 0) {
            btnUpdate.setVisibility(View.VISIBLE);
        }
    }

    public void makeComponentsVisible(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");
        String currentTime = simpleDateFormat.format(calendar.getTime());
        textViewMoodTime.setText(currentTime);

        btnUpdateLocationInfo.setVisibility(View.VISIBLE);
        switchUpdateLocation.setVisibility(View.VISIBLE);
        btnUpdateVisibilityInfo.setVisibility(View.VISIBLE);
        switchUpdateVisibility.setVisibility(View.VISIBLE);
        btnUpdateUsernameInfo.setVisibility(View.VISIBLE);
        switchUpdateUsername.setVisibility(View.VISIBLE);

        textPreview.setVisibility(View.VISIBLE);
        btnFace.setVisibility(View.VISIBLE);
        textViewMoodTitle.setVisibility(View.VISIBLE);
//        textViewMoodDate.setVisibility(View.VISIBLE);
        textViewMoodTime.setVisibility(View.VISIBLE);
        textViewMoodLocation.setVisibility(View.VISIBLE);
        textViewMoodUsername.setVisibility(View.VISIBLE);
        btnUpdateVisibility.setVisibility(View.VISIBLE);
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
//        btnHappy.setBackgroundResource(R.drawable.btn_face_happy_unselected);

//method 3
//          if (view.getId() == R.id.btn_update_sad) {
//                  isButtonClicked = !isButtonClicked; // toggle the boolean flag
//                  view.setBackgroundResource(isButtonClicked ? R.drawable.btn_face_sad_selected : R.drawable.btn_face_sad_unselected);
//                  }

//date

//                    Date currentTime = Calendar.getInstance().getTime();
//                    textViewMoodDate.setText(currentDate.toString());

//                    Calendar calendar = Calendar.getInstance();
//                    String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
//                    textViewMoodDate.setText(currentDate);

//                    String currentDate = DateFormat.getDateTimeInstance(DateFormat.FULL).format(calendar.getTime());
//                    String currentDate = DateFormat.getTimeInstance(DateFormat.FULL).format(calendar.getTime());
//                    textViewMoodDate.setText(currentDate);