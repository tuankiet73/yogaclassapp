package com.example.yogaclassapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddYogaClassActivity extends AppCompatActivity {
    private EditText dayEditText, timeEditText, capacityEditText, durationEditText, priceEditText, typeEditText, descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_yoga_class);

        dayEditText = findViewById(R.id.dayEditText);
        timeEditText = findViewById(R.id.timeEditText);
        capacityEditText = findViewById(R.id.capacityEditText);
        durationEditText = findViewById(R.id.durationEditText);
        priceEditText = findViewById(R.id.priceEditText);
        typeEditText = findViewById(R.id.typeEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
    }

    public void saveYogaClass(View view) {
        String day = dayEditText.getText().toString();
        String time = timeEditText.getText().toString();
        String capacity = capacityEditText.getText().toString();
        String duration = durationEditText.getText().toString();
        String price = priceEditText.getText().toString();
        String type = typeEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        if (day.isEmpty() || time.isEmpty() || capacity.isEmpty() || duration.isEmpty() || price.isEmpty() || type.isEmpty()) {
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save the yoga class to the database
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("day", day);
        values.put("time", time);
        values.put("capacity", Integer.parseInt(capacity));
        values.put("duration", Integer.parseInt(duration));
        values.put("price", Double.parseDouble(price));
        values.put("type", type);
        values.put("description", description);
        db.insert("yoga_classes", null, values);
        db.close();

        Toast.makeText(this, "Yoga class saved successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}