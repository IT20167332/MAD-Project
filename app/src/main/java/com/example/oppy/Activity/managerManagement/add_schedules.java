package com.example.oppy.Activity.managerManagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.Database.warehouseDB;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.DatabaseTable.Warehouse;
import com.example.oppy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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



        warehouseDB wareDb = new warehouseDB();

        wareDb.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                ArrayList<String> item_x = new ArrayList<>();

                String[] item2;
                for(DataSnapshot data : snapshot.getChildren()){
                    Warehouse ware = data.getValue(Warehouse.class);
                     item_x.add(ware.getItem());
                }
                String[] item = GetStringArray(item_x);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(add_schedules.this, android.R.layout.simple_spinner_dropdown_item,item);
                spin_item.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


//        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,item2);
//        spin_item.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.type,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
                M_et_distance.setText(edit_sche.getDistance());

            }
        }catch(Exception e){

        }
        brn_addS.setOnClickListener(v->{
            //Toast.makeText(this, "submit button click1", Toast.LENGTH_SHORT).show();
            if(TextUtils.isEmpty(et_title.getText())){
                et_title.setError("Title is required!");
            }else if(TextUtils.isEmpty(et_qty.getText())){
                et_qty.setError("Qty is required!");
            }else if(TextUtils.isEmpty(et_date.getText())){
                et_date.setError("date is required!");
            }else if(TextUtils.isEmpty(et_time.getText())){
                et_time.setError("Time is required!");
            }else if(TextUtils.isEmpty(et_maxTime.getText())){
                et_maxTime.setError("Time is required!");
            }else if(TextUtils.isEmpty(et_destination.getText())){
                et_destination.setError("Destination is required!");
            }else if(TextUtils.isEmpty(et_vehicleNo.getText())){
                et_vehicleNo.setError("date is required!");
            }else if(TextUtils.isEmpty(M_et_distance.getText())){
                M_et_distance.setError("Distance is required!");
            }
            else{
                String title  = et_title.getText().toString();
                String arrivalDate = et_date.getText().toString();
                String arrivalTime = et_time.getText().toString();
                String D_date = et_vehicleNo.getText().toString();
                String destination = et_destination.getText().toString();
                String qty = et_qty.getText().toString();
                String D_time = et_maxTime.getText().toString();
                int distance = Integer.valueOf(M_et_distance.getText().toString());

                if(!chackValidate1(title)){
                    et_title.setError("First letter should upper case!");
                }
                else if(title.length() == 0){
                    et_title.setError("Title is not empty!");
                }


                else{
                    //validate is OK
                    if(edit_sche == null) {
                        //if you are not going to update this code will excute
                        Sehedules sehedules = new Sehedules(
                                title,
                                spin_item.getSelectedItem().toString(),
                                et_type.getSelectedItem().toString(),
                                qty,
                                arrivalDate,
                                arrivalTime,
                                D_date,
                                destination,
                                D_time,
                                false,
                                false,
                                false,
                                distance
                        );

                        scheduleDb.add(sehedules).addOnSuccessListener(suc -> {
                            Toast.makeText(this, "Schedule is inserted!", Toast.LENGTH_LONG).show();

                            et_title.setText("");
                            et_qty.setText("");
                            //et_type.setText(edit_sche.getType());
                            et_maxTime.setText("");
                            et_destination.setText("");
                            et_vehicleNo.setText("");
                            et_date.setText("");
                            et_time.setText("");
                            M_et_distance.setText("");


                        }).addOnFailureListener(er -> {
                            Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                    }else{
                        try {
                            HashMap<String,Object> hashMap = new HashMap<>();

                            hashMap.put("title",title);
                            hashMap.put("item",spin_item.getSelectedItem().toString());
                            hashMap.put("type",et_type.getSelectedItem().toString());
                            hashMap.put("qty",qty);
                            hashMap.put("date",arrivalDate);
                            hashMap.put("time",arrivalTime);
                            hashMap.put("vehicleNo",D_date);
                            hashMap.put("destination",destination);
                            hashMap.put("maxTime",D_time);
                            hashMap.put("distance",Integer.valueOf(M_et_distance.getText().toString()));

                            scheduleDb.update(edit_sche.getKey(),hashMap).addOnSuccessListener(suc->{
                                Toast.makeText(this,"Record is updated",Toast.LENGTH_SHORT).show();
                                //finish();
                                Intent intent= new Intent(this,schedules_list.class);
                                startActivity(intent);
                            }).addOnFailureListener(er->{
                                Toast.makeText(this,"err with update"+er.getMessage(),Toast.LENGTH_SHORT).show();

                            });
                        }catch (Exception e){
                            Toast.makeText(this,"err with update"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }


        });

    }

    public boolean chackValidate1(String word){
        char firstL = word.charAt(0);

        if(Character.isUpperCase(firstL) && (word != null)){
            return true;
        }else{
            return false;
        }
    }

    public static String[] GetStringArray(ArrayList<String> arr)
    {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }

        return str;
    }




}