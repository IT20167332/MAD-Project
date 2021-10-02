package com.example.oppy.Activity.WarehouseManagement;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oppy.R;

public class W_scheduleVH extends RecyclerView.ViewHolder {

    public TextView txt_title,w_txt_date,w_txt_item,w_txt_qtys;
    public Button W_btm_submit,W_btn_more;
    public W_scheduleVH(View itemView){
        super(itemView);

        txt_title = itemView.findViewById(R.id.txt_title);
        w_txt_date = itemView.findViewById(R.id.w_txt_date);
        w_txt_item = itemView.findViewById(R.id.w_txt_item);
        w_txt_qtys = itemView.findViewById(R.id.w_txt_qtys);
        W_btm_submit = itemView.findViewById(R.id.W_btm_submit);
        W_btn_more = itemView.findViewById(R.id.W_btn_more);
    }
}
