package com.example.appbenhvienlocal;

import  androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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
import com.example.models.Region;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class LoginScreen extends AppCompatActivity {

    Spinner spRegion;
    ArrayList<Region> region;
    RegionAdapter adapter;
    Button btnContinue;
    EditText edtSdt;
    Intent intent;
    TextView txtLoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        linkView();
        loadData();
        addEvents();
    }

    private void linkView() {
        spRegion= findViewById(R.id.spRegion);
        btnContinue = findViewById(R.id.btnContinue);
        edtSdt = findViewById(R.id.edtSdt);
        txtLoi = findViewById(R.id.txtLoi);
    }

    private void loadData() {
        region = new ArrayList<>();
        region.add(new Region(R.drawable.vietnam));
        region.add(new Region(R.drawable.ukflag));
        region.add(new Region(R.drawable.usflag));
        adapter = new RegionAdapter(this,region);
        spRegion.setAdapter(adapter);

    }

    private void addEvents() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtSdt.getText().toString().equals("") ) {
                    txtLoi.setVisibility(View.VISIBLE);

                }else {
                    intent = new Intent(LoginScreen.this, ManHinhNhapPassWord.class);
                    String sdt = edtSdt.getText().toString();
                    intent.putExtra("Sdt", sdt);
                    startActivity(intent);


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