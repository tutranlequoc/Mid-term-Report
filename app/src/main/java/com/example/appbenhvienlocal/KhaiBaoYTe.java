package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

public class KhaiBaoYTe extends AppCompatActivity {

    //Để hai cái button có thể check lần lượt mà k cần bỏ vào radionbutton(chia 2 cột) thì phải code BE. Cụ thể là kiểm tra sự kiện check trên layout chung của 2 button đó.
    private AutoCompleteTextView noiKhaiBao, quocTich;
    private ImageView imvDropDownNoiKhaiBao, imvQuocTich;
    private ArrayAdapter<String> adapter, adapterQT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khai_bao_yte);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void addEvents() {
        imvDropDownNoiKhaiBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noiKhaiBao.showDropDown();
            }
        });
        imvQuocTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quocTich.showDropDown();
            }
        });
    }

    private void loadData() {
        noiKhaiBao.setAdapter(adapter);
    }

    private void initData() {
        String[] diaDiem = {"Bệnh viện Thủ Đức", "Bệnh viện Da Liễu"};
        String[] quocTich = {"Mỹ","Canada"};
        adapter = new ArrayAdapter<String>(this, R.layout.noi_khai_bao_dropdown);
        adapter.addAll(diaDiem);
        adapterQT = new ArrayAdapter<String>(this, R.layout.noi_khai_bao_dropdown);
        adapterQT.addAll(quocTich);
    }

    private void linkViews() {
        noiKhaiBao = findViewById(R.id.actKhaiBao);
        quocTich = findViewById(R.id.actQuocTich);
        imvQuocTich = findViewById(R.id.imvQuocTich);
        imvDropDownNoiKhaiBao = findViewById(R.id.imvDropDownKhaiBao);
    }
}