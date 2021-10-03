package com.example.oppy.Activity.managerManagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    TextView P_txt,C_txt,P_A_txt,P_D_txt,C_A_txt,C_D_txt;
    ImageButton Rf_button;
    ScheduleDb db = new ScheduleDb();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        P_txt = findViewById(R.id.P_txt);
        C_txt = findViewById(R.id.C_txt);
        Rf_button = findViewById(R.id.Rf_button);
        P_A_txt = findViewById(R.id.P_A_txt);
        P_D_txt = findViewById(R.id.P_D_txt);
        C_A_txt = findViewById(R.id.C_A_txt);
        C_D_txt = findViewById(R.id.C_D_txt);

        count();

        Rf_button.setOnClickListener(v->{
            Toast.makeText(this,"Reloading....",Toast.LENGTH_SHORT).show();
            count();
        });

    }

    private void count(){
        db.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                ArrayList<Sehedules> emps = new ArrayList<>();
                int C_count=0,C_A_count=0,C_D_count=0;
                int P_count = 0,P_D_count=0,P_A_count=0;

                for(DataSnapshot data : snapshot.getChildren()){
                    Sehedules emp = data.getValue(Sehedules.class);
                    //emp.setKey(data.getKey());
                    //emps.add(emp);
                    if((emp.isStatus() == true)&&(emp.isWarehouseCheck()==true)&&(emp.isGateCheck()==true)) {
                        C_count++;
                        if(emp.getType().toString().equals("ARRIVAL")){
                            C_A_count++;
                        }else{
                            C_D_count++;
                        }
                    }else{
                        P_count++;
                        if(emp.getType().toString().equals("ARRIVAL")){
                            P_A_count++;
                        }else{
                            P_D_count++;
                        }
                    }
                }
                C_txt.setText(String.valueOf(C_count));
                P_txt.setText(String.valueOf(P_count));

                C_A_txt.setText(String.valueOf(C_A_count));
                C_D_txt.setText(String.valueOf(C_D_count));
                P_A_txt.setText(String.valueOf(P_A_count));
                P_D_txt.setText(String.valueOf(P_D_count));
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }
}