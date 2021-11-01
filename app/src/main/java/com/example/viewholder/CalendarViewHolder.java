package com.example.viewholder;

import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.CalendarAdapter;
import com.example.appbenhvienlocal.R;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtDate;
    private CalendarAdapter.onItemListener onItemListener;

    public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.onItemListener onItemListener) {
        super(itemView);
        txtDate = itemView.findViewById(R.id.txtDate);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemListener.onItemClick(getAdapterPosition(), (String) txtDate.getText());
    }
}
