package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CalculatorExercise extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Button> allButtons = new ArrayList<>();

    TextView result, solution;
    MaterialButton button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals;
    MaterialButton buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        result = findViewById(R.id.equationLower);
        solution = findViewById(R.id.equationUpper);

        buttonDivide = findViewById(R.id.button4);














        allButtons.add(calcbutton1);
        allButtons.add(calcbutton2);
        allButtons.add(calcbutton3);
        allButtons.add(calcbutton4);
        allButtons.add(calcbutton5);
        allButtons.add(calcbutton6);
        allButtons.add(calcbutton7);
        allButtons.add(calcbutton8);
        allButtons.add(calcbutton9);
        allButtons.add(calcbutton10);
        allButtons.add(calcbutton11);
        allButtons.add(calcbutton12);
        allButtons.add(calcbutton13);
        allButtons.add(calcbutton14);
        allButtons.add(calcbutton15);
        allButtons.add(calcbutton16);


    }

    @Override
    public void onClick(View view) {

    }


//    public void addInDisplay(View v){
//        Text.view.equation
//    }
}