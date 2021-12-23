package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.CategoryAdapter;
import com.example.category.Category;
import com.example.models.CodePatient;
import com.example.ultis.Constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class screen_chuatungkham extends AppCompatActivity {

    CategoryAdapter categoryAdapter, districtAdapter, wardAdapter;
    TextView txtThongBao;
    EditText edtFullName, edtDateofBirth, edtIDNumberPassport, edtPhoneNumber, edtAddress, edtEmail, edtCountry,
    edtBHYT;
    Spinner spnGender, spnNation, spnCareer, spnProvince, spnDistrict, spnWard;
    ImageButton imgBack;
    Button btnCreateDoc;
    String gender, province, district, ward, nation, job;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_chuatungkham);
        linkViews();
        initData();
        addEvents();
        createDocument();
    }

    private void createDocument() {
        btnCreateDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = edtFullName.getText().toString();
                String dateOfBirth = edtDateofBirth.getText().toString();
                String phone_booking = edtPhoneNumber.getText().toString();
                ArrayList<String> blankField = new ArrayList<>();
                if(gender.equals("")||province.equals("")||district == null||ward == null||
                   fullName.equals("")||dateOfBirth.equals("")||phone_booking.equals("")||nation.equals("")){
                    Toast.makeText(screen_chuatungkham.this,"Vui lòng nhập đủ các ô bắt buộc", Toast.LENGTH_SHORT).show();
                }else {
                    if(checkFormatPhone(phone_booking)&&checkFormatDate(dateOfBirth)){
                        Constant.database.insertDataForDocuments(CodePatient.createCode(phone_booking), fullName, dateOfBirth, gender,
                                edtIDNumberPassport.getText().toString(),edtBHYT.getText().toString(), nation, job, phone_booking,
                                edtEmail.getText().toString(), edtCountry.getText().toString(),
                                province, district, ward, edtAddress.getText().toString(), Constant.user.getPhone());

                        Dialog dialog = new Dialog(screen_chuatungkham.this);
                        dialog.setContentView(R.layout.custom_dialog_tao_ho_so_thanh_cong);
                        Window window = dialog.getWindow();
                        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        dialog.findViewById(R.id.txtAgree).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });
                        dialog.show();
                    }else {
                        Toast.makeText(screen_chuatungkham.this, "Vui lòng kiểm tra lại định dạng ngày sinh hoặc số điện thoại",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void addEvents() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        edtDateofBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String dateOfBirth = edtDateofBirth.getText().toString();
                int len = dateOfBirth.length();
                if((len == 3 || len== 6)&& !dateOfBirth.substring(len - 1).equals("/")){
                    dateOfBirth = dateOfBirth.substring(0, len - 1) + "/" + dateOfBirth.substring(len - 1);
                    edtDateofBirth.setText(dateOfBirth);
                    edtDateofBirth.setSelection(dateOfBirth.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs,getListCategory1());
        spnGender.setAdapter(categoryAdapter);
        spnGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category category = (Category) spnGender.getItemAtPosition(i);
                gender = category.getName().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, getListCategory2());
        spnNation.setAdapter(categoryAdapter);
        spnNation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category category = (Category) adapterView.getItemAtPosition(i);
                nation = category.getName().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, getListCategory3());
        spnCareer.setAdapter(categoryAdapter);
        spnCareer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category category = (Category) adapterView.getItemAtPosition(i);
                job = category.getName().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, getListCategory4());
        spnProvince.setAdapter(categoryAdapter);
        spnProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category category = (Category) adapterView.getItemAtPosition(i);
                province = category.getName().toString();
                //nếu chọn tp hồ chí minh có index = 1
                if(i==0){
                    districtAdapter = new CategoryAdapter(screen_chuatungkham.this, R.layout.item_selected_quen_ma_hs, (List<Category>) getListCategory5());
                    spnDistrict.setAdapter(districtAdapter);

                    spnDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Category category = (Category) adapterView.getItemAtPosition(i);
                            district = category.getName().toString();
                            //nếu chọn quận 1 có index = 1, thêm index thì thêm nữa dữ liệu ...
                            if(i==1){
                                wardAdapter = new CategoryAdapter(screen_chuatungkham.this, R.layout.item_selected_quen_ma_hs, getListCategory7());
                                spnWard.setAdapter(wardAdapter);

                                spnWard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        Category category = (Category) adapterView.getItemAtPosition(i);
                                        ward = category.getName().toString();
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
                //nếu chọn hà nội, có index = 2
                if(i==1){
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

    public Boolean checkFormatPhone(String phoneNumber){
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean flag = phoneNumber.matches(reg);
        return flag;
    }

    public Boolean checkFormatDate(String date){
        String reg = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
        boolean flag = date.matches(reg);
        return flag;
    }

    private List<Category> getListCategory8() {
        List<Category> list8 = new ArrayList<>();
        list8.add(new Category("Thị trấn Tây Đằng"));
        return list8;
    }

    private List<Category> getListCategory7() {
        List<Category> list7 = new ArrayList<>();
        list7.add(new Category("Phường Tân Phú"));
        list7.add(new Category("Phường Linh Tây"));
        return list7;
    }

    private Object getListCategory6() {
        List<Category> list6 = new ArrayList<>();
        list6.add(new Category("Huyện Ba Vì"));
        return list6;
    }

    private Object getListCategory5() {
        List<Category> list5 = new ArrayList<>();
        list5.add(new Category("Quận 1"));
        list5.add(new Category("TP Thủ Đức"));
        return list5;
    }

    private List<Category> getListCategory4() {
        List<Category> list4 = new ArrayList<>();
        list4.add(new Category("Thành phố Hồ Chí Minh"));
        list4.add(new Category("Thành phố Hà Nội"));
        return list4;
    }

    private List<Category> getListCategory3() {
        List<Category> list3 = new ArrayList<>();
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
        edtPhoneNumber =findViewById(R.id.edtPhoneNumber);
        edtAddress = findViewById(R.id.edtAddress);
        spnGender = findViewById(R.id.spinnerGender);
        spnNation = findViewById(R.id.spinnerDanToc);
        spnCareer = findViewById(R.id.spinnerNgheNghiep);
        spnProvince = findViewById(R.id.spinnerTinh);
        spnDistrict = findViewById(R.id.spinnerQuan);
        spnWard = findViewById(R.id.spinnerPhuong);
        imgBack = findViewById(R.id.imgBack);
        btnCreateDoc = findViewById(R.id.btnCreateDoc);
        edtBHYT = findViewById(R.id.edtBHYT);
        edtEmail = findViewById(R.id.edtEmail);
        edtCountry = findViewById(R.id.edtCountry);
    }
    private void initData() {
        String text = "<font color=#FFFFFF>Vui lòng cung cấp thông tin chính xác để được phục vụ tốt nhất. Trong trường hợp cung cấp sai thông tin bệnh nhân &amp; điện thoại, việc xác nhận cuộc hẹn sẽ không có hiệu lực trước khi đặt khám</font> \n <font color=#00E60F0F>(*) Yêu cầu vui lòng nhập đầy đủ thông tin bên dưới</font>";
        txtThongBao.setText(Html.fromHtml(text));
    }
}