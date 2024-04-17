package com.example.androidprojectcollection;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Connect3 extends AppCompatActivity {

    private boolean winStat = false;
    private static int playerTurn = 1;
    private CardView playerColor;
    private final Button [][] arrButton = new Button[5][5];
    private final boolean [][] hasColor = new boolean[5][5];

    private Button btnRestart;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);


        playerColor = findViewById(R.id.cvPlayer);
        btnRestart = findViewById(R.id.btnRestart);


        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restart();
            }
        });

        for(int x = 0; x < 5; x++){
            for(int y = 0 ; y<5; y++){
                hasColor[x][y] = false;
            }
        }

        int i = 1;
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                String buttonID = "btn" + i;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                arrButton[x][y] = ((Button) findViewById(resID));

                final int finalY = y;

                if(x == 0){
                    arrButton[x][y].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!winStat){
                                for (int i = 4; i >= 0; i--) {
                                    if (!hasColor[i][finalY]) {
                                        ColorStateList currColor;
                                        if(playerTurn == 1){
                                            currColor = ColorStateList.valueOf(Color.BLACK);
                                            playerColor.setCardBackgroundColor(Color.RED);
                                        }else{
                                            currColor = ColorStateList.valueOf(Color.RED);
                                            playerColor.setCardBackgroundColor(Color.BLACK);
                                        }

                                        hasColor[i][finalY] = true;
                                        arrButton[i][finalY].setBackgroundTintList(currColor);



                                        togglePlayerTurn();
                                        togglePlayerName();
                                        chckWin();

                                        break;
                                    }
                                }
                            }

                        }
                    });
                }
                i++;
                }


        }
        if (savedInstanceState != null) {
            boolean[] hasColorArray = savedInstanceState.getBooleanArray("hasColorArray");
            int[] buttonColors = savedInstanceState.getIntArray("buttonColors");
            if (hasColorArray != null && buttonColors != null) {
                int k = 0;
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        hasColor[x][y] = hasColorArray[k];
                        arrButton[x][y].setBackgroundTintList(ColorStateList.valueOf(buttonColors[k]));
                        k++;
                    }
                }
            }

            playerTurn = savedInstanceState.getInt("playerTurn");
            String str = "Player " + playerTurn;
            int color = (playerTurn == 1) ? Color.BLACK : Color.RED;
            playerColor.setCardBackgroundColor(color);
            TextView playertxt = findViewById(R.id.txtPlayer);
            playertxt.setText(str);
        }
    }
    private void Restart(){
        for(int x = 0; x < 5; x++){
            for(int y = 0 ; y<5; y++){
                hasColor[x][y] = false;
                arrButton[x][y].setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            }
        }
        winStat = false;
        playerTurn = 1;
        playerColor.setCardBackgroundColor(Color.BLACK);
        TextView playertxt = findViewById(R.id.txtPlayer);
        playertxt.setText("Player 1");
    }

    private void togglePlayerTurn(){
        if(playerTurn == 1){
            playerTurn = 2;
        }else{
            playerTurn = 1;
        }
    }

    private void togglePlayerName(){
        TextView playertxt = findViewById(R.id.txtPlayer);
        if(playerTurn == 1){
            playertxt.setText("Player 1");
        }else{
            playertxt.setText("Player 2");
        }
    }

    private int getColorTint(int x, int y){
        return Objects.requireNonNull(arrButton[x][y].getBackgroundTintList()).getDefaultColor();
    }

    private void onWin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Connect3.this);

        builder.setTitle("YOU WIN!!!");
        int playerNo = (playerTurn == 1) ? 2 : 1;
        String str = "Player " + playerNo + " Wins!";
        builder.setMessage(str);
        builder.setPositiveButton("RESTART?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Restart();
            }
        });
        builder.setNegativeButton("NO!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
            }
        });

        winStat = true;
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        boolean[] hasColorArray = new boolean[25];
        int[] buttonColors = new int[25];
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                hasColorArray[k] = hasColor[i][j];
                buttonColors[k] = getColorTint(i, j);
                k++;
            }
        }
        outState.putBooleanArray("hasColorArray", hasColorArray);
        outState.putIntArray("buttonColors", buttonColors);

        outState.putInt("playerTurn", playerTurn);
    }



    private void chckWin(){

        // Check Row
        for(int x = 0; x < 5 ; x++){
            for(int y = 0; y < 3; y++){
                if(hasColor[x][y] && hasColor[x][y+1] && hasColor[x][y+2]){
                    if(getColorTint(x,y) == getColorTint(x,y+1) &&  getColorTint(x,y) == getColorTint(x,y+2)){
                        onWin();
                    }
                }

            }
        }

        //Check Column
        for(int x = 0; x < 3 ; x++){
            for(int y = 0; y < 5; y++){
                if(hasColor[x][y] && hasColor[x+1][y] && hasColor[x+2][y]) {
                    if(getColorTint(x,y) == getColorTint(x+1,y) &&  getColorTint(x,y) == getColorTint(x+2,y)){
                        onWin();
                    }
                }
            }
        }

        //Check Diagonal
        for(int x = 0; x < 3 ; x++){
            for(int y = 0; y < 3; y++){
                if(hasColor[x][y] && hasColor[x+1][y+1] && hasColor[x+2][y+2]) {
                    if(getColorTint(x,y) == getColorTint(x+1,y+1) &&  getColorTint(x,y) == getColorTint(x+2,y+2)){
                        onWin();
                    }
                }
            }
        }

        // Check Diagonal (top-right to bottom-left)
        for(int x = 0; x < 3 ; x++){
            for(int y = 4; y > 1; y--){
                if(hasColor[x][y] && hasColor[x+1][y-1] && hasColor[x+2][y-2]) {
                    if(getColorTint(x,y) == getColorTint(x+1,y-1) &&  getColorTint(x,y) == getColorTint(x+2,y-2)){
                        onWin();
                    }
                }
            }
        }
    }
}