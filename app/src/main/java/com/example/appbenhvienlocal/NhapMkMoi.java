package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ultis.Constant;

public class NhapMkMoi extends AppCompatActivity {

    TextView txtSdtDoiMk;
    Button btnDoiMk;
    EditText edtNhapMKMoi,edtXacNhanMkMoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_mk_moi);
        linkView();
        getData();
    }

    private void linkView() {
        txtSdtDoiMk = findViewById(R.id.txtSdtDoiMk);
        edtNhapMKMoi = findViewById(R.id.edtNhapMkMoi);
        edtXacNhanMkMoi = findViewById(R.id.edtXacNhanMkMoi);
        btnDoiMk = findViewById(R.id.btnDoiMk);

    }

    private void getData() {
        Intent intent = getIntent();
        String sdt = intent.getStringExtra(Constant.PHONE_NUMBER);
        txtSdtDoiMk.setText(sdt);
    }
}