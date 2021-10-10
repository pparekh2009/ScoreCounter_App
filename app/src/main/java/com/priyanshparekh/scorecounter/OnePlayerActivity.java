package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OnePlayerActivity extends AppCompatActivity {

    Button opChangeNameBtn, opResetBtn;
    Button opPlayer1Btn;
    TextView opPlayer1Name;
    int op_p1_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

        opChangeNameBtn = findViewById(R.id.op_change_name_btn);
        opResetBtn = findViewById(R.id.op_reset_btn);
        opPlayer1Btn = findViewById(R.id.op_player_1_btn);
        opPlayer1Name = findViewById(R.id.op_player_1_name);

        opPlayer1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op_p1_score++;
                opPlayer1Btn.setText(String.valueOf(op_p1_score));
            }
        });

        opPlayer1Btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (op_p1_score > 0) {
                    op_p1_score--;
                    opPlayer1Btn.setText(String.valueOf(op_p1_score));
                }
                else {
                    opPlayer1Btn.setText("0");
                }
                return true;
            }
        });

        opResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op_p1_score = 0;
                opPlayer1Btn.setText("0");
            }
        });

        opChangeNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
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

        builder.setNegativeButton("Cancel", (dialog, which) -> {});

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void setPlayerNames(String name1) {
        if (name1.equals("")) {
            opPlayer1Name.setText("Player 1");
        }
        else {
            opPlayer1Name.setText(name1);
        }
    }
}