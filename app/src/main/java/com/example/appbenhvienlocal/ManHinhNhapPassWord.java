package com.example.appbenhvienlocal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.models.User;
import com.example.ultis.Constant;

public class ManHinhNhapPassWord extends AppCompatActivity {

    TextView txtSdt,txtDangKi,txtQuenMk;
    EditText edtPass;
    Intent intent;
    Button btnLogin;
    int REQUEST_CODE_FOR_LOGIN = 0;
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
        edtPass = findViewById(R.id.edtPass);
    }

    private void getData() {
        intent = getIntent();
        if(intent!=null){
            String sdt = intent.getStringExtra(Constant.PHONE_NUMBER);
            txtSdt.setText(sdt);
            if(intent.getIntExtra(Constant.REQUEST_TAG,0) == Constant.REQUEST_CODE_FOR_LOGIN){
                REQUEST_CODE_FOR_LOGIN = Constant.REQUEST_CODE_FOR_LOGIN;
            }
        }

    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = txtSdt.getText().toString();
                String pass = edtPass.getText().toString();
                if(!pass.equals("")){
                    if(Constant.database.checkUserPhoneAndPass(phone, pass) == 1){
                        String userName = Constant.database.getUserName(phone);
                        Constant.user = new User(phone, userName);
                        if(REQUEST_CODE_FOR_LOGIN == 0){
                            Intent intentDangNhap = new Intent(ManHinhNhapPassWord.this,MainActivity.class);
                            startActivity(intentDangNhap);
                        }else {
                            finish();
                        }
                    }else {
                        Toast.makeText(ManHinhNhapPassWord.this, "Sai mật khâu", Toast.LENGTH_SHORT).show();
                    }

                }else if(pass.equals("")){
                    Toast.makeText(ManHinhNhapPassWord.this,"Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                }

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