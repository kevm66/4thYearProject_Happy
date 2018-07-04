package com.kevinmaher.x14328981.happy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavFrag1Activity extends Fragment{
   public static NavFrag1Activity newInstance(){
       NavFrag1Activity fragment = new NavFrag1Activity();
       return fragment;
   }

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
   }



   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState){

//       Button btnSupport = (Button) getView().findViewById(R.id.btn_home_support);

//       btnSupport.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               startActivity(new getActivity(NavFrag1Activity.this, NavFrag3Activity.class));
//           }
//       });

       return inflater.inflate(R.layout.activity_log, containter, false);
   }



}
