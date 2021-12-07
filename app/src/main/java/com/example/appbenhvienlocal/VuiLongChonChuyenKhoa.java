package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.function.ThongTin;
import com.example.models.BackScreenClick;
import com.example.ultis.Constant;

import java.util.ArrayList;

public class VuiLongChonChuyenKhoa extends AppCompatActivity {

    private ListView lvChuyenkhoa;
    String [] chuyenkhoa;
    ArrayAdapter<String> adapter;
    private ImageButton btnCK;
    ArrayList<ThongTin> ketQuaTraVe;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_long_chon_chuyen_khoa);
        linkViews();
        initData();
        loadData();
        addEvents();
        getData();
    }

    private void getData() {
        intent = getIntent();
        ArrayList<ThongTin> thongTins = intent.getParcelableArrayListExtra(Constant.THONGTIN);
        ketQuaTraVe = thongTins;
    }

    private void addEvents() {
        lvChuyenkhoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adapter.getItem(i);
                int index = intent.getIntExtra(Constant.INDEX_THONGTIN, 0);
                ketQuaTraVe.get(index).setResult(s);
                int k = index;
                while (k + 1 <= ketQuaTraVe.size() - 1){
                    ketQuaTraVe.get(k + 1).setResult("");
                    k++;
                }

                try{
                    intent = new Intent(VuiLongChonChuyenKhoa.this, VuiLongChonDichVu.class);
                    intent.putParcelableArrayListExtra(Constant.THONGTIN, ketQuaTraVe);
                    intent.putExtra(Constant.INDEX_THONGTIN, index+1);
                    startActivity(intent);
                }catch (Exception e) {
                    Log.e("Lỗi", e.toString());
                }

            }
        });
        btnCK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(Constant.THONGTIN, ketQuaTraVe);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }

    private void loadData() {
        lvChuyenkhoa.setAdapter(adapter);
    }

    private void initData() {
        chuyenkhoa = getResources().getStringArray(R.array.chuyen_khoa);
        adapter = new ArrayAdapter<String>(VuiLongChonChuyenKhoa.this, android.R.layout.simple_list_item_1, chuyenkhoa);
    }

    private void linkViews() {
        lvChuyenkhoa = findViewById(R.id.lvChuyenKhoa);
        btnCK = findViewById(R.id.btnCK);
    }
}