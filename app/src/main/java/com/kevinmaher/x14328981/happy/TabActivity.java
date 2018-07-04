package com.kevinmaher.x14328981.happy;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class TabActivity extends AppCompatActivity {

    private static final String TAG = "TabActivity";

    private SectionPageAdapterActivity mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Log.d(TAG,"onCreate: Starting");

        mSectionsPageAdapter = new SectionPageAdapterActivity(getSupportFragmentManager());

        //set up the viewPage with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapterActivity adapter = new SectionPageAdapterActivity((getSupportFragmentManager()));
        adapter.addFragment(new Tab1Frag(), "Log");
        adapter.addFragment(new Tab2Frag(), "Activity");
        adapter.addFragment(new Tab3Frag(), "Chat");
        adapter.addFragment(new Tab4Frag(), "Support");
//        adapter.addFragment(new Tab5Frag(), "Support");
////        adapter.addFragment(new Tab6Frag(), "Support");
        viewPager.setAdapter(adapter);
        }



}
