package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ultis.Constant;

import java.util.Random;

public class PhieuKhamBenhDaThanhToan extends AppCompatActivity {

    TextView txtOrderNumber, txtDichVu, txtDate, txtTime, txtFullName, txtGender, txtDateOfBirth, txtForm, txtCity, txtMoney,
    txtCodeBN, txtCodeMedicalTest, txtChuyenKhoa;
    Button btnBackPKTT;
    ImageButton btnBackPhieuKham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phieu_kham_benh_da_thanh_toan);
        linkViews();
        loadData();
        addEvents();

    }

    private void addEvents() {
        btnBackPKTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhieuKhamBenhDaThanhToan.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnBackPhieuKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhieuKhamBenhDaThanhToan.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        Random random = new Random();
        int number = random.nextInt(100);
        txtOrderNumber.setText(String.valueOf(number));
        txtDichVu.setText(Constant.bookingInfor.getDichVu());
        txtDate.setText(Constant.bookingInfor.getNgayKham());
        txtTime.setText(Constant.bookingInfor.getGioKham());
        txtFullName.setText(Constant.document.getFullName());
        txtGender.setText(Constant.document.getGender());
        txtDateOfBirth.setText(Constant.document.getDateOfBirth());
        txtForm.setText("Khám BHYT");
        txtCity.setText(Constant.document.getCity());
        txtMoney.setText(Constant.bookingInfor.getTienKham());
        txtCodeBN.setText(Constant.document.getCode());
        txtCodeMedicalTest.setText("(Mã phiếu: "+ Constant.code_medical_test + ")");
        txtChuyenKhoa.setText("Chuyên khoa: " + Constant.bookingInfor.getChuyenKhoa());
    }

    private void linkViews() {
        txtOrderNumber = findViewById(R.id.txtOrderNumber);
        txtDichVu = findViewById(R.id.txtDichVu);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        txtFullName = findViewById(R.id.txtFullName);
        txtGender = findViewById(R.id.txtGender);
        txtDateOfBirth = findViewById(R.id.txtDateOfBirth);
        txtForm = findViewById(R.id.txtForm);
        txtCity = findViewById(R.id.txtCity);
        txtMoney = findViewById(R.id.txtMoney);
        txtCodeBN = findViewById(R.id.txtCodeBN);
        txtCodeMedicalTest = findViewById(R.id.txtCodeMedicalTest);
        txtChuyenKhoa = findViewById(R.id.txtChuyenKhoa);
        btnBackPhieuKham = findViewById(R.id.btnBackPhieuKham);
        btnBackPKTT = findViewById(R.id.btnBackPKTT);
    }
}