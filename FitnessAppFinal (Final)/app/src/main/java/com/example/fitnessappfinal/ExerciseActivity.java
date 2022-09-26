package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ArrayList<Model> productList  = new ArrayList<Model>();
    private ArrayList<String> countList= new ArrayList<>();
    private ArrayList<String> dateList= new ArrayList<>();
    private ArrayList<String> exerciseList= new ArrayList<>();
    private ArrayList<String> minutesList= new ArrayList<>();
    String name;
    int age, weight, height;
    double totalCarb,totalPro,totalFat,totalFiber;
    TextView amtExercise;

    private TextView selection;
    Model item1, item2, item3, item4, item5, item6;


    // Add Button
    Button GBB;

    // For Text View
    String Type_of_Excercise, Date = "9/26/2022", SelectionString;

    int current_excercise_time = 0, Number_Count, Spinner_One  = 0;



    // Total Excercise Amounts
    int amount_of_exercise_total_min=0, running_min=0, walking_min=0, biking_min=0,
            swimming_min=0, hiking_min=0;

    EditText Minutes;
    String[] items = new String[]{"Running", "Walking", "Biking", "Swimming", "Hiking"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        amtExercise=(TextView) findViewById(R.id.exerText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            age = extras.getInt("age");
            weight = extras.getInt("weight");
            height = extras.getInt("height");
            countList=extras.getStringArrayList("count");
            dateList= extras.getStringArrayList("date");
            exerciseList= extras.getStringArrayList("exercise");
            minutesList= extras.getStringArrayList("minutes");
            totalCarb=extras.getDouble("carb");
            totalPro=extras.getDouble("protein");
            totalFat=extras.getDouble("fat");
            totalFiber=extras.getDouble("fiber");

        }
        System.out.println(countList);
        System.out.println(dateList);
        System.out.println(exerciseList);
        System.out.println(minutesList);
        selection=(TextView)findViewById(R.id.selection);

        Spinner spin=(Spinner)findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                items);

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        Minutes = (EditText) findViewById(R.id.editTextNumber);


        ListView lview = (ListView) findViewById(R.id.listview);
        listviewAdapter adapter = new listviewAdapter(this, productList);
        lview.setAdapter((ListAdapter) adapter);


//        populateList();
//        item1 = new Model("Number", "Date", "Type of Excercise", "Time (Minutes)");
//        productList.add(item1);
//
//        adapter.notifyDataSetChanged();
        Number_Count=countList.size();
        for(int i=0;i<countList.size();i++) {
            item2 = new Model(countList.get(i), dateList.get(i), exerciseList.get(i), minutesList.get(i));
            productList.add(item2);
            adapter.notifyDataSetChanged();
            if(exerciseList.get(i).equals("Running")){
                running_min+=Integer.parseInt(minutesList.get(i));
            }else if(exerciseList.get(i).equals("Walking")){
                walking_min+=Integer.parseInt(minutesList.get(i));
            }else if(exerciseList.get(i).equals("Biking")){
                biking_min+=Integer.parseInt(minutesList.get(i));
            }else if(exerciseList.get(i).equals("Swimming")){
                swimming_min+=Integer.parseInt(minutesList.get(i));
            }else if(exerciseList.get(i).equals("Hiking")){
                hiking_min+=Integer.parseInt(minutesList.get(i));
            }
            if(i>0) {
                amount_of_exercise_total_min += Integer.parseInt(minutesList.get(i));
            }
        }
        System.out.println(running_min);
        System.out.println(walking_min);
        System.out.println(biking_min);
        System.out.println(swimming_min);
        System.out.println(hiking_min);
        System.out.println(amount_of_exercise_total_min);
        amtExercise.setText("You've worked out for "+amount_of_exercise_total_min+ " minutes");



        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String sno = ((TextView)view.findViewById(R.id.sNo)).getText().toString();
                String product = ((TextView)view.findViewById(R.id.product)).getText().toString();
                String category = ((TextView)view.findViewById(R.id.category)).getText().toString();
                String price = ((TextView)view.findViewById(R.id.price)).getText().toString();

                Toast.makeText(getApplicationContext(),
                        "S no : " + sno +"\n"
                                +"Product : " + product +"\n"
                                +"Category : " +category +"\n"
                                +"Price : " +price, Toast.LENGTH_SHORT).show();
            }
        });


        GBB = findViewById(R.id.button7);

        // Add Button
        GBB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Makes Number and Time a String
                String Minutes_String = Minutes.getText().toString();
                String Count_TO_String = String.valueOf(Number_Count);

                int Min = convert(Minutes_String);

                // Depending On Catagory Add to Total Min
                switch (SelectionString) {
                    case "Running":
                        running_min += Min;
                        break;
                    case "Walking":
                        walking_min += Min;
                        break;
                    case "Biking":
                        biking_min += Min;
                        break;
                    case "Swimming":
                        swimming_min += Min;
                        break;
                    case "Hiking":
                        hiking_min += Min;
                        break;
                }

                amount_of_exercise_total_min+=Min;
                amtExercise.setText("You've worked out for "+amount_of_exercise_total_min+ " minutes");
                // Add items to text view
                countList.add(Count_TO_String);
                dateList.add(Date);
                exerciseList.add(SelectionString);
                minutesList.add(Minutes_String);
                item5 = new Model(Count_TO_String, Date, SelectionString, Minutes_String);
                productList.add(item5);
                adapter.notifyDataSetChanged();

                // Increase Number by one
                Number_Count++;
            }
        });

    }


    public void onItemSelected(AdapterView<?> parent,
                               View v, int position, long id) {
        // Put Selected Excercise Into a String
        if (Spinner_One >= 1) {
            selection.setText(items[position]);
            SelectionString = selection.getText().toString();
        }
        // Don't Show the Excercise As soon as u pull up the button
        Spinner_One++;


    }

    // Set Text to Excercise Type
    public void onNothingSelected(AdapterView<?> parent) {
        selection.setText("");
    }


    // Convert String to Int
    // Used for Minutes Grabbed From Text Field
    public static int convert(String str)
    {
        int val = 0;
        System.out.println("String = " + str);

        // Convert the String
        try {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {

            // This is thrown when the String
            // contains characters other than digits
            System.out.println("Invalid String");
        }
        return val;
    }


    public void exerciseBackStart(View view) {
        Intent intent= new Intent(ExerciseActivity.this ,StartActivity.class);
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
