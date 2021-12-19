package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appbenhvienlocal.R;
import com.example.models.ThoiGianKham;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GioKhamAdapter extends ArrayAdapter {
    private Context context;
    private int resoure;
    private ArrayList<ThoiGianKham> times;


    public GioKhamAdapter(@NonNull Context context, int resource, ArrayList<ThoiGianKham> times) {
        super(context, resource);
        this.context = context;
        this.resoure = resource;
        this.times = times;
    }

    @Override
    public int getCount() {
        return times.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return times.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resoure, null);
            holder = new ViewHolder();
            holder.txtGioKham = convertView.findViewById(R.id.txtGioKham);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        LocalTime thoiGianBĐ = times.get(position).getThoiGianBĐ();
        LocalTime thoiGianKT = times.get(position).getThoiGianKT();
        holder.txtGioKham.setText(timeFromLocalTime(thoiGianBĐ)+ " - " + timeFromLocalTime(thoiGianKT));
        return convertView;
    }

    private String timeFromLocalTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

    public class ViewHolder{
        TextView txtGioKham;
    }
}
