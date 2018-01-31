package com.example.android.Test_app;

import android.app.Fragment;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Evasin on 26.01.2018.
 */

public class JsonHelper extends Fragment {

    public static int i;
    ArrayList<HashMap<String, String>> shopList = new ArrayList<>();

    public static int getI() {
        return i;
    }

    //Connecting json file
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("shops.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    //output data from json to the list
    public ArrayList<HashMap<String, String>> dataFromJson(Context context) {

        String jsonStr = loadJSONFromAsset(context);

        try {

            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray shop = jsonObject.getJSONArray("shop");

            for (i = 0; i < shop.length(); i++) {
                JSONObject a = shop.getJSONObject(i);
                String name = a.getString("name");
                String address = a.getString("address");
                String opening_hours = a.getString("opening_hours");

                HashMap<String, String> contact = new HashMap<>();

                contact.put("name", name);
                contact.put("address", address);
                contact.put("opening_hours", opening_hours);

                shopList.add(contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shopList;
    }
}
