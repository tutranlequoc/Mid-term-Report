package com.example.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbenhvienlocal.R;
import com.example.viewholder.CalendarViewHolder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private Context context;
    private int resource;
    private ArrayList<LocalDate> daysOfMonth;
    public onItemListener onItemListener;

    public CalendarAdapter(Context context, int resource, ArrayList<LocalDate> daysOfMonth, onItemListener onItemListener) {
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
        return new CalendarViewHolder(view, onItemListener, daysOfMonth);
    }



    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        LocalDate date = daysOfMonth.get(position);
        holder.txtDate.setClickable(false);
        if(date == null)
        {
            holder.txtDate.setText("");
        }
        else {
            holder.txtDate.setText(String.valueOf(date.getDayOfMonth()));
            holder.txtDate.setTextColor(Color.parseColor("#E5E5E5"));
            if(date.equals(LocalDate.now())){
                holder.txtDate.setBackgroundResource(R.drawable.calendar_round_day);
                holder.txtDate.setTextColor(Color.parseColor("#FFFFFF"));
            }
            if(date.getDayOfWeek() == DayOfWeek.SUNDAY){
                holder.txtDate.setTextColor(Color.parseColor("#FF0000"));
            }

            ArrayList<LocalDate> holidays = new ArrayList<>();
            holidays.add(LocalDate.of(0, 4, 30));
            holidays.add(LocalDate.of(0,9,2));
            holidays.add(LocalDate.of(0,5,1));
            holidays.add(LocalDate.of(0,1,1));

            for (LocalDate holiday: holidays) {
                if(date.getDayOfMonth()== holiday.getDayOfMonth() && date.getMonth() == holiday.getMonth()){
                    holder.txtDate.setTextColor(Color.parseColor("#0038FF"));
                    break;
                }
            }


            LocalDate fiveWeeksAfter = LocalDate.now().plusDays(31);
            int plusDay = fiveWeeksAfter.getDayOfWeek().getValue();
//            if(plusDay >=1 && plusDay <= 5)
//            {
//                fiveWeeksAfter = fiveWeeksAfter.plusDays(5 - plusDay);
//                if(plusDay == 5){
//                    fiveWeeksAfter = fiveWeeksAfter.plusDays(1);
//                }
//            }
            if(date.isBefore(fiveWeeksAfter) && date.isAfter(LocalDate.now().plusDays(1)) && date.getDayOfWeek() != DayOfWeek.SUNDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY){
                //logic db lấy từ hồ sơ đặt khám nếu getcount trong ngày đó số bệnh nhân đã full thì thôi
                //mỗi khung giờ 5-10 bệnh nhân --> 1 ngày có 6 khung giờ -->getcount lớn hơn 60 là out date
                holder.txtDate.setClickable(true);
                holder.txtDate.setTextColor(Color.parseColor("#5CC0AB"));
                holder.txtDate.setTypeface(holder.txtDate.getTypeface(), Typeface.BOLD);
            }

        }
        //Sửa lại logic để làm code gọn hơn. (chưa cần)
        //Đưa những ngày có thể khám được vào SQLite vì theo logic thì không thể luôn luôn fix cứng ngày được (chưa cần)
        //Tạo ra một constance để lưu các giá trị ngày lễ
        //Tìm cách đưa giá trị Locale về giờ giấc của Việt Nam (làm đc cái này là làm được cái trên)
    }

    @Override
    public int getItemCount() {
        return daysOfMonth.size();
    }


    public interface onItemListener{
        void onItemClick(int position, LocalDate date, boolean clickable);
    }
}
