package com.jenish.socms;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycle_view extends RecyclerView.Adapter<Recycle_view.DATA_HOLDER> {
     Activity activity;
     List<DataClass> dataClassList;


    public Recycle_view(Activity activity, List<DataClass> dataClassList) {
        this.activity = activity;
        this.dataClassList = dataClassList;


    }

    @NonNull
    @Override
    public Recycle_view.DATA_HOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(activity).inflate(R.layout.member_list_item,parent,false);

        return new DATA_HOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_view.DATA_HOLDER holder, int position) {
        holder.membername.setText(dataClassList.get(position).getName());
        holder.flat_number.setText(dataClassList.get(position).getFlat_ID());
    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }

    public class DATA_HOLDER extends RecyclerView.ViewHolder {
        TextView membername,flat_number;

        public DATA_HOLDER(@NonNull View itemView) {
            super(itemView);
            membername = itemView.findViewById(R.id.member_name);
            flat_number = itemView.findViewById(R.id.flat_number);

        }
    }
}
