package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import com.unity3d.ads.IUnityAdsListener;
//import com.unity3d.ads.UnityAds;
//import com.unity3d.services.banners.BannerErrorInfo;
//import com.unity3d.services.banners.BannerView;
//import com.unity3d.services.banners.UnityBannerSize;

public class TwoPlayerActivity extends AppCompatActivity {

    Button tpChangeNameBtn, tpResetBtn;
    Button tpPlayer1Btn, tpPlayer2Btn;
    TextView tpPlayer1Name, tpPlayer2Name;
    int tp_p1_score = 0;
    int tp_p2_score = 0;
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.5f);

//    String unityGameId = "4402543";
//    Boolean testMode = true;
//    Boolean enableLoad = true;
//    String adUnitId = "Banner_Android";
//
//    UnityBannerListener bannerListener = new UnityBannerListener();
//
//    BannerView bannerView;
//    RelativeLayout bannerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

        tpChangeNameBtn = findViewById(R.id.tp_change_name_btn);
        tpResetBtn = findViewById(R.id.tp_reset_btn);
        tpPlayer1Btn = findViewById(R.id.tp_player_1_btn);
        tpPlayer2Btn = findViewById(R.id.tp_player_2_btn);
        tpPlayer1Name = findViewById(R.id.tp_player_1_name);
        tpPlayer2Name = findViewById(R.id.tp_player_2_name);

//        UnityAds.initialize(this, unityGameId, null, testMode, enableLoad);
//
//        bannerView = new BannerView(this, adUnitId, new UnityBannerSize(320, 50));
//        bannerView.setListener(bannerListener);
//        bannerView.load();
//
//        bannerLayout = findViewById(R.id.twp_banner_layout);
//        bannerLayout.addView(bannerView);

        // Increment score for player 1
        tpPlayer1Btn.setOnClickListener(v -> {
            tp_p1_score++;
            tpPlayer1Btn.setText(String.valueOf(tp_p1_score));
            v.startAnimation(buttonClick);
        });

        // Decrement score for player 1
        tpPlayer1Btn.setOnLongClickListener(v -> {
            if(tp_p1_score > 0) {
                tp_p1_score--;
                tpPlayer1Btn.setText(String.valueOf(tp_p1_score));
            }
            else {
                tpPlayer1Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        // Increment score for player 2
        tpPlayer2Btn.setOnClickListener(v -> {
            tp_p2_score++;
            tpPlayer2Btn.setText(String.valueOf(tp_p2_score));
            v.startAnimation(buttonClick);
        });

        // Decrement score for player 2
        tpPlayer2Btn.setOnLongClickListener(v -> {
            if(tp_p2_score > 0) {
                tp_p2_score--;
                tpPlayer2Btn.setText(String.valueOf(tp_p2_score));
            }
            else {
                tpPlayer2Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        tpResetBtn.setOnClickListener(v -> {
            tp_p1_score = 0;
            tp_p2_score = 0;
            tpPlayer1Btn.setText("0");
            tpPlayer2Btn.setText("0");
            v.startAnimation(buttonClick);
        });

        tpChangeNameBtn.setOnClickListener(v -> {
            v.startAnimation(buttonClick);
            showAlertDialog();
        });
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Names");

        final View customLayout = getLayoutInflater().inflate(R.layout.tp_dialog_box, null);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", (dialog, which) -> {
            EditText tpP1Input = customLayout.findViewById(R.id.tp_p1_input);
            EditText tpP2Input = customLayout.findViewById(R.id.tp_p2_input);

            setPlayerNames(tpP1Input.getText().toString(), tpP2Input.getText().toString());
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {});

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setPlayerNames(String name1, String name2) {

        if (name1.equals("") && name2.equals("")) {
            tpPlayer1Name.setText(R.string.player_1_name);
            tpPlayer2Name.setText(R.string.player_2_name);
        }
        else if (name1.equals("")) {
            tpPlayer1Name.setText(R.string.player_1_name);
            tpPlayer2Name.setText(name2);
        }
        else if (name2.equals("")) {
            tpPlayer1Name.setText(name1);
            tpPlayer2Name.setText(R.string.player_2_name);
        }
        else {
            tpPlayer1Name.setText(name1);
            tpPlayer2Name.setText(name2);
        }
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