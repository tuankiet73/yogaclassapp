package com.example.yogaclassapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addYogaClass(View view) {
        Intent intent = new Intent(this, AddYogaClassActivity.class);
        startActivity(intent);
    }

    public void manageClasses(View view) {
        Intent intent = new Intent(this, ManageClassInstancesActivity.class);
        startActivity(intent);
    }

    public void searchClasses(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}