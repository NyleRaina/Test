package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NutritionActivity extends AppCompatActivity {

    String name;
    int age, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            age = extras.getInt("age");
            weight = extras.getInt("weight");
            height = extras.getInt("height");

        }
    }
    public void nutritionBackStart(View view) {
        Intent intent= new Intent(NutritionActivity.this ,StartActivity.class);
        intent.putExtra("age", age);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        startActivity(intent);
    }
}