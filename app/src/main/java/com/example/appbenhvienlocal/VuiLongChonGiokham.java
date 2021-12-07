package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.function.ThongTin;
import com.example.ultis.Constant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class VuiLongChonGiokham extends AppCompatActivity {

    private ImageButton btnGK;
    ArrayList<ThongTin> ketQuaTraVe;
    Intent intent;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_long_chon_giokham);
        linkViews();
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
                    backToFirstScreen.putExtra(Constant.INDEX_THONGTIN, index - 1);
                    startActivity(backToFirstScreen);
                }

            }
        });
    }

    private void linkViews() {
        btnGK = findViewById(R.id.btnGK);
    }
}