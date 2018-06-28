package com.kevinmaher.x14328981.happy;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag2Activity extends Fragment{
   public static Frag2Activity newInstance(){
       Frag2Activity fragment = new Frag2Activity();
       return fragment;
   }

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
   }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState){
       return inflater.inflate(R.layout.activity_frag_2, containter, false);
   }

}
