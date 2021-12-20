package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManHinhDangKy extends AppCompatActivity {
 Button btnDangKi;
 EditText edtSdtDKi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ky);
        linkView();
        addEvents();
    }

    private void linkView() {
        btnDangKi = findViewById(R.id.btnDangKi);
        edtSdtDKi = findViewById(R.id.edtSdtDKi);
    }

    private void addEvents() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinhDangKy.this,OTPScreen.class);

                String sdt = edtSdtDKi.getText().toString();
                intent.putExtra("SdtDKi",sdt);
                startActivity(intent);
            }
        });
    }
}