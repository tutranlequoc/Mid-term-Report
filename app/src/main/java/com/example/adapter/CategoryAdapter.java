package com.example.adapter;

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

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {
    public CategoryAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Category> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_quen_ma_hs,parent,false);
        TextView txtSelectedItem = convertView.findViewById(R.id.txtSelectedHS);
        Category category = this.getItem(position);
        if(category!=null)
        {
            txtSelectedItem.setText(category.getName());
        }
        return convertView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_quen_ma_hs,parent,false);
        TextView txtItem = convertView.findViewById(R.id.txtItemListHS);
        Category category = this.getItem(position);
        if(category!=null)
        {
            txtItem.setText(category.getName());
        }
        return convertView;
    }
}
