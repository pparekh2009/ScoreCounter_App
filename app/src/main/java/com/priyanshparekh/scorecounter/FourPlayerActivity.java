package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FourPlayerActivity extends AppCompatActivity {

    Button fpChangeNameBtn, fpResetBtn;
    Button fpPlayer1Btn, fpPlayer2Btn, fpPlayer3Btn, fpPlayer4Btn;
    TextView fpPlayer1Name, fpPlayer2Name, fpPlayer3Name, fpPlayer4Name;
    int fp_p1_score = 0;
    int fp_p2_score = 0;
    int fp_p3_score = 0;
    int fp_p4_score = 0;
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_player);

        fpChangeNameBtn = findViewById(R.id.fp_change_name_btn);
        fpResetBtn = findViewById(R.id.fp_reset_btn);
        fpPlayer1Btn = findViewById(R.id.fp_player_1_btn);
        fpPlayer2Btn = findViewById(R.id.fp_player_2_btn);
        fpPlayer3Btn = findViewById(R.id.fp_player_3_btn);
        fpPlayer4Btn = findViewById(R.id.fp_player_4_btn);
        fpPlayer1Name = findViewById(R.id.fp_player_1_name);
        fpPlayer2Name = findViewById(R.id.fp_player_2_name);
        fpPlayer3Name = findViewById(R.id.fp_player_3_name);
        fpPlayer4Name = findViewById(R.id.fp_player_4_name);

        fpPlayer1Btn.setOnClickListener(v -> {
            fp_p1_score++;
            fpPlayer1Btn.setText(String.valueOf(fp_p1_score));
            v.startAnimation(buttonClick);
        });

        fpPlayer2Btn.setOnClickListener(v -> {
            fp_p2_score++;
            fpPlayer2Btn.setText(String.valueOf(fp_p2_score));
            v.startAnimation(buttonClick);
        });

        fpPlayer3Btn.setOnClickListener(v -> {
            fp_p3_score++;
            fpPlayer3Btn.setText(String.valueOf(fp_p3_score));
            v.startAnimation(buttonClick);
        });

        fpPlayer4Btn.setOnClickListener(v -> {
            fp_p4_score++;
            fpPlayer4Btn.setText(String.valueOf(fp_p4_score));
            v.startAnimation(buttonClick);
        });

        fpPlayer1Btn.setOnLongClickListener(v -> {
            if(fp_p1_score > 0) {
                fp_p1_score--;
                fpPlayer1Btn.setText(String.valueOf(fp_p1_score));
            }
            else {
                fpPlayer1Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        fpPlayer2Btn.setOnLongClickListener(v -> {
            if(fp_p2_score > 0) {
                fp_p2_score--;
                fpPlayer2Btn.setText(String.valueOf(fp_p2_score));
            }
            else {
                fpPlayer2Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        fpPlayer3Btn.setOnLongClickListener(v -> {
            if(fp_p3_score > 0) {
                fp_p3_score--;
                fpPlayer3Btn.setText(String.valueOf(fp_p3_score));
            }
            else {
                fpPlayer3Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        fpPlayer4Btn.setOnLongClickListener(v -> {
            if(fp_p4_score > 0) {
                fp_p4_score--;
                fpPlayer4Btn.setText(String.valueOf(fp_p4_score));
            }
            else {
                fpPlayer4Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        fpResetBtn.setOnClickListener(v -> {
            fp_p1_score = 0;
            fp_p2_score = 0;
            fp_p3_score = 0;
            fp_p4_score = 0;
            fpPlayer1Btn.setText("0");
            fpPlayer2Btn.setText("0");
            fpPlayer3Btn.setText("0");
            fpPlayer4Btn.setText("0");
            v.startAnimation(buttonClick);
        });

        fpChangeNameBtn.setOnClickListener(v -> {
            showAlertDialog();
            v.startAnimation(buttonClick);
        });
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Names");

        final View customLayout = getLayoutInflater().inflate(R.layout.fp_dialog_box, null);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", (dialog, which) -> {
            EditText fpP1Input = customLayout.findViewById(R.id.fp_p1_input);
            EditText fpP2Input = customLayout.findViewById(R.id.fp_p2_input);
            EditText fpP3Input = customLayout.findViewById(R.id.fp_p3_input);
            EditText fpP4Input = customLayout.findViewById(R.id.fp_p4_input);

            setPlayerNames(fpP1Input.getText().toString(), fpP2Input.getText().toString(), fpP3Input.getText().toString(), fpP4Input.getText().toString());

        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {});

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void setPlayerNames(String name1, String name2, String name3, String name4) {

        if (name1.equals("") && name2.equals("") && name3.equals("") && name4.equals("")){
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else if (name1.equals("") && name2.equals("") && name3.equals("")) {
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(name4);
        }
        else if (name1.equals("") && name2.equals("") && name4.equals("")) {
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else if (name1.equals("") && name3.equals("") && name4.equals("")) {
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else if (name2.equals("") && name3.equals("") && name4.equals("")) {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else if (name1.equals("") && name2.equals("")) {
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(name4);
        }
        else if (name2.equals("") && name3.equals("")) {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(name4);
        }
        else if (name3.equals("") && name4.equals("")) {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else if (name1.equals("") && name3.equals("")) {
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(name4);
        }
        else if (name1.equals("") && name4.equals("")) {
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else if (name2.equals("") && name4.equals("")) {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else if (name1.equals("")) {
            fpPlayer1Name.setText(R.string.player_1_name);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(name4);
        }
        else if (name2.equals("")) {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(R.string.player_2_name);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(name4);
        }
        else if (name3.equals("")) {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(R.string.player_3_name);
            fpPlayer4Name.setText(name4);
        }
        else if (name4.equals("")) {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(R.string.player_4_name);
        }
        else {
            fpPlayer1Name.setText(name1);
            fpPlayer2Name.setText(name2);
            fpPlayer3Name.setText(name3);
            fpPlayer4Name.setText(name4);
        }

    }
}
