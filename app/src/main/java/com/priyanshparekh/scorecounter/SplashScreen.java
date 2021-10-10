package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIMEOUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            Intent i =new Intent(SplashScreen.this, MenuActivity.class);
            startActivity(i);
            finish();
        }, SPLASH_SCREEN_TIMEOUT);

    }
}