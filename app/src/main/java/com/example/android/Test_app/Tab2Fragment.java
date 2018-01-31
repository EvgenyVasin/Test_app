package com.example.android.Test_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Evasin on 23.01.2018.
 */

public class Tab2Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";
    static ArrayList<HashMap<String, String>> shopList;
    private static ListView list;

    public static void buttonClick(View view) {
        
        //Getting data from json and creating a list based on them
        JsonHelper helper = new JsonHelper();
        shopList = helper.dataFromJson(view.getContext());

        ListAdapter adapter = new SimpleAdapter(
                view.getContext(), shopList,
                R.layout.list_item_layout, new String[]{"name", "address",
                "opening_hours"}, new int[]{R.id.name,
                R.id.address, R.id.opening_hours});

        list.setAdapter(adapter);

        //Creating Toast when clicking on list items
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "clicked " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        list = view.findViewById(R.id.list);
        
        //Elegant creation of the "default" list :)
        ArrayList<String> mounts = new ArrayList<>();
        mounts.add("Январь");
        mounts.add("Февраль");
        mounts.add("Март");
        mounts.add("Апрель");
        mounts.add("Май");
        mounts.add("Июнь");
        mounts.add("Июль");
        mounts.add("Август");
        mounts.add("Сентябрь");
        mounts.add("Октябрь");
        mounts.add("Ноябрь");
        mounts.add("Декабрь");
        mounts.add("Январь");
        mounts.add("Февраль");
        mounts.add("Март");
        mounts.add("Апрель");
        mounts.add("Май");
        mounts.add("Июнь");
        mounts.add("Июль");
        mounts.add("Август");
        mounts.add("Сентябрь");
        mounts.add("Октябрь");
        mounts.add("Ноябрь");
        mounts.add("Декабрь");

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.simple_list_item_layout, mounts);
        list.setAdapter(adapter);

        return view;
    }
}





