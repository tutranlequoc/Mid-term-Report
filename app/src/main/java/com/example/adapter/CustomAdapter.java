package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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
import com.example.function.DichVu;
import com.example.function.Function;
import com.example.function.HoSoDK;
import com.example.function.ThongTin;
import com.example.ultis.Constant;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Function> listFunction;
    private ArrayList<DichVu> listDichVu;
    private ArrayList<HoSoDK> hoSoDKS;
    private ArrayList<String> phuongThucTT;
    private ArrayList<ThongTin> thongTins;
    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Function> listFunction) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.listFunction = listFunction;
    }

    public CustomAdapter(@NonNull Activity context, int resource, ArrayList<DichVu> listDichVu) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.listDichVu = listDichVu;
    }

    public CustomAdapter(@NonNull Activity context, ArrayList<HoSoDK> hoSoDKS, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.hoSoDKS = hoSoDKS;
    }
    public CustomAdapter(@NonNull Context context, ArrayList<String> phuongThucTT, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.phuongThucTT = phuongThucTT;
    }
    public CustomAdapter(ArrayList<ThongTin> thongTins, int resource, @NonNull Context context) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.thongTins = thongTins;
    }


    @Override
    public int getCount() {
        Integer count = 0;
        if(listDichVu!= null)
        {
            count = listDichVu.size();
        }
        if(listFunction!=null)
        {
            count = listFunction.size();
        }
        if(hoSoDKS!=null)
        {
            count = hoSoDKS.size();
        }
        if(phuongThucTT!=null)
        {
            count = phuongThucTT.size();
        }
        if(thongTins!=null)
        {
            count = thongTins.size();
        }
        return count;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        Object item = null;
        if(listDichVu!= null)
        {
            item = listDichVu.get(position);
        }
        if(listFunction!=null)
        {
            item = listFunction.get(position);
        }
        if(hoSoDKS!=null)
        {
            item = hoSoDKS.get(position);
        }
        if(phuongThucTT!=null)
        {
            item = phuongThucTT.get(position);
        }
        if(thongTins!=null)
        {
            item = thongTins.get(position);
        }
        return item;
    }

    @Override
    public boolean isEnabled(int position) {
        if (thongTins != null){
            if(position == 0)
            {
                return true;
            } else{
                ThongTin thongTin = thongTins.get(position - 1);
                if(!thongTin.getResult().equals(""))
                {
                    return true;
                }
                else {
                    return false;
                }
            }
        }else {
            return true;
        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        String tag = "";
        if(convertView == null)
        {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(resource, null);
            switch (convertView.getId()){
                case R.id.layoutFooter:
                    holder.txtFunction = convertView.findViewById(R.id.txtFunction);
                    holder.imvFunction = convertView.findViewById(R.id.imvFunction);
                    tag = Constant.FUNCTION;
                    break;
                case R.id.layoutThongTin:
                    holder.txtThongTin = convertView.findViewById(R.id.txtThongTin);
                    holder.imvThongTin = convertView.findViewById(R.id.imvThongTin);
                    holder.txtKetQua = convertView.findViewById(R.id.txtKetQua);
                    tag = Constant.THONGTIN;
                    break;
                case R.id.layoutDichVu:
                    holder.txtFunction = convertView.findViewById(R.id.txtDichVu);
                    holder.txtThoiGian = convertView.findViewById(R.id.txtThoiGian);
                    holder.txtGia = convertView.findViewById(R.id.txtGiaDichVu);
                    tag = Constant.DICHVU;
                    break;
                case R.id.layouHoSoDatKham:
                    holder.txtName = convertView.findViewById(R.id.txtName);
                    holder.txtDateOfBirth = convertView.findViewById(R.id.txtDateOfBirth);
                    holder.txtCode = convertView.findViewById(R.id.txtCode);
                    holder.txtAddress = convertView.findViewById(R.id.txtAddress);
                    holder.txtPhone = convertView.findViewById(R.id.txtPhone);
                    tag = Constant.HOSODATKHAM;
                    break;
                case R.id.layoutCPTTT:
                    holder.txtPTTT = convertView.findViewById(R.id.txtPTTT);
                    tag = Constant.PTTT;
                    break;
            }
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        switch (tag){
            case Constant.FUNCTION:
                Function f = listFunction.get(position);
                holder.txtFunction.setText(f.getFunction());
                holder.imvFunction.setImageResource(f.getFunctionImage());
                break;
            case Constant.THONGTIN:
                ThongTin t = thongTins.get(position);
                holder.txtThongTin.setText(t.getInfo());
                holder.imvThongTin.setImageResource(t.getIconID());
                holder.txtKetQua.setText(t.getResult());
                if(isEnabled(position))
                {
                    holder.txtThongTin.setTypeface(holder.txtThongTin.getTypeface(), Typeface.BOLD);
                    holder.txtThongTin.setTextColor(Color.parseColor("#00a8c7"));
                }
                if(!t.getResult().equals("")){
                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.txtKetQua.getLayoutParams();
                    params.height = ViewGroup.MarginLayoutParams.WRAP_CONTENT;
                    params.topMargin = 10;
                    holder.txtKetQua.setLayoutParams(params);
                    holder.txtKetQua.setTextColor(Color.parseColor("#00a8c7"));
                    holder.txtThongTin.setTypeface(null, Typeface.NORMAL);
                    holder.txtThongTin.setTextColor(Color.parseColor("#000000"));
                }
                break;
            case Constant.DICHVU:
                DichVu dichVu = listDichVu.get(position);
                holder.txtFunction.setText(dichVu.getTenDichVu());
                holder.txtThoiGian.setText(dichVu.getThoiGian());
                holder.txtGia.setText(String.format("%.0f", dichVu.getGiaDichVu()) + " đ");
                break;
            case Constant.HOSODATKHAM:
                HoSoDK hoSoDK = hoSoDKS.get(position);
                holder.txtName.setText(hoSoDK.getTen());
                holder.txtDateOfBirth.setText(hoSoDK.getThoiGian());
                holder.txtCode.setText(hoSoDK.getMaSo());
                holder.txtAddress.setText(hoSoDK.getDiaChi());
                holder.txtPhone.setText(hoSoDK.getsDT());
                break;
            case Constant.PTTT:
                holder.txtPTTT.setText(phuongThucTT.get(position));
        }
        return convertView;
    }

    public static class ViewHolder {
        private TextView txtFunction, txtThoiGian, txtGia,txtName,txtDateOfBirth, txtCode, txtAddress, txtPhone, txtPTTT, txtKetQua, txtThongTin;
        private ImageView imvFunction, imvThongTin;
    }
}
