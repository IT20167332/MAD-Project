package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

public class add_schedules extends AppCompatActivity {

    EditText et_title,et_qty,et_date,et_time,et_maxTime,et_vehicleNo,et_destination,et_type;
    Spinner spin_item;

    ScheduleDb scheduleDb = new ScheduleDb();

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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_item.setAdapter(adapter);
        //spin_item.setOnItemSelectedListener(this);


    }
    public void onAdd(View view){

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

        scheduleDb.add(sehedules).addOnSuccessListener(suc->{
            Toast.makeText(this,"Sehedule is inserted",Toast.LENGTH_SHORT).show();

        }).addOnFailureListener(er->{
            Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
        });
    }
}