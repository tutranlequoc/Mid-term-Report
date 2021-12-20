package com.example.appbenhvienlocal;

import  androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
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
import com.example.database.BenhVienSQLiteHelper;
import com.example.models.Region;
import com.example.ultis.Constant;

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
        Constant.database = new BenhVienSQLiteHelper(this);
        Constant.database.createDefaultUser();
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

    public Boolean checkFormatPhone(String phoneNumber){
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean flag = phoneNumber.matches(reg);
        return flag;
    }

    private void addEvents() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edtSdt.getText().toString();
                if (phone.equals("") || checkFormatPhone(phone) == false) {
                    txtLoi.setVisibility(View.VISIBLE);
                }else {
                    if(Constant.database.checkUserPhone(phone) == 1){
                        intent = new Intent(LoginScreen.this, ManHinhNhapPassWord.class);
                        Cursor cursor =  Constant.database.getReadableDatabase().rawQuery("SELECT * FROM " + BenhVienSQLiteHelper.TBL_NAME_USER + " WHERE " + BenhVienSQLiteHelper.COL_USER_PHONE + " =?", new String[]{phone});
                        cursor.moveToFirst();
                        cursor.getString(1);
                    }else {
                        intent = new Intent(LoginScreen.this, Fill_Infor_Screen.class);
                    }
                    intent.putExtra(Constant.PHONE_NUMBER, phone);
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