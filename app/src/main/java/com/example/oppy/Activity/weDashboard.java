package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.oppy.R;

public class weDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_dashboard);
    }
    public void schedule(View view){
        Intent intent = new Intent(this,Schedules.class);
        startActivity(intent);
    }
    public void spnote(View view){
        Intent intent = new Intent(this,SPnotes .class);
        startActivity(intent);
    }
    public void streport(View view){
        Intent intent = new Intent(this,StockReport .class);
        startActivity(intent);
    }
}