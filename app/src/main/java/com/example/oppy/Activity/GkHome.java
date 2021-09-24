package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.oppy.R;

public class GkHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gk_home2);
    }

    public void btnArrival(View view) {
        Intent intent = new Intent(this, Main_arrival.class);
        startActivity(intent);
    }
    public void btnDeparture(View view) {
        Intent intent = new Intent(this, Main_depature.class);
        startActivity(intent);
    }
}