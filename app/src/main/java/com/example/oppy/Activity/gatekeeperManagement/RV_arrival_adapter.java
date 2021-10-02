package com.example.oppy.Activity.gatekeeperManagement;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.Activity.WarehouseManagement.W_scheduleVH;
import com.example.oppy.Activity.managerManagement.add_schedules;
import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class RV_arrival_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    ScheduleDb D_scheduleDb = new ScheduleDb();
    String empId = "BRGzmN1orEe7YhuAtPtJAbBuuD53";
    private Context context;
    ArrayList<Sehedules> list = new ArrayList<>();
    public RV_arrival_adapter(Context ctx) {
        this.context = ctx;
    }
    public void setItems(ArrayList<Sehedules> emp){
        list.addAll(emp);
    }
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_arrival_item,parent,false);
        return new G_arrivalScheduleVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder holder, int position) {

        G_arrivalScheduleVH vh = (G_arrivalScheduleVH) holder;
        //Sehedules emp = list.get(position);
        Sehedules sch = list.get(position);

        vh.G_txt_title.setText(sch.getTitle());
        vh.G_text_date.setText(sch.getDate());
        vh.G_txt_time.setText(sch.getTime());

        String type = sch.getType();

        if(type.equals("ARRIVAL")){
            vh.G_arr_a.setVisibility(View.VISIBLE);
        }else if(type.equals("DEPARTURE") ){
            vh.G_dep_a.setVisibility(View.VISIBLE);
        }

        vh.G_btn_accept.setOnClickListener(v->{

            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("gateCheck",true);
            D_scheduleDb.update(sch.getKey(),hashMap).addOnSuccessListener(suc->{
                Toast.makeText(context,"Accepted!",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(context,"err ewith update"+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

        vh.G_btn_complain.setOnClickListener(v->{
            Intent newintent = new Intent(context, G_Complain.class);
            newintent.putExtra("SendSch", (Parcelable)sch);
            //newintent.putExtra("empId",empId);
            context.startActivity(newintent);
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
