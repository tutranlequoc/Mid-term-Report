package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ultis.Constant;

public class NhapTheATM extends AppCompatActivity {

    TextView txtMaDonHang, txtGiaTien;
    EditText edtSoThe, edtTenThe, edtSodt, edtEmail;
    Button btnTiepTuc;
    ImageButton btnBackThanhToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_the_atm);
        linkViews();
        addEvents();
        loadData();
        checkFormat();
    }

    private void addEvents() {
        btnBackThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        txtMaDonHang.setText(Constant.code_medical_test);
        txtGiaTien.setText(Constant.bookingInfor.getTienKham());
        edtEmail.setText(Constant.document.getEmail());
        edtSodt.setText(Constant.document.getPhoneNumber_booking());
        edtTenThe.setText(Constant.document.getFullName());
    }

    private void checkFormat() {
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soThe = edtSoThe.getText().toString();
                String tenThe = edtTenThe.getText().toString();
                String soDT = edtSodt.getText().toString();
                String email = edtEmail.getText().toString();
                if(soThe.equals("")&&tenThe.equals("")&&soDT.equals("")){
                    Toast.makeText(NhapTheATM.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    if(!email.equals("")&& !checkFormatEmail(email)){
                        Toast.makeText(NhapTheATM.this, "Vui lòng kiểm tra lại định dạng email",Toast.LENGTH_SHORT).show();
                    }else {
                        if(checkFormatPhone(soDT)){
                            Constant.database.insertDataForMedicalTest(Constant.code_medical_test, Constant.doc.getMaSo(),
                                    Constant.bookingInfor.getNgayKham(), "Khám BHYT", Constant.bookingInfor.getTienKham(),
                                    Constant.bookingInfor.getGioKham());
//                          Constant.danhsachphieukham = Constant.database.getInForFromMedicalTest(Constant.code_medical_test, Constant.document.getFullName());
                            Dialog dialogSuccess = new Dialog(NhapTheATM.this);
                            dialogSuccess.setContentView(R.layout.dialog_payment_success);
                            dialogSuccess.setCanceledOnTouchOutside(false);

                            Window window = dialogSuccess.getWindow();
                            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                            TextView txtClose = dialogSuccess.findViewById(R.id.txtClose);
                            txtClose.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialogSuccess.dismiss();
                                    Intent intent = new Intent(NhapTheATM.this, PhieuKhamBenhDaThanhToan.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            dialogSuccess.show();
                        }else {
                            Toast.makeText(NhapTheATM.this, "Vui lòng nhập đúng số điện thoại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    public Boolean checkFormatPhone(String phoneNumber){
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean flag = phoneNumber.matches(reg);
        return flag;
    }

    public Boolean checkFormatEmail(String email){
        String reg = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(?:\\.[a-z0-9]{2,4}){1,2}$";
        boolean flag = email.matches(reg);
        return flag;
    }

    private void linkViews() {
        txtMaDonHang = findViewById(R.id.txtMaDonHang);
        txtGiaTien = findViewById(R.id.txtGiaTien);
        edtSoThe = findViewById(R.id.edtSoThe);
        edtTenThe = findViewById(R.id.edtTenThe);
        edtSodt = findViewById(R.id.edtSodt);
        edtEmail =findViewById(R.id.edtEmail);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnBackThanhToan = findViewById(R.id.btnBackThanhToan);
    }
}