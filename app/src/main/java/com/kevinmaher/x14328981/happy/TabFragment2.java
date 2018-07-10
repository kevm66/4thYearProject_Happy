package com.kevinmaher.x14328981.happy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment2 extends Fragment {
    private static final String TAG ="TabFragment2";

//    private Button btnTest2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed,container,false);
//        btnTest2 = (Button) view.findViewById(R.id.btnTest2);


//        btnTest2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Testing button 2", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }

//    //menu button
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.more, menu);
//        return true;
//    }
//
//    //menu button
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_filter:
//                startActivity(new Intent(this, SettingsActivity.class));
//                return true;
//            case R.id.menu_insights:
//                startActivity(new Intent(this, InsightsActivity.class));
//                return true;
//            case R.id.menu_settings:
//                startActivity(new Intent(this, SettingsActivity.class));
//                return true;
//            case R.id.menu_support:
//                startActivity(new Intent(this, SupportActivity.class));
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
