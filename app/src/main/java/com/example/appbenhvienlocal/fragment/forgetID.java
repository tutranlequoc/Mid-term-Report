package com.example.appbenhvienlocal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adapter.CategoryAdapter;
import com.example.appbenhvienlocal.R;
import com.example.category.Category;

import java.util.ArrayList;
import java.util.List;

public class forgetID extends Fragment {
    CategoryAdapter genderAdapter, provinceAdapter;
    Spinner spnGender, spnProvince;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.screen_quenmaso,container,false);
        spnGender = view.findViewById(R.id.spn_gioitinh_quenMaHS);
        spnProvince = view.findViewById(R.id.spn_tinhTP_quenMaHS);
        genderAdapter = new CategoryAdapter(getContext(), R.layout.item_selected_quen_ma_hs, getListGender());
        spnGender.setAdapter(genderAdapter);
        provinceAdapter = new CategoryAdapter(getContext(), R.layout.item_selected_quen_ma_hs, getListProvince());
        spnProvince.setAdapter(provinceAdapter);
        return view;
        
    }

    private List<Category> getListProvince() {
        List<Category> province = new ArrayList<>();
        province.add(new Category("TP.HCM"));
        return province;
    }

    private List<Category> getListGender() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Nam"));
        list.add(new Category("Nữ"));
        return list;
    }
}
