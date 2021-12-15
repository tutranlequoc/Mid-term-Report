package com.example.models;

import android.os.Parcelable;

import com.example.function.ThongTin;

import java.io.Serializable;
import java.util.ArrayList;

public interface BackScreenClick {
    public void onBackScreenClick(ArrayList<ThongTin> thongTins);
}
