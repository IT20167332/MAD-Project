package com.example.oppy.Activity.managerManagement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
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

        vh.text_qty.setText(sch.getQty());

        String type = sch.getType();

        if(type.equals("ARRIVAL")){
            vh.M_arrow_G.setVisibility(View.VISIBLE);
        }else{vh.M_arrow_R.setVisibility(View.VISIBLE);}


        if((sch.isStatus() == true) &&(sch.isGateCheck() == true) && (sch.isWarehouseCheck()==true)){
            vh.cl_card.setBackgroundColor(Color.rgb(198, 232, 114));
            //198, 232, 114
        }else{vh.cl_card.setBackgroundColor(Color.rgb(247, 211, 166));}

        if(sch.isStatus() == true){
            vh.M_img_lorry_green.setVisibility(View.VISIBLE);
        }else{vh.M_img_lorry_red.setVisibility(View.VISIBLE);}

        if(sch.isGateCheck() == true){
            vh.M_img_gate_green.setVisibility(View.VISIBLE);
        }else{vh.M_img_gate_red.setVisibility(View.VISIBLE);}

        if(sch.isWarehouseCheck()==true){
            vh.M_img_house_green.setVisibility(View.VISIBLE);
        }else{vh.M_img_house_red.setVisibility(View.VISIBLE);}

        vh.btn_update.setOnClickListener(v->{

            Intent intent2 = new Intent(context, add_schedules.class);
            intent2.putExtra("EDIT", (Parcelable)sch);
            context.startActivity(intent2);

        });

        vh.btn_delete.setOnClickListener(v->{

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
                        Intent intent2 = new Intent(context,schedules_list.class);
                        context.startActivity(intent2);
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
