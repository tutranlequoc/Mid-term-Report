package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class GoiYTimMaBHYT extends AppCompatActivity {

    Button btnTimMaBHYT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_bhyt_screen);
        linkView();
    }

    private void linkView() {
        btnTimMaBHYT = findViewById(R.id.btnTimMaBHYT);
        btnTimMaBHYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        GoiYTimMaBHYT.this,R.style.BottomSheetDialogTheme

                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_goi_ytim_ma_bhyt,
                        findViewById(R.id.goi_y_tim_maBHYT));
                //Đóng dialog
                bottomSheetView.findViewById(R.id.txtClose).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
    }
}