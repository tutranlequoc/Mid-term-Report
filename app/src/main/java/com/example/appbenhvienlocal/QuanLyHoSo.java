package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.BenhVienSQLiteHelper;
import com.example.dialog.CustomDiaLogHoSo;
import com.example.ultis.Constant;

public class QuanLyHoSo extends AppCompatActivity {

    ImageButton btnDelete, btnBackXacNhan;
    Button btnBackToMain, btnUpdate;
    CustomDiaLogHoSo customDiaLogHoSo;
    TextView txtCode, txtDateOfBirth, txtGender, txtIdentity, txtInsurance, txtEthnic,
            txtJob, txtPhoneNumber, txtEmail, txtCountry, txtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_ho_so);
        linkViews();
        getDataFromDb();
        initData();
        addEvents();
        loadData();
    }

    private void initData() {
        customDiaLogHoSo = new CustomDiaLogHoSo(this);
        customDiaLogHoSo.setCancelable(false);
        customDiaLogHoSo.getTxtXoa().setTextColor(Color.parseColor("#5CC0AB"));
        customDiaLogHoSo.getTxtXoa().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Constant.doc != null){
                    Constant.database.deleteDocument(Constant.doc.getMaSo(), Constant.user.getPhone());
                }
                customDiaLogHoSo.dismiss();
                finish();
            }
        });

        customDiaLogHoSo.getTxtHuy().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDiaLogHoSo.dismiss();
            }
        });
        Window window = customDiaLogHoSo.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }


    private void setTextFromData(TextView txtText, String text){
        if(!text.equals("")){
            txtText.setText(text);
        }
    }

    private void loadData() {
        setTextFromData(txtCode, Constant.document.getCode());
        setTextFromData(txtDateOfBirth, Constant.document.getDateOfBirth());
        setTextFromData(txtGender, Constant.document.getGender());
        setTextFromData(txtIdentity, Constant.document.getIdentity());
        setTextFromData(txtInsurance, Constant.document.getInsurance());
        setTextFromData(txtJob, Constant.document.getJob());
        setTextFromData(txtPhoneNumber, Constant.document.getPhoneNumber_booking());
        setTextFromData(txtEmail, Constant.document.getEmail());
        setTextFromData(txtCountry, Constant.document.getCountry());
        setTextFromData(txtAddress, Constant.document.getAddress());
        setTextFromData(txtEthnic, Constant.document.getEthnic());
    }

    private void getDataFromDb() {
        if(Constant.database != null){
            Constant.document = Constant.database.getInForFromDocumentByCode(Constant.doc.getMaSo());
        }
    }

    private void addEvents() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDiaLogHoSo.show();
            }
        });
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMain = new Intent(QuanLyHoSo.this, MainActivity.class);
                startActivity(backToMain);
            }
        });

        btnBackXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toEditScreen = new Intent(QuanLyHoSo.this, ChinhSuaHoSo.class);
                startActivity(toEditScreen);
            }
        });
    }

    private void linkViews() {
        btnBackToMain = findViewById(R.id.btnBackToMain);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        txtCode = findViewById(R.id.txtCodePatient);
        txtDateOfBirth = findViewById(R.id.txtDateOfBirth);
        txtGender = findViewById(R.id.txtGender);
        txtIdentity = findViewById(R.id.txtInsurance);
        txtInsurance = findViewById(R.id.txtEthnic);
        txtJob = findViewById(R.id.txtJob);
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        txtEmail = findViewById(R.id.txtMail);
        txtCountry = findViewById(R.id.txtCountry);
        txtAddress = findViewById(R.id.txtAddress);
        txtEthnic = findViewById(R.id.txtEthnic);
        btnBackXacNhan = findViewById(R.id.btnBackXacNhan);
    }
}