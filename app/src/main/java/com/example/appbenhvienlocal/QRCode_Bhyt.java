package com.example.appbenhvienlocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class QRCode_Bhyt extends AppCompatActivity {

    public static final int CAMERA_REQUEST_CODE=101;
    CodeScanner codeScanner;
    CodeScannerView scannerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_bhyt);
        linkView();
        scanerCode();
    }

    private void linkView() {
        scannerView = findViewById(R.id.scaner_view);
    }

    private void scanerCode() {

        codeScanner = new CodeScanner(this,scannerView);
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        //Sau khi quét code xong
                        Intent intent = new Intent(QRCode_Bhyt.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        codeScanner.releaseResources();
        super.onPause();
    }
}