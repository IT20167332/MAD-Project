package com.example.oppy.Activity.driverManagement;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

public class D_schedulesVH extends RecyclerView.ViewHolder {

    public TextView D_text_name,D_text_date,D_txt_destand,D_text_type,D_destination;
    public ConstraintLayout D_cl_card;
    Button D_btn_accept,D_btn_decline,WH_delete;

    public D_schedulesVH(@NonNull @NotNull View itemView) {
        super(itemView);
        D_text_name = itemView.findViewById(R.id.D_text_name);
        D_text_date = itemView.findViewById(R.id.D_text_date);
        D_txt_destand = itemView.findViewById(R.id.D_txt_destand);
        //D_text_type = itemView.findViewById(R.id.D_txt_type2);
        D_cl_card = itemView.findViewById(R.id.cl_card);
        D_btn_accept = itemView.findViewById(R.id.D_btn_accept);
        D_btn_decline = itemView.findViewById(R.id.D_btn_decline);
        D_destination = itemView.findViewById(R.id.D_destination);
    }
}
