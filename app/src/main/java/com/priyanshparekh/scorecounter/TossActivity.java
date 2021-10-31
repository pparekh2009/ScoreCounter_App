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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

import java.util.Random;

public class TossActivity extends AppCompatActivity {

//    TextView tossTextView;
    Button tossButton;
    ImageView tossImageView;

    String unityGameId = "4402543";
    Boolean testMode = true;
    Boolean enableLoad = true;
    String adUnitId = "Banner_Android";

    UnityBannerListener bannerListener = new UnityBannerListener();

    BannerView bannerView;
    RelativeLayout bannerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);

//        tossTextView = findViewById(R.id.toss_textview);
        tossButton = findViewById(R.id.toss_button);
        tossImageView = findViewById(R.id.toss_imageview);

        UnityAds.initialize(this, unityGameId, null, testMode, enableLoad);

        bannerView = new BannerView(this, adUnitId, new UnityBannerSize(320, 50));
        bannerView.setListener(bannerListener);
        bannerView.load();

        bannerLayout = findViewById(R.id.toss_banner_layout);
        bannerLayout.addView(bannerView);

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

    private class UnityBannerListener implements BannerView.IListener, IUnityAdsListener {

        @Override
        public void onUnityAdsReady(String s) {

        }

        @Override
        public void onUnityAdsStart(String s) {

        }

        @Override
        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {

        }

        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

        }

        @Override
        public void onBannerLoaded(BannerView bannerView) {

        }

        @Override
        public void onBannerClick(BannerView bannerView) {

        }

        @Override
        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {

        }

        @Override
        public void onBannerLeftApplication(BannerView bannerView) {

        }
    }
}