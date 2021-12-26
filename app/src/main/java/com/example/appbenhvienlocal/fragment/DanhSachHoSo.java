package com.example.appbenhvienlocal.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;
import com.example.appbenhvienlocal.HoSoDatKham;
import com.example.appbenhvienlocal.R;
import com.example.function.HoSoDK;
import com.example.models.onItemFragmentClick;
import com.example.ultis.Constant;

import java.util.ArrayList;

public class DanhSachHoSo extends Fragment {

    ListView lvHoSo;
    CustomAdapter adapter;
    ArrayList<HoSoDK> hoSoDKS;
    onItemFragmentClick onItemFragmentClick;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_danh_sach_ho_so, container, false);
       lvHoSo = view.findViewById(R.id.lvHoSo);
       hoSoDKS = new ArrayList<>();
       initData();
       return view;
    }

    public void initData(){
        hoSoDKS = Constant.database.getInForFromDocument(Constant.user.getPhone());
        adapter = new CustomAdapter((Activity) getContext(), hoSoDKS, R.layout.listview_ho_so_dat_kham);
        lvHoSo.setAdapter(adapter);
        lvHoSo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onItemFragmentClick = (onItemFragmentClick) getActivity();
                if(onItemFragmentClick != null){
                    HoSoDK doc = (HoSoDK) adapter.getItem(i);
                    onItemFragmentClick.click(doc);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        lvHoSo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onItemFragmentClick = (onItemFragmentClick) getActivity();
                if(onItemFragmentClick != null){
                    HoSoDK doc = (HoSoDK) adapter.getItem(i);
                    onItemFragmentClick.click(doc);
                }
            }
        });
    }
}