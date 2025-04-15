package com.example.health_app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class BreathingActivity extends Activity {
    TextView breathText;
    String[] cycle = {"Inhale", "Hold", "Exhale"};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing);

        breathText = findViewById(R.id.breathText);
        updateBreathing();
    }

    void updateBreathing() {
        breathText.setText(cycle[index % 3]);
        index++;
        new Handler().postDelayed(this::updateBreathing, 4000); // 4-second steps
    }
}
