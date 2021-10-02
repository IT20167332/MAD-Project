package com.example.oppy.Activity.WarehouseManagement;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.Activity.gatekeeperManagement.Schedules;
import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class RV_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ScheduleDb D_scheduleDb = new ScheduleDb();
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

        vh.W_btm_submit.setOnClickListener(v->{

            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("warehouseCheck",true);
            D_scheduleDb.update(emp.getKey(),hashMap).addOnSuccessListener(suc->{
                Toast.makeText(context,"Accepted!",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(context,"err ewith update"+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

        vh.W_btn_more.setOnClickListener(v->{
            Intent intent = new Intent(context,SPnotes.class);
            intent.putExtra("schduleObject",(Parcelable)emp);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
