package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class VuiLongChonChuyenKhoa extends AppCompatActivity {

    private ListView lvChuyenkhoa;
    String [] chuyenkhoa;
    ArrayAdapter<String> adapter;
    private ImageButton btnCK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_long_chon_chuyen_khoa);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void addEvents() {
        btnCK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VuiLongChonChuyenKhoa.this, ChonThongTinKham.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        lvChuyenkhoa.setAdapter(adapter);
    }

    private void initData() {
        chuyenkhoa = getResources().getStringArray(R.array.chuyen_khoa);
        adapter = new ArrayAdapter<String>(VuiLongChonChuyenKhoa.this, android.R.layout.simple_list_item_1, chuyenkhoa);
    }

    private void linkViews() {
        lvChuyenkhoa = findViewById(R.id.lvChuyenKhoa);
        btnCK = findViewById(R.id.btnCK);
    }
}