package com.example.appbenhvienlocal;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.PhieuKhamAdapter;
import com.example.models.Danhsachphieukham;

import java.util.ArrayList;

public class DanhSachPhieuKhamScreen extends AppCompatActivity {

    ListView lvDanhSachPhieuKham;
    PhieuKhamAdapter adapter;
    ArrayList<Danhsachphieukham> phieuKhamList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danh_sach_phieu_kham);
        linkView();
        initData();
        loadData();
    }

    private void linkView() {
        lvDanhSachPhieuKham= findViewById(R.id.lvDanhSachPhieuKhan);

    }

    private void initData() {
phieuKhamList = new ArrayList<Danhsachphieukham>();
phieuKhamList.add(new Danhsachphieukham("AFGW421","ABC","11/11/2021","8:30 (Buổi sáng)",R.drawable.rounded_dathanhtoan,"Đã thanh toán"));
phieuKhamList.add(new Danhsachphieukham("AFGW421","ABC","11/11/2021","8:30 (Buổi sáng)",R.drawable.rounded_chuathanhtoan,"Chưa thanh toán"));
phieuKhamList.add(new Danhsachphieukham("AFGW421","ABC","11/11/2021","8:30 (Buổi sáng)",R.drawable.rounded_dahuy,"Đã hủy"));


    }

    private void loadData() {
 adapter = new PhieuKhamAdapter(DanhSachPhieuKhamScreen.this,R.layout.phieu_kham_layout,phieuKhamList);
lvDanhSachPhieuKham.setAdapter(adapter);

    }
}