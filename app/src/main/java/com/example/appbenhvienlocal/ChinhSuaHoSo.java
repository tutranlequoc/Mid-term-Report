package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.adapter.DistrictAdapter;
import com.example.adapter.ProvinceAdapter;
import com.example.adapter.WardAdapter;
import com.example.category.Category;
import com.example.database.BenhVienSQLiteHelper;
import com.example.models.CodePatient;
import com.example.models.District;
import com.example.models.Province;
import com.example.models.Ward;
import com.example.ultis.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ChinhSuaHoSo extends AppCompatActivity {

    CategoryAdapter categoryAdapter;
    ProvinceAdapter provinceAdapter;
    DistrictAdapter districtAdapter;
    TextView txtThongBao;
    WardAdapter wardAdapter;
    EditText edtFullName, edtDateofBirth, edtIDNumberPassport, edtPhoneNumber, edtAddress, edtEmail, edtCountry,
            edtBHYT;
    Spinner spnGender, spnNation, spnCareer, spnProvince, spnDistrict, spnWard;
    ImageButton imgBack;
    Button btnCreateDoc;
    String gender, province, district, ward, nation, job;
    int count;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh_sua_ho_so);
        copyData();
        linkViews();
        loadData();
        initData();
        addEvents();
        createDocument();
    }



    private void copyData() {
        try{
            File dbfile = getDatabasePath(Constant.DATABASE_NAME_ADMINISTRATIVE_UNITS);
            if(!dbfile.exists()){
                if(copyFromAssets()){
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Already exists", Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e){
            Log.e("Error", e.toString());
        }
    }

    private boolean copyFromAssets() {
        String savePath = getApplicationInfo().dataDir + Constant.DB_PATH_SUFFIX + Constant.DATABASE_NAME_ADMINISTRATIVE_UNITS;
        try{
            File dataPath = new File(getApplicationInfo().dataDir + Constant.DB_PATH_SUFFIX);
            if(!dataPath.exists()){
                dataPath.mkdir();
            }
            InputStream inputStream = getAssets().open(Constant.DATABASE_NAME_ADMINISTRATIVE_UNITS);
            OutputStream outputStream = new FileOutputStream(savePath);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer))> 0){
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        }catch (Exception e){
            Log.e("Error: ", e.toString());
            return false;
        }
    }

    private void createDocument() {
        btnCreateDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = edtFullName.getText().toString();
                String dateOfBirth = edtDateofBirth.getText().toString();
                String phone_booking = edtPhoneNumber.getText().toString();
                ArrayList<String> blankField = new ArrayList<>();
                String email = edtEmail.getText().toString();
                String address = edtAddress.getText().toString();
                if(gender.equals("")||province.equals("")||district == null||ward == null||
                        fullName.equals("")||dateOfBirth.equals("")||phone_booking.equals("")||nation.equals("")||address.equals("")){
                    Toast.makeText(ChinhSuaHoSo.this,"Vui lòng nhập đủ các ô bắt buộc", Toast.LENGTH_SHORT).show();
                }else {
                    if(!email.equals("") && !checkFormatEmail(email)){
                        Toast.makeText(ChinhSuaHoSo.this, "Vui lòng kiểm tra lại định dạng email",Toast.LENGTH_SHORT).show();
                    }else{
                        if(checkFormatPhone(phone_booking)&&checkFormatDate(dateOfBirth)){
//                            Constant.database.insertDataForDocuments(CodePatient.createCode(phone_booking), fullName, dateOfBirth, gender,
//                                    edtIDNumberPassport.getText().toString(),edtBHYT.getText().toString(), nation, job, phone_booking,
//                                    edtEmail.getText().toString(), edtCountry.getText().toString(),
//                                    province, district, ward, edtAddress.getText().toString(), Constant.user.getPhone());

                            ContentValues values = new ContentValues();
                            values.put(BenhVienSQLiteHelper.COL_FULLNAME, fullName);
                            values.put(BenhVienSQLiteHelper.COL_DATEOFBIRTH, dateOfBirth);
                            values.put(BenhVienSQLiteHelper.COL_GENDER, gender);
                            values.put(BenhVienSQLiteHelper.COL_IDENTITY, edtIDNumberPassport.getText().toString());
                            values.put(BenhVienSQLiteHelper.COL_INSURRANCE, edtBHYT.getText().toString());
                            values.put(BenhVienSQLiteHelper.COL_ETHNIC, nation);
                            values.put(BenhVienSQLiteHelper.COL_JOB, job);
                            values.put(BenhVienSQLiteHelper.COL_PHONE, phone_booking);
                            values.put(BenhVienSQLiteHelper.COL_EMAIL, email);
                            values.put(BenhVienSQLiteHelper.COL_COUNTRY, edtCountry.getText().toString());
                            values.put(BenhVienSQLiteHelper.COL_CITY, province);
                            values.put(BenhVienSQLiteHelper.COL_DISTRICT, district);
                            values.put(BenhVienSQLiteHelper.COL_WARD, ward);
                            values.put(BenhVienSQLiteHelper.COL_ADDRESS, address);
                            int flag = Constant.database.updateDocument(values, Constant.document.getCode());
                            if(flag > 0){
                                Dialog dialog = new Dialog(ChinhSuaHoSo.this);
                                dialog.setContentView(R.layout.custom_dialog_tao_ho_so_thanh_cong);
                                TextView txtNoiDung = dialog.findViewById(R.id.txtNoiDung);
                                txtNoiDung.setText("Chỉnh sửa thành công");
                                Window window = dialog.getWindow();
                                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                                dialog.findViewById(R.id.txtAgree).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialog.dismiss();
                                        Intent intent = new Intent(ChinhSuaHoSo.this, HoSoDatKham.class);
                                        intent.putExtra(Constant.REQUEST_TAG, Constant.REQUEST_CODE_FOR_DOCUMENT_FROM_MAIN);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                dialog.show();
                            }else {
                                Toast.makeText(ChinhSuaHoSo.this, "Có lỗi xảy ra trong quá trình chỉnh sửa. Vui lòng thử lại", Toast.LENGTH_SHORT).show();
                                Log.e("Error:", "Lỗi xảy ra");
                            }


                        }else {
                            Toast.makeText(ChinhSuaHoSo.this, "Vui lòng kiểm tra lại định dạng ngày sinh hoặc số điện thoại",Toast.LENGTH_SHORT).show();
                        }
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

        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, createListGender());
        spnGender.setAdapter(categoryAdapter);
        int position_gender = 0;
        Category c1;
        for(int m = 0; m < createListGender().size(); m++){
            c1 =  createListGender().get(m);
            if(c1.getName().toLowerCase().equals(Constant.document.getGender().toLowerCase())){
                position_gender = m;
                break;
            }
        }
        spnGender.setSelection(position_gender);
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

        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, createListNations());
        spnNation.setAdapter(categoryAdapter);
        int position_nation = 0;
        Category c2;
        for(int n = 0; n < createListNations().size(); n++){
            c2 =  createListNations().get(n);
            if(c2.getName().toLowerCase().equals(Constant.document.getEthnic().toLowerCase())){
                position_nation = n;
                break;
            }
        }
        spnNation.setSelection(position_nation);
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


        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, createListJobs());
        spnCareer.setAdapter(categoryAdapter);
        int position_career = 0;
        Category c3;
        for(int o = 0; o < createListJobs().size(); o++){
            c3 =  createListJobs().get(o);
            if(c3.getName().toLowerCase().equals(Constant.document.getJob().toLowerCase())){
                position_career = o;
                break;
            }
        }
        spnCareer.setSelection(position_career);
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

        provinceAdapter = new ProvinceAdapter(ChinhSuaHoSo.this, R.layout.item_selected_quen_ma_hs, createListProvinces());
        spnProvince.setAdapter(provinceAdapter);
        int position_province = 0;
        Province p;
        for(int i = 0; i < createListProvinces().size(); i++){
            p =  createListProvinces().get(i);
            if(p.getName().toLowerCase().equals(Constant.document.getCity().toLowerCase())){
                position_province = i;
                break;
            }
        }
        spnProvince.setSelection(position_province);
        spnProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Province p = (Province) adapterView.getItemAtPosition(i);
                province = p.getName();
                String province_id = p.getId();
                if(createListDistricts(province_id)!=null){
                    districtAdapter = new DistrictAdapter(ChinhSuaHoSo.this, R.layout.item_selected_quen_ma_hs, createListDistricts(province_id));
                    spnDistrict.setAdapter(districtAdapter);
                    int position_district = 0;
                    District d;
                    for(int j = 0; j < createListDistricts(province_id).size(); j++){
                        d =  createListDistricts(province_id).get(j);
                        if(d.getName().toLowerCase().equals(Constant.document.getDistrict().toLowerCase())){
                            position_district = j;
                            break;
                        }
                    }
                    spnProvince.setSelection(position_district);
                    spnDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            District d = (District) adapterView.getItemAtPosition(i);
                            district = d.getName();
                            String district_id = d.getId();
                            if(createListWards(district_id)!=null){
                                wardAdapter = new WardAdapter(ChinhSuaHoSo.this, R.layout.item_selected_quen_ma_hs, createListWards(district_id));
                                spnWard.setAdapter(wardAdapter);
                                int position_ward = 0;
                                Ward w;
                                for(int k = 0; k < createListWards(district_id).size(); k++){
                                    w =  createListWards(district_id).get(k);
                                    if(w.getName().toLowerCase().equals(Constant.document.getWard().toLowerCase())){
                                        position_ward = k;
                                        break;
                                    }
                                }
                                spnProvince.setSelection(position_ward);
                                spnWard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        Ward w = (Ward) adapterView.getItemAtPosition(i);
                                        ward = w.getName();
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

    public Boolean checkFormatEmail(String email){
        String reg = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(?:\\.[a-z0-9]{2,4}){1,2}$";
        boolean flag = email.matches(reg);
        return flag;
    }

    private List<Ward> createListWards(String district_id){
        List<Ward> wards = new ArrayList<>();
        try{
            db = openOrCreateDatabase(Constant.DATABASE_NAME_ADMINISTRATIVE_UNITS, MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM " + Constant.TBL_NAME_WARD + " WHERE " + Constant.WARE_DISTRICT_ID +"=?", new String[]{district_id});
            Ward ward;
            while (cursor.moveToNext()){
                ward = new Ward(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                wards.add(ward);
            }
            cursor.close();
            return wards;
        }catch (Exception e){
            Log.e("Error:", e.toString());
            return null;
        }
    }

    private List<District> createListDistricts(String province_id){
        List<District> districts = new ArrayList<>();
        try{
            db = openOrCreateDatabase(Constant.DATABASE_NAME_ADMINISTRATIVE_UNITS, MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM " + Constant.TBL_NAME_DISTRICT + " WHERE " + Constant.DISTRICT_PROVINCE_ID +"=?", new String[]{province_id});
            District district;
            while (cursor.moveToNext()){
                district = new District(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                districts.add(district);
            }
            cursor.close();
            return districts;
        }catch (Exception e){
            Log.e("Error:", e.toString());
            return null;
        }
    }

    private List<Province> createListProvinces(){
        List<Province> provinces = new ArrayList<>();
        try{
            db = openOrCreateDatabase(Constant.DATABASE_NAME_ADMINISTRATIVE_UNITS, MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM " + Constant.TBL_NAME_PROVINCE, null);
            Province province;
            while (cursor.moveToNext()){
                province = new Province(cursor.getString(0), cursor.getString(1), cursor.getString(2));
                provinces.add(province);
            }
            cursor.close();
            return provinces;
        }catch (Exception e){
            Log.e("Error:", e.toString());
            return null;
        }
    }

    private List<Category> createListJobs() {
        List<Category> jobs = new ArrayList<>();
        jobs.add(new Category("Học sinh/Sinh viên"));
        jobs.add(new Category("Văn phòng"));
        jobs.add(new Category("Thợ sửa xe"));
        jobs.add(new Category("Kỹ sư"));
        jobs.add(new Category("Kinh doanh"));
        jobs.add(new Category("Khác"));
        return jobs;
    }

    private List<Category> createListNations() {
        List<Category> nations = new ArrayList<>();
        nations.add(new Category("Kinh"));
        nations.add(new Category("Tày"));
        nations.add(new Category("Thái"));
        nations.add(new Category("Mường"));
        nations.add(new Category("Hmong"));
        nations.add(new Category("Khmer"));
        nations.add(new Category("Hoa"));
        nations.add(new Category("Khác"));
        return nations;
    }

    private List<Category> createListGender(){
        List<Category> genders = new ArrayList<>();
        genders.add(new Category("Nam"));
        genders.add(new Category("Nữ"));
        genders.add(new Category("Khác"));
        return genders;
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

    private void setTextFromData(EditText edtText, String text){
        if(!text.equals("")){
            edtText.setText(text);
        }
    }

    private void loadData() {
        setTextFromData(edtFullName, Constant.document.getFullName());
        setTextFromData(edtDateofBirth, Constant.document.getDateOfBirth());
        setTextFromData(edtIDNumberPassport, Constant.document.getIdentity());
        setTextFromData(edtPhoneNumber, Constant.document.getPhoneNumber_booking());
        setTextFromData(edtAddress, Constant.document.getAddress());
        setTextFromData(edtBHYT, Constant.document.getInsurance());
        setTextFromData(edtEmail, Constant.document.getEmail());
        setTextFromData(edtCountry, Constant.document.getCountry());

    }
    private void initData() {
        String text = "<font color=#FFFFFF>Vui lòng cung cấp thông tin chính xác để được phục vụ tốt nhất. Trong trường hợp cung cấp sai thông tin bệnh nhân &amp; điện thoại, việc xác nhận cuộc hẹn sẽ không có hiệu lực trước khi đặt khám</font> \n <font color=#00E60F0F>(*) Yêu cầu vui lòng nhập đầy đủ thông tin bên dưới</font>";
        txtThongBao.setText(Html.fromHtml(text));
    }
}