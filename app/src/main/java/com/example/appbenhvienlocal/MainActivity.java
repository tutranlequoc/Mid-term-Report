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
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.CustomAdapter;
import com.example.database.BenhVienSQLiteHelper;
import com.example.function.Function;
import com.example.ultis.Constant;
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
    ImageButton imgbtnZalo;
//    ArrayAdapter<String> spinnerAdapter= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinner));

    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareDB();
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void prepareDB() {
        Constant.database = new BenhVienSQLiteHelper(this);
//        Constant.database.createDefaultUser();
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

        imgbtnZalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = getPackageManager().getLaunchIntentForPackage("com.zalo");
//                if(intent != null){
//                    startActivity(intent);
//                }
//                Cài app trước
            }
        });

    }

    private void loadData() {
        gvFunction.setAdapter(adapter);
        gvFunction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Function function = (Function) adapter.getItem(i);
                Intent toFunctionScreen;
                if(Constant.user == null){
                    toFunctionScreen = new Intent(MainActivity.this, LoginScreen.class);
                    toFunctionScreen.putExtra(Constant.REQUEST_TAG, Constant.REQUEST_CODE_FOR_LOGIN);
                    startActivity(toFunctionScreen);
                }else {
                    switch (function.getFunction()){
                        case Constant.HO_SO:
                            toFunctionScreen = new Intent(MainActivity.this, HoSoDatKham.class);
                            toFunctionScreen.putExtra(Constant.REQUEST_TAG, Constant.REQUEST_CODE_FOR_DOCUMENT_FROM_MAIN);
                            startActivity(toFunctionScreen);
                            break;
                        case Constant.PHIEU_KHAM:
                            toFunctionScreen = new Intent(MainActivity.this, DanhSachPhieuKhamScreen.class);
                            startActivity(toFunctionScreen);
                            break;
                        case Constant.KIEM_TRA:
                            toFunctionScreen = new Intent(MainActivity.this, QRCode_Bhyt.class);
                            startActivity(toFunctionScreen);
                            break;
                    }
                }

            }
        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(spinnerAdapter);

    }

    private void initData() {
        listFunction = new ArrayList<Function>();
        listFunction.add(new Function(Constant.HO_SO, R.drawable.iconhoso));
        listFunction.add(new Function(Constant.PHIEU_KHAM, R.drawable.iconphieukham));
        listFunction.add(new Function(Constant.KIEM_TRA, R.drawable.iconkiemtra));
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
        imgbtnZalo = findViewById(R.id.imbtnZalo);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId==R.id.nav_paper)
        {
            Intent i;
            if(Constant.user == null) {
                i = new Intent(MainActivity.this, LoginScreen.class);
                i.putExtra(Constant.REQUEST_TAG, Constant.REQUEST_CODE_FOR_LOGIN);
            }else {
                i = new Intent(MainActivity.this, HoSoDatKham.class);
            }
            startActivity(i);
        }
        else if (itemId==R.id.nav_phieuKham) {
            Intent i;
            if(Constant.user == null) {
                i = new Intent(MainActivity.this, LoginScreen.class);
                i.putExtra(Constant.REQUEST_TAG, Constant.REQUEST_CODE_FOR_LOGIN);
            }else {
                i = new Intent(MainActivity.this, screen_phieukham.class);
            }
            startActivity(i);
        }
        else if(itemId==R.id.nav_noti){
            Intent i = new Intent(MainActivity.this, screen_thongbao.class);
            startActivity(i);
        }else if (itemId == R.id.nav_login){
            Intent i = new Intent(MainActivity.this, LoginScreen.class);
            startActivity(i);
        }else if (itemId == R.id.nav_policy){
            Intent i = new Intent(MainActivity.this, screen_dieukhoan.class);
            startActivity(i);
        }else if (itemId == R.id.nav_faq){
            Intent i = new Intent(MainActivity.this, screen_faq.class);
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