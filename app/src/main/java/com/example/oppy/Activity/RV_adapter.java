package com.example.oppy.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RV_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Sehedules> list = new ArrayList<>();
    public RV_adapter(Context ctx) {
        this.context = ctx;
    }
    public void setItems(ArrayList<Sehedules> emp){
        list.addAll(emp);
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new W_scheduleVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        W_scheduleVH vh = (W_scheduleVH) holder;
        Sehedules emp = list.get(position);
        vh.txt_title.setText(emp.getTitle());
        vh.w_txt_date.setText(emp.getDate());
        vh.w_txt_item.setText(emp.getItem());
        vh.w_txt_qtys.setText(emp.getQty());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
