package com.jenish.socms;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Event_recyler extends RecyclerView.Adapter<Event_recyler.Event_HoLDER> {
    Activity activity;
    List<Event_Data_class> dataClassList;
    public Event_recyler(Activity activity, List<Event_Data_class> dataClassList) {
        this.activity = activity;
        this.dataClassList = dataClassList;
    }

    @NonNull
    @Override
    public Event_HoLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.event_item,parent,false);
        return new Event_HoLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Event_HoLDER holder, int position) {
          holder.soc.setText(dataClassList.get(position).getEvent_SOC());
        holder.type.setText(dataClassList.get(position).getEvent_type());
        holder.date.setText(dataClassList.get(position).getEvent_date());
        holder.id.setText(dataClassList.get(position).getEvent_ID());
    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }

    public class Event_HoLDER extends RecyclerView.ViewHolder {
        TextView soc,type,date,id;
        public Event_HoLDER(@NonNull View itemView) {
            super(itemView);
            soc= itemView.findViewById(R.id.Event_soc);
            type = itemView.findViewById(R.id.Even_type);
            date = itemView.findViewById(R.id.Event_date);
            id = itemView.findViewById(R.id.event_id);
        }
    }
}
