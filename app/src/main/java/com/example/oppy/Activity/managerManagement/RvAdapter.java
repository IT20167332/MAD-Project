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
        vh.text_type.setText(sch.getType());
        vh.text_qty.setText(sch.getQty());
        if(sch.isStatus() == true){
            vh.cl_card.setBackgroundColor(Color.rgb(51, 255, 109));
        }
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
