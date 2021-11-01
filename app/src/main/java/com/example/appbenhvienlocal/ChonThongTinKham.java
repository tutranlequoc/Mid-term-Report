package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;
import com.example.function.Function;

import java.util.ArrayList;

public class ChonThongTinKham extends AppCompatActivity {

    private ListView lvOptions;
    private CustomAdapter adapter;
    private ImageButton btnTTK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chon_thong_tin_kham);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void addEvents() {
        btnTTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChonThongTinKham.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        lvOptions.setAdapter(adapter);
    }

    private void initData() {
        ArrayList<Function> thongTin = new ArrayList<Function>();
        thongTin.add(new Function("Chọn chuyên khoa", R.drawable.cck));
        thongTin.add(new Function("Chọn dịch vụ", R.drawable.cdv));
        thongTin.add(new Function("Chọn ngày khám", R.drawable.chonngay));
        thongTin.add(new Function("Chọn giờ tiếp nhận bệnh", R.drawable.cg));
        adapter = new CustomAdapter(getApplicationContext(), R.layout.listview_chon_thong_tin_kham, thongTin);
    }

    private void linkViews() {
        lvOptions = findViewById(R.id.lvOptions);
        btnTTK = findViewById(R.id.btnTTK);
    }
}