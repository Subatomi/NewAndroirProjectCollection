package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Connect3 extends AppCompatActivity {

    private Button [][] arrButton = new Button[5][5];
    private boolean [][] hasColor = new boolean[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);

        for(int x = 0; x < 5; x++){
            for(int y = 0 ; y<5; y++){
                hasColor[x][y] = false;
            }
        }

        int i = 1;
        for(int x = 0; x < 5; x++){
            for(int y = 0 ; y<5; y++){
                String buttonID = "btn" + i;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                arrButton[x][y] = ((Button) findViewById(resID));
            }
        }

        for(int y = 0; y < 5; y++) {
            int finalY = y;
            arrButton[0][y].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int x = 0; x < 5; x++){
                            if(hasColor[4][finalY] == false){
                                hasColor[4][finalY] = true;
                                arrButton[4][finalY].setBackgroundColor(Color.RED);
                                break;
                            }

                            if(hasColor[x][finalY] == true){
                                hasColor[x-1][finalY] = true;
                                arrButton[x-1][finalY].setBackgroundColor(Color.RED);
                                break;
                            }

                    }
                }
            });
        }



    }
}