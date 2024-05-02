package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MapsExercise extends AppCompatActivity {

    ImageButton btnMap, btnMap2, btnMap3, btnMap4, btnMap5;
    ConstraintLayout bg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        bg = findViewById(R.id.MainBg);

        btnMap = findViewById(R.id.btnMaps1);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.90224160577575, 12.458546176208424 "));
                bg.setBackgroundResource(R.drawable.bg1);
                startActivity(intent);
            }
        });

        btnMap2 = findViewById(R.id.btnMaps2);
        btnMap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:11.964899250265013, 121.92196206806284"));
                bg.setBackgroundResource(R.drawable.bg2);
                startActivity(intent);
            }
        });

        btnMap3 = findViewById(R.id.btnMaps3);
        btnMap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.88933630943758, -77.04966321863951"));
                bg.setBackgroundResource(R.drawable.bg4);
                startActivity(intent);
            }
        });

        btnMap4 = findViewById(R.id.btnMaps4);
        btnMap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.65920250536892, 139.74539170634333"));
                bg.setBackgroundResource(R.drawable.bg3);
                startActivity(intent);
            }
        });

        btnMap5 = findViewById(R.id.btnMaps5);
        btnMap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:51.50103765381699, -0.12431474460836532"));
                bg.setBackgroundResource(R.drawable.bg5);
                startActivity(intent);
            }
        });
    }
}