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
import com.example.models.District;
import com.example.models.Province;

import java.util.List;

public class DistrictAdapter extends ArrayAdapter<District> {
    private Activity context;
    private int resource;
    private List<District> districts;

    public DistrictAdapter(@NonNull Activity context, int resource, List<District> districts) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.districts = districts;
    }

    @Override
    public int getCount() {
        return districts.size();
    }

    @Nullable
    @Override
    public District getItem(int position) {
        return districts.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_quen_ma_hs,parent,false);
        TextView txtSelectedItem = convertView.findViewById(R.id.txtSelectedHS);
        District district = districts.get(position);
        if(district!=null)
        {
            txtSelectedItem.setText(district.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_quen_ma_hs,parent,false);
        TextView txtItem = convertView.findViewById(R.id.txtItemListHS);
        District district = districts.get(position);
        if(district!=null)
        {
            txtItem.setText(district.getName());
        }
        return convertView;
    }
}
