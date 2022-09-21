package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    String name;
    int age, weight, height;
//    TextView ageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name=extras.getString("name");
            age = extras.getInt("age");
            weight=extras.getInt("weight");
            height=extras.getInt("height");

            //The key argument here must match that used in the other activity

//            ageText =  (TextView) findViewById(R.id.textView2);
//            ageText.setText("Age: " +  age);


        }
    }
    public void goBack(View view) {
        Intent intent= new Intent(StartActivity.this ,MainActivity.class);
        intent.putExtra("age", age);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        startActivity(intent);
    }
    public void goSettings(View view) {
        Intent intent= new Intent(StartActivity.this ,SettingsActivity.class);
        intent.putExtra("age", age);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        startActivity(intent);
    }
    public void goNutrition(View view) {
        Intent intent= new Intent(StartActivity.this ,NutritionActivity.class);
        intent.putExtra("age", age);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        startActivity(intent);
    }
    public void goExercise(View view) {
        Intent intent= new Intent(StartActivity.this ,ExerciseActivity.class);
        intent.putExtra("age", age);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        startActivity(intent);
    }

}