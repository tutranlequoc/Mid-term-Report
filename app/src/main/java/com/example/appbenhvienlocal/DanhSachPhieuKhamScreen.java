package com.example.appbenhvienlocal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.PhieuKhamAdapter;
import com.example.models.Danhsachphieukham;

import java.util.ArrayList;

public class DanhSachPhieuKhamScreen extends AppCompatActivity {

    ListView lvDanhSachPhieuKham;
    PhieuKhamAdapter adapter;
    ArrayList<Danhsachphieukham> phieuKhamList;
    ImageButton imvDanhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danh_sach_phieu_kham);
        linkView();
        initData();
        loadData();
        addEvents();
    }

    private void addEvents() {
        imvDanhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkView() {
        lvDanhSachPhieuKham = findViewById(R.id.lvDanhSachPhieuKhan);

    }

    private void initData() {
        phieuKhamList = new ArrayList<Danhsachphieukham>();
        phieuKhamList.add(new Danhsachphieukham("AFGW421", "ABC", "11/11/2021", "8:30 (Buổi sáng)", R.drawable.rounded_dathanhtoan, "Đã thanh toán"));
        phieuKhamList.add(new Danhsachphieukham("AFGW421", "ABC", "11/11/2021", "8:30 (Buổi sáng)", R.drawable.rounded_chuathanhtoan, "Chưa thanh toán"));
        phieuKhamList.add(new Danhsachphieukham("AFGW421", "ABC", "11/11/2021", "8:30 (Buổi sáng)", R.drawable.rounded_dahuy, "Đã hủy"));


    }

    private void loadData() {
        adapter = new PhieuKhamAdapter(DanhSachPhieuKhamScreen.this, R.layout.phieu_kham_layout, phieuKhamList);
        lvDanhSachPhieuKham.setAdapter(adapter);
        imvDanhSach = findViewById(R.id.imvDanhSach);

    }
}