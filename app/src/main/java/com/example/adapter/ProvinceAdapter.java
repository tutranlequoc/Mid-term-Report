package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appbenhvienlocal.R;
import com.example.category.Category;
import com.example.models.Province;

import java.util.List;

public class ProvinceAdapter extends ArrayAdapter<Province> {
    private Activity context;
    private int resource;
    private List<Province> provinces;

    public ProvinceAdapter(@NonNull Activity context, int resource, List<Province> provinces) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.provinces = provinces;
    }

    @Override
    public int getCount() {
        return provinces.size();
    }

    @Nullable
    @Override
    public Province getItem(int position) {
        return provinces.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_quen_ma_hs,parent,false);
        TextView txtSelectedItem = convertView.findViewById(R.id.txtSelectedHS);
        Province province = provinces.get(position);
        if(province!=null)
        {
            txtSelectedItem.setText(province.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_quen_ma_hs,parent,false);
        TextView txtItem = convertView.findViewById(R.id.txtItemListHS);
        Province province = provinces.get(position);
        if(province!=null)
        {
            txtItem.setText(province.getName());
        }
        return convertView;
    }


}
