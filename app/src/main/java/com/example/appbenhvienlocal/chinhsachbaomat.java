package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chinhsachbaomat extends AppCompatActivity {
    Button btnBackCS, btnBackHomeCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinhsachbaomat);
        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnBackHomeCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMain = new Intent(chinhsachbaomat.this, MainActivity.class);
                startActivity(backMain);
            }
        });
        btnBackCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMain = new Intent(chinhsachbaomat.this, MainActivity.class);
                startActivity(backMain);
            }
        });
    }

    private void linkViews() {
        btnBackCS = findViewById(R.id.btnBackCS);
        btnBackHomeCS = findViewById(R.id.btnBackCS);
    }
}