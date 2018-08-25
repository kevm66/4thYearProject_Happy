package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //member variables
    private String mUsername;
    public static final String ANONYMOUS = "anonymous";
    public static final int RC_SIGN_IN = 1;

    //firebase instance variables
    public FirebaseAuth mFirebaseAuth;
    public FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTheme(R.style.AppTheme); //splash screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize firebase components
        mFirebaseAuth = FirebaseAuth.getInstance();

        //setup bottom navigation bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.menu_nav_home:
                                selectedFragment = HomeFragment.newInstance();
                                break;
                            case R.id.menu_nav_insights:
                                selectedFragment = InsightsFragment.newInstance();
                                break;
                            case R.id.menu_nav_support:
                                selectedFragment = SupportFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();   //Manually displaying the first fragment - one time only

        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

        //bottomNavigationView.getMenu().getItem(2).setChecked(true);                       //Used to select an item programmatically

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {                         //firebase auth state check
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //user is signed in
                    onSignedInInitialize(user.getDisplayName());
                }else{
                    //user is signed out
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(true) //set to true for production
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "Signed in successfully!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Sign in cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);     //log user in
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);  //log user out
        }
//        detachDatabaseReadListener();//TODO DATABASE
//        mMessageAdapter.clear();//TODO DATABASE
    }


    private void onSignedInInitialize(String username) {
        mUsername = username;
//        attachDatabaseReadListener(); //TODO DATABASE
    }

    private void onSignedOutCleanup() {
        mUsername = ANONYMOUS;
//        mMessageAdapter.clear();//TODO DATABASE
//        detachDatabaseReadListener();//TODO DATABASE
        Toast.makeText(this, "Signed out successfully!", Toast.LENGTH_SHORT).show();
    }

    //menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.more, menu);
        return true;
    }

    //menu contents
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_more_filter:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.menu_more_feedback:
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "kevm66@gmail.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Happy - Feedback");
//                Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
                return true;
            case R.id.menu_more_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.menu_more_about:
                startActivity(new Intent(this, SupportFragment.class));
                return true;
            case R.id.menu_more_log_out:
                AuthUI.getInstance().signOut(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

//        Log.d("myTag","DEBUG");
//        Log.e("myTag","ERROR");
//        Log.i("myTag","INFO");
//        Log.v("myTag","VERBOSE");
//        Log.e("myTag","WARN");

//        Button btnSettings = (Button)findViewById(R.id.btn_main_settings);
//
//        btnSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
//            }
//        });