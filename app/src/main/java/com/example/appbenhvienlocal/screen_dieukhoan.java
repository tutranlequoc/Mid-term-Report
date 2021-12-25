package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen_dieukhoan extends AppCompatActivity {
    Button btnBackDK, btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_dieukhoan);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackDK = findViewById(R.id.btnBackDK);
        btnBackHome = findViewById(R.id.btnBackHome);
    }

    private void addEvents() {
        btnBackDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_dieukhoan.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_dieukhoan.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}