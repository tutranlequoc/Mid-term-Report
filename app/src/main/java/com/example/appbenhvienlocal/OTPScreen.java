package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OTPScreen extends AppCompatActivity {
    TextView txtSdtOtp,txtSdtNumber,txtMoSMS,txtGuiLaiMa,txtNotMyPhone;
    EditText edtOtp1,edtOtp2,edtOtp3,edtOtp4,edtOtp5,edtOtp6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpscreen);
        linkView();
        getData();
        addEvents();
    }

    private void linkView() {
        txtSdtOtp = findViewById(R.id.txtSdtOtp);
        txtSdtNumber = findViewById(R.id.txtSdtNumber);
        txtMoSMS = findViewById(R.id.txtMoSMS);
        txtGuiLaiMa = findViewById(R.id.txtGuilaiMa);
        txtNotMyPhone = findViewById(R.id.txtNotMyPhone);
    }

    private void getData() {
        Intent intent = getIntent();
        String sdt = intent.getStringExtra("Sdt1");
        txtSdtOtp.setText(sdt);
        txtSdtNumber.setText(sdt);
    }

    private void addEvents() {
        txtMoSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        txtGuiLaiMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGuiLaiMa.setBackgroundResource(R.drawable.rounded_textview1);

                //Tạo countdown timer
                long timer = TimeUnit.MINUTES.toMillis(1);

                new CountDownTimer(timer, 1000) {
                    @Override
                    public void onTick(long l) {
                        String timeConvert = String.format(Locale.ENGLISH,"%02d : %02d", TimeUnit.MILLISECONDS.toMinutes(l),
                                TimeUnit.MILLISECONDS.toSeconds(l), - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));

                        txtGuiLaiMa.setText("Vui lòng thử lại sau " + timeConvert);
                        txtGuiLaiMa.setClickable(false);
                    }

                    @Override
                    public void onFinish() {
                        txtGuiLaiMa.setBackgroundResource(R.drawable.rounded_textview2);
                        txtGuiLaiMa.setText("Gửi lại mã");
                    }
                }.start();
            }
        });
        txtNotMyPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OTPScreen.this,LoginScreen.class);
                startActivity(intent);
            }
        });
    }
}