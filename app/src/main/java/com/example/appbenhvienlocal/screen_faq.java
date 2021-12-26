package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class screen_faq extends AppCompatActivity {
    Button btnQues1, btnQues2,btnQues3, btnBack,btnBackHome;
    TextView txtAnswer1, txtAnswer2, txtAnswer3;
    LinearLayout linearQuestion;
    boolean expand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_faq);
        linkViews();
        loadAnswer();
    }

    private void loadAnswer() {
        btnQues1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(linearQuestion);
                expand = !expand;
                txtAnswer1.setVisibility(expand ? View.VISIBLE : View.GONE);
            }
        });
        btnQues2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(linearQuestion);
                expand = !expand;
                txtAnswer2.setVisibility(expand ? View.VISIBLE : View.GONE);
            }
        });
        btnQues3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(linearQuestion);
                expand = !expand;
                txtAnswer3.setVisibility(expand ? View.VISIBLE : View.GONE);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMain = new Intent(screen_faq.this, MainActivity.class);
                startActivity(backMain);
            }
        });
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMain = new Intent(screen_faq.this, MainActivity.class);
                startActivity(backMain);
            }
        });
    }

    private void linkViews() {
        btnQues1 =findViewById(R.id.btnQues1);
        btnQues2 = findViewById(R.id.btnQues2);
        btnQues3 = findViewById(R.id.btnQues3);
        btnBack = findViewById(R.id.btnBackDK);
        btnBackHome = findViewById(R.id.btnBackHome);
        txtAnswer1 = findViewById(R.id.txtQues1);
        txtAnswer2 = findViewById(R.id.txtQues2);
        txtAnswer3 = findViewById(R.id.txtQues3);
        linearQuestion = findViewById(R.id.linearQuestion);
    }
}