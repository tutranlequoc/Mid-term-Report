package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appbenhvienlocal.R;
import com.example.models.Region;


import java.util.ArrayList;

public class RegionAdapter  extends ArrayAdapter {
    public RegionAdapter(@NonNull Context context, ArrayList<Region> regions) {
        super(context,0, regions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }
    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout. region_spinner_layout,parent,false);

        ImageView imvRegion =convertView.findViewById(R.id.imvRegion);
        Region currentReion = (Region) getItem(position);

        if(currentReion != null){

            imvRegion.setImageResource(currentReion.getRegionThumb());

        }
        return convertView;
    }


}
