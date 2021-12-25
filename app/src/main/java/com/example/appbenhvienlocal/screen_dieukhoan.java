package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class screen_dieukhoan extends AppCompatActivity {
    ImageButton imgBackDK, imgBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_dieukhoan);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        imgBackDK = findViewById(R.id.imgBackDK);
        imgBackHome = findViewById(R.id.imgBackHome);
    }

    private void addEvents() {
        imgBackDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_dieukhoan.this, MainActivity.class);
                startActivity(i);
            }
        });
        imgBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_dieukhoan.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}