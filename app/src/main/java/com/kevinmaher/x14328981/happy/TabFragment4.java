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

public class TabFragment4 extends Fragment {
    private static final String TAG ="TabFragment4";

    private Button btnSupportWebsites;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_support,container,false);

        btnSupportWebsites = (Button) view.findViewById(R.id.btn_support_websites);

        btnSupportWebsites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Websites", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), UpdateActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
