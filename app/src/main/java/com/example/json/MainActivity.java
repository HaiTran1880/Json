package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.bt1);
        button2=findViewById(R.id.bt2);

      button1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            getFragment(FragmentJsonObject.newInstance());
          }
      });

      button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              getFragment(FragmentJsonA.newInstance());
          }
      });

}
    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }
}
