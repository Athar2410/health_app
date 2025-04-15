package com.example.health_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "wellness.db";
    public static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Journal (id INTEGER PRIMARY KEY AUTOINCREMENT, entry TEXT, date TEXT)");
        db.execSQL("CREATE TABLE Mood (id INTEGER PRIMARY KEY AUTOINCREMENT, mood INTEGER, date TEXT)");

    }
    public void insertJournalEntry(String text, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Journal (entry, date) VALUES (?, ?)", new Object[]{text, date});
    }
    public List<String> getAllJournalEntries() {
        List<String> entries = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT entry, date FROM Journal ORDER BY id DESC", null);
        while (cursor.moveToNext()) {
            String date = cursor.getString(1);
            String entry = cursor.getString(0);
            entries.add(date + "\n" + entry);
        }
        cursor.close();
        return entries;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades if needed
    }
}
