package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.widget.ImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> countList= new ArrayList<>();
    private ArrayList<String> dateList= new ArrayList<>();
    private ArrayList<String> exerciseList= new ArrayList<>();
    private ArrayList<String> minutesList= new ArrayList<>();
    String name;
    int age, weight, height;
    TextView ageDisp;
    EditText nameText, ageText, weightText, heightText;
    double totalCarb,totalPro,totalFat,totalFiber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText=(EditText) findViewById(R.id.nameText);
        ageText=(EditText) findViewById(R.id.ageText);
        weightText=(EditText) findViewById(R.id.weightText);
        heightText=(EditText) findViewById(R.id.heightText);
        //getting the variables from the other activity
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

            ageDisp = (TextView) findViewById(R.id.textView);
            ageDisp.setText("age: " + age);
        }




    }
    public void goToStart(View view) {
        countList.add("Number");
        dateList.add("Date");
        exerciseList.add("Type of Exercise");
        minutesList.add("Time (Minutes)");
        totalCarb=0.0;
        totalPro=0.0;
        totalFat=0.0;
        totalFiber=0.0;
        Intent intent= new Intent(MainActivity.this ,StartActivity.class);
        age=Integer.valueOf(String.valueOf(ageText.getText()));
        name=String.valueOf(nameText.getText());
        weight=Integer.valueOf(String.valueOf(weightText.getText()));
        height=Integer.valueOf(String.valueOf(heightText.getText()));
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