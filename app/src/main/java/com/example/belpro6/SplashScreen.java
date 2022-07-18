package com.example.belpro6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    int loading = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.contains("tokens")){
                    Intent home=new Intent(SplashScreen.this, Landing.class);
                    startActivity(home);
                }
                else {
                    Intent home = new Intent(SplashScreen.this, Landing.class);
                    startActivity(home);
                }
                finish();
            }
        },loading);
    }
}