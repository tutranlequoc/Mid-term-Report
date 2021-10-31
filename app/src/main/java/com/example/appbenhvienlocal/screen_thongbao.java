package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen_thongbao extends AppCompatActivity {

    Button btnBackThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_thongbao);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBackThongBao = findViewById(R.id.btnBackThongBao);
    }

    private void addEvents() {
        btnBackThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_thongbao.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}