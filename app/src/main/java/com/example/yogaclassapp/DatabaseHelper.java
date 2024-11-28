package com.example.yogaclassapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "yogaclasses.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create yoga classes table
        db.execSQL("CREATE TABLE yoga_classes (id INTEGER PRIMARY KEY AUTOINCREMENT, day TEXT, time TEXT, capacity INTEGER, duration INTEGER, price REAL, type TEXT, description TEXT)");
        // Create class instances table
        db.execSQL("CREATE TABLE class_instances (id INTEGER PRIMARY KEY AUTOINCREMENT, class_id INTEGER, date TEXT, teacher TEXT, comments TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS yoga_classes");
        db.execSQL("DROP TABLE IF EXISTS class_instances");
        onCreate(db);
    }
}