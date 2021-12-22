package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import com.unity3d.ads.IUnityAdsListener;
//import com.unity3d.ads.UnityAds;
//import com.unity3d.services.banners.BannerErrorInfo;
//import com.unity3d.services.banners.BannerView;
//import com.unity3d.services.banners.UnityBannerSize;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    TextView diceTextView;
    ImageView diceImageView;
    Button diceButton;

//    String unityGameId = "4402543";
//    Boolean testMode = true;
//    Boolean enableLoad = true;
//    String adUnitId = "Banner_Android";
//
//    UnityBannerListener bannerListener = new UnityBannerListener();
//
//    BannerView bannerView;
//    RelativeLayout bannerLayout;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        diceImageView = findViewById(R.id.dice_imageView);
        diceButton = findViewById(R.id.dice_button);

//        UnityAds.initialize(this, unityGameId, null, testMode, enableLoad);
//
//        bannerView = new BannerView(this, adUnitId, new UnityBannerSize(320, 50));
//        bannerView.setListener(bannerListener);
//        bannerView.load();
//
//        bannerLayout = findViewById(R.id.dice_banner_layout);
//        bannerLayout.addView(bannerView);

        mp = MediaPlayer.create(this, R.raw.rolling_dice);

        Animation diceAnimation = AnimationUtils.loadAnimation(this, R.anim.dice_animation);
        diceAnimation.setDuration(100);

        int[] images = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Random random = new Random();

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = random.nextInt(6);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        diceImageView.setImageResource(images[num]);
                    }
                }, 750);

                diceImageView.startAnimation(diceAnimation);
                mp.start();
            }
        });
    }

//    private class UnityBannerListener implements BannerView.IListener, IUnityAdsListener {
//
//        @Override
//        public void onUnityAdsReady(String s) {
//
//        }
//
//        @Override
//        public void onUnityAdsStart(String s) {
//
//        }
//
//        @Override
//        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
//
//        }
//
//        @Override
//        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {
//
//        }
//
//        @Override
//        public void onBannerLoaded(BannerView bannerView) {
//
//        }
//
//        @Override
//        public void onBannerClick(BannerView bannerView) {
//
//        }
//
//        @Override
//        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
//
//        }
//
//        @Override
//        public void onBannerLeftApplication(BannerView bannerView) {
//
//        }
//    }
}