package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String name;
    int age, weight, height;
    TextView ageDisp;
    EditText nameText, ageText, weightText, heightText;

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

            ageDisp = (TextView) findViewById(R.id.textView);
            ageDisp.setText("age: " + age);
        }
    }
    public void goToStart(View view) {
        Intent intent= new Intent(MainActivity.this ,StartActivity.class);
        age=Integer.valueOf(String.valueOf(ageText.getText()));
        name=String.valueOf(nameText.getText());
        weight=Integer.valueOf(String.valueOf(weightText.getText()));
        height=Integer.valueOf(String.valueOf(heightText.getText()));
        intent.putExtra("age", age);
        intent.putExtra("name", name);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        startActivity(intent);
    }
}