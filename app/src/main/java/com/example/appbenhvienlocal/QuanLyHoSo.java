package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dialog.CustomDiaLogHoSo;
import com.example.ultis.Constant;

public class QuanLyHoSo extends AppCompatActivity {

    ImageButton btnDelete;
    Button btnBackToMain, btnUpdate;
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
        customDiaLogHoSo.getTxtXoa().setTextColor(Color.parseColor("#5CC0AB"));
        customDiaLogHoSo.getTxtXoa().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Constant.doc != null){
                    Constant.database.deleteDocument(Constant.doc.getMaSo());
                }
                customDiaLogHoSo.dismiss();
                finish();
            }
        });

        customDiaLogHoSo.getTxtHuy().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDiaLogHoSo.dismiss();
            }
        });
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
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMain = new Intent(QuanLyHoSo.this, MainActivity.class);
                startActivity(backToMain);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toEditScreen = new Intent(QuanLyHoSo.this, screen_chuatungkham.class);
                startActivity(toEditScreen);
            }
        });
    }

    private void linkViews() {
        btnBackToMain = findViewById(R.id.btnBackToMain);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
    }
}