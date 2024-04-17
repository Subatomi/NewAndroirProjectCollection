package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class ColorMatching extends AppCompatActivity {

    Button[][] arrayButtons = new Button[3][3];
    int[] color = {Color.RED, Color.BLUE, Color.YELLOW};
    boolean winStat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matching);

        int i = 1;
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                String buttonID = "btn" + i;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                arrayButtons[x][y] = findViewById(resID);

                int finalX = x;
                int finalY = y;

                arrayButtons[x][y].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!winStat){
                            clickSorround(finalX, finalY);
                            chckWin();
                        }

                    }
                });
                i++;
            }
        }
        restart();
    }

    private void restart(){
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                Random rand = new Random();
                int colorNum = rand.nextInt(3);
                arrayButtons[x][y].setBackgroundTintList(ColorStateList.valueOf(color[colorNum]));
            }
        }
    }

    private void chckWin(){
        int color = getColorTint(0,0);
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                if(color == getColorTint(x,y)){
                    color = getColorTint(x,y);
                }else{
                    return;
                }
            }
        }
        winStat = true;
    }

    private int getCol(int col){
        if(col == Color.BLUE){
            return Color.RED;
        }else if(col == Color.RED){
            return Color.YELLOW;
        }else{
            return Color.BLUE;
        }
    }

    private int getColorTint(int x, int y){
        return Objects.requireNonNull(arrayButtons[x][y].getBackgroundTintList()).getDefaultColor();
    }

    private void clickSorround(int x, int y){
        arrayButtons[x][y].setBackgroundTintList(ColorStateList.valueOf(getCol(getColorTint(x,y))));

        if(x-1 >= 0){
            arrayButtons[x-1][y].setBackgroundTintList(ColorStateList.valueOf(getCol(getColorTint(x-1,y))));
        }

        if(y-1 >= 0){
            arrayButtons[x][y-1].setBackgroundTintList(ColorStateList.valueOf(getCol(getColorTint(x,y-1))));
        }

        if(y+1 <= 2){
            arrayButtons[x][y+1].setBackgroundTintList(ColorStateList.valueOf(getCol(getColorTint(x,y+1))));
        }
        if(x+1 <= 2){
            arrayButtons[x+1][y].setBackgroundTintList(ColorStateList.valueOf(getCol(getColorTint(x+1,y))));
        }
    }

}
