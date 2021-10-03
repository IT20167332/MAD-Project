package com.example.oppy.Activity.WarehouseManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.R;

public class weDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_dashboard);
    }

    public void schedule(View view){
        Intent intent = new Intent(this, RV_activity.class);
        startActivity(intent);
    }

    public void streport(View view){
        Intent intent = new Intent(this, warehouseList.class);
        startActivity(intent);
    }
}