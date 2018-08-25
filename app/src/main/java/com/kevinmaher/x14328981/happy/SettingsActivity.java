package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by x14328981 on 23/11/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    //firebase instance variables
//    public FirebaseAuth mFirebaseAuth;
//    public FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        mFirebaseAuth = FirebaseAuth.getInstance();
//
//        TextView text_settings_log_out = (TextView) findViewById(R.id.text_settings_log_out);
//
//        text_settings_log_out.setOnClickListener(new View.OnClickListener() {
//            AuthUI.getInstance().signOut(this);
//        });

    }
}
