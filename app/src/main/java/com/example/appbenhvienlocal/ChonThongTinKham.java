package com.example.appbenhvienlocal;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.CustomAdapter;
import com.example.function.Function;
import com.example.function.ThongTin;
import com.example.models.BackScreenClick;
import com.example.ultis.Constant;

import java.util.ArrayList;

public class ChonThongTinKham extends AppCompatActivity {

    private ListView lvOptions;
    private CustomAdapter adapter;
    private ImageButton btnTTK;
    private ArrayList<ThongTin> thongTin;
    private ActivityResultLauncher<Intent> activityResultLauncher, activityResultLauncherHSDK;
    private Button btnTiepTuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chon_thong_tin_kham);
        Log.e("oncreate","run");
        linkViews();
        initData();
        if(savedInstanceState == null){
            initData();
        }else {
            thongTin = savedInstanceState.getParcelableArrayList(Constant.THONGTIN);
            adapter = new CustomAdapter(thongTin, R.layout.listview_chon_thong_tin_kham, this);
        }
        getData();
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == Activity.RESULT_OK && result.getData() != null){
//                ArrayList<ThongTin> ketQua = result.getData().getParcelableArrayListExtra(Constant.THONGTIN);
//                thongTin.get(0).setResult(ketQua.get(0).getResult());
//                adapter.notifyDataSetChanged();
                  Log.e(Constant.THONGTIN, "success");
            }
        });
        addEvents();
        loadData();

    }

    private void getData() {
        Intent result = getIntent();
        if(result.hasExtra(Constant.THONGTIN)){
            ArrayList<ThongTin> ketQua = result.getParcelableArrayListExtra(Constant.THONGTIN);
            try {
                int no_elements_changes = result.getIntExtra(Constant.INDEX_THONGTIN, 0);
                for(int i =0; i <= no_elements_changes; i++){
                    thongTin.get(i).setResult(ketQua.get(i).getResult());
                }
                adapter.notifyDataSetChanged();
            }catch (Exception e){
                Log.e("Error","Can't get value. " + e.toString());
            }
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Constant.THONGTIN, thongTin);
        Log.e("onSave","run");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onresume","run");

    }

    private void addEvents() {
        btnTTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChonThongTinKham.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lvOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i){
                    case 0:
                        intent = new Intent(ChonThongTinKham.this, VuiLongChonChuyenKhoa.class);
                        break;
                    case 1:
                        intent = new Intent(ChonThongTinKham.this, VuiLongChonDichVu.class);
                        break;
                    case 2:
                        intent = new Intent(ChonThongTinKham.this,ChonNgayKham.class);
                        break;
                    case 3:
                        intent = new Intent(ChonThongTinKham.this,VuiLongChonGiokham.class);
                        break;
                }
                try{
                    intent.putExtra(Constant.INDEX_THONGTIN,i);
                    intent.putParcelableArrayListExtra(Constant.THONGTIN, thongTin);
                    intent.putExtra(Constant.REQUEST_TAG, Constant.REQUEST_CODE);
                    activityResultLauncher.launch(intent);
                }catch (Exception e){
                    Log.e("Lỗi",e.toString());
                    Toast.makeText(ChonThongTinKham.this, "Đã có lỗi xảy ra", Toast.LENGTH_SHORT).show();
                }

            }
        });

        if(thongTin.get(thongTin.size() - 1).getResult().equals("")){
            btnTiepTuc.setClickable(false);
            Toast.makeText(ChonThongTinKham.this, "Vui lòng chọn đủ thông tin", Toast.LENGTH_SHORT).show();
        }else if(!thongTin.get(thongTin.size()-1).getResult().equals("")){
            btnTiepTuc.setClickable(true);
            btnTiepTuc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Constant.user == null){
                        Intent toLogin = new Intent(ChonThongTinKham.this, LoginScreen.class);
                        toLogin.putExtra(Constant.REQUEST_TAG, Constant.REQUEST_CODE_FOR_LOGIN);
                        startActivity(toLogin);
                    }else {
                        Intent toHoSoDK = new Intent(ChonThongTinKham.this, HoSoDatKham.class);
                        startActivity(toHoSoDK);
                    }

                }
            });
        }


    }

    private void loadData() {
        lvOptions.setAdapter(adapter);
    }

    private void initData() {
        thongTin = new ArrayList<ThongTin>();
        thongTin.add(new ThongTin("Chọn chuyên khoa", R.drawable.cck, ""));
        thongTin.add(new ThongTin("Chọn dịch vụ", R.drawable.cdv,""));
        thongTin.add(new ThongTin("Chọn ngày khám", R.drawable.chonngay,""));
        thongTin.add(new ThongTin("Chọn giờ tiếp nhận bệnh", R.drawable.cg,""));
        adapter = new CustomAdapter(thongTin, R.layout.listview_chon_thong_tin_kham, this);
    }

    private void linkViews() {
        lvOptions = findViewById(R.id.lvOptions);
        btnTTK = findViewById(R.id.btnTTK);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
    }

}