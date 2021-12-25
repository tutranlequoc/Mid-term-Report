package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ultis.Constant;

public class XacNhanThongTin extends AppCompatActivity {

    ImageButton btnBackXacNhan;
    Button btnDatKham;

    TextView txtCode, txtDateOfBirth, txtGender, txtIdentity, txtInsurance, txtEthnic,
    txtJob, txtPhoneNumber, txtEmail, txtCountry, txtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_thong_tin);
        linkViews();
        getDataFromDb();
        loadData();
        addEvents();

    }

    private void addEvents() {
        btnBackXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDatKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XacNhanThongTin.this, screen_phuongthucthanhtoan.class);
                startActivity(intent);
            }
        });
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

    private void linkViews() {
        btnBackXacNhan = findViewById(R.id.btnBackXacNhan);
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
        btnDatKham = findViewById(R.id.btnDatKhamBottom);
    }
}