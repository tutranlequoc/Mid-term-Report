package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;
import com.example.function.DichVu;
import com.example.function.ThongTin;
import com.example.models.BackScreenClick;
import com.example.ultis.Constant;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VuiLongChonDichVu extends AppCompatActivity {

    private ListView lvDichVu;
    CustomAdapter adapter;
    ImageButton btnDV;
    ArrayList<ThongTin> ketQuaTraVe;
    Intent intent;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_long_chon_dich_vu);
        linkViews();
        initData();
        loadData();
        addEvents();
        getData();
    }

    private void getData() {
        intent = getIntent();
        ArrayList<ThongTin> thongTins = intent.getParcelableArrayListExtra(Constant.THONGTIN);
        ketQuaTraVe = thongTins;
        index = intent.getIntExtra(Constant.INDEX_THONGTIN, 0);
    }

    private void addEvents() {
        btnDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VuiLongChonDichVu.this, VuiLongChonChuyenKhoa.class);
                startActivity(intent);
            }
        });
        lvDichVu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DichVu dichVu = (DichVu) adapter.getItem(i);
                ketQuaTraVe.get(index).setResult(dichVu.getTenDichVu());
                int k = index;
                while (k + 1 <= ketQuaTraVe.size() - 1){
                    ketQuaTraVe.get(k + 1).setResult("");
                    k++;
                }
                intent = new Intent(VuiLongChonDichVu.this, ChonNgayKham.class);
                intent.putParcelableArrayListExtra(Constant.THONGTIN, ketQuaTraVe);
                intent.putExtra(Constant.INDEX_THONGTIN, index+1);
                startActivity(intent);
            }
        });
        btnDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(intent.getIntExtra(Constant.REQUEST_TAG, 0) == Constant.REQUEST_CODE){
                    intent.putExtra(Constant.THONGTIN, ketQuaTraVe);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }else {
                    intent = new Intent(VuiLongChonDichVu.this, ChonThongTinKham.class);
                    intent.putExtra(Constant.THONGTIN, ketQuaTraVe);
                    intent.putExtra(Constant.INDEX_THONGTIN, index - 1);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadData() {
        lvDichVu.setAdapter(adapter);
    }

    private void initData() {
        ArrayList<DichVu> dichVus = new ArrayList<DichVu>();
        dichVus.add(new DichVu(Constant.DICH_VU,"Lịch khám: thứ 2 - thứ 6", 80000));
        dichVus.add(new DichVu(Constant.VIP,"Lịch khám: thứ 2 - thứ 6", 300000));
        adapter = new CustomAdapter(VuiLongChonDichVu.this, R.layout.listview_chon_dich_vu, dichVus);
    }

    private void linkViews() {
        lvDichVu = findViewById(R.id.lvDichVu);
        btnDV = findViewById(R.id.btnBackDV);
    }
}