package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewholder.CalendarViewHolder;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private Context context;
    private int resource;
    private ArrayList<String> daysOfMonth;
    public onItemListener onItemListener;

    public CalendarAdapter(Context context, int resource, ArrayList<String> daysOfMonth, onItemListener onItemListener) {
        this.context = context;
        this.resource = resource;
        this.daysOfMonth = daysOfMonth;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(resource, parent, false);
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.height = (int) (parent.getHeight() * 0.1);
        return new CalendarViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.txtDate.setText(daysOfMonth.get(position));
    }

    @Override
    public int getItemCount() {
        return daysOfMonth.size();
    }

    public interface onItemListener{
        void onItemClick(int position, String dayText);
    }
}
