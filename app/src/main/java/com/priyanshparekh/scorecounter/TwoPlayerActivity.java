package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class TwoPlayerActivity extends AppCompatActivity {

    Button tpChangeNameBtn, tpResetBtn;
    Button tpPlayer1Btn, tpPlayer2Btn;
    TextView tpPlayer1Name, tpPlayer2Name;
    int tp_p1_score = 0;
    int tp_p2_score = 0;

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


        // Increment score for player 1
        tpPlayer1Btn.setOnClickListener(v -> {
            tp_p1_score++;
            tpPlayer1Btn.setText(String.valueOf(tp_p1_score));
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
            return true;
        });

        // Increment score for player 2
        tpPlayer2Btn.setOnClickListener(v -> {
            tp_p2_score++;
            tpPlayer2Btn.setText(String.valueOf(tp_p2_score));
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
            return true;
        });

        tpResetBtn.setOnClickListener(v -> {
            tp_p1_score = 0;
            tp_p2_score = 0;
            tpPlayer1Btn.setText("0");
            tpPlayer2Btn.setText("0");
        });

        tpChangeNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
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
        if (name1.equals("")) {
            tpPlayer1Name.setText("Player 1");
            tpPlayer2Name.setText(name2);
        }
        else if (name2.equals("")) {
            tpPlayer1Name.setText(name1);
            tpPlayer2Name.setText("Player 2");
        }
        else if (!name1.equals("") && !name2.equals("")) {
            tpPlayer1Name.setText(name1);
            tpPlayer2Name.setText(name2);
        }
        else {
            tpPlayer1Name.setText("Player 1");
            tpPlayer2Name.setText("Player 2");
        }
    }
}