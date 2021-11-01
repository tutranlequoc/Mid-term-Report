package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;
import com.example.function.DichVu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VuiLongChonDichVu extends AppCompatActivity {

    private ListView lvDichVu;
    CustomAdapter adapter;
    ImageButton btnDV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_long_chon_dich_vu);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void addEvents() {
        btnDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VuiLongChonDichVu.this, VuiLongChonChuyenKhoa.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        lvDichVu.setAdapter(adapter);
    }

    private void initData() {
        ArrayList<DichVu> dichVus = new ArrayList<DichVu>();
        dichVus.add(new DichVu("KHÁM DỊCH VỤ","Lịch khám: thứ 2 - thứ 6", 80000));
        dichVus.add(new DichVu("KHÁM VIP","Lịch khám: thứ 2 - thứ 6", 300000));
        adapter = new CustomAdapter(VuiLongChonDichVu.this, R.layout.listview_chon_dich_vu, dichVus);
    }

    private void linkViews() {
        lvDichVu = findViewById(R.id.lvDichVu);
        btnDV = findViewById(R.id.btnBackDV);
    }
}