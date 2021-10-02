package com.example.oppy.Activity.driverManagement;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class D_travel extends AppCompatActivity {

    ScheduleDb dao = new ScheduleDb();
    TextView t_tv2;
    Button t_b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtravel);
        t_tv2 = findViewById(R.id.t_tv2);
        t_b1 = findViewById(R.id.t_b1);


        AtomicInteger TotalDistance = new AtomicInteger();
        t_b1.setOnClickListener(v->{


            Toast.makeText(this, "Calculating.....", Toast.LENGTH_SHORT).show();
            dao.get().addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    ArrayList<Sehedules> emps = new ArrayList<>();
                    int des2=0;
                    for(DataSnapshot data : snapshot.getChildren()){
                        Sehedules emp = data.getValue(Sehedules.class);
                        //emp.setKey(data.getKey());
                        //emps.add(emp);
                        if(emp.isStatus() == true) {
                            int dis = emp.getDistance();
                            des2 += dis;
                            Log.i("myTag",String.valueOf(des2));
                            t_tv2.setText(String.valueOf(des2));

                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            //TotalDistance.set(distance.size());
            //TotalDistance = 20;

        });

    }
}