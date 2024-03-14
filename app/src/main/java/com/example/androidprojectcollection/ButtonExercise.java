package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class ButtonExercise extends AppCompatActivity {

    Button close_btn;
    Button toast_btn;
    Button change_bg_btn;
    Button change_btn_bg;
    Button disappear_btn;


    String[] colors = {"red", "blue", "green", "white"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        close_btn = (Button) findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ButtonExercise.this, CloseLayout.class);
                startActivity(myIntent);
            }
        });

        toast_btn = (Button) findViewById(R.id.toast_btn);
        toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                String txt = "string message";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, txt, duration);
                toast.show();
            }
        });

        change_bg_btn = (Button) findViewById(R.id.change_bg_btn);
        change_bg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout layout = findViewById(R.id.ButtonExercise);
//                layout.setBackgroundColor(Color.parseColor(colors[getRandom(3,0)]));
                layout.setBackgroundColor(Color.GREEN);
            }
        });

        change_btn_bg = (Button) findViewById(R.id.change_btn_bg);
        change_btn_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                change_btn_bg.setBackgroundColor(Color.parseColor(colors[getRandom(2,0)]));
                change_btn_bg.setBackgroundColor(Color.RED);
            }
        });

        disappear_btn = (Button) findViewById(R.id.disapear_btn);
        disappear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disappear_btn.setVisibility(View.GONE);
            }
        });
    }

    int getRandom(int max, int min){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


}