package com.example.oppy.Activity.WarehouseManagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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

public class warehouseList extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RV_warehouse_adapter adapter;
    warehouseDB dao;
    Button W_button_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_list);

        swipeRefreshLayout = findViewById(R.id.wareswip);
        recyclerView = findViewById(R.id.warerv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        W_button_add = findViewById(R.id.W_button_add);
        adapter = new RV_warehouse_adapter(this);
        recyclerView.setAdapter(adapter);
        dao = new warehouseDB();
        loadData();

        W_button_add.setOnClickListener(v->{
            Intent intent = new Intent(this,StockReport.class);
            startActivity(intent);
        });


    }
    private  void loadData(){
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                ArrayList<Warehouse> emps = new ArrayList<>();
                for(DataSnapshot data : snapshot.getChildren()){
                    Warehouse emp = data.getValue(Warehouse.class);
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