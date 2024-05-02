package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    int[] color = {Color.RED, Color.BLUE, Color.YELLOW};

    int width;
    int height;
    float position;

    Button btnChanger;
    float track = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
//        scale = this.getResources().getDisplayMetrics();



        btnChanger = findViewById(R.id.btnTransformingButton);
        btnChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChanger.setText("Hello");
            }
        });
        btnChanger.setBackgroundColor(Color.RED);
        saveBtn();


    }

    void saveBtn(){
        ViewGroup.LayoutParams params = btnChanger.getLayoutParams();
        width = params.width;
        height = params.height;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
        position = layoutParams.verticalBias;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ViewGroup.LayoutParams param = btnChanger.getLayoutParams();

        if(item.getItemId() == R.id.mItemChange){
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();

        }else if(item.getItemId() == R.id.mItemReset){
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
            param.width = width;
            param.height = height;
            btnChanger.setLayoutParams(param);

            ConstraintLayout.LayoutParams param2 = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
            param2.verticalBias = position;
            btnChanger.setLayoutParams(param2);

            GradientDrawable draw = new GradientDrawable();
            draw.setCornerRadius(0);
            btnChanger.setBackground(draw);
            ConstraintLayout back = findViewById(R.id.clBG);
            back.setBackgroundColor(Color.WHITE);


            btnChanger.setBackgroundTintList(ColorStateList.valueOf(Color.RED));



        }else if(item.getItemId() == R.id.mItemChangeToCircle){
            GradientDrawable draw = new GradientDrawable();
            draw.setCornerRadius(2000);
            btnChanger.setBackgroundTintList(btnChanger.getBackgroundTintList());
            btnChanger.setBackground(draw);

        }else if(item.getItemId() == R.id.mItemChangeColor){
            Random rand = new Random();
            int colorNum = rand.nextInt(3);
            btnChanger.setBackgroundTintList(ColorStateList.valueOf(color[colorNum]));
        }else if(item.getItemId() == R.id.mItemChangeGrow){
            param.height = btnChanger.getLayoutParams().height + ((int) (btnChanger.getLayoutParams().height*.10));
            param.width = btnChanger.getLayoutParams().width + ((int) (btnChanger.getLayoutParams().width*.10));
            btnChanger.setLayoutParams(param);
        }else if(item.getItemId() == R.id.mItemPositionUp){
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
            params.verticalBias = track = 0.25f;
            btnChanger.setLayoutParams(params);
        }else if(item.getItemId() == R.id.mItemBGColor){
            ConstraintLayout back = findViewById(R.id.clBG);
            back.setBackgroundColor(Color.BLACK);
        }else{
            finish();
        }
        return true;
    }
}