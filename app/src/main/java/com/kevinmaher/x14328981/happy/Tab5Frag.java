//package com.kevinmaher.x14328981.happy;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.Toast;
//
//public class Tab5Frag extends Fragment {
//    private static final String TAG ="Tab5Fragment";
//
//    private Button btnTest5;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_tab_5_frag,container,false);
//        btnTest5 = (Button) view.findViewById(R.id.btnTest5);
//
//
//        btnTest5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Testing button 5", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        return view;
//    }
//}
