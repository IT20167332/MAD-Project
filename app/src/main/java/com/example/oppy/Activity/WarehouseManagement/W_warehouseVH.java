package com.example.oppy.Activity.WarehouseManagement;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

public class W_warehouseVH extends RecyclerView.ViewHolder{

    TextView W_tv_item,w_tv_qty;
    Button Wbutton_delete;
    public W_warehouseVH(@NonNull @NotNull View itemView) {
        super(itemView);

        W_tv_item = itemView.findViewById(R.id.W_tv_item);
        w_tv_qty = itemView.findViewById(R.id.w_tv_qty);
        Wbutton_delete = itemView.findViewById(R.id.Wbutton_delete);
    }
}
