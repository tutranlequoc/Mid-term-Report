package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
        //set cho dialog nằm giữa màn hình
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);
        //không cho ng dùng bấm ra ngoài để tắt dialog
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
        txtDongY.setTextColor(Color.parseColor("#5CC0AB"));
        txtDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogConfirm.dismiss();
//                dialogSuccess();
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