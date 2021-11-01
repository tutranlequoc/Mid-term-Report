package com.example.appbenhvienlocal.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appbenhvienlocal.R;
import com.example.appbenhvienlocal.screen_hoso_moi;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class addDocument extends Fragment {
    private Button btnXemHoSo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nhaphoso,container,false);
        btnXemHoSo= view.findViewById(R.id.btnTimHoSo);
        btnXemHoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheet();
            }
        });
        return view;

    }
    public void bottomSheet(){
        View view1 = getLayoutInflater().inflate(R.layout.bottom_sheet_themhoso,null);
//        Button close = view1.findViewById(R.id.btnClose);
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
        dialog.setContentView(view1);
        dialog.show();
    }




}
