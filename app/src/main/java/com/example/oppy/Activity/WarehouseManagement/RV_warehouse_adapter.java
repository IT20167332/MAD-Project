package com.example.oppy.Activity.WarehouseManagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.Database.warehouseDB;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.DatabaseTable.Warehouse;
import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RV_warehouse_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {


    warehouseDB warehousedb = new warehouseDB();
    private Context context;
    ArrayList<Warehouse> list = new ArrayList<>();
    public RV_warehouse_adapter(Context ctx) {
        this.context = ctx;
    }
    public void setItems(ArrayList<Warehouse> emp){
        list.addAll(emp);
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.warehouse_card,parent,false);
        return new W_warehouseVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        W_warehouseVH vh = (W_warehouseVH) holder;
        Warehouse emp = list.get(position);

        vh.W_tv_item.setText(emp.getItem());
        vh.w_tv_qty.setText(String.valueOf(emp.getQty()));

        vh.Wbutton_delete.setOnClickListener(v->{
            //delete
            warehouseDB dao = new warehouseDB();
            dao.remove(emp.getKey()).addOnSuccessListener(suc->{
                Toast.makeText(context,"Item Deleted!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,warehouseList.class);
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
