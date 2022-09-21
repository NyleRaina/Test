package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    String name;
    int age, weight, height;
    EditText nameTxt, ageTxt, weightTxt, heightTxt;

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
        startActivity(intent);
    }
}