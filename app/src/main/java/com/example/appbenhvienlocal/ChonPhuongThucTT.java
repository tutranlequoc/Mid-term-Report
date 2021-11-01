package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;

import java.util.ArrayList;

public class ChonPhuongThucTT extends AppCompatActivity {

    private ListView lvCPTTT;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_phuong_thuc_tt);
        linkViews();
        initData();
        loadData();
    }

    private void loadData() {
        lvCPTTT.setAdapter(adapter);
    }

    private void initData() {
        ArrayList<String> phuongThucTT = new ArrayList<>();
        phuongThucTT.add("Thanh toán bằng thẻ ATM nội địa/ Internet\n" + "Banking");
        phuongThucTT.add("Thanh toán bằng ví MOMO");
        adapter = new CustomAdapter(this, phuongThucTT, R.layout.listview_chon_phuong_thuc_tt);
    }

    private void linkViews() {
        lvCPTTT = findViewById(R.id.lvCPTTT);
    }
}