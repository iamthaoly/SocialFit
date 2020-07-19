package com.iamthaoly.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        TextView txt = findViewById(R.id.txtInfo);
        String s = "10/07/2020: 6 PACKS ABS CHALLENGES -> COMPLETED" +
                "\n" + "11/07/2020: 5 minutes home workout -> 50%" + "\n" +
                "18/07/2020: Legs workout -> COMPLETED" + "\n";
        txt.setText(s);
    }
}
