// Gaurav Tiwari
package com.Gaurav.basicbankingapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


import com.Gaurav.basicbankingapp.R;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_SCREEN_TIME = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HomeScreen.class);
                startActivity(intent);
                finish();
            }
        } ,SPLASH_SCREEN_TIME);
    }
}