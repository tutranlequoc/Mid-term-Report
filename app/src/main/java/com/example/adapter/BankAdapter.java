package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbenhvienlocal.R;

import java.util.List;

public class BankAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Bank> list;

    public BankAdapter(Context context, int layout, List<Bank> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.txtBankName = view.findViewById(R.id.txtBankName);
            viewHolder.imvBankThumb = view.findViewById(R.id.imvBankThumb);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.txtBankName.setText(list.get(i).bankName);
        viewHolder.imvBankThumb.setImageResource(list.get(i).bankThumb);
        return view;
    }
    private class ViewHolder {
        TextView txtBankName;
        ImageView imvBankThumb;
    }
}
