package com.example.appbenhvienlocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ultis.Constant;
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

import java.util.concurrent.TimeUnit;


public class ManHinhDangKy extends AppCompatActivity {
    Button btnDangKi;
    EditText edtSdtDKi;
    FirebaseAuth mAuth;
    ImageButton imvBackRegister;
    private static final String TAG = ManHinhDangKy.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ky);
        mAuth = FirebaseAuth.getInstance();
        linkView();
        addEvents();
    }

    private void linkView() {
        btnDangKi = findViewById(R.id.btnDangKi);
        edtSdtDKi = findViewById(R.id.edtSdtDKi);
        imvBackRegister = findViewById(R.id.imvBackRegister);
    }

    private void addEvents() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ManHinhDangKy.this,OTPScreen.class);
//
//                String sdt = edtSdtDKi.getText().toString();
//                intent.putExtra("SdtDKi",sdt);
//                startActivity(intent);
                String sdt = edtSdtDKi.getText().toString();
                sendVerifyToUser(sdt);

            }
        });

        imvBackRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
                                Toast.makeText(ManHinhDangKy.this, e.getMessage(), Toast.LENGTH_LONG).show();
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
                            goToMainActivity(user.getPhoneNumber());
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(ManHinhDangKy.this, "Code was invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void goToMainActivity(String phoneNumber) {
        Intent intent = new Intent(ManHinhDangKy.this,MainActivity.class);
        intent.putExtra(Constant.PHONE_NUMBER,phoneNumber);
        startActivity(intent);
    }

    private void goToOTPScreen(String sdt, String verifycationID) {
        Intent intent = new Intent(ManHinhDangKy.this,OTPScreen.class);
        intent.putExtra(Constant.PHONE_NUMBER,sdt);
        intent.putExtra(Constant.VERIFYID,verifycationID);
        startActivity(intent);
    }
}