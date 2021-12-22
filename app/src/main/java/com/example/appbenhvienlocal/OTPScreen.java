package com.example.appbenhvienlocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OTPScreen extends AppCompatActivity {
    public static final String TAG = OTPScreen.class.getName();

    TextView txtSdtOtp,txtSdtNumber,txtMoSMS,txtGuiLaiMa,txtNotMyPhone;
    EditText edtOtp1,edtOtp2,edtOtp3,edtOtp4,edtOtp5,edtOtp6,edtCode;
    String sdt,mVerificationId;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpscreen);

        linkView();
        getData();
        mAuth = FirebaseAuth.getInstance();

        addEvents();

    }

    private void linkView() {
        txtSdtOtp = findViewById(R.id.txtSdtOtp);
        txtSdtNumber = findViewById(R.id.txtSdtNumber);
        txtMoSMS = findViewById(R.id.txtMoSMS);
        txtGuiLaiMa = findViewById(R.id.txtGuilaiMa);
        txtNotMyPhone = findViewById(R.id.txtNotMyPhone);
//        edtOtp1 = findViewById(R.id.ed);
//        edtOtp2 = findViewById(R.id.edtOtp2);
//        edtOtp3 = findViewById(R.id.edtOtp3);
//        edtOtp4 = findViewById(R.id.edtOtp4);
//        edtOtp5 = findViewById(R.id.edtOtp5);
//        edtOtp6 = findViewById(R.id.edtOtp6);
        edtCode = findViewById(R.id.edtCode);
    }

    private void getData() {

        sdt = getIntent().getStringExtra("SdtDKi");
        mVerificationId = getIntent().getStringExtra("verifyID");
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
//                Intent intent = new Intent(OTPScreen.this,LoginScreen.class);
//                startActivity(intent);
                String otpCode = edtCode.getText().toString();
                sendOTPCode(otpCode);
            }
        });
    }

//    private void verifyCode() {
//        if (    edtOtp1.getText().toString()!=null
//                &&edtOtp2.getText().toString()!=null
//                &&edtOtp3.getText().toString()!= null
//                &&edtOtp4.getText().toString()!= null
//                &&edtOtp5.getText().toString()!=null
//                &&edtOtp6.getText().toString()!=null
//
//        )
//        {
//            String otpCode = edtOtp1.getText().toString() + edtOtp2.getText().toString()
//                    + edtOtp3.getText().toString() + edtOtp4.getText().toString() + edtOtp5.getText().toString() + edtOtp6.getText().toString()  ;
//            sendOTPCode(otpCode);
//        }
//    }

    private void sendOTPCode(String otpCode) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId,otpCode);
        signInWithPhoneAuthCredential(credential);

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            // Update UI
                            goToMainActivity(user.getPhoneNumber());
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(OTPScreen.this, "Code was invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void goToMainActivity(String phoneNumber) {
        Intent intent = new Intent(OTPScreen.this,MainActivity.class);
        intent.putExtra("SdtDKi",phoneNumber);

        startActivity(intent);
    }


}