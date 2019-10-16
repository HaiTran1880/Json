package com.example.json;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentJsonArray extends Fragment {
    TextView textView;
    String jO = "{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
            "  \"weather\": [\n" +
            "    {\n" +
            "      \"id\": 800,\n" +
            "      \"main\": \"Clear\",\n" +
            "      \"description\": \"clear sky\",\n" +
            "      \"icon\": \"01n\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"base\": \"stations\",\n" +
            "  \"main\": {\n" +
            "    \"temp\": 289.92,\n" +
            "    \"pressure\": 1009,\n" +
            "    \"humidity\": 92,\n" +
            "    \"temp_min\": 288.71,\n" +
            "    \"temp_max\": 290.93\n" +
            "  },\n" +
            "  \"wind\": {\n" +
            "    \"speed\": 0.47,\n" +
            "    \"deg\": 107.538\n" +
            "  },\n" +
            "  \"clouds\": {\n" +
            "    \"all\": 2\n" +
            "  },\n" +
            "  \"dt\": 1560350192,\n" +
            "  \"sys\": {\n" +
            "    \"type\": 3,\n" +
            "    \"id\": 2019346,\n" +
            "    \"message\": 0.0065,\n" +
            "    \"country\": \"JP\",\n" +
            "    \"sunrise\": 1560281377,\n" +
            "    \"sunset\": 1560333478\n" +
            "  },\n" +
            "  \"timezone\": 32400,\n" +
            "  \"id\": 1851632,\n" +
            "  \"name\": \"Shuzenji\",\n" +
            "  \"cod\": 200\n" +
            "}";
    public static FragmentJsonArray newInstance() {

        Bundle args = new Bundle();

        FragmentJsonArray fragment = new FragmentJsonArray();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.jsonarray,container,false);
        textView=view.findViewById(R.id.tvFragment2);
        getJsonArray(jO);
        return view;
    }
    private void getJsonArray(String jO) {
        try {
            JSONObject object=new JSONObject(jO);
            JSONArray jsonArray = object.getJSONArray("weather");
            String strJson="";

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                String main=jsonObject.getString("main");
                String description=jsonObject.getString("description");
                String icon=jsonObject.getString("icon");
                strJson += "\nid: " + id + " main: " + main + " description: " + description +"icon" +icon;
            }

            textView.setText(strJson);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
