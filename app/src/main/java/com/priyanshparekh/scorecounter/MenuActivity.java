package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.Button;


public class MenuActivity extends AppCompatActivity {

    Button plyr1Btn, plyr2Btn, plyr3Btn, plyr4Btn;
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        plyr1Btn = findViewById(R.id.plyr_1_btn);
        plyr2Btn = findViewById(R.id.plyr_2_btn);
        plyr3Btn = findViewById(R.id.plyr_3_btn);
        plyr4Btn = findViewById(R.id.plyr_4_btn);

        plyr1Btn.setOnClickListener(v -> {
            v.startAnimation(buttonClick);
            Intent intent = new Intent(MenuActivity.this, OnePlayerActivity.class);
            startActivity(intent);
        });

        plyr2Btn.setOnClickListener(v -> {
            v.startAnimation(buttonClick);
            Intent intent = new Intent(MenuActivity.this, TwoPlayerActivity.class);
            startActivity(intent);
        });

        plyr3Btn.setOnClickListener(v -> {
            v.startAnimation(buttonClick);
            Intent intent = new Intent(MenuActivity.this, ThreePlayerActivity.class);
            startActivity(intent);
        });

        plyr4Btn.setOnClickListener(v -> {
            v.startAnimation(buttonClick);
            Intent intent = new Intent(MenuActivity.this, FourPlayerActivity.class);
            startActivity(intent);
        });
    }
}