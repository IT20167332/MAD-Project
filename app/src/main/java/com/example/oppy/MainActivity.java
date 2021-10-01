package com.example.oppy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oppy.Activity.AddEmployee;
import com.example.oppy.Activity.weDashboard;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            }


    public void onadd(View view){
        Intent intent = new Intent(this, weDashboard.class);
        startActivity(intent);
    }

}