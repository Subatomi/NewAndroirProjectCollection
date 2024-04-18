package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    TextView tFname, tLname, tBdate, tBplace, tAddress, tNum, tEmailAdd, tMotName, tFatName, tGender, tCourse;

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        tFname = findViewById(R.id.txtPI2Fname);
        tLname = findViewById(R.id.txtPI2Lname);
        tBdate = findViewById(R.id.txtPI2BDate);
        tBplace = findViewById(R.id.txtPI2BPlace);
        tAddress = findViewById(R.id.txtPI2Address);
        tNum = findViewById(R.id.txtPI2Number);
        tEmailAdd = findViewById(R.id.txtPI2Email);
        tMotName = findViewById(R.id.txtPI2MothersName);
        tFatName = findViewById(R.id.txtPI2FathersName);
        tGender = findViewById(R.id.txtPI2Gender);
        tCourse = findViewById(R.id.txtPI2Course);

        btnReturn = findViewById(R.id.btnPI2Return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        tFname.setText(intent.getStringExtra("fname_key"));
        tLname.setText(intent.getStringExtra("lname_key"));
        tBdate.setText(intent.getStringExtra("bdate_key"));
        tBplace.setText(intent.getStringExtra("bplace_key"));
        tAddress.setText(intent.getStringExtra("address_key"));
        tNum.setText(intent.getStringExtra("pnumber_key"));
        tEmailAdd.setText(intent.getStringExtra("eaddress_key"));
        tMotName.setText(intent.getStringExtra("moname_key"));
        tFatName.setText(intent.getStringExtra("faname_key"));
        tGender.setText(intent.getStringExtra("gender_key"));
        tCourse.setText(intent.getStringExtra("course_key"));

    }
}