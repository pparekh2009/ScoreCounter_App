package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class TossActivity extends AppCompatActivity {

//    TextView tossTextView;
    Button tossButton;
    ImageView tossImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);

//        tossTextView = findViewById(R.id.toss_textview);
        tossButton = findViewById(R.id.toss_button);
        tossImageView = findViewById(R.id.toss_imageview);

        String[] toss_possibilities = {"Heads", "Tails"};
        int[] toss_images = {R.drawable.tossh, R.drawable.tosst};

        Random random = new Random();
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.dice_animation);


        tossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = random.nextInt(toss_possibilities.length);

//                tossTextView.setText(toss_possibilities[num]);

                tossImageView.setImageResource(toss_images[num]);

                ObjectAnimator animation = (ObjectAnimator) AnimatorInflater.loadAnimator(TossActivity.this, R.animator.toss_animator);
                animation.setTarget(tossImageView);
                animation.setDuration(750);
                animation.start();
//                tossImageView.startAnimation(animation);
            }
        });
    }
}