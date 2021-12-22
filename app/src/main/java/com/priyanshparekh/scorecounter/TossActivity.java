package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

//import com.unity3d.ads.IUnityAdsListener;
//import com.unity3d.ads.UnityAds;
//import com.unity3d.services.banners.BannerErrorInfo;
//import com.unity3d.services.banners.BannerView;
//import com.unity3d.services.banners.UnityBannerSize;

import java.util.Random;

public class TossActivity extends AppCompatActivity {

    Button tossButton;
    ImageView tossImageView;

//    String unityGameId = "4402543";
//    Boolean testMode = true;
//    Boolean enableLoad = true;
//    String adUnitId = "Banner_Android";
//
//    UnityBannerListener bannerListener = new UnityBannerListener();

//    BannerView bannerView;
//    RelativeLayout bannerLayout;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);

        tossButton = findViewById(R.id.toss_button);
        tossImageView = findViewById(R.id.toss_imageview);

//        UnityAds.initialize(this, unityGameId, null, testMode, enableLoad);

//        bannerView = new BannerView(this, adUnitId, new UnityBannerSize(320, 50));
//        bannerView.setListener(bannerListener);
//        bannerView.load();
//
//        bannerLayout = findViewById(R.id.toss_banner_layout);
//        bannerLayout.addView(bannerView);

        mp = MediaPlayer.create(this, R.raw.tossing_coin);

        String[] toss_possibilities = {"Heads", "Tails"};
        int[] toss_images = {R.drawable.tossh_copy, R.drawable.tosst_copy};

        Random random = new Random();

        tossButton.setOnClickListener(v -> {
            int num = random.nextInt(toss_possibilities.length);

            ObjectAnimator animation = (ObjectAnimator) AnimatorInflater.loadAnimator(TossActivity.this, R.animator.toss_animator);
            animation.setTarget(tossImageView);
            animation.setDuration(1500);
            animation.start();

            new Handler().postDelayed(() -> tossImageView.setImageResource(toss_images[num]), 1250);

            mp.start();
        });
    }

//    private static class UnityBannerListener implements BannerView.IListener, IUnityAdsListener {
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