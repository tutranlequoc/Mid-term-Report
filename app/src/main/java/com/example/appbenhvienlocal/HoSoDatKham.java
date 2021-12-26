package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;
import com.example.appbenhvienlocal.fragment.DanhSachHoSo;
import com.example.appbenhvienlocal.fragment.KhongCoHoSo;
import com.example.function.DichVu;
import com.example.function.HoSoDK;
import com.example.models.onItemFragmentClick;
import com.example.ultis.Constant;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class HoSoDatKham extends AppCompatActivity implements onItemFragmentClick {

    private ListView lvHoSo;
    CustomAdapter adapter;
    ImageButton btnBackHS, btnThem;
    private FragmentManager manager;
    Intent changeScreen;
    int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_so_dat_kham);
        linkViews();
        addEvents();
        getData();

    }


    private void getData() {
       changeScreen = getIntent();
       if(changeScreen != null){
           code = changeScreen.getIntExtra(Constant.REQUEST_TAG, 0);
       }
    }

    @Override
    protected void onResume() {
        super.onResume();
        replaceFragment();
    }

    private void replaceFragment() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(Constant.database.checkExistDocument(Constant.user.getPhone()) == 0){
            ;
            transaction.replace(R.id.lvContainer, new KhongCoHoSo());
        }else {
            transaction.replace(R.id.lvContainer, new DanhSachHoSo());
        }
        transaction.commit();
    }

    private void addEvents() {
        btnBackHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(code == Constant.REQUEST_CODE_FOR_DOCUMENT_FROM_MAIN){
                    changeScreen = new Intent(HoSoDatKham.this, MainActivity.class);
                    startActivity(changeScreen);
                }else {
                    finish();
                }

            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(HoSoDatKham.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_layout,
                        findViewById(R.id.bottomSheetContainer));
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
                Button btnChuaTungKham = bottomSheetDialog.findViewById(R.id.btnQuetMa);
                Button btnDaTungKham = bottomSheetDialog.findViewById(R.id.btnNhapHS);
                Button btnQuetMa = bottomSheetDialog.findViewById(R.id.btnDKMoi);
                btnChuaTungKham.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent screen_chuatungkham = new Intent(HoSoDatKham.this, com.example.appbenhvienlocal.screen_chuatungkham.class);
                        startActivity(screen_chuatungkham);
                        bottomSheetDialog.dismiss();
                    }
                });
                btnDaTungKham.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent screen_datungkham = new Intent(HoSoDatKham.this, com.example.appbenhvienlocal.screen_datungkham.class);
                        startActivity(screen_datungkham);
                    }
                });
                btnQuetMa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        });
    }

    private void linkViews() {
        btnBackHS = findViewById(R.id.btnBackHS);
        btnThem = findViewById(R.id.btnBoVao);
    }

    @Override
    public void click(HoSoDK doc) {
        if(code == Constant.REQUEST_CODE_FOR_DOCUMENT_FROM_MAIN){
            changeScreen = new Intent(HoSoDatKham.this, QuanLyHoSo.class);
            Constant.doc = doc;
            startActivity(changeScreen);
        }else {
            changeScreen = new Intent(HoSoDatKham.this, XacNhanThongTin.class);
            Constant.doc = doc;
            startActivity(changeScreen);
        }
    }
}