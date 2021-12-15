package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.ThongBaoAdapter;
import com.example.models.ThongBao;

import java.util.ArrayList;

public class ManHinhThongBao extends AppCompatActivity {
    ListView lvDanhSachThongBao;
    ArrayList<ThongBao> thongBaos;
    ThongBaoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_thong_bao);
        linkView();
        inItDaTa();
        loadData();
    }

    private void linkView() {
        lvDanhSachThongBao= findViewById(R.id.lvDanhSachThongBao);

    }

    private void inItDaTa() {
        thongBaos = new ArrayList<ThongBao>();
        thongBaos.add(new ThongBao("T221030SOP0E3","08:30 11/11/2021","15:00 29/10/2021"));
        thongBaos.add(new ThongBao("T221030SOP0E3","08:30 11/11/2021","15:00 29/10/2021"));
        thongBaos.add(new ThongBao("T221030SOP0E3","08:30 11/11/2021","15:00 29/10/2021"));
        thongBaos.add(new ThongBao("T221030SOP0E3","08:30 11/11/2021","15:00 29/10/2021"));
    }

    private void loadData() {
        adapter = new ThongBaoAdapter(ManHinhThongBao.this,R.layout.notification_layout,thongBaos);
        lvDanhSachThongBao.setAdapter(adapter);

    }
}