package com.example.appbenhvienlocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ultis.Constant;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class QuenMatKhau extends AppCompatActivity {
    private static final String TAG = QuenMatKhau.class.getName();
    EditText edtQuenMk;
    TextView txtDangKiQuenMk;
    Button btnQuenMk;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);
        mAuth = FirebaseAuth.getInstance();
        linkView();
        addEvents();
    }

    private void linkView() {
        edtQuenMk = findViewById(R.id.edtSdtQuenMk);
        txtDangKiQuenMk = findViewById(R.id.txtDangKiQuenMk);
        btnQuenMk = findViewById(R.id.btnContinueQuenMk);
    }

    private void addEvents() {
        btnQuenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(QuenMatKhau.this,OTPScreen.class);
//                String phoneNum = edtQuenMk.getText().toString();
//                intent.putExtra(Constant.PHONE_NUMBER,phoneNum);
//                intent.putExtra(Constant.REQUEST_TAG,Constant.REQUEST_CODE);
//                startActivity(intent);
                String sdt = edtQuenMk.getText().toString();
                sendVerifyToUser(sdt);
            }
        });
        txtDangKiQuenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuenMatKhau.this,ManHinhDangKy.class);
                startActivity(intent);
            }
        });
    }
    public void sendVerifyToUser(String sdt) {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+84"+sdt)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(QuenMatKhau.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                            public void onCodeSent(String verifycationID, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(verifycationID, forceResendingToken);
                                goToOTPScreen(sdt,verifycationID);
                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
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
                            goToNhapMKMoi(user.getPhoneNumber());
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(QuenMatKhau.this, "Code was invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void goToNhapMKMoi(String phoneNumber) {
        Intent intent = new Intent(QuenMatKhau.this,NhapMkMoi.class);
        intent.putExtra(Constant.PHONE_NUMBER,phoneNumber);
        startActivity(intent);
    }

    private void goToOTPScreen(String sdt, String verifycationID) {
        Intent intent = new Intent(QuenMatKhau.this,OTPScreen.class);
        intent.putExtra(Constant.PHONE_NUMBER,sdt);
        intent.putExtra(Constant.VERIFYID,verifycationID);
        intent.putExtra(Constant.REQUEST_TAG,Constant.REQUEST_CODE);
        startActivity(intent);
    }
}