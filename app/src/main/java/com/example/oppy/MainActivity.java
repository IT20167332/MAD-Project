package com.example.oppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.oppy.Activity.AddEmployee;
import com.example.oppy.Activity.D_home;


public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onadd(View view){
        Intent intent = new Intent(this, D_home.class);
        startActivity(intent);
    }

}