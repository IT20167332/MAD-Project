package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

import java.util.HashMap;

public class add_schedules<edit_sche> extends AppCompatActivity {

    EditText et_title,et_qty,et_date,et_time,et_maxTime,et_vehicleNo,et_destination,et_type;
    Spinner spin_item;
    Button brn_addS;

    ScheduleDb scheduleDb = new ScheduleDb();
    private Sehedules edit_sche = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedules);

        et_title = findViewById(R.id.et_title);
        et_qty = findViewById(R.id.et_qty);
        et_date = findViewById(R.id.et_date);
        et_time = findViewById(R.id.et_time);
        et_maxTime = findViewById(R.id.et_time2);
        et_destination = findViewById(R.id.et_destination);
        et_vehicleNo = findViewById(R.id.et_Vno);
        spin_item = findViewById(R.id.spin_item);
        et_type = findViewById(R.id.et_type);
        brn_addS = findViewById(R.id.brn_addS);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_item.setAdapter(adapter);
        //spin_item.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        try{
            Intent get_i = getIntent();

            edit_sche = (Sehedules)get_i.getExtras().getParcelable("EDIT");
            if(edit_sche != null){
                Toast.makeText(this,"Update page",Toast.LENGTH_SHORT).show();
                brn_addS.setText("UPDATE");
                et_title.setText(edit_sche.getTitle());
                et_qty.setText(edit_sche.getQty());
                et_type.setText(edit_sche.getType());
                et_maxTime.setText(edit_sche.getTime());
                et_destination.setText(edit_sche.getDestination());
                et_vehicleNo.setText(edit_sche.getVehicleNo());
                et_date.setText(edit_sche.getDate());
                et_time.setText(edit_sche.getTime());

            }
        }catch(Exception e){

        }

        brn_addS.setOnClickListener(v->{
            //Toast.makeText(this, "submit button click1", Toast.LENGTH_SHORT).show();
            if(edit_sche == null) {
                //if you are not going to update this code will excute
                Sehedules sehedules = new Sehedules(
                        et_title.getText().toString(),
                        spin_item.getSelectedItem().toString(),
                        et_type.getText().toString(),
                        et_qty.getText().toString(),
                        et_date.getText().toString(),
                        et_time.getText().toString(),
                        et_vehicleNo.getText().toString(),
                        et_destination.getText().toString(),
                        et_maxTime.getText().toString(),
                        false,
                        false,
                        false
                );

                scheduleDb.add(sehedules).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "Sehedule is inserted", Toast.LENGTH_SHORT).show();

                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }else{
                try {
                    HashMap<String,Object> hashMap = new HashMap<>();

                    hashMap.put("title",et_title.getText().toString());
                    hashMap.put("item",spin_item.getSelectedItem().toString());
                    hashMap.put("type",et_type.getText().toString());
                    hashMap.put("qty",et_qty.getText().toString());
                    hashMap.put("date",et_date.getText().toString());
                    hashMap.put("time",et_time.getText().toString());
                    hashMap.put("vehicleNo",et_vehicleNo.getText().toString());
                    hashMap.put("destination",et_destination.getText().toString());
                    hashMap.put("maxTime",et_maxTime.getText().toString());
//                    hashMap.put("status",edit_sche.isStatus());
//                    hashMap.put("isWarehouseCheck",edit_sche.isWarehouseCheck());
//                    hashMap.put("isGateCheck",edit_sche.isGateCheck());

                    scheduleDb.update(edit_sche.getKey(),hashMap).addOnSuccessListener(suc->{
                        Toast.makeText(this,"Record is updated",Toast.LENGTH_SHORT).show();
                        finish();
                    }).addOnFailureListener(er->{
                        Toast.makeText(this,"err ewith update"+er.getMessage(),Toast.LENGTH_SHORT).show();

                    });
                }catch (Exception e){
                    Toast.makeText(this,"err ewith update"+e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}