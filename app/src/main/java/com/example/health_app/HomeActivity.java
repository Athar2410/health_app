package com.example.health_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {
    String[] affirmations = {
            "You are stronger than you think.",
            "Breathe. You are doing your best.",
            "You deserve peace and happiness."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView affirmation = findViewById(R.id.affirmationText);
        affirmation.setText(affirmations[(int)(Math.random() * affirmations.length)]);

        findViewById(R.id.journalBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, JournalActivity.class));
        });

        findViewById(R.id.breathingBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, BreathingActivity.class));
        });
        findViewById(R.id.weeklySummaryBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, WeeklySummaryActivity.class));
        });
        findViewById(R.id.weeklySummaryBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, WeeklySummaryActivity.class));
        });




    }
}
