package com.example.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appbenhvienlocal.R;
import com.example.models.Danhsachphieukham;

import java.util.List;

public class PhieuKhamAdapter extends BaseAdapter {
    Context context;
    int phieuKham_layout;
    List<Danhsachphieukham> danhsachphieukhamList;

    public PhieuKhamAdapter(Context context, int phieuKham_layout, List<Danhsachphieukham> danhsachphieukhamList) {
        this.context = context;
        this.phieuKham_layout = phieuKham_layout;
        this.danhsachphieukhamList = danhsachphieukhamList;
    }

    @Override
    public int getCount() {
        return danhsachphieukhamList.size();
    }

    @Override
    public Object getItem(int i) {
        return danhsachphieukhamList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(phieuKham_layout, null);
            viewHolder.txtMaPhieu = view.findViewById(R.id.txtMaPhieu);
            viewHolder.txtTen = view.findViewById(R.id.txtTen);
            viewHolder.txtTrangThai = view.findViewById(R.id.txtTrangThai);
            viewHolder.txtNgayKham = view.findViewById(R.id.txtNgayKham);
            viewHolder.txtGioDuKien = view.findViewById(R.id.txtGioKhamDuKien);

            view.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) view.getTag();

        }

        Danhsachphieukham phieuKham = danhsachphieukhamList.get(i);
        viewHolder.txtMaPhieu.setText(phieuKham.getMaPhieu());
        viewHolder.txtTen.setText(phieuKham.getTen());
        viewHolder.txtTrangThai.setBackgroundResource(phieuKham.getTrangThai());
        viewHolder.txtTrangThai.setText(phieuKham.getTenTrangThai());
        viewHolder.txtNgayKham.setText(phieuKham.getNgayKham());
        viewHolder.txtGioDuKien.setText(phieuKham.getGioKhamDuKien());

        return view;
    }

    public static class ViewHolder {

        TextView txtMaPhieu, txtTen, txtNgayKham, txtGioDuKien, txtTrangThai;
    }
}
