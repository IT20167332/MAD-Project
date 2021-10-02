package com.example.oppy.Activity.driverManagement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

import java.util.ArrayList;
import java.util.HashMap;

public class D_RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ScheduleDb D_scheduleDb = new ScheduleDb();
    private Context context;
    ArrayList<Sehedules> list = new ArrayList<>();
    public D_RvAdapter(Context context) {
        this.context = context;
    }
    public void setItems(ArrayList<Sehedules> sch){
        list.addAll(sch);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_layout_dsch,parent,false);
        return new D_schedulesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder holder, int position) {

        D_schedulesVH vh = (D_schedulesVH) holder;
        Sehedules sch = list.get(position);
        vh.D_text_name.setText(sch.getTitle());
        vh.D_text_date.setText(sch.getDate());
        vh.D_txt_destand.setText(String.valueOf(sch.getDistance()));
        vh.D_destination.setText(sch.getDestination());

        //vh.D_text_qty.setText(sch.getQty());
        if(sch.isStatus()==true){
            vh.D_txt_accept.setVisibility(View.VISIBLE);
        }else{

        }

        vh.D_btn_accept.setOnClickListener(v->{
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("status",true);
            D_scheduleDb.update(sch.getKey(),hashMap).addOnSuccessListener(suc->{
                Toast.makeText(context,"Accepted!",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(context,"err ewith update"+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

        vh.D_btn_decline.setOnClickListener(v->{

            AlertDialog.Builder deleteDialog = new AlertDialog.Builder(context);
            deleteDialog.setTitle("Warning!");
            deleteDialog.setMessage("Are you sure delete this!");
            deleteDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ScheduleDb dao = new ScheduleDb();
                    dao.remove(sch.getKey()).addOnSuccessListener(suc->{
                        Toast.makeText(context,"Schedule Deleted!",Toast.LENGTH_SHORT).show();
                        notifyItemRemoved(position);
                    }).addOnFailureListener(er->{
                        Toast.makeText(context,""+er.getMessage(),Toast.LENGTH_SHORT).show();
                    });
                }

            });
            deleteDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context,"You select No",Toast.LENGTH_SHORT).show();
                }
            });
            deleteDialog.create().show();



        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
