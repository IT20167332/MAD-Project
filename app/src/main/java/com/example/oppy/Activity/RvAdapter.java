package com.example.oppy.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Sehedules> list = new ArrayList<>();
    public RvAdapter(Context context) {
        this.context = context;
    }
    public void setItems(ArrayList<Sehedules> sch){
        list.addAll(sch);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_sche,parent,false);
        return new SchedulesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder holder, int position) {

        SchedulesVH vh = (SchedulesVH) holder;
        Sehedules sch = list.get(position);
        vh.text_name.setText(sch.getTitle());
        vh.text_date.setText(sch.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
