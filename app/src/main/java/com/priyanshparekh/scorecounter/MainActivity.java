package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button player1_btn, player2_btn, reset_btn;
    TextView player1_txt, player2_txt;
    int p1_score = 0;
    int p2_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1_btn = findViewById(R.id.player1_btn);
        player2_btn = findViewById(R.id.player2_btn);
        reset_btn = findViewById(R.id.reset_btn);

        player1_txt = findViewById(R.id.player1_txt);
        player2_txt = findViewById(R.id.player2_txt);

        // Increment score for player 1
        player1_btn.setOnClickListener(v -> {
            p1_score = p1_score + 1;
            player1_btn.setText(String.valueOf(p1_score));
        });

        // Decrement score for player 1
        player1_btn.setOnLongClickListener(v -> {
            if(p1_score > 0) {
                p1_score = p1_score - 1;
                player1_btn.setText(String.valueOf(p1_score));
            }
            else {
                player1_btn.setText("0");
            }
            return true;
        });

        // Increment score for player 2
        player2_btn.setOnClickListener(v -> {
            p2_score = p2_score + 1;
            player2_btn.setText(String.valueOf(p2_score));
        });

        // Decrement score for player 2
        player2_btn.setOnLongClickListener(v -> {
            if(p2_score > 0) {
                p2_score = p2_score - 1;
                player2_btn.setText(String.valueOf(p2_score));
            }
            else {
                player2_btn.setText("0");
            }
            return true;
        });

        reset_btn.setOnClickListener(v -> {
            p1_score = 0;
            p2_score = 0;
            player1_btn.setText("0");
            player2_btn.setText("0");
        });
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Names");

        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_box, null);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", (dialog, which) -> {
            EditText p1_input = customLayout.findViewById(R.id.p1_input);
            EditText p2_input = customLayout.findViewById(R.id.p2_input);
            setPlayerNames(p1_input.getText().toString(), p2_input.getText().toString());
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {

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