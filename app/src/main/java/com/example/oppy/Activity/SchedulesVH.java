package com.example.oppy.Activity;

import android.telecom.TelecomManager;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

public class SchedulesVH extends RecyclerView.ViewHolder {

    public TextView text_name,text_date;
    public SchedulesVH(@NonNull @NotNull View itemView) {
        super(itemView);
        text_name = itemView.findViewById(R.id.text_name);
        text_date = itemView.findViewById(R.id.text_date);
    }
}
