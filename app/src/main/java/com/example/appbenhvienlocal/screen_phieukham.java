package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class screen_phieukham extends AppCompatActivity {

    ImageButton imvBackPhieuKham;
    Spinner spinner;
    ArrayList<String> trangthai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_phieukham);

        linkViews();
        addEvents();
        initData();
    }

    private void initData() {
        trangthai = new ArrayList<>();
        trangthai.add("Tất cả");
        trangthai.add("Đã khám");
        trangthai.add("Chưa thanh toán");
        trangthai.add("Đã hủy");

        ArrayAdapter adapter = new ArrayAdapter(screen_phieukham.this, android.R.layout.simple_spinner_item,trangthai);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void linkViews() {
        imvBackPhieuKham = findViewById(R.id.btnBackPhieuKham);
        spinner = findViewById(R.id.spinnerDanhSach);
    }

    private void addEvents() {
        imvBackPhieuKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_phieukham.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
