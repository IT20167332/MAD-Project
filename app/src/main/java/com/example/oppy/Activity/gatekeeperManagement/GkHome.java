package com.example.oppy.Activity.gatekeeperManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.R;

public class GkHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gk_home2);
    }

    public void btnArrival(View view) {
        Intent intent = new Intent(this, RV_arrival_activity.class);
        startActivity(intent);
    }
    public void btnDeparture(View view) {
        Intent intent = new Intent(this, MY_complaint_activity.class);
        startActivity(intent);
    }
}