package com.example.appbenhvienlocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class KhaiBaoYTe extends AppCompatActivity {

    //Để hai cái button có thể check lần lượt mà k cần bỏ vào radionbutton(chia 2 cột) thì phải code BE. Cụ thể là kiểm tra sự kiện check trên layout chung của 2 button đó.
    private AutoCompleteTextView actNoiKhaiBao, actQuocTich, actTinhThanh, actQuanHuyen, actXaPhuong;
    private ImageView imvDropDownNoiKhaiBao, imvQuocTich, imvTinhThanh, imvQuanHuyen, imvXaPhuong, imvMenu;
    private ArrayAdapter<String> adapter, adapterQT, adapterTT, adapterQH, adapterXaPhuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thong_tin_khai_bao);
//        linkViews();
//        initData();
//        loadData();
//        showMenu();
//        addEvents();

    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, imvMenu);
        popupMenu.getMenuInflater().inflate(R.menu.context_menu_khai_bao_y_te, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.mnKhaiBao:
                        Toast.makeText(KhaiBaoYTe.this,"Success", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mnLichSu:
                        Toast.makeText(KhaiBaoYTe.this,"Fail", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        imvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();
            }
        });
    }

    private void addEvents() {

        imvDropDownNoiKhaiBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actNoiKhaiBao.showDropDown();
            }
        });

        imvQuocTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actQuocTich.showDropDown();
            }
        });

        imvTinhThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actTinhThanh.showDropDown();
            }
        });

        imvQuanHuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhaiBaoYTe.this.openContextMenu(view);
            }
        });

        imvXaPhuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actXaPhuong.showDropDown();
            }
        });



    }




    private void loadData() {
        actNoiKhaiBao.setAdapter(adapter);
        actQuocTich.setAdapter(adapterQT);
        actTinhThanh.setAdapter(adapterTT);
        actQuanHuyen.setAdapter(adapterQH);
        actXaPhuong.setAdapter(adapterXaPhuong);
    }

    private void initData() {
        String[] diaDiem = {"Bệnh viện Thủ Đức", "Bệnh viện Da Liễu"};
        String[] quocTich = {"Mỹ","Canada","Việt Nam"};
        String[] tinhThanh = {"Hồ Chí Minh","Hà Nội", "Hải Phòng"};
        String[] quanHuyen = {"Thủ Đức", "Hoàn Kiếm"};
        String[] xaPhuong = {"Linh Tây", "Linh Xuân", "Linh Trung"};
        adapter = new ArrayAdapter<String>(this, R.layout.noi_khai_bao_dropdown);
        adapter.addAll(diaDiem);
        adapterQT = new ArrayAdapter<String>(this, R.layout.noi_khai_bao_dropdown);
        adapterQT.addAll(quocTich);
        adapterTT = new ArrayAdapter<String>(this, R.layout.noi_khai_bao_dropdown);
        adapterTT.addAll(tinhThanh);
        adapterQH = new ArrayAdapter<String>(this, R.layout.noi_khai_bao_dropdown);
        adapterQH.addAll(quanHuyen);
        adapterXaPhuong = new ArrayAdapter<String>(this, R.layout.noi_khai_bao_dropdown);
        adapterXaPhuong.addAll(xaPhuong);
    }

    private void linkViews() {
        actNoiKhaiBao = findViewById(R.id.actKhaiBao);
        actQuocTich = findViewById(R.id.actQuocTich);
        actTinhThanh = findViewById(R.id.actTinhThanh);
        actQuanHuyen = findViewById(R.id.actQuanHuyen);
        actXaPhuong = findViewById(R.id.actXaPhuong);
        imvQuocTich = findViewById(R.id.imvQuocTich);
        imvDropDownNoiKhaiBao = findViewById(R.id.imvDropDownKhaiBao);
        imvTinhThanh = findViewById(R.id.imvTinhThanh);
        imvQuanHuyen = findViewById(R.id.imvQuanHuyen);
        imvXaPhuong = findViewById(R.id.imvXaPhuong);
        imvMenu = findViewById(R.id.imvMenu);
    }
}