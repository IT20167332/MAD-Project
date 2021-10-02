package com.example.oppy.Activity.gatekeeperManagement;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

import org.jetbrains.annotations.NotNull;

public class G_complantVH extends RecyclerView.ViewHolder {

    public TextView G_textTitle,G_textdes;
    public Button btn_delete;
    public G_complantVH(@NonNull @NotNull View itemView) {
        super(itemView);
        G_textTitle = itemView.findViewById(R.id.textView29);
        G_textdes = itemView.findViewById(R.id.textView25);
        btn_delete = itemView.findViewById(R.id.button12);

    }
}
