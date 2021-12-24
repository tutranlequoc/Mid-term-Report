package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.adapter.RegionAdapter;
import com.example.models.Region;

import java.util.ArrayList;


public class NhapPassWordScreen extends AppCompatActivity {

    Spinner spRegion;
    ArrayList<Region> region;
    RegionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        linkView();
        loadData();
    }

    private void linkView() {
//        spRegion= findViewById(R.id.spRegion);
    }

    private void loadData() {
        region = new ArrayList<>();
        region.add(new Region(R.drawable.vietnam));
        region.add(new Region(R.drawable.ukflag));
        region.add(new Region(R.drawable.usflag));
        adapter = new RegionAdapter(this,region);
//        spRegion.setAdapter(adapter);

    }
}