package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.CalendarAdapter;
import com.example.function.ThongTin;
import com.example.ultis.Constant;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ChonNgayKham extends AppCompatActivity implements CalendarAdapter.onItemListener{

    private TextView txtMonthYear;
    private RecyclerView rvCalendar;
    private LocalDate selectedDate;
    private ImageButton btnDecrease, btnIncrease, btnNK;
    ArrayList<ThongTin> ketQuaTraVe;
    Intent intent;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ngay_kham);
        linkViews();
        selectedDate = LocalDate.now();
        setMonthView();
        addEvents();
        getData();
    }

    private void getData() {
        intent = getIntent();
        ArrayList<ThongTin> thongTins = intent.getParcelableArrayListExtra(Constant.THONGTIN);
        ketQuaTraVe = thongTins;
        index = intent.getIntExtra(Constant.INDEX_THONGTIN, 0);
    }

    private void addEvents() {
        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDate = selectedDate.minusMonths(1);
                setMonthView();
            }
        });
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDate = selectedDate.plusMonths(1);
                setMonthView();
            }
        });
        btnNK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(intent.getIntExtra(Constant.REQUEST_TAG, 0) == Constant.REQUEST_CODE){
                    intent.putExtra(Constant.THONGTIN, ketQuaTraVe);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }else {
                    Intent backToFirstScreen = new Intent(ChonNgayKham.this, ChonThongTinKham.class);
                    backToFirstScreen.putExtra(Constant.THONGTIN, ketQuaTraVe);
                    backToFirstScreen.putExtra(Constant.INDEX_THONGTIN, index - 1);
                    startActivity(backToFirstScreen);
                }

            }
        });
    }

    private void setMonthView() {
        txtMonthYear.setText("Tháng " + monthYearFromDate(selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(this, R.layout.calendar_cell, daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        rvCalendar.setLayoutManager(layoutManager);
        rvCalendar.setAdapter(calendarAdapter);

    }

    private ArrayList<LocalDate> daysInMonthArray(LocalDate date) {
        ArrayList<LocalDate> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        while ((dayOfWeek > 1) && (dayOfWeek) % 7 == 0){
            dayOfWeek = dayOfWeek - 7;
        }
        for(int i = 1; i <= daysInMonth + dayOfWeek; i++){
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek){
                daysInMonthArray.add(null);
            }
            else {
                daysInMonthArray.add(LocalDate.of(date.getYear(), date.getMonth(), i - dayOfWeek));
            }
        }
        return daysInMonthArray;

    }

    private String monthYearFromDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M - y");
        return date.format(formatter);
    }

    private String dateMonthYearFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/y");
        return date.format(formatter);
    }

    private void linkViews() {
        txtMonthYear = findViewById(R.id.txtMonthYear);
        rvCalendar = findViewById(R.id.rvCalendar);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnNK = findViewById(R.id.btnNK);
    }

    @Override
    public void onItemClick(int position, LocalDate date, boolean clickable) {
        if(clickable == true){
            ketQuaTraVe.get(index).setResult(dateMonthYearFromDate(date));
            int k = index;
            while (k + 1 <= ketQuaTraVe.size() - 1){
                ketQuaTraVe.get(k + 1).setResult("");
                k++;
            }
            intent = new Intent(ChonNgayKham.this, VuiLongChonGiokham.class);
            intent.putParcelableArrayListExtra(Constant.THONGTIN, ketQuaTraVe);
            intent.putExtra(Constant.INDEX_THONGTIN, index+1);
            Constant.bookingInfor.setNgayKham(dateMonthYearFromDate(date));
            startActivity(intent);
        }
    }
}