package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class screen_chuatungkham extends AppCompatActivity {
    TextView txtThongBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_chuatungkham);
        
        linkViews();
        initData();
    }



    private void linkViews() {
       txtThongBao = findViewById(R.id.txtThongBao);
    }
    private void initData() {
        String text = "<font color=#FFFFFF>Vui lòng cung cấp thông tin chính xác để được phục vụ tốt nhất. Trong trường hợp cung cấp sai thông tin bệnh nhân &amp; điện thoại, việc xác nhận cuộc hẹn sẽ không có hiệu lực trước khi đặt khám</font> \n <font color=#00E60F0F>(*) Yêu cầu vui lòng nhập đầy đủ thông tin bên dưới</font>";
        txtThongBao.setText(Html.fromHtml(text));
    }
}