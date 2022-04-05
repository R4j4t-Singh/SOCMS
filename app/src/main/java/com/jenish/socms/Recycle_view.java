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
     int index;

    public Recycle_view(Activity activity, List<DataClass> dataClassList,int index) {
        this.activity = activity;
        this.dataClassList = dataClassList;
        this.index=index;
    }

    @NonNull
    @Override
    public Recycle_view.DATA_HOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(activity).inflate(R.layout.member_list_item,parent,false);

        return new DATA_HOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_view.DATA_HOLDER holder, int position) {
        holder.membername.setText(dataClassList.get(index).name);
        holder.flat_number.setText(dataClassList.get(index).flat_number);
    }

    @Override
    public int getItemCount() {
        return 10;
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
