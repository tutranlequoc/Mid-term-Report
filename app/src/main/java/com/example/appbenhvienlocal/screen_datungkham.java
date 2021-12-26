package com.example.appbenhvienlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class screen_datungkham extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    ImageButton imgBackDTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_datungkham);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        imgBackDTK = findViewById(R.id.imgBackDKT);
        imgBackDTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHoSoDK = new Intent(screen_datungkham.this, HoSoDatKham.class);
                startActivity(backHoSoDK);
            }
        });
    }

    private void addEvents() {

    }
}