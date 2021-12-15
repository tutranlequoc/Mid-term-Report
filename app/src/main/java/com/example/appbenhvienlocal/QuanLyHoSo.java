package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dialog.CustomDiaLogHoSo;

public class QuanLyHoSo extends AppCompatActivity {

    ImageButton btnDelete;
    CustomDiaLogHoSo customDiaLogHoSo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_ho_so);
        linkViews();
        initData();
        addEvents();
    }

    private void initData() {
        customDiaLogHoSo = new CustomDiaLogHoSo(this);
        customDiaLogHoSo.setCancelable(false);
        Window window = customDiaLogHoSo.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private void addEvents() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDiaLogHoSo.show();
            }
        });
    }

    private void linkViews() {
        btnDelete = findViewById(R.id.btnDelete);
    }
}