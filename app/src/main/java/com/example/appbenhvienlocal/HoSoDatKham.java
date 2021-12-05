package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;
import com.example.function.DichVu;
import com.example.function.HoSoDK;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class HoSoDatKham extends AppCompatActivity {

    private ListView lvHoSo;
    CustomAdapter adapter;
    ImageButton btnBackHS, btnThem;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_so_dat_kham);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void addEvents() {
        btnBackHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(HoSoDatKham.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_layout,
                        findViewById(R.id.bottomSheetContainer));
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
    }

    private void loadData() {
        lvHoSo.setAdapter(adapter);
    }

    private void initData() {
        ArrayList<HoSoDK> hoSoDKS = new ArrayList<HoSoDK>();
        hoSoDKS.add(new HoSoDK("Giap","04/03/01", "MP14WFWQDA", "TP Thủ Đức","01223455"));
        hoSoDKS.add(new HoSoDK("Tu","05/11/01", "MP31AFSQHB", "Quận 7","098765342"));
        adapter = new CustomAdapter(HoSoDatKham.this, hoSoDKS, R.layout.listview_ho_so_dat_kham);
    }

    private void linkViews() {
        lvHoSo = findViewById(R.id.lvHoSo);
        btnBackHS = findViewById(R.id.btnBackHS);
        btnThem = findViewById(R.id.btnBoVao);
    }
}