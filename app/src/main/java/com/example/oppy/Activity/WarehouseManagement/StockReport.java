package com.example.oppy.Activity.WarehouseManagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.Database.warehouseDB;
import com.example.oppy.DatabaseTable.Warehouse;
import com.example.oppy.R;

public class StockReport extends AppCompatActivity {

    warehouseDB db = new warehouseDB();
    EditText W_item,W_qty,editTextDate2;
    Button W_button_submit;
    String empId = "phIORbfRm2f07KNGlB5sIla36ed2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_report);

        W_item = findViewById(R.id.W_item);
        W_qty = findViewById(R.id.W_qty);
        editTextDate2 = findViewById(R.id.editTextDate2);
        W_button_submit = findViewById(R.id.W_button_submit);

       W_button_submit.setOnClickListener(v->{
           String item = W_item.getText().toString();

           if(TextUtils.isEmpty(W_item.getText())){
               W_item.setError("The item name required!");
           }
           else if(TextUtils.isEmpty(W_qty.getText())){
               W_qty.setError("Qty required!");
           }else if(TextUtils.isEmpty(editTextDate2.getText())){
               editTextDate2.setError("Date is required!");
           }else if(!(item.length() > 3)){
               W_item.setError("The item must have more than 3 letters! ");
           }
           else{
               int qty = Integer.valueOf(W_qty.getText().toString());
               Warehouse wh= new Warehouse(W_item.getText().toString(),editTextDate2.getText().toString(),empId,qty);

               db.add(wh);

               Intent intent = new Intent(this,warehouseList.class);
               startActivity(intent);
           }
        });


    }

}