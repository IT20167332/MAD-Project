package com.example.oppy.Activity.gatekeeperManagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.Database.ComplaintDB;
import com.example.oppy.DatabaseTable.Complaint;
import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RV_complant_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Context context;

    ArrayList<Complaint> list = new ArrayList<>();
    public RV_complant_adapter(Context ctx) {
        this.context = ctx;
    }
    public void setItems(ArrayList<Complaint> emp){
        list.addAll(emp);
    }
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_complant,parent,false);
        return new G_complantVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        G_complantVH vh = (G_complantVH) holder;
        //Sehedules emp = list.get(position);
        Complaint com = list.get(position);

        vh.G_textdes.setText(com.getDescription());
        vh.G_textTitle.setText(com.getSTitle());

        vh.btn_delete.setOnClickListener(v->{

            ComplaintDB dao = new ComplaintDB();
            dao.remove(com.getKey()).addOnSuccessListener(suc->{
                Toast.makeText(context,"Complaint Deleted!",Toast.LENGTH_SHORT).show();
                //notifyItemRemoved(position);
                Intent intent = new Intent(context, MY_complaint_activity.class);
                context.startActivity(intent);
            }).addOnFailureListener(er->{
                Toast.makeText(context,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
