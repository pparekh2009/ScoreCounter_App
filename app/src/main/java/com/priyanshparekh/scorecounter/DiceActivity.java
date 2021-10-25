package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    TextView diceTextView;
    ImageView diceImageView;
    Button diceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        diceImageView = findViewById(R.id.dice_imageView);
        diceButton = findViewById(R.id.dice_button);

        Animation diceAnimation = AnimationUtils.loadAnimation(this, R.anim.dice_animation);
//        Animation.AnimationListener animationListener = new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        };

        int[] images = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Random random = new Random();

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = random.nextInt(6);
//                textView.setText(String.valueOf(num+1));

                diceImageView.setImageResource(images[num]);

                diceImageView.startAnimation(diceAnimation);
            }
        });
    }
}