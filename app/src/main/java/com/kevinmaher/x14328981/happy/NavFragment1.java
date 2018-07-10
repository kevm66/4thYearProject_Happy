package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NavFragment1 extends Fragment {

    private Button btnLogUpdate;

    public static NavFragment1 newInstance() {
        NavFragment1 fragment = new NavFragment1();
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        @Nullable //for the onCreateView?
        View view = inflater.inflate(R.layout.fragment_log,container,false);

        btnLogUpdate = (Button) view.findViewById(R.id.btn_log_update);

        btnLogUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Testing button 1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), UpdateActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
