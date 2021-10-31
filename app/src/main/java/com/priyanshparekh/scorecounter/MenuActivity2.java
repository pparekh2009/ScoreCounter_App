package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBannerSize;

public class MenuActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] players = {"Select Player", "1 Player", "2 Players", "3 Players", "4 Players"};

    String unityGameId = "4402543";
    Boolean testMode = true;
    Boolean enableLoad = true;
    String adUnitId = "Banner_Android";

    UnityBannerListener bannerListener = new UnityBannerListener();

    BannerView bannerView;
    RelativeLayout bannerLayout;

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        UnityAds.initialize(this, unityGameId, null, testMode, enableLoad);

        bannerView = new BannerView(this, adUnitId, new UnityBannerSize(320, 50));
        bannerView.setListener(bannerListener);
        bannerView.load();

        bannerLayout = findViewById(R.id.banner_layout);
        bannerLayout.addView(bannerView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, players);
        spinner.setAdapter(arrayAdapter);

        spinner.setSelection(0, true);
        View v = spinner.getSelectedView();
        ((TextView)v).setTextColor(Color.WHITE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity2.this, TossActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity2.this, DiceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Intent intent;
        switch(position) {
            case 0:
                doNothing();
                break;
            case 1:
                startIntent(OnePlayerActivity.class);
//                intent = new Intent(MenuActivity2.this, OnePlayerActivity.class);
//                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MenuActivity2.this, TwoPlayerActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(MenuActivity2.this, ThreePlayerActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(MenuActivity2.this, FourPlayerActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void doNothing(){}

    public void startIntent(Class<?> toClass) {
        Intent intent = new Intent(MenuActivity2.this, toClass);
        startActivity(intent);
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