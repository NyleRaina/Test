package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    private ArrayList<String> countList= new ArrayList<>();
    private ArrayList<String> dateList= new ArrayList<>();
    private ArrayList<String> exerciseList= new ArrayList<>();
    private ArrayList<String> minutesList= new ArrayList<>();
    String name;
    int age, weight, height;
    EditText nameTxt, ageTxt, weightTxt, heightTxt;
    double totalCarb,totalPro,totalFat,totalFiber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        nameTxt=(EditText) findViewById(R.id.txtName);
        ageTxt=(EditText) findViewById(R.id.txtAge);
        weightTxt=(EditText) findViewById(R.id.txtWeight);
        heightTxt=(EditText) findViewById(R.id.txtHeight);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name=extras.getString("name");
            age = extras.getInt("age");
            weight=extras.getInt("weight");
            height=extras.getInt("height");
            countList=extras.getStringArrayList("count");
            dateList= extras.getStringArrayList("date");
            exerciseList= extras.getStringArrayList("exercise");
            minutesList= extras.getStringArrayList("minutes");
            totalCarb=extras.getDouble("carb");
            totalPro=extras.getDouble("protein");
            totalFat=extras.getDouble("fat");
            totalFiber=extras.getDouble("fiber");

            ageTxt.setText(""+age);
            nameTxt.setText(name);
            weightTxt.setText(""+weight);
            heightTxt.setText(""+height);
        }
    }
    public void goStart(View view) {
        Intent intent= new Intent(SettingsActivity.this ,StartActivity.class);
        intent.putExtra("age", age);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        intent.putExtra("count", countList);
        intent.putExtra("date", dateList);
        intent.putExtra("exercise", exerciseList);
        intent.putExtra("minutes", minutesList);
        intent.putExtra("carb",totalCarb);
        intent.putExtra("protein", totalPro);
        intent.putExtra("fat", totalFat);
        intent.putExtra("fiber", totalFiber);
        startActivity(intent);
    }
}