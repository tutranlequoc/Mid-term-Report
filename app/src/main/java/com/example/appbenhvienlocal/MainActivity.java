package com.example.appbenhvienlocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.GridView;
import android.widget.Spinner;

import com.example.adapter.CustomAdapter;
import com.example.function.Function;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GridView gvFunction;
    ArrayList<Function> listFunction;
    CustomAdapter adapter;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    //Spinner spinner;
    Button btnDatKham;
//    ArrayAdapter<String> spinnerAdapter= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinner));

    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void addEvents() {
        //tạo thanh toggle trên toolbar để thao tác mở đóng navigation
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        btnDatKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChonThongTinKham.class);
                startActivity(intent);
            }
        });

    }

    private void loadData() {
        gvFunction.setAdapter(adapter);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(spinnerAdapter);

    }

    private void initData() {
        listFunction = new ArrayList<Function>();
        listFunction.add(new Function(getResources().getString(R.string.ho_so), R.drawable.iconhoso));
        listFunction.add(new Function(getResources().getString(R.string.phieu_kham), R.drawable.iconphieukham));
        listFunction.add(new Function(getResources().getString(R.string.kiem_tra), R.drawable.iconkiemtra));
        adapter = new CustomAdapter(getApplicationContext(), R.layout.function, listFunction);
    }


    private void linkViews() {
        gvFunction = findViewById(R.id.gvFunction);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolBar);
        navigationView =findViewById(R.id.navigation);

//        spinner = findViewById(R.id.spinnerPhieuKham) (phần Tú comment - cần sửa lại tên để không trùng);

        //spinner = findViewById(R.id.spinnerPhieuKham);
        btnDatKham = findViewById(R.id.btnDatKham);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId==R.id.nav_paper)
        {
            Intent i = new Intent(MainActivity.this, screen_hoso_moi.class);
            startActivity(i);
        }
        else if (itemId==R.id.nav_phieuKham) {
            Intent i = new Intent(MainActivity.this, screen_phieukham.class);
            startActivity(i);
        }
        else if(itemId==R.id.nav_noti){
            Intent i = new Intent(MainActivity.this, screen_thongbao.class);
            startActivity(i);
        }
        return true;
    }
    //xử lý tình huống ng dùng chưa đóng navigation nhưng thoát app
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
}