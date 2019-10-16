package com.example.json;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

public class FragmentJsonObject extends Fragment {
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

    public static FragmentJsonObject newInstance() {

        Bundle args = new Bundle();

        FragmentJsonObject fragment = new FragmentJsonObject();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_json_o, container, false);
        textView = view.findViewById(R.id.tvFragment1);
        getJsonObject();

        return view;
    }

    private void getJsonObject() {
        try {
            String strJS="";
            JSONObject object=new JSONObject(jO);
            JSONObject subObject1=object.getJSONObject("wind");
            String speed=subObject1.getString("speed");
            String deg=subObject1.getString("deg");
            strJS+= "speed: " + speed + "deg" +deg;
            textView.setText(strJS);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
