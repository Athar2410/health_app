package com.example.health_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class JournalActivity extends Activity {

    DatabaseHelper dbHelper;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        dbHelper = new DatabaseHelper(this);

        EditText entry = findViewById(R.id.journalEntry);
        ListView journalList = findViewById(R.id.journalList);

        // Load and show past entries
        List<String> entries = dbHelper.getAllJournalEntries();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, entries);
        journalList.setAdapter(adapter);

        // Save journal entry
        findViewById(R.id.saveBtn).setOnClickListener(v -> {
            String text = entry.getText().toString();
            if (!text.isEmpty()) {
                String date = DateFormat.getDateTimeInstance().format(new Date());
                dbHelper.insertJournalEntry(text, date);
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();

                entry.setText("");

                // Refresh list
                entries.clear();
                entries.addAll(dbHelper.getAllJournalEntries());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
