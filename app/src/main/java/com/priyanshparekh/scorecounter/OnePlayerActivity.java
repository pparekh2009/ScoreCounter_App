package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class OnePlayerActivity extends AppCompatActivity {

    Button opChangeNameBtn, opResetBtn;
    Button opPlayer1Btn;
    TextView opPlayer1Name;
    int op_p1_score = 0;
    private AlphaAnimation buttonClick = new AlphaAnimation(1f, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

        opChangeNameBtn = findViewById(R.id.op_change_name_btn);
        opResetBtn = findViewById(R.id.op_reset_btn);
        opPlayer1Btn = findViewById(R.id.op_player_1_btn);
        opPlayer1Name = findViewById(R.id.op_player_1_name);

        opPlayer1Btn.setOnClickListener(v -> {
            op_p1_score++;
            opPlayer1Btn.setText(String.valueOf(op_p1_score));
            v.startAnimation(buttonClick);
        });

        opPlayer1Btn.setOnLongClickListener(v -> {
            if (op_p1_score > 0) {
                op_p1_score--;
                opPlayer1Btn.setText(String.valueOf(op_p1_score));
            } else {
                opPlayer1Btn.setText("0");
            }
            v.startAnimation(buttonClick);
            return true;
        });

        opResetBtn.setOnClickListener(v -> {
            op_p1_score = 0;
            opPlayer1Btn.setText("0");
            v.startAnimation(buttonClick);
        });

        opChangeNameBtn.setOnClickListener(v -> {
            showAlertDialog();
            v.startAnimation(buttonClick);
        });
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Names");

        final View customLayout = getLayoutInflater().inflate(R.layout.op_dialog_box, null);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", (dialog, which) -> {
            EditText opP1Input = customLayout.findViewById(R.id.op_p1_input);
            setPlayerNames(opP1Input.getText().toString());
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void setPlayerNames(String name1) {
        if (name1.equals("")) {
            opPlayer1Name.setText(R.string.player_1_name);
        } else {
            opPlayer1Name.setText(name1);
        }
    }
}