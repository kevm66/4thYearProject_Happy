package com.kevinmaher.x14328981.happy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragSupportActivity extends Fragment{
   public static FragSupportActivity newInstance(){
       FragSupportActivity fragment = new FragSupportActivity();
       return fragment;
   }

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
   }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState){
       return inflater.inflate(R.layout.activity_frag_support, containter, false);
   }

}
