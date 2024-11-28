package com.example.yogaclassapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManageClassInstancesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private YogaClassAdapter adapter;
    private ArrayList<YogaClass> yogaClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_classes_instances); // Ensure this matches your layout file

        recyclerView = findViewById(R.id.recyclerView);
        yogaClassList = new ArrayList<>();
        adapter = new YogaClassAdapter(yogaClassList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        loadYogaClasses();
    }

    private void loadYogaClasses() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("yoga_classes", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String day = cursor.getString(cursor.getColumnIndex("day"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                int capacity = cursor.getInt(cursor.getColumnIndex("capacity"));
                int duration = cursor.getInt(cursor.getColumnIndex("duration"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                String description = cursor.getString(cursor.getColumnIndex("description"));

                YogaClass yogaClass = new YogaClass(day, time, capacity, duration, price, type, description);
                yogaClassList.add(yogaClass);
            } while (cursor.moveToNext());

            cursor.close();
        } else {
            Toast.makeText(this, "No yoga classes found", Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }
}