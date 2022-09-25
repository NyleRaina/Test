package com.example.fitnessappfinal;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import cz.msebera.android.httpclient.Header;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

public class NutritionActivity extends AppCompatActivity {
    private Button btn,GraphButtonNut,buttonTableNut;
    private TextView txt;
    private EditText itemName, brandName;
    PieChart piechart;
    private String str1,str2;
    int servingSize=0;
    ListView lstView;
    ArrayList<String> listViewArrayList=new ArrayList<>();
    ArrayList<Integer> arrayListProteinServingSize=new ArrayList<>();
    ArrayList<Integer> arrayListCarbServingSize=new ArrayList<>();
    ArrayList<Integer> arrayListFatServingSize=new ArrayList<>();
    ArrayList<Integer> arrayListFiberServingSize=new ArrayList<>();
    ArrayList<PieEntry> pieEntries=new ArrayList<>();

    private boolean proTrue,carbTrue,fatTrue,fiberTrue;
    String name;
    int age, weight, height;
    double percentCarb,percentPro,percentFat,percentFib;
    double total=0.0;
    double totalCarb,totalPro,totalFat,totalFiber;

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

        lstView=findViewById(R.id.listViewType);
        piechart=findViewById(R.id.pie_chart);
//        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        GraphButtonNut=findViewById(R.id.GraphButtonNut);
        txt = findViewById(R.id.textView);
        itemName=findViewById(R.id.foodName);
        listViewArrayList.add("Protein");
        listViewArrayList.add("Carb");
        listViewArrayList.add("Fat");
        listViewArrayList.add("Fiber");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,listViewArrayList);
        lstView.setAdapter(arrayAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    proTrue=true;

                }
                if(i==1){
                    carbTrue=true;
                }
                if(i==2){
                    fatTrue=true;
                }
                if(i==3){
                    fiberTrue=true;
                }
                lstView.setVisibility(View.INVISIBLE);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstView.setVisibility(View.VISIBLE);

                itemName=findViewById(R.id.foodName);

                str1= String.valueOf(itemName.getText());
                System.out.println(str1+""+str2);



                String url1 = "https://api.nal.usda.gov/fdc/v1/foods/search?query="+str1+"&pageSize=2&api_key=oSgby2wXUBdGIadufb93LBIyb8TgjgEvmX6D9O52";//api URL MUST HAVE HTTPS:// THAT IS NOT OPTIONAL
                //APPID is your apikey that you get from signing up
//                String url1 = "https://jsonplaceholder.typicode.com/posts/1";

                new AsyncHttpClient().get(url1, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);//this will show all the raw data which can be substringed for individual data
                        System.out.println(str.indexOf("servingSize"));
                        String substrservingsize=str.substring(str.indexOf("servingSize")+35,str.indexOf("servingSize")+38);
                        if(substrservingsize.contains(".")){
                            substrservingsize=substrservingsize.substring(0,2);
                        }
                        servingSize= Integer.parseInt(substrservingsize);
                        if(proTrue){
                            proTrue=false;
                            arrayListProteinServingSize.add(servingSize);
                        }
                        if(carbTrue){
                            carbTrue=false;
                            arrayListCarbServingSize.add(servingSize);
                        }
                        if(fatTrue){
                            fatTrue=false;
                            arrayListFatServingSize.add(servingSize);
                        }
                        if(fiberTrue){
                            fiberTrue=false;
                            arrayListFiberServingSize.add(servingSize);
                        }
                    }


                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        error.printStackTrace();//wil print error message
                    }
                });
            }//There are additional steps in the gradle scripts and manifests so watch the youtube tutorial
        });

        GraphButtonNut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float percentCarb2=(float)percentCarb;
                Float percentPro2=(float)percentPro;
                Float percentFib2=(float)percentFib;
                Float percentFat2=(float)percentFat;
                    //cpnverting to float
                    //Initilize pie chart entry
                    PieEntry pieEntry=new PieEntry(0,percentCarb2);
                PieEntry pieEntry1=new PieEntry(1,percentFat2);
                PieEntry pieEntry2=new PieEntry(2,percentFib2);
                PieEntry pieEntry3=new PieEntry(3,percentPro2);
                    pieEntries.add(pieEntry);
                pieEntries.add(pieEntry1);
                pieEntries.add(pieEntry2);
                pieEntries.add(pieEntry3);
                for (int i = 0; i < arrayListCarbServingSize.size(); i++) {
                    totalCarb=arrayListCarbServingSize.get(i)+totalCarb;
                }
                for (int i = 0; i < arrayListProteinServingSize.size(); i++) {
                    totalPro=arrayListProteinServingSize.get(i)+totalPro;
                }
                for (int i = 0; i < arrayListFatServingSize.size(); i++) {
                    totalFat=arrayListFatServingSize.get(i)+totalFat;
                }
                for (int i = 0; i < arrayListFiberServingSize.size(); i++) {
                    totalFiber=arrayListFiberServingSize.get(i)+totalFiber;
                }
                total=totalCarb+totalFiber+totalPro+totalFat;
                percentCarb=(totalCarb/total)*100.0;
                percentFat=(totalFat/total)*100.0;
                percentFib=(totalFiber/total)*100.0;
                percentPro=(totalPro/total)*100.0;
                System.out.println(percentCarb);
                System.out.println(percentFat);
                System.out.println(percentFib);
                System.out.println(percentPro);

                PieDataSet pieDataSet=new PieDataSet(pieEntries,"Percent type of Food eaten ");
                //setcolors
                pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                //set pie data
                piechart.setData(new PieData(pieDataSet));
                //set Animation
                piechart.animateXY(5000,5000);
                //hide description
                piechart.getDescription().setEnabled(false);

            }
        });
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