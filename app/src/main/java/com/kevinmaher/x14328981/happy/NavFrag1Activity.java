package com.kevinmaher.x14328981.happy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NavFrag1Activity extends Fragment {

    private Button btnLogUpdate;

    public static NavFrag1Activity newInstance() {
        NavFrag1Activity fragment = new NavFrag1Activity();
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_log,container,false);

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
