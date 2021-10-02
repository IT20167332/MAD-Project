package com.example.oppy.Activity.managerManagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

import java.util.HashMap;

public class add_schedules<edit_sche> extends AppCompatActivity {

    EditText et_title,et_qty,et_date,et_time,et_maxTime,et_vehicleNo,et_destination,M_et_distance;
    Spinner spin_item,et_type;
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
        M_et_distance = findViewById(R.id.M_et_distance2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_item.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.type,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        et_type.setAdapter(adapter2);
        //spin_item.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        try{
            Intent get_i = getIntent();

            edit_sche = (Sehedules)get_i.getExtras().getParcelable("EDIT");
            if(edit_sche != null){
                Toast.makeText(this,"Update page",Toast.LENGTH_SHORT).show();
                brn_addS.setText("UPDATE");
                et_title.setText(edit_sche.getTitle());
                et_qty.setText(edit_sche.getQty());
                //et_type.setText(edit_sche.getType());
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
                        et_type.getSelectedItem().toString(),
                        et_qty.getText().toString(),
                        et_date.getText().toString(),
                        et_time.getText().toString(),
                        et_vehicleNo.getText().toString(),
                        et_destination.getText().toString(),
                        et_maxTime.getText().toString(),
                        false,
                        false,
                        false,
                        Integer.valueOf(M_et_distance.getText().toString())
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
                    hashMap.put("type",et_type.getSelectedItem().toString());
                    hashMap.put("qty",et_qty.getText().toString());
                    hashMap.put("date",et_date.getText().toString());
                    hashMap.put("time",et_time.getText().toString());
                    hashMap.put("vehicleNo",et_vehicleNo.getText().toString());
                    hashMap.put("destination",et_destination.getText().toString());
                    hashMap.put("maxTime",et_maxTime.getText().toString());
                    hashMap.put("distance",Integer.valueOf(M_et_distance.getText().toString()));

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