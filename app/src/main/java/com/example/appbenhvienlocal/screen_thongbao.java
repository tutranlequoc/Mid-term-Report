package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class screen_thongbao extends AppCompatActivity {

    ImageButton imgBackThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_thongbao);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        imgBackThongBao = findViewById(R.id.imgBackThongBao);
    }

    private void addEvents() {
        imgBackThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_thongbao.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}