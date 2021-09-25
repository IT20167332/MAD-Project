package com.example.oppy.Activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.oppy.Database.ScheduleDb;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class D_schedule extends AppCompatActivity {


    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    D_RvAdapter adapter;
    ScheduleDb dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dschedule);

        swipeRefreshLayout = findViewById(R.id.D_swip);
        recyclerView = findViewById(R.id.D_rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new D_RvAdapter(this);
        recyclerView.setAdapter(adapter);

        dao = new ScheduleDb();
        loadData();
    }

    private void loadData() {
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( @NotNull DataSnapshot snapshot) {
                ArrayList<Sehedules> schs = new ArrayList<>();
                for(DataSnapshot data: snapshot.getChildren()){
                    Sehedules sch = data.getValue(Sehedules.class);
                    sch.setKey(data.getKey());
                    schs.add(sch);
                }
                adapter.setItems(schs);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}