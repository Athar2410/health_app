package com.example.health_app;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WeeklySummaryActivity extends Activity {

    String[] emojis = {"😞", "😕", "😐", "😊", "😄"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_summary);

        TextView summaryView = findViewById(R.id.weeklySummaryText);
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get current date - 7 days
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date weekAgo = calendar.getTime();
        String weekAgoStr = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(weekAgo);

        Cursor cursor = db.rawQuery(
                "SELECT mood FROM Mood WHERE date >= ?",
                new String[]{weekAgoStr});

        int moodSum = 0;
        int count = 0;
        int[] moodCounts = new int[5]; // for 😞 to 😄

        while (cursor.moveToNext()) {
            int mood = cursor.getInt(0);
            moodSum += mood;
            moodCounts[mood]++;
            count++;
        }
        cursor.close();

        String summary;
        if (count > 0) {
            int avgMood = Math.round((float) moodSum / count);
            summary = "Your mood this week: " + emojis[avgMood] + "\n\n" +
                    "😞: " + moodCounts[0] + " days\n" +
                    "😕: " + moodCounts[1] + " days\n" +
                    "😐: " + moodCounts[2] + " days\n" +
                    "😊: " + moodCounts[3] + " days\n" +
                    "😄: " + moodCounts[4] + " days\n";
        } else {
            summary = "No mood data recorded in the past 7 days.";
        }

        summaryView.setText(summary);
    }
}
