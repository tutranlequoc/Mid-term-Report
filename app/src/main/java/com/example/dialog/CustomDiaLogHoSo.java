package com.example.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.appbenhvienlocal.R;

public class CustomDiaLogHoSo extends Dialog {

    Activity context;
    TextView txtHuy, txtXoa;

    public CustomDiaLogHoSo(@NonNull Context context) {
        super(context);
        this.context = (Activity) context;
        setContentView(R.layout.custom_dialog_ho_so);
        linkViews();
        addEvents();
        setCanceledOnTouchOutside(false);
    }

    private void addEvents() {
        txtHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        txtXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void linkViews() {

       txtXoa = findViewById(R.id.txtXoa);
       txtHuy = findViewById(R.id.txtHuy);
    }
}

