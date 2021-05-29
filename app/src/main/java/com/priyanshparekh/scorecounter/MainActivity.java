package com.priyanshparekh.scorecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    Button player1_btn, player2_btn, reset_btn;
    TextView player1_txt, player2_txt;
    int p1_score = 0;
    int p2_score = 0;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        adView = findViewById(R.id.homeBanner);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        player1_btn = findViewById(R.id.player1_btn);
        player2_btn = findViewById(R.id.player2_btn);
        reset_btn = findViewById(R.id.reset_btn);

        player1_txt = findViewById(R.id.player1_txt);
        player2_txt = findViewById(R.id.player2_txt);

        player1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_score = p1_score + 1;
                player1_btn.setText(String.valueOf(p1_score));
            }
        });

        player1_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(p1_score > 0) {
                    p1_score = p1_score - 1;
                    player1_btn.setText(String.valueOf(p1_score));
                }
                else {
                    player1_btn.setText("0");
                }
                return true;
            }
        });

        player2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2_score = p2_score + 1;
                player2_btn.setText(String.valueOf(p2_score));
            }
        });

        player2_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(p2_score > 0) {
                    p2_score = p2_score - 1;
                    player2_btn.setText(String.valueOf(p2_score));
                }
                else {
                    player2_btn.setText("0");
                }
                return true;
            }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_score = 0;
                p2_score = 0;
                player1_btn.setText("0");
                player2_btn.setText("0");
            }
        });
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter your name");

        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_box, null);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText p1_input = customLayout.findViewById(R.id.p1_input);
                EditText p2_input = customLayout.findViewById(R.id.p2_input);
                setPlayerNames(p1_input.getText().toString(), p2_input.getText().toString());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setPlayerNames(String name1, String name2) {
//        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        player1_txt.setText(name1);
        player2_txt.setText(name2);
    }
}