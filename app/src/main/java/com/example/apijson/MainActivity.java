package com.example.apijson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.bt1);
        button2 = findViewById(R.id.bt2);
        textView = findViewById(R.id.tvMain);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJsonObject();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJsonArray(jO);
            }
        });

    }

    private void getJsonObject() {
        try {
            String strJS = "";
            JSONObject object = new JSONObject(jO);
            JSONObject subObject1 = object.getJSONObject("wind");
            String speed = subObject1.getString("speed");
            String deg = subObject1.getString("deg");
            strJS += "speed: " + speed + "deg" + deg;
            textView.setText(strJS);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void getJsonArray(String jO) {
        try {
            JSONObject object = new JSONObject(jO);
            JSONArray jsonArray = object.getJSONArray("weather");
            String strJson = "";

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String main = jsonObject.getString("main");
                String description = jsonObject.getString("description");
                String icon = jsonObject.getString("icon");
                strJson += "\nid: " + id + " \nmain: " + main + " \ndescription: " + description + "\nicon" + icon;
            }

            textView.setText(strJson);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
