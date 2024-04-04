package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity implements View.OnClickListener {

    boolean firstInput = true;
    int ctr = 0;
    String numtext = "";
    Calculation calc = new Calculation();
    private boolean dotCheck = true;
    private boolean opCheck = true;

    private boolean numBefore = false;



    TextView result, solution;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals, buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);


        // text part
        result = findViewById(R.id.equationLower);
        solution = findViewById(R.id.equationUpper);

        // operation parts
        assignId(buttonDivide, R.id.calcbuttonDiv);
        assignId(buttonMultiply, R.id.calcbuttonMul);
        assignId(buttonPlus, R.id.calcbuttonAdd);
        assignId(buttonMinus, R.id.calcbuttonSub);
        assignId(buttonEquals, R.id.calcbuttonEqual);
        assignId(buttonDot, R.id.calcbuttonDot);

        // number buttons
        assignId(button0, R.id.calcbutton0);
        assignId(button1, R.id.calcbutton1);
        assignId(button2, R.id.calcbutton2);
        assignId(button3, R.id.calcbutton3);
        assignId(button4, R.id.calcbutton4);
        assignId(button5, R.id.calcbutton5);
        assignId(button6, R.id.calcbutton6);
        assignId(button7, R.id.calcbutton7);
        assignId(button8, R.id.calcbutton8);
        assignId(button9, R.id.calcbutton9);

        if (savedInstanceState != null) {
            numtext = savedInstanceState.getString("numtext");
            dotCheck = savedInstanceState.getBoolean("dotCheck");
            opCheck = savedInstanceState.getBoolean("opCheck");
            ctr = savedInstanceState.getInt("ctr");
            result.setText(savedInstanceState.getString("resultText"));
            solution.setText(savedInstanceState.getString("solutionText"));
        }

    }

    private void assignId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if(firstInput){
            result.setText("");
            solution.setText("");
            firstInput = false;
        }

        if (buttonText.equals(".")) {
            handleDotButtonClick();
        } else if (isOperator(buttonText)) {
            handleOperatorButtonClick(buttonText);
        } else if (Character.isDigit(buttonText.charAt(0))) {
            handleDigitButtonClick(buttonText);
        }


    }

    private void handleDotButtonClick() {
        if (dotCheck) {
            String solutionText = solution.getText().toString();
            solution.setText(solutionText + ".");

            String resultText = result.getText().toString();
            result.setText(resultText + ".");
            numtext += ".";
            dotCheck = false;
            numBefore = false;
        }
    }

    private void handleOperatorButtonClick(String buttonText) {
        if (buttonText.equals("=") && numBefore) {
            System.out.println("EQUAL TRIGGERED");
            String newResult = calc.Calculate(solution.getText().toString());
            System.out.println(newResult);
            String last2 = newResult.substring(newResult.length() - 2);
            System.out.println(last2);
            if(last2.equals(".0")){
                String lastResult = newResult.substring(0, newResult.length() - 2);
                result.setText(lastResult);
            }else{
                result.setText(newResult);
            }

            return;
        }

        if (opCheck && dotCheck) {
            numtext = "";

            String solutionText = solution.getText().toString();
            solution.setText(solutionText + " " + buttonText + " ");

            String resultText = result.getText().toString();
            result.setText(resultText+ " " + buttonText + " ");

            dotCheck = false;
            opCheck = false;
            numBefore = false;

        }
    }

    private void handleDigitButtonClick(String buttonText) {
        String solutionText = solution.getText().toString();
        solution.setText(solutionText + buttonText);

        String resultText = result.getText().toString();
        result.setText(resultText + buttonText);

        dotCheck = true;
        opCheck = true;
        numBefore = true;

        String[] tokens = solutionText.split("\\s+");
        ctr = tokens.length +1;
        if (ctr >= 3 && ctr % 2 != 0) {
            String newResult = calc.CalculateSequence(result.getText().toString());
            String last2 = newResult.substring(newResult.length() - 2);
            System.out.println(last2);
            if(last2.equals(".0")){
                String lastResult = newResult.substring(0, newResult.length() - 2);
                result.setText(lastResult);
            }else{
                result.setText(newResult);
            }
        }
    }



    private boolean isOperator(String c) {
        return Objects.equals(c, "+") || Objects.equals(c, "-") || Objects.equals(c, "*") || Objects.equals(c, "/") || Objects.equals(c, "=");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current state
        outState.putString("numtext", numtext);
        outState.putBoolean("dotCheck", dotCheck);
        outState.putBoolean("opCheck", opCheck);
        outState.putInt("ctr", ctr);
        outState.putString("resultText", result.getText().toString());
        outState.putString("solutionText", solution.getText().toString());
    }

}
