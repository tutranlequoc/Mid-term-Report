package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen_phuongthucthanhtoan extends AppCompatActivity {
    Button btnthanhToanATM, btnthanhToanMomo,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_phuongthucthanhtoan);
        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnthanhToanATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(screen_phuongthucthanhtoan.this, screen_thongtinthanhtoan.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("atm","Bạn đang thực hiện thanh toán bằng Thanh toán bằng thẻ ATM nội địa/Internet Banking");
                intent1.putExtra("method1",bundle1);
                startActivity(intent1);
            }

        });
        btnthanhToanMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(screen_phuongthucthanhtoan.this, screen_thongtinthanhtoan.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("momo","Bạn đang thực hiện thanh toán bằng Thanh toán bằng ví Momo");
                intent2.putExtra("method2",bundle2);
                startActivity(intent2);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen_phuongthucthanhtoan.this, screen_thongtinthanhtoan.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        btnthanhToanATM = findViewById(R.id.btnThanhToanATM);
        btnthanhToanMomo = findViewById(R.id.btnThanhToanMomo);
        btnBack = findViewById(R.id.btnBackPhuongThuc);
    }
}