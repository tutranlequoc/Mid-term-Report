package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.adapter.RegionAdapter;
import com.example.models.Region;

import java.util.ArrayList;


public class Fill_Infor_Screen extends AppCompatActivity {

    TextView txtSdtDki;
    EditText edtHoten,edtNhapMk,edtXacNhanMk;
    Button btnDangKi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_infor_screen);
        linkView();
        addEvents();

    }

    private void linkView() {
        txtSdtDki = findViewById(R.id.txtSdtDki);
        edtHoten = findViewById(R.id.edtHoTen);
        edtNhapMk = findViewById(R.id.edtNhapMK);
        edtXacNhanMk = findViewById(R.id.edtXacNhanMk);
        btnDangKi = findViewById(R.id.btnDangKiFinal);
    }

    private void addEvents() {

    }


}