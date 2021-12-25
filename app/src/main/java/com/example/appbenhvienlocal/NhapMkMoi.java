package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NhapMkMoi extends AppCompatActivity {

    TextView txtSdtDoiMk;
    Button btnDoiMk;
    EditText edtNhapMKMoi,edtXacNhanMkMoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_mk_moi);
        linkView();
    }

    private void linkView() {
        txtSdtDoiMk = findViewById(R.id.txtSdtDoiMk);
        edtNhapMKMoi = findViewById(R.id.edtNhapMkMoi);
        edtXacNhanMkMoi = findViewById(R.id.edtXacNhanMkMoi);
        btnDoiMk = findViewById(R.id.btnDoiMk);

    }
}