package com.example.appbenhvienlocal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.models.User;
import com.example.ultis.Constant;
import com.google.android.material.textfield.TextInputLayout;

public class ManHinhNhapPassWord extends AppCompatActivity {

    TextView txtSdt,txtDangKi,txtQuenMk,txtSaiMk;
    EditText edtPass;
    Intent intent;
    Button btnLogin;
    ImageButton imvFillPass;
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
        txtSaiMk = findViewById(R.id.txtSaiMk);
        txtQuenMk = findViewById(R.id.txtQuenMK);
        btnLogin = findViewById(R.id.btnLogin);
        edtPass = findViewById(R.id.edtPass);
        imvFillPass = findViewById(R.id.imvBackFillPass);
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
                            Toast.makeText(ManHinhNhapPassWord.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intentDangNhap = new Intent(ManHinhNhapPassWord.this,MainActivity.class);
                            startActivity(intentDangNhap);
                        }else {
                            Toast.makeText(ManHinhNhapPassWord.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }else {
//                        Toast.makeText(ManHinhNhapPassWord.this, "Sai mật khâu", Toast.LENGTH_SHORT).show();
                        txtSaiMk.setText("Sai mật khẩu");
                        txtSaiMk.setVisibility(View.VISIBLE);
                    }

                }else if(pass.equals("")){
//                    Toast.makeText(ManHinhNhapPassWord.this,"Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    txtSaiMk.setText("Vui lòng nhập mật khẩu");
                    txtSaiMk.setVisibility(View.VISIBLE);
                }

            }
        });
        imvFillPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

    @Override
    protected void onResume() {
        super.onResume();
        txtSaiMk.setVisibility(View.GONE);
    }
}