package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbenhvienlocal.R;
import com.example.function.Function;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Function> listFunction;
    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Function> listFunction) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.listFunction = listFunction;
    }

    @Override
    public int getCount() {
        return listFunction.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return listFunction.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(resource, null);
            holder.txtFunction = convertView.findViewById(R.id.txtFunction);
            holder.imvFunction = convertView.findViewById(R.id.imvFunction);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Function f = listFunction.get(position);
        holder.txtFunction.setText(f.getFunction());
        holder.imvFunction.setImageResource(f.getFunctionImage());
        return convertView;
    }

    public static class ViewHolder {
        private TextView txtFunction;
        private ImageView imvFunction;
    }
}
