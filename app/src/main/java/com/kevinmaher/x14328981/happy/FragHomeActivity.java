package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragHomeActivity extends Fragment{
   public static FragHomeActivity newInstance(){
       FragHomeActivity fragment = new FragHomeActivity();
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
//               startActivity(new getActivity(FragHomeActivity.this, FragSupportActivity.class));
//           }
//       });

       return inflater.inflate(R.layout.activity_frag_home, containter, false);
   }



}
