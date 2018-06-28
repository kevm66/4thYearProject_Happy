package com.kevinmaher.x14328981.happy;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag3Activity extends Fragment{
   public static Frag3Activity newInstance(){
       Frag3Activity fragment = new Frag3Activity();
       return fragment;
   }

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
   }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState){
       return inflater.inflate(R.layout.activity_frag_3, containter, false);
   }

}
