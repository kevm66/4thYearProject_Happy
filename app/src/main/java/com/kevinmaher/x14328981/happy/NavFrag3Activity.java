package com.kevinmaher.x14328981.happy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavFrag3Activity extends Fragment{
   public static NavFrag3Activity newInstance(){
       NavFrag3Activity fragment = new NavFrag3Activity();
       return fragment;
   }

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
   }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState){
       return inflater.inflate(R.layout.activity_support, containter, false);
   }

}
