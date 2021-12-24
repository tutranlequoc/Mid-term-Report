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

public class forgetID extends Fragment {
    CategoryAdapter genderAdapter, provinceAdapter;
    Spinner spnGender, spnProvince;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        spnGender = container.findViewById(R.id.spn_gioitinh_quenMaHS);
        spnProvince = container.findViewById(R.id.spn_tinhTP_quenMaHS);
        //genderAdapter = new CategoryAdapter(this, R.layout.item_selected_quen_ma_hs, getListGender());
        return inflater.inflate(R.layout.screen_quenmaso,container,false);
        
    }

    private Object getListGender() {
        return true;
    }
}
