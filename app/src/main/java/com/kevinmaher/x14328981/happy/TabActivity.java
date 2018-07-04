package com.kevinmaher.x14328981.happy;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

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
        adapter.addFragment(new Tab1FragActivity(), "Log");
        adapter.addFragment(new Tab2FragActivity(), "Activity");
        adapter.addFragment(new Tab3FragActivity(), "Chat");
        adapter.addFragment(new Tab4FragActivity(), "Support");
//        adapter.addFragment(new Tab5Frag(), "Support");
////        adapter.addFragment(new Tab6Frag(), "Support");
        viewPager.setAdapter(adapter);
        }



}
