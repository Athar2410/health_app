package com.example.health_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button moodButton, journalButton, breathingButton, reminderButton, weeklySummaryBtn, quotesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // make sure this XML has the correct buttons

        moodButton = findViewById(R.id.moodButton);
        weeklySummaryBtn = findViewById(R.id.weeklySummaryBtn);
        journalButton = findViewById(R.id.journalButton);
        breathingButton = findViewById(R.id.breathingButton);
        reminderButton = findViewById(R.id.reminderButton);
        quotesBtn = findViewById(R.id.quotesBtn);


        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoodTrackerActivity.class);
                startActivity(intent);
            }
        });

        journalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JournalActivity.class);
                startActivity(intent);
            }
        });

        breathingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BreathingActivity.class);
                startActivity(intent);
            }
        });

        reminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReminderActivity.class);
                startActivity(intent);
            }
        });

        weeklySummaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeeklySummaryActivity.class);
                startActivity(intent);
            }
        });

        quotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
                startActivity(intent);
            }
        });
    }
}
