package com.example.viewholder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.CalendarAdapter;
import com.example.appbenhvienlocal.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class CalendarViewHolder extends RecyclerView.ViewHolder{

    public TextView txtDate;
    private CalendarAdapter.onItemListener onItemListener;

    public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.onItemListener onItemListener, ArrayList<LocalDate> daysOfMonth) {
        super(itemView);
        txtDate = itemView.findViewById(R.id.txtDate);
        this.onItemListener = onItemListener;
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemListener.onItemClick(getAdapterPosition(), daysOfMonth.get(getAdapterPosition()), txtDate.isClickable());
            }
        });
    }
}
