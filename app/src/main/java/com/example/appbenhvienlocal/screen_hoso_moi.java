package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class screen_hoso_moi extends AppCompatActivity {
    Button btnBack;
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_hoso_moi);
        linkViews();
        addEvents();
        //        addEvents();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(screen_hoso_moi.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_layout,
                        findViewById(R.id.bottomSheetContainer));
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
                Button btnChuaTungKham = bottomSheetDialog.findViewById(R.id.btnQuetMa);
                Button btnDaTungKham = bottomSheetDialog.findViewById(R.id.btnNhapHS);
                Button btnQuetMa = bottomSheetDialog.findViewById(R.id.btnDKMoi);
                btnChuaTungKham.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent screen_chuatungkham = new Intent(screen_hoso_moi.this, com.example.appbenhvienlocal.screen_chuatungkham.class);
                        startActivity(screen_chuatungkham);
                    }
                });
                btnDaTungKham.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent screen_datungkham = new Intent(screen_hoso_moi.this, com.example.appbenhvienlocal.screen_datungkham.class);
                        startActivity(screen_datungkham);
                    }
                });
                btnQuetMa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }


//    private void addEvents() {
//
        });

    }


    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_hoso_moi.this,
                        MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);
        btnThem = findViewById(R.id.btnAdd);
    }
}