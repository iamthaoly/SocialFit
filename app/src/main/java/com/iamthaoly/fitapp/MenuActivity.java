package com.iamthaoly.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {
    ImageButton btnChallenges, btnTraining, btnTracker, btnLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
        btnChallenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ChallengeActivity.class);
                startActivity(intent);
            }
        });
        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TrackerActivity.class);
                startActivity(intent);
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LogActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        btnChallenges = findViewById(R.id.btnChallenges);
        btnTraining = findViewById(R.id.btnTraining);
        btnTracker = findViewById(R.id.btnTracker);
        btnLog = findViewById(R.id.btnLog);
    }
}
