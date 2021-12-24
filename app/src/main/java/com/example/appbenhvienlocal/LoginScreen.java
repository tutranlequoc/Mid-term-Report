package com.example.appbenhvienlocal;

import  androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.RegionAdapter;
import com.example.database.BenhVienSQLiteHelper;
import com.example.models.Region;
import com.example.models.User;
import com.example.ultis.Constant;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class LoginScreen extends AppCompatActivity {

    Button btnContinue;
    EditText edtSdt;
    Intent intent;
    TextView txtLoi;
    int REQUEST_CODE_FOR_LOGIN = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        Constant.database = new BenhVienSQLiteHelper(this);
        Constant.database.createDefaultUser();
        linkView();

        getData();
        addEvents();

    }



    private void linkView() {

        btnContinue = findViewById(R.id.btnContinue);
        edtSdt = findViewById(R.id.edtSdt);
        txtLoi = findViewById(R.id.txtLoi);
    }



    public Boolean checkFormatPhone(String phoneNumber){
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean flag = phoneNumber.matches(reg);
        return flag;
    }

    private void getData() {
        intent = getIntent();
        if(intent!=null){
            if(intent.getIntExtra(Constant.REQUEST_TAG,0) == Constant.REQUEST_CODE_FOR_LOGIN){
                REQUEST_CODE_FOR_LOGIN = Constant.REQUEST_CODE_FOR_LOGIN;
            }
        }

    }

    private void addEvents() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edtSdt.getText().toString();
                if (phone.equals("") || checkFormatPhone(phone) == false) {
                    txtLoi.setVisibility(View.VISIBLE);
                }else {
                    if(Constant.database.checkUserPhone(phone) == 1){
                        intent = new Intent(LoginScreen.this, ManHinhNhapPassWord.class);

                    }else {
                        intent = new Intent(LoginScreen.this, OTPScreen.class);
                    }
                    intent.putExtra(Constant.PHONE_NUMBER, phone);
                    if(REQUEST_CODE_FOR_LOGIN != 0){
                        intent.putExtra(Constant.REQUEST_TAG, REQUEST_CODE_FOR_LOGIN);
                        startActivity(intent);
                        finish();
                    }else {
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtLoi.setVisibility(View.GONE);

    }
}