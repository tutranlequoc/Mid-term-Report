package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        linkViews();
//        initData();
//        loadData();
    }

    private void loadData() {
        gvFunction.setAdapter(adapter);
    }

    private void initData() {
        listFunction = new ArrayList<Function>();
        listFunction.add(new Function("Hỗ trợ đặt khám", R.drawable.location));
        listFunction.add(new Function("Hỗ trợ Zalo", R.drawable.location));
        listFunction.add(new Function("Bản đồ", R.drawable.location));
        adapter = new CustomAdapter(getApplicationContext(), R.layout.function, listFunction);
    }


    private void linkViews() {
//        gvFunction = findViewById(R.id.gvFunction);
    }

}