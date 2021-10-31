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

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;


public class ThreePlayerActivity extends AppCompatActivity {

    Button thpChangeNameBtn, thpResetBtn;
    Button thpPlayer1Btn, thpPlayer2Btn, thpPlayer3Btn;
    TextView thpPlayer1Name, thpPlayer2Name, thpPlayer3Name;
    int thp_p1_score = 0;
    int thp_p2_score = 0;
    int thp_p3_score = 0;
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.5f);

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
        setContentView(R.layout.activity_three_player);

        thpChangeNameBtn = findViewById(R.id.thp_change_name_btn);
        thpResetBtn = findViewById(R.id.thp_reset_btn);
        thpPlayer1Btn = findViewById(R.id.thp_player_1_btn);
        thpPlayer2Btn = findViewById(R.id.thp_player_2_btn);
        thpPlayer3Btn = findViewById(R.id.thp_player_3_btn);
        thpPlayer1Name = findViewById(R.id.thp_player_1_name);
        thpPlayer2Name = findViewById(R.id.thp_player_2_name);
        thpPlayer3Name = findViewById(R.id.thp_player_3_name);

        UnityAds.initialize(this, unityGameId, null, testMode, enableLoad);

        bannerView = new BannerView(this, adUnitId, new UnityBannerSize(320, 50));
        bannerView.setListener(bannerListener);
        bannerView.load();

        bannerLayout = findViewById(R.id.thp_banner_layout);
        bannerLayout.addView(bannerView);

        thpPlayer1Btn.setOnClickListener(v -> {
            thp_p1_score++;
            thpPlayer1Btn.setText(String.valueOf(thp_p1_score));
            v.startAnimation(buttonClick);
        });

        thpPlayer2Btn.setOnClickListener(v -> {
            thp_p2_score++;
            thpPlayer2Btn.setText(String.valueOf(thp_p2_score));
            v.startAnimation(buttonClick);
        });

        thpPlayer3Btn.setOnClickListener(v -> {
            thp_p3_score++;
            thpPlayer3Btn.setText(String.valueOf(thp_p3_score));
            v.startAnimation(buttonClick);
        });

        thpPlayer1Btn.setOnLongClickListener(v -> {
            if (thp_p1_score > 0) {
                thp_p1_score--;
                thpPlayer1Btn.setText(String.valueOf(thp_p1_score));
            }
            else {
                thpPlayer1Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        thpPlayer2Btn.setOnLongClickListener(v -> {
            if (thp_p2_score > 0) {
                thp_p2_score--;
                thpPlayer2Btn.setText(String.valueOf(thp_p2_score));
            }
            else {
                thpPlayer2Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        thpPlayer3Btn.setOnLongClickListener(v -> {
            if (thp_p3_score > 0) {
                thp_p3_score--;
                thpPlayer3Btn.setText(String.valueOf(thp_p3_score));
            }
            else {
                thpPlayer3Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        thpResetBtn.setOnClickListener(v -> {
            thp_p1_score = 0;
            thp_p2_score = 0;
            thp_p3_score = 0;
            thpPlayer1Btn.setText("0");
            thpPlayer2Btn.setText("0");
            thpPlayer3Btn.setText("0");
            v.startAnimation(buttonClick);
        });

        thpChangeNameBtn.setOnClickListener(v -> {
            v.startAnimation(buttonClick);
            showAlertDialog();
        });
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Names");

        final View customLayout = getLayoutInflater().inflate(R.layout.thp_dialog_box, null);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", (dialog, which) -> {
            EditText thpP1Input = customLayout.findViewById(R.id.thp_p1_input);
            EditText thpP2Input = customLayout.findViewById(R.id.thp_p2_input);
            EditText thpP3Input = customLayout.findViewById(R.id.thp_p3_input);

            setPlayerNames(thpP1Input.getText().toString(), thpP2Input.getText().toString(), thpP3Input.getText().toString());
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {});

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void setPlayerNames(String name1, String name2, String name3) {

        if (name1.equals("") && name2.equals("") && name3.equals("")) {
            thpPlayer1Name.setText(R.string.player_1_name);
            thpPlayer2Name.setText(R.string.player_2_name);
            thpPlayer3Name.setText(R.string.player_3_name);
        }
        else if (name1.equals("") && name2.equals("")) {
            thpPlayer1Name.setText(R.string.player_1_name);
            thpPlayer2Name.setText(R.string.player_2_name);
            thpPlayer3Name.setText(name3);
        }
        else if (name2.equals("") && name3.equals("")) {
            thpPlayer1Name.setText(name1);
            thpPlayer2Name.setText(R.string.player_2_name);
            thpPlayer3Name.setText(R.string.player_3_name);
        }
        else if (name1.equals("") && name3.equals("")) {
            thpPlayer1Name.setText(R.string.player_1_name);
            thpPlayer2Name.setText(name2);
            thpPlayer3Name.setText(R.string.player_3_name);
        }
        else if (name1.equals("")) {
            thpPlayer1Name.setText(R.string.player_1_name);
            thpPlayer2Name.setText(name2);
            thpPlayer3Name.setText(name3);
        }
        else if (name2.equals("")) {
            thpPlayer1Name.setText(name1);
            thpPlayer2Name.setText(R.string.player_2_name);
            thpPlayer3Name.setText(name3);
        }
        else if (name3.equals("")) {
            thpPlayer1Name.setText(name1);
            thpPlayer2Name.setText(name2);
            thpPlayer3Name.setText(R.string.player_3_name);
        }
        else {
            thpPlayer1Name.setText(name1);
            thpPlayer2Name.setText(name2);
            thpPlayer3Name.setText(name3);
        }
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