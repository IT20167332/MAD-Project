package com.example.oppy.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

public class SchedulesVH extends RecyclerView.ViewHolder {

    public TextView text_name,text_date,text_qty,text_type;
    public ConstraintLayout cl_card;
    Button btn_update,btn_delete;
    public SchedulesVH(@NonNull @NotNull View itemView) {
        super(itemView);
        text_name = itemView.findViewById(R.id.D_text_name);
        text_date = itemView.findViewById(R.id.D_text_date);
        text_qty = itemView.findViewById(R.id.D_txt_destand);
        text_type = itemView.findViewById(R.id.txt_type2);
        cl_card = itemView.findViewById(R.id.cl_card);
        btn_update = itemView.findViewById(R.id.btn_update);
        btn_delete = itemView.findViewById(R.id.btn_delete);
    }
}
