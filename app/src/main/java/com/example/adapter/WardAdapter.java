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
import com.example.models.Ward;

import java.util.List;

public class WardAdapter extends ArrayAdapter<Ward> {

    private Activity context;
    private int resource;
    private List<Ward> wards;

    public WardAdapter(@NonNull Activity context, int resource,List<Ward> wards ) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.wards = wards;
    }

    public WardAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return wards.size();
    }

    @Nullable
    @Override
    public Ward getItem(int position) {
        return wards.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_quen_ma_hs,parent,false);
        TextView txtSelectedItem = convertView.findViewById(R.id.txtSelectedHS);
        Ward ward = wards.get(position);
        if(ward!=null)
        {
            txtSelectedItem.setText(ward.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_quen_ma_hs,parent,false);
        TextView txtItem = convertView.findViewById(R.id.txtSelectedHS);
        Ward ward = wards.get(position);
        if(ward!=null)
        {
            txtItem.setText(ward.getName());
        }
        return convertView;
    }
}
