package com.example.appbenhvienlocal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ultis.Constant;

public class ManHinhNhapPassWord extends AppCompatActivity {

    TextView txtSdt,txtDangKi,txtQuenMk;
    Intent intent;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_nhap_password);
        linkView();
        getData();
        addEvents();

    }

    private void linkView() {
        txtSdt = findViewById(R.id.txtSdt);
        txtDangKi = findViewById(R.id.txtDangKi);
        txtQuenMk = findViewById(R.id.txtQuenMK);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void getData() {
        intent = getIntent();
        String sdt = intent.getStringExtra("Sdt");
        txtSdt.setText(sdt);
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDangNhap = new Intent(ManHinhNhapPassWord.this,MainActivity.class);
                String sdt1 = txtSdt.getText().toString();
                intentDangNhap.putExtra("Sdt1",sdt1);
                startActivity(intentDangNhap);
            }
        });
        txtDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDangKi = new Intent(ManHinhNhapPassWord.this,ManHinhDangKy.class);
                startActivity(intentDangKi);
            }
        });
        txtQuenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuenMk = new Intent(ManHinhNhapPassWord.this,QuenMatKhau.class);
                startActivity(intentQuenMk);
            }
        });

    }
}