package com.example.apifinally;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import java.util.FormatFlagsConversionMismatchException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import cz.msebera.android.httpclient.Header;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url1 = "http://api.weatherapi.com/v1/current.json?key=7c9157e232654b0090d12513221409&q=Chicago&aqi=no";//api URL MUST HAVE HTTPS:// THAT IS NOT OPTIONAL
                //APPID is your apikey that you get from signing up
//                String url1 = "https://jsonplaceholder.typicode.com/posts/1";

                new AsyncHttpClient().get(url1, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);//this will show all the raw data which can be substringed for individual data
                        txt.setText(str);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        error.printStackTrace();//wil print error message
                    }
                });
            }//There are additional steps in the gradle scripts and manifests so watch the youtube tutorial
        });

    }


}