package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen_quydinh extends AppCompatActivity {
    Button btnBackHomeQD, btnBackQD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_quydinh);
        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnBackQD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMain = new Intent(screen_quydinh.this, MainActivity.class);
                startActivity(backMain);
            }
        });
        btnBackHomeQD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMain = new Intent(screen_quydinh.this, MainActivity.class);
                startActivity(backMain);
            }
        });
    }

    private void linkViews() {
        btnBackHomeQD = findViewById(R.id.btnBackHomeQD);
        btnBackQD = findViewById(R.id.btnBackQD);
    }
}