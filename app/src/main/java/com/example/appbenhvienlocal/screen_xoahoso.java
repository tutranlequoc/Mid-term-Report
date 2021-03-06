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
import android.widget.ImageButton;
import android.widget.TextView;

public class screen_xoahoso extends AppCompatActivity {

    Button  btnCancelDelete, btnAgreeDelete;
     ImageButton imgDeleteFile,imgBackXacNhanTT;
    View deleteFileLine, deleteFileDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_xoahoso);
        linkViews();
        addEvents();
    }

    private void addEvents() {
        imgDeleteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfirmDialog(Gravity.CENTER);
            }
        });
        imgBackXacNhanTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(screen_xoahoso.this, screen_hoso_moi.class);
                startActivity(i);
            }
        });

    }

    private void openConfirmDialog(int gravity) {
        Dialog confirmDialog = new Dialog(this);
        confirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        confirmDialog.setContentView(R.layout.confirm_delete_file);

        Window window = confirmDialog.getWindow();
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

        if(gravity == Gravity.CENTER)
        {
            confirmDialog.setCancelable(false);
        }
        //gán view
        TextView txtXacNhan = confirmDialog.findViewById(R.id.txtXacNhan);
        TextView txtYes = confirmDialog.findViewById(R.id.txtBanCoMuon);
        btnCancelDelete = confirmDialog.findViewById(R.id.btnCancelDelete);
        btnAgreeDelete = confirmDialog.findViewById(R.id.btnAgreeDelete);
        deleteFileLine = confirmDialog.findViewById(R.id.deleteFileLineTop);
        deleteFileDiv = confirmDialog.findViewById(R.id.deleteFileDivider);

        btnCancelDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog.dismiss();
            }
        });
        confirmDialog.show();
    }

    private void linkViews() {
        imgDeleteFile = findViewById(R.id.imgXoaHoSo);
        imgBackXacNhanTT = findViewById(R.id.imgBackXacNhanTT);
    }
}