package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class TossActivity extends AppCompatActivity {

    Button tossButton;
    ImageView tossImageView;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);

        tossButton = findViewById(R.id.toss_button);
        tossImageView = findViewById(R.id.toss_imageview);

        mp = MediaPlayer.create(this, R.raw.tossing_coin);

        int[] toss_images = {R.drawable.tossh_copy, R.drawable.tosst_copy};

        Random random = new Random();

        tossButton.setOnClickListener(v -> {
            int num = random.nextInt(2);

            ObjectAnimator animation = (ObjectAnimator) AnimatorInflater.loadAnimator(TossActivity.this, R.animator.toss_animator);
            animation.setTarget(tossImageView);
            animation.setDuration(1500);
            animation.start();

            new Handler().postDelayed(() -> tossImageView.setImageResource(toss_images[num]), 1250);

            mp.start();
        });
    }
}