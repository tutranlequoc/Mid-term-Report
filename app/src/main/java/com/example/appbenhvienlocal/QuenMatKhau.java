package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuenMatKhau extends AppCompatActivity {

    EditText edtQuenMk;
    TextView txtDangKiQuenMk;
    Button btnQuenMk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);
        linkView();
        addEvents();
    }

    private void linkView() {
        edtQuenMk = findViewById(R.id.edtSdtQuenMk);
        txtDangKiQuenMk = findViewById(R.id.txtDangKiQuenMk);
        btnQuenMk = findViewById(R.id.btnContinueQuenMk);
    }

    private void addEvents() {
        btnQuenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuenMatKhau.this,NhapMkMoi.class);
                String phoneNum = edtQuenMk.getText().toString();
                intent.putExtra("phoneNum",phoneNum);
                startActivity(intent);
            }
        });
        txtDangKiQuenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuenMatKhau.this,ManHinhDangKy.class);
                startActivity(intent);
            }
        });
    }
}