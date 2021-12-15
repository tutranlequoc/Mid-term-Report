package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.GioKhamAdapter;
import com.example.function.ThongTin;
import com.example.models.ThoiGianKham;
import com.example.ultis.Constant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VuiLongChonGiokham extends AppCompatActivity {



    private ImageButton btnGK;
    ArrayList<ThongTin> ketQuaTraVe;
    ArrayList<ThoiGianKham> timesMor, timesEve ;
    GridView gvMor, gvEve;
    GioKhamAdapter adapterMor, adapterEve;
    Intent intent;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_long_chon_giokham);
        linkViews();
        loadApdater();
        getData();
        addEvents();
    }

    private void loadApdater() {
        timesMor = new ArrayList<>();
        timesEve = new ArrayList<>();
        timesMor.add(new ThoiGianKham(Constant.BUOI_SANG, LocalTime.of(7,30,0), LocalTime.of(8,30,0)));
        timesMor.add(new ThoiGianKham(Constant.BUOI_SANG, LocalTime.of(8,30,0), LocalTime.of(9,30,0)));
        timesMor.add(new ThoiGianKham(Constant.BUOI_SANG, LocalTime.of(9,30,0), LocalTime.of(10,30,0)));
        timesEve.add(new ThoiGianKham(Constant.BUOI_TOI, LocalTime.of(13,0,0), LocalTime.of(14,0,0)));
        timesEve.add(new ThoiGianKham(Constant.BUOI_TOI, LocalTime.of(14,0,0), LocalTime.of(15,0,0)));
        timesEve.add(new ThoiGianKham(Constant.BUOI_TOI, LocalTime.of(15,0,0), LocalTime.of(16,0,0)));
        adapterMor = new GioKhamAdapter(this, R.layout.item_list_chon_gio_kham, timesMor);
        gvMor.setAdapter(adapterMor);
        adapterEve = new GioKhamAdapter(this, R.layout.item_list_chon_gio_kham, timesEve);
        gvEve.setAdapter(adapterEve);

    }

    private void getData() {
        intent = getIntent();
        ArrayList<ThongTin> thongTins = intent.getParcelableArrayListExtra(Constant.THONGTIN);
        ketQuaTraVe = thongTins;
        index = intent.getIntExtra(Constant.INDEX_THONGTIN, 0);
    }

    private String timeFromLocalTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

    private void addEvents() {
        btnGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(intent.getIntExtra(Constant.REQUEST_TAG,0) == Constant.REQUEST_CODE){
                    intent.putExtra(Constant.THONGTIN, ketQuaTraVe);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }else {
                    Intent backToFirstScreen = new Intent(VuiLongChonGiokham.this, ChonThongTinKham.class);
                    backToFirstScreen.putExtra(Constant.THONGTIN, ketQuaTraVe);
                    backToFirstScreen.putExtra(Constant.INDEX_THONGTIN, index + 1);
                    startActivity(backToFirstScreen);
                }

            }
        });

       gvMor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 ThoiGianKham time = (ThoiGianKham) adapterMor.getItem(i);
                 LocalTime startTime = time.getThoiGianBĐ();
                 LocalTime endTime = time.getThoiGianKT();
                 ketQuaTraVe.get(index).setResult(timeFromLocalTime(startTime) + " - " + timeFromLocalTime(endTime));
                 intent = new Intent(VuiLongChonGiokham.this, ChonThongTinKham.class);
                 intent.putExtra(Constant.THONGTIN, ketQuaTraVe);
                 intent.putExtra(Constant.INDEX_THONGTIN, index + 1);
                 startActivity(intent);
           }
       });

       gvEve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               ThoiGianKham time = (ThoiGianKham) adapterEve.getItem(i);
               LocalTime startTime = time.getThoiGianBĐ();
               LocalTime endTime = time.getThoiGianKT();
               ketQuaTraVe.get(index).setResult(timeFromLocalTime(startTime) + " - " + timeFromLocalTime(endTime));
               intent = new Intent(VuiLongChonGiokham.this, ChonThongTinKham.class);
               intent.putExtra(Constant.THONGTIN, ketQuaTraVe);
               intent.putExtra(Constant.INDEX_THONGTIN, index + 1);
               startActivity(intent);
           }
       });
    }

    private void linkViews() {
        gvMor = findViewById(R.id.gvMor);
        gvEve = findViewById(R.id.gvEve);
        btnGK = findViewById(R.id.btnGK);
    }
}