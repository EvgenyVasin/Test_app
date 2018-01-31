package com.example.android.Test_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Evasin on 23.01.2018.
 */

public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";
    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        btnTEST = view.findViewById(R.id.btnTEST);

        //Listener button for loading the directory
        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView view1 = getActivity().findViewById(R.id.content);
                view1.setText("Загрузка справочника…");
                Tab2Fragment.buttonClick(view);
                view1.setText("Загружено " + JsonHelper.getI() + " объектов");
            }
        });

        return view;
    }
}
