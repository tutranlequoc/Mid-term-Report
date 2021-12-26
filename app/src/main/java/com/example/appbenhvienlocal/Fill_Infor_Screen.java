package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.RegionAdapter;
import com.example.models.Region;
import com.example.models.User;
import com.example.ultis.Constant;

import java.util.ArrayList;


public class Fill_Infor_Screen extends AppCompatActivity {

    TextView txtSdtDki;
    EditText edtHoten,edtNhapMk,edtXacNhanMk;
    Button btnDangKi;
    String sdt;
    ImageButton imvFillInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_infor_screen);
        linkView();
        getData();
        addEvents();

    }

    private void linkView() {
        txtSdtDki = findViewById(R.id.txtSdtDki);
        edtHoten = findViewById(R.id.edtHoTen);
        edtNhapMk = findViewById(R.id.edtNhapMK);
        edtXacNhanMk = findViewById(R.id.edtXacNhanMk);
        btnDangKi = findViewById(R.id.btnDangKiFinal);
        imvFillInfor = findViewById(R.id.imvFillInfor);
    }

    private void getData() {
       sdt = getIntent().getStringExtra(Constant.PHONE_NUMBER);
       txtSdtDki.setText(sdt);
    }

    private void addEvents() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtHoten.getText().toString();
                String pass = edtNhapMk.getText().toString();
                String pass_again = edtXacNhanMk.getText().toString();
                if(sdt.equals("") || ten.equals("") || pass_again.equals("") || pass.equals("")){
                    Toast.makeText(Fill_Infor_Screen.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    Constant.database.insertDataForUser(sdt, ten, pass);
                    String userName = Constant.database.getUserName(sdt);
                    Constant.user = new User(sdt, userName);
                    Intent intent = new Intent(Fill_Infor_Screen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        imvFillInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}