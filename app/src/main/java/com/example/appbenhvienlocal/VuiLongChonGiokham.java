package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VuiLongChonGiokham extends AppCompatActivity {

    private ImageButton btnGK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_long_chon_giokham);
        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VuiLongChonGiokham.this, ChonNgayKham.class );
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        btnGK = findViewById(R.id.btnGK);
    }
}