package com.example.appbenhvienlocal;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.CustomAdapter;
import com.example.function.Function;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvFunction;
    ArrayList<Function> listFunction;
    CustomAdapter adapter;
    ActionBarDrawerToggle actionBarDrawerToggle;

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
    }

    private void loadData() {
        gvFunction.setAdapter(adapter);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

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
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
}