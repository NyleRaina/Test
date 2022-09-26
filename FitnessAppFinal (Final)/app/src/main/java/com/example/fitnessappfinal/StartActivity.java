package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.widget.ImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {
    private ArrayList<String> countList = new ArrayList<>();
    private ArrayList<String> dateList = new ArrayList<>();
    private ArrayList<String> exerciseList = new ArrayList<>();
    private ArrayList<String> minutesList = new ArrayList<>();
    String name;
    int age, weight, height;
    TextView selection, motivationText;
    double totalCarb, totalPro, totalFat, totalFiber;
    String[] messages = new String[]{"Have fun, but don't overwork yourself!", "Exercise may be tedious but it's good for you", "A good diet is just as important as exercise", "You're on a streak of 4 days!", "Try to push yourself today!"};
//    TextView ageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            age = extras.getInt("age");
            weight = extras.getInt("weight");
            height = extras.getInt("height");
            countList = extras.getStringArrayList("count");
            dateList = extras.getStringArrayList("date");
            exerciseList = extras.getStringArrayList("exercise");
            minutesList = extras.getStringArrayList("minutes");
            totalCarb = extras.getDouble("carb");
            totalPro = extras.getDouble("protein");
            totalFat = extras.getDouble("fat");
            totalFiber = extras.getDouble("fiber");
            //The key argument here must match that used in the other activity

//            ageText =  (TextView) findViewById(R.id.textView2);
//            ageText.setText("Age: " +  age);


        }
        selection = (TextView) findViewById(R.id.textView6);
        selection.setText("Welcome " + name);
        ImageButton Button1 = (ImageButton) findViewById(R.id.imageButton);
        ImageButton Button2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton Button3 = (ImageButton) findViewById(R.id.imageButton3);
        motivationText=(TextView) findViewById(R.id.motivationText);
        motivationText.setText(messages[(int) (Math.random()*5)]);


    Button1.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(StartActivity.this, NutritionActivity.class);
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
    });


Button2.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(StartActivity.this, ExerciseActivity.class);
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
    });


Button3.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(StartActivity.this, SettingsActivity.class);
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
    });
}





//    public void goBack(View view) {
//        Intent intent= new Intent(StartActivity.this ,MainActivity.class);
//        intent.putExtra("age", age);
//        intent.putExtra("name", name);
//        intent.putExtra("weight", weight);
//        intent.putExtra("height", height);
//        intent.putExtra("count", countList);
//        intent.putExtra("date", dateList);
//        intent.putExtra("exercise", exerciseList);
//        intent.putExtra("minutes", minutesList);
//        intent.putExtra("carb",totalCarb);
//        intent.putExtra("protein", totalPro);
//        intent.putExtra("fat", totalFat);
//        intent.putExtra("fiber", totalFiber);
//        startActivity(intent);
//    }
//    public void goSettings(View view) {
//        Intent intent= new Intent(StartActivity.this ,SettingsActivity.class);
//        intent.putExtra("age", age);
//        intent.putExtra("name", name);
//        intent.putExtra("weight", weight);
//        intent.putExtra("height", height);
//        intent.putExtra("count", countList);
//        intent.putExtra("date", dateList);
//        intent.putExtra("exercise", exerciseList);
//        intent.putExtra("minutes", minutesList);
//        intent.putExtra("carb",totalCarb);
//        intent.putExtra("protein", totalPro);
//        intent.putExtra("fat", totalFat);
//        intent.putExtra("fiber", totalFiber);
//        startActivity(intent);
//    }
//    public void goNutrition(View view) {
//        Intent intent= new Intent(StartActivity.this ,NutritionActivity.class);
//        intent.putExtra("age", age);
//        intent.putExtra("name", name);
//        intent.putExtra("weight", weight);
//        intent.putExtra("height", height);
//        intent.putExtra("count", countList);
//        intent.putExtra("date", dateList);
//        intent.putExtra("exercise", exerciseList);
//        intent.putExtra("minutes", minutesList);
//        intent.putExtra("carb",totalCarb);
//        intent.putExtra("protein", totalPro);
//        intent.putExtra("fat", totalFat);
//        intent.putExtra("fiber", totalFiber);
//        startActivity(intent);
//    }
//    public void goExercise(View view) {
//        Intent intent= new Intent(StartActivity.this ,ExerciseActivity.class);
//        intent.putExtra("age", age);
//        intent.putExtra("name", name);
//        intent.putExtra("weight", weight);
//        intent.putExtra("height", height);
//        intent.putExtra("count", countList);
//        intent.putExtra("date", dateList);
//        intent.putExtra("exercise", exerciseList);
//        intent.putExtra("minutes", minutesList);
//        intent.putExtra("carb",totalCarb);
//        intent.putExtra("protein", totalPro);
//        intent.putExtra("fat", totalFat);
//        intent.putExtra("fiber", totalFiber);
//        startActivity(intent);
//    }

}