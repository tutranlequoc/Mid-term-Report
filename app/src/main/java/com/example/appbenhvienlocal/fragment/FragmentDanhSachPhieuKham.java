package com.example.appbenhvienlocal.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.adapter.PhieuKhamAdapter;
import com.example.appbenhvienlocal.DanhSachPhieuKhamScreen;
import com.example.appbenhvienlocal.R;
import com.example.models.Danhsachphieukham;
import com.example.ultis.Constant;

import java.util.ArrayList;


public class FragmentDanhSachPhieuKham extends Fragment {

    ListView lvDanhSachPhieuKham;
    ArrayList<Danhsachphieukham> danhsachphieukhams;
    PhieuKhamAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_danh_sach_phieu_kham, container, false);
        lvDanhSachPhieuKham = view.findViewById(R.id.lvDanhSachPhieuKham);
        ArrayList <Danhsachphieukham> danhsachphieukhams = new ArrayList<>();

        return view;
    }

    private void initData() {
        danhsachphieukhams = Constant.database.getInforFromMedicalTest(Constant.user.getPhone());
        adapter = new PhieuKhamAdapter(getContext(), R.layout.phieu_kham_layout, danhsachphieukhams);
        lvDanhSachPhieuKham.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }
}