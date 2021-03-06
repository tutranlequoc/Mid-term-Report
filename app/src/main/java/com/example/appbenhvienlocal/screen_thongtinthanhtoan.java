package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.models.CodePatient;
import com.example.ultis.Constant;

public class screen_thongtinthanhtoan extends AppCompatActivity {
    Button btnThanhToan,btnPhuongThuc,btnCancel,btnAgreePay;
    View lineTop, divider;
    ImageButton btnBack;
    TextView txtTenBN, txtNgaySinhBN, txtSDTBN, txtDichVu, txtLichKham, txtTienKham, txtTongTien;
    Bundle v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_thongtinthanhtoan);

        linkViews();
        addEvents();
        loadData();
    }

    private void loadData() {
        if(Constant.document!=null && Constant.bookingInfor !=null){
            txtTenBN.setText(Constant.document.getFullName());
            txtNgaySinhBN.setText(Constant.document.getDateOfBirth());
            txtSDTBN.setText(Constant.document.getPhoneNumber_booking());
            txtDichVu.setText(Constant.bookingInfor.getDichVu());
            txtLichKham.setText(Constant.bookingInfor.getNgayKham() + " " + Constant.bookingInfor.getGioKham());
            txtTienKham.setText(Constant.bookingInfor.getTienKham());
            txtTongTien.setText(Constant.bookingInfor.getTienKham());
        }
    }

    private void addEvents() {
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPaymentDialog(Gravity.CENTER);
            }
        });
        btnPhuongThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen_thongtinthanhtoan.this, screen_phuongthucthanhtoan.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
    private void openPaymentDialog(int gravity) {
        Dialog dialogConfirm = new Dialog(this);
        dialogConfirm.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogConfirm.setContentView(R.layout.confirm_payment_dialog);

        Window window = dialogConfirm.getWindow();
        if(window == null)
        {
            return;
        }
        //set cho dialog n???m gi???a m??n h??nh
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);
        //kh??ng cho ng d??ng b???m ra ngo??i ????? t???t dialog
        if(gravity == Gravity.CENTER)
        {
            dialogConfirm.setCancelable(false);
        }
        //gan data cho cac view trong dialog
//        TextView txtThongBao = dialogConfirm.findViewById(R.id.txtThongBao);
//        TextView txtThongBaoTToan = dialogConfirm.findViewById(R.id.txtThongBaoThanhToan);
//        btnCancel = dialogConfirm.findViewById(R.id.btnCancelPayment);
//        btnAgreePay=dialogConfirm.findViewById(R.id.btnAgreePayment);
//        lineTop = dialogConfirm.findViewById(R.id.lineTop);
//        divider=dialogConfirm.findViewById(R.id.divider);
        TextView txtDongY = dialogConfirm.findViewById(R.id.txtDongY);
        TextView txtHuy = dialogConfirm.findViewById(R.id.txtHuy);
        TextView txtNoiDung = dialogConfirm.findViewById(R.id.txtContentPayment);
        String noiDung = "B???n ??ang th???c hi???n thanh to??n b???ng " + "<font color=#5CC0AB>Thanh to??n b???ng Th??? ATM n???i ?????a/Internet Banking c???a "+
                Constant.bank.getBankName() + "</font>" + ". V???i s??? ti???n " + "<font color=#5CC0AB>" + Constant.bookingInfor.getTienKham() + "</font>";

        txtNoiDung.setText(Html.fromHtml(noiDung));
        txtNoiDung.setTypeface(txtNoiDung.getTypeface(), Typeface.BOLD);
        txtDongY.setTextColor(Color.parseColor("#5CC0AB"));

        txtDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogConfirm.dismiss();
//                dialogSuccess();
                String code_test = CodePatient.createCodeTest(Constant.doc.getMaSo());
//                Constant.database.insertDataForMedicalTest(code_test, Constant.doc.getMaSo(),
//                        Constant.bookingInfor.getNgayKham(), "Kh??m BHYT", Constant.bookingInfor.getTienKham(),
//                        Constant.bookingInfor.getGioKham());
                Constant.code_medical_test = code_test;
                Intent intent = new Intent(screen_thongtinthanhtoan.this, NhapTheATM.class);
                startActivity(intent);

            }
        });

        txtHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogConfirm.dismiss();
            }
        });
        dialogConfirm.show();
    }

//    private void dialogSuccess() {
//        Dialog dialogSuccess = new Dialog(screen_thongtinthanhtoan.this);
//        dialogSuccess.setContentView(R.layout.dialog_payment_success);
//        dialogSuccess.setCanceledOnTouchOutside(false);
//
//        TextView txtClose = dialogSuccess.findViewById(R.id.txtClose);
//        txtClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogSuccess.dismiss();
//            }
//        });
//        dialogSuccess.show();
//    }

    private void linkViews() {
        btnThanhToan = findViewById(R.id.btnMakePayment);
        btnPhuongThuc=findViewById(R.id.btnChooseMethod);
        btnBack = findViewById(R.id.btnBack);
        txtTenBN = findViewById(R.id.txtTenBN);
        txtNgaySinhBN = findViewById(R.id.txtNgaySinhBN);
        txtSDTBN = findViewById(R.id.txtSDTBN);
        txtDichVu  = findViewById(R.id.txtDichVu);
        txtLichKham = findViewById(R.id.txtLichKham);
        txtTienKham = findViewById(R.id.txtTienKham);
        txtTongTien = findViewById(R.id.txtTongTien);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}