package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class screen_thongtinthanhtoan extends AppCompatActivity {
    Button btnThanhToan,btnPhuongThuc,btnCancel,btnAgreePay;
    View lineTop, divider;
    Bundle v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_thongtinthanhtoan);

        linkViews();
        addEvents();
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
//        Intent i = getIntent();
//        v= i.getBundleExtra("method1");
//        btnPhuongThuc.setText("Thanh toán bằng thẻ ATM nội địa");
//        btnPhuongThuc.setText("Thanh toán bằng momo");



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
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);
        //không cho ng dùng bấm ra ngoài để tắt dialog
        if(gravity == Gravity.CENTER)
        {
            dialogConfirm.setCancelable(false);
        }
        //gan data cho cac view trong dialog
        TextView txtThongBao = dialogConfirm.findViewById(R.id.txtThongBao);
        TextView txtThongBaoTToan = dialogConfirm.findViewById(R.id.txtThongBaoThanhToan);
        btnCancel = dialogConfirm.findViewById(R.id.btnCancelPayment);
        btnAgreePay=dialogConfirm.findViewById(R.id.btnAgreePayment);
        lineTop = dialogConfirm.findViewById(R.id.lineTop);
        divider=dialogConfirm.findViewById(R.id.divider);

//        Intent i = getIntent();
//        Bundle bundle = new Bundle();
//        bundle = i.getBundleExtra("method1");
//        txtThongBaoTToan.setText(bundle.getString("momo"));
//        if(bundle == i.getBundleExtra("method1")){
//            txtThongBaoTToan.setText(bundle.getString("atm"));
//        }
//        else {
//            txtThongBaoTToan.setText(bundle.getString("momo"));
//        }


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogConfirm.dismiss();
            }
        });
        btnAgreePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSuccess();
            }
        });
        dialogConfirm.show();
    }

    private void dialogSuccess() {
        Dialog dialogSuccess = new Dialog(screen_thongtinthanhtoan.this);
        dialogSuccess.setContentView(R.layout.dialog_payment_success);
        dialogSuccess.setCanceledOnTouchOutside(false);

        Button btnCloseDialog = dialogSuccess.findViewById(R.id.btnClosePayment);
        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSuccess.dismiss();
            }
        });
    }

    private void linkViews() {
        btnThanhToan = findViewById(R.id.btnMakePayment);
        btnPhuongThuc=findViewById(R.id.btnChooseMethod);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}