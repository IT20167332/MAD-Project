package com.example.oppy.Activity.gatekeeperManagement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.oppy.Database.ComplaintDB;
import com.example.oppy.DatabaseTable.Complaint;
import com.example.oppy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MY_complaint_activity extends AppCompatActivity {


    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RV_complant_adapter adapter;
    //ScheduleDb dao;
    ComplaintDB dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_complaint);

        swipeRefreshLayout = findViewById(R.id.comSwip);
        recyclerView = findViewById(R.id.comRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new RV_complant_adapter(this);
        recyclerView.setAdapter(adapter);
        dao = new ComplaintDB();
        loadData();

    }

    private  void loadData(){
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                ArrayList<Complaint> emps = new ArrayList<>();
                for(DataSnapshot data : snapshot.getChildren()){
                    Complaint emp = data.getValue(Complaint.class);
                    emp.setKey(data.getKey());
                    emps.add(emp);
                }
                adapter.setItems(emps);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}