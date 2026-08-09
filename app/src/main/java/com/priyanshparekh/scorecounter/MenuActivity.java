package com.priyanshparekh.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] players = {"Select Player", "1 Player", "2 Players", "3 Players", "4 Players"};

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, players);
        spinner.setAdapter(arrayAdapter);

        spinner.setSelection(0, true);
        View v = spinner.getSelectedView();
        ((TextView)v).setTextColor(Color.WHITE);

        button1.setOnClickListener(v1 -> {
            Intent intent = new Intent(MenuActivity.this, TossActivity.class);
            startActivity(intent);
        });

        button2.setOnClickListener(v2 -> {
            Intent intent = new Intent(MenuActivity.this, DiceActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch(position) {
            case 0:
                doNothing();
                break;
            case 1:
                startIntent(OnePlayerActivity.class);
                break;
            case 2:
                startIntent(TwoPlayerActivity.class);
                break;
            case 3:
                startIntent(ThreePlayerActivity.class);
                break;
            case 4:
                startIntent(FourPlayerActivity.class);
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
        Intent intent = new Intent(MenuActivity.this, toClass);
        startActivity(intent);
    }
}