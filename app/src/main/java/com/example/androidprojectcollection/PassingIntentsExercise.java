package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class PassingIntentsExercise extends AppCompatActivity {
    TextView eFname, eLname, eBdate, eBplace, eAddress, eNum, eEmailAdd, eMotName, eFatName;
    RadioButton rMale, rFem, rOth, rBSCS, rBSIT, rBSCPE;
    Button btnClear, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        btnClear = findViewById(R.id.btnPIClear);
        btnSubmit = findViewById(R.id.btnPISubmit);

        eFname =findViewById(R.id.etxtFName);
        eLname =findViewById(R.id.etxtLName);
        eBdate =findViewById(R.id.etxtBdate);
        eBplace =findViewById(R.id.etxtBplace);
        eAddress =findViewById(R.id.etxtAddress);
        eNum =findViewById(R.id.etxtPhoneNumber);
        eEmailAdd =findViewById(R.id.etxtEmailAddress);
        eMotName =findViewById(R.id.etxtMothersName);
        eFatName =findViewById(R.id.etxtFathersName);

        rMale = findViewById(R.id.radMale);
        rFem = findViewById(R.id.radFemale);
        rOth = findViewById(R.id.radOthers);
        rBSCS = findViewById(R.id.radBSCS);
        rBSIT = findViewById(R.id.radBSIT);
        rBSCPE = findViewById(R.id.radBSCPE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = eFname.getText().toString();
                String lName = eLname.getText().toString();
                String bDate = eBdate.getText().toString();
                String bPlace = eBplace.getText().toString();
                String address = eAddress.getText().toString();
                String pNumber = eNum.getText().toString();
                String eAddress = eEmailAdd.getText().toString();
                String mothersName = eMotName.getText().toString();
                String fathersName = eFatName.getText().toString();

                String gender;
                if(rMale.isChecked()){
                    gender = "Male";
                } else if (rFem.isChecked()) {
                    gender = "Female";
                }else{
                    gender = "Unknown";
                }

                String course;
                if(rBSCS.isChecked()){
                    course = "BSCS";
                } else if (rBSIT.isChecked()) {
                    course = "BSIT";
                }else{
                    course = "BSCPE";
                }

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                intent.putExtra("fname_key",fName);
                intent.putExtra("lname_key",lName);
                intent.putExtra("bdate_key",bDate);
                intent.putExtra("bplace_key",bPlace);
                intent.putExtra("address_key",address);
                intent.putExtra("pnumber_key",pNumber);
                intent.putExtra("eaddress_key",eAddress);
                intent.putExtra("moname_key",mothersName);
                intent.putExtra("faname_key",fathersName);
                intent.putExtra("gender_key",gender);
                intent.putExtra("course_key",course);

                startActivity(intent);
            }
        });
    }
}