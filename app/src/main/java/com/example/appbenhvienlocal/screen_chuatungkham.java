package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.adapter.CategoryAdapter;
import com.example.category.Category;

import java.util.ArrayList;
import java.util.List;

public class screen_chuatungkham extends AppCompatActivity {

    CategoryAdapter categoryAdapter;
    TextView txtThongBao;
    EditText edtFullName, edtPatientName, edtDateofBirth, edtIDNumberPassport, edtPhoneNumber, edtAddress;
    Spinner spnGender, spnNation, spnCareer, spnProvince, spnDistrict, spnWard;
    Button btnGoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_chuatungkham);
        
        linkViews();
        initData();
        addEvents();
    }

    private void addEvents() {
        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs,getListCategory1());
        spnGender.setAdapter(categoryAdapter);
        spnGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private List<Category> getListCategory1(){
        List<Category> list1  = new ArrayList<>();
        list1.add(new Category("Nam"));
        list1.add(new Category("Nữ"));
        return list1;
    }

    private void linkViews() {
       txtThongBao = findViewById(R.id.txtThongBao);
       edtFullName =findViewById(R.id.edtFullName);
       edtDateofBirth = findViewById(R.id.edtDateBirth);
       edtIDNumberPassport = findViewById(R.id.edtIDNumber_Passport);
       edtPatientName = findViewById(R.id.edtPatientName);
       edtPhoneNumber =findViewById(R.id.edtPhoneNumber);
       edtAddress = findViewById(R.id.edtAddress);
       spnGender = findViewById(R.id.spinnerGender);
       spnNation = findViewById(R.id.spinnerDanToc);
       spnCareer = findViewById(R.id.spinnerNgheNghiep);
       spnProvince = findViewById(R.id.spinnerTinh);
       spnDistrict = findViewById(R.id.spinnerQuan);
       spnWard = findViewById(R.id.spinnerPhuong);
       btnGoBack = findViewById(R.id.btnBackDTK);
    }
    private void initData() {
        String text = "<font color=#FFFFFF>Vui lòng cung cấp thông tin chính xác để được phục vụ tốt nhất. Trong trường hợp cung cấp sai thông tin bệnh nhân &amp; điện thoại, việc xác nhận cuộc hẹn sẽ không có hiệu lực trước khi đặt khám</font> \n <font color=#00E60F0F>(*) Yêu cầu vui lòng nhập đầy đủ thông tin bên dưới</font>";
        txtThongBao.setText(Html.fromHtml(text));
    }
}