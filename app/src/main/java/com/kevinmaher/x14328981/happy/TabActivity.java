package com.kevinmaher.x14328981.happy;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

public class TabActivity extends AppCompatActivity {

    private static final String TAG = "TabActivity";

    private SectionPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_tab);
        Log.d(TAG,"onCreate: Starting");

        mSectionsPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        //set up the viewPage with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapter adapter = new SectionPageAdapter((getSupportFragmentManager()));
        adapter.addFragment(new TabFragment1(), "Log");
        adapter.addFragment(new TabFragment2(), "Activity");
        adapter.addFragment(new TabFragment3(), "Chat");
        adapter.addFragment(new TabFragment4(), "Support");
//        adapter.addFragment(new Tab5Frag(), "Support");
////        adapter.addFragment(new Tab6Frag(), "Support");
        viewPager.setAdapter(adapter);
        }



}
