package com.iamthaoly.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TrackerActivity extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        txt = findViewById(R.id.text);
        String s = "19/07/2020: Apples: 1" + "\n" + "19/07/2020: Snack: 4" + "\n" + "19/07/2020: Coffee: 4";
        txt.setText(s);
    }
}
