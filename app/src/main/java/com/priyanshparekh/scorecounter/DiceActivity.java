package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    ImageView diceImageView;
    Button diceButton;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        diceImageView = findViewById(R.id.dice_imageView);
        diceButton = findViewById(R.id.dice_button);

        mp = MediaPlayer.create(this, R.raw.rolling_dice);

        Animation diceAnimation = AnimationUtils.loadAnimation(this, R.anim.dice_animation);
        diceAnimation.setDuration(100);

        int[] images = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Random random = new Random();

        diceButton.setOnClickListener(v -> {
            int num = random.nextInt(6);

            new Handler().postDelayed(() -> diceImageView.setImageResource(images[num]), 750);

            diceImageView.startAnimation(diceAnimation);
            mp.start();
        });
    }

}