package com.example.health_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.util.Date;

public class MoodTrackerActivity extends Activity {

    // Mood emojis - you can customize these
    String[] emojis = {"😞", "😕", "😐", "😊", "😄"};
    int currentMood = 2; // Neutral by default

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);

        // Bind UI elements
        SeekBar slider = findViewById(R.id.moodSlider);
        TextView emojiView = findViewById(R.id.moodEmoji);
        Button saveBtn = findViewById(R.id.saveMoodBtn);

        // Initial state
        slider.setProgress(currentMood);
        emojiView.setText(emojis[currentMood]);

        // Handle slider movement
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentMood = progress;
                emojiView.setText(emojis[progress]);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {}
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Handle Save button
        saveBtn.setOnClickListener(v -> {
            // Save mood to SQLite
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String date = DateFormat.getDateTimeInstance().format(new Date());

            db.execSQL("INSERT INTO Mood (mood, date) VALUES (?, ?)", new Object[]{currentMood, date});

            Toast.makeText(this, "Mood saved: " + emojis[currentMood], Toast.LENGTH_SHORT).show();
        });
    }
}
