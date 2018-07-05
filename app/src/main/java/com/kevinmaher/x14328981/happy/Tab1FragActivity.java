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
import android.widget.Toast;

public class Tab1FragActivity extends Fragment {
    private static final String TAG ="Tab1Fragment";

    private Button btnLogUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_log,container,false);

        btnLogUpdate = (Button) view.findViewById(R.id.btn_log_update);

        btnLogUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Testing button 1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), NavFrag1Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
