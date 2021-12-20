package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    CategoryAdapter categoryAdapter, districtAdapter, wardAdapter;
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
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_chuatungkham.this, screen_hoso_moi.class);
                startActivity(i);
            }
        });

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
        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, getListCategory2());
        spnNation.setAdapter(categoryAdapter);

        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, getListCategory3());
        spnCareer.setAdapter(categoryAdapter);

        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, getListCategory4());
        spnProvince.setAdapter(categoryAdapter);
        spnProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //nếu chọn tp hồ chí minh có index = 1
                if(i==1){
                    districtAdapter = new CategoryAdapter(screen_chuatungkham.this, R.layout.item_selected_quen_ma_hs, (List<Category>) getListCategory5());
                    spnDistrict.setAdapter(districtAdapter);
                    spnDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            //nếu chọn quận 1 có index = 1, thêm index thì thêm nữa dữ liệu ...
                            if(i==1){
                                wardAdapter = new CategoryAdapter(screen_chuatungkham.this, R.layout.item_selected_quen_ma_hs, getListCategory7());
                                spnWard.setAdapter(wardAdapter);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                //nếu chọn hà nội, có index = 2
                if(i==2){
                    districtAdapter = new CategoryAdapter(screen_chuatungkham.this, R.layout.item_selected_quen_ma_hs, (List<Category>) getListCategory6());
                    spnDistrict.setAdapter(districtAdapter);
                    spnDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            //nếu chọn huyện ba vì có index = 1;
                            if(i==1){
                                wardAdapter = new CategoryAdapter(screen_chuatungkham.this, R.layout.item_selected_quen_ma_hs, getListCategory8());
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private List<Category> getListCategory8() {
        List<Category> list8 = new ArrayList<>();
        list8.add(new Category("Chọn phường xã"));
        list8.add(new Category("Thị trấn Tây Đằng"));
        return list8;
    }

    private List<Category> getListCategory7() {
        List<Category> list7 = new ArrayList<>();
        list7.add(new Category("Chọn phường xã"));
        list7.add(new Category("Phường Bến Nghé"));
        return list7;
    }

    private Object getListCategory6() {
        List<Category> list6 = new ArrayList<>();
        list6.add(new Category("Chọn quận huyện"));
        list6.add(new Category("Huyện Ba Vì"));
        return list6;
    }

    private Object getListCategory5() {
        List<Category> list5 = new ArrayList<>();
        list5.add(new Category("Chọn quận huyện"));
        list5.add(new Category("Quận 1"));
        return list5;
    }

    private List<Category> getListCategory4() {
        List<Category> list4 = new ArrayList<>();
        list4.add(new Category("Chọn tỉnh thành"));
        list4.add(new Category("Thành phố Hồ Chí Minh"));
        list4.add(new Category("Thành phố Hà Nội"));
        return list4;
    }

    private List<Category> getListCategory3() {
        List<Category> list3 = new ArrayList<>();
        list3.add(new Category("Chọn nghề nghiệp"));
        list3.add(new Category("Bác sĩ"));
        list3.add(new Category("Dược sĩ"));
        list3.add(new Category("Nha sĩ"));
        list3.add(new Category("Hộ lý"));
        list3.add(new Category("Kỹ sư xây dựng"));
        return list3;
    }

    private List<Category> getListCategory2() {
        List<Category> list2 = new ArrayList<>();
        list2.add(new Category("Kinh"));
        list2.add(new Category("Hoa"));
        list2.add(new Category("Khơ-me"));
        list2.add(new Category("Thái"));
        return list2;
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