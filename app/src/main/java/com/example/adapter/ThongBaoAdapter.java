package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appbenhvienlocal.R;
import com.example.models.ThongBao;

import java.util.List;

public class ThongBaoAdapter extends BaseAdapter {

    Context context;
    int thongbao_layout;
    List<ThongBao> thongBaoList;

    public ThongBaoAdapter(Context context, int thongbao_layout, List<ThongBao> thongBaoList) {
        this.context = context;
        this.thongbao_layout = thongbao_layout;
        this.thongBaoList = thongBaoList;
    }

    @Override
    public int getCount() {
        return thongBaoList.size();
    }

    @Override
    public Object getItem(int i) {
        return thongBaoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(thongbao_layout,null);
            viewHolder.txtMaPhieuHuy = view.findViewById(R.id.txtMaPhieuHuy);
            viewHolder.txtNgayKhamHuy = view.findViewById(R.id.txtNgayKhamHuy);
            viewHolder.txtNgayThongBaoHuy = view.findViewById(R.id.txtNgayThongBaoHuy);
            view.setTag(viewHolder);

        }else {

           viewHolder= (ViewHolder) view.getTag();
        }

        ThongBao thongBao = thongBaoList.get(i);
        viewHolder.txtMaPhieuHuy.setText(thongBao.getMaPhieuHuy());
        viewHolder.txtNgayKhamHuy.setText(thongBao.getNgayKhamHuy());
        viewHolder.txtNgayThongBaoHuy.setText(thongBao.getNgayThongBaoHuy());

            return view;
    }

    public static class ViewHolder {
        TextView txtMaPhieuHuy, txtNgayKhamHuy, txtNgayThongBaoHuy;

    }
}
