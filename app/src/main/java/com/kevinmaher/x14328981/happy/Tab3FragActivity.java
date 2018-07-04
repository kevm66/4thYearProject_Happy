package com.kevinmaher.x14328981.happy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Tab3FragActivity extends Fragment {
    private static final String TAG ="Tab3Fragment";

//    private Button btnTest3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_chat,container,false);
//        btnTest3 = (Button) view.findViewById(R.id.btnTest3);


//        btnTest3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Testing button 3", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }
}
