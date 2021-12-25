package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.adapter.Bank;
import com.example.adapter.BankAdapter;
import com.example.ultis.Constant;

import java.io.Serializable;
import java.util.ArrayList;

public class screen_phuongthucthanhtoan extends AppCompatActivity {
    Button btnthanhToanATM, btnthanhToanMomo;
    ViewGroup linearMethod;
    ImageButton btnBack;
    GridView gvBank;
    boolean expandable;
    BankAdapter bankAdapter;
    ArrayList<Bank> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_phuongthucthanhtoan);
        linkViews();
        initData();
        addEvents();
    }

    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Bank("Agribank",R.drawable.agribank));
        arrayList.add(new Bank("Techcombank",R.drawable.techcombank));
        bankAdapter = new BankAdapter(this,R.layout.bank_list,arrayList);
        gvBank.setAdapter(bankAdapter);
    }

    private void addEvents() {
        btnthanhToanATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(linearMethod);
                expandable = !expandable;
                gvBank.setVisibility(expandable ? View.VISIBLE : View.GONE);
                gvBank.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(screen_phuongthucthanhtoan.this, screen_thongtinthanhtoan.class);
                        Constant.bank = (Bank) adapterView.getItemAtPosition(i);
                        startActivity(intent);
                    }
                });
            }

        });
        btnthanhToanMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(screen_phuongthucthanhtoan.this, screen_thongtinthanhtoan.class);
                Constant.bank = new Bank("MOMO", 0);
                startActivity(intent2);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkViews() {
        btnthanhToanATM = findViewById(R.id.btnThanhToanATM);
        btnthanhToanMomo = findViewById(R.id.btnThanhToanMomo);
        btnBack = findViewById(R.id.btnBackPhuongThuc);
        linearMethod = findViewById(R.id.linearMethods);
        gvBank = findViewById(R.id.gvBanks);
    }
}