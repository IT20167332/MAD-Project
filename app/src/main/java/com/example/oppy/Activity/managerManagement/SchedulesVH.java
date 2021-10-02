package com.example.oppy.Activity.managerManagement;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

public class SchedulesVH extends RecyclerView.ViewHolder {

    public TextView text_name,text_date,text_qty,text_type;
    public ConstraintLayout cl_card;
    public Button btn_update,btn_delete;
    public ImageView M_img_house_red,M_img_lorry_red,M_img_gate_red,M_img_house_green,M_img_lorry_green,M_img_gate_green;
    public ImageView M_arrow_G,M_arrow_R;
    public SchedulesVH(@NonNull @NotNull View itemView) {
        super(itemView);
        text_name = itemView.findViewById(R.id.D_text_name);
        text_date = itemView.findViewById(R.id.D_text_date);
        text_qty = itemView.findViewById(R.id.D_txt_destand);

        cl_card = itemView.findViewById(R.id.cl_card);
        btn_update = itemView.findViewById(R.id.btn_update);
        btn_delete = itemView.findViewById(R.id.btn_delete);

        M_arrow_G = itemView.findViewById(R.id.M_arrow_G);
        M_arrow_R = itemView.findViewById(R.id.M_arrow_R);

        M_img_house_red= itemView.findViewById(R.id.M_img_house_red);
        M_img_gate_red= itemView.findViewById(R.id.M_img_gate_red);
        M_img_lorry_red= itemView.findViewById(R.id.M_img_lorry_red);
        M_img_house_green= itemView.findViewById(R.id.M_img_house_green);
        M_img_lorry_green= itemView.findViewById(R.id.M_img_lorry_green);
        M_img_gate_green= itemView.findViewById(R.id.M_img_gate_green);


    }
}
