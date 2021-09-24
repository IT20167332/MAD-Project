package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.oppy.R;

public class Sed_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sed_menu);
    }

    public void btn_addE(View view){

        Intent intent = new Intent(this,AddEmployee.class);
        startActivity(intent);

    }
    public void btn_addS(View view){

        Intent intent = new Intent(this,schedules_list.class);
        startActivity(intent);
    }
    public void btn_list(View view){

    }
}