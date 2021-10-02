package com.example.oppy.Activity.gatekeeperManagement;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

public class G_arrivalScheduleVH extends RecyclerView.ViewHolder{

    public TextView G_txt_title,G_txt_time,G_text_date;
    public Button G_btn_accept,G_btn_complain;
    public ImageView G_dep_a,G_arr_a;
    public G_arrivalScheduleVH(@NonNull @NotNull View itemView) {
        super(itemView);
        G_txt_title = itemView.findViewById(R.id.G_txt_title);
        G_txt_time = itemView.findViewById(R.id.G_txt_time);
        G_text_date= itemView.findViewById(R.id.G_text_date);
        G_btn_accept = itemView.findViewById(R.id.G_btn_accept);
        G_btn_complain = itemView.findViewById(R.id.G_btn_complain);
        G_dep_a = itemView.findViewById(R.id.G_dep_a);
        G_arr_a = itemView.findViewById(R.id.G_arr_a);
    }
}
