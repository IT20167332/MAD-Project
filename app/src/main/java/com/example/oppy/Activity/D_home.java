package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.oppy.R;

public class D_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhome);
    }
    public void gosch(View view){
        Intent intent = new Intent(this, D_schedule.class);
        startActivity(intent);
    }
    public void gotrav(View view){
        Intent intent = new Intent(this, D_travel.class);
        startActivity(intent);
    }
}

