package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oppy.CrudComplaint;
import com.example.oppy.NewComplaint;
import com.example.oppy.R;

public class Complaint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        TextView Complaint=(TextView)findViewById(R.id.textView9);
        TextView Give_Complaint=(TextView)findViewById(R.id.textView10);
        final EditText Edit1=(EditText)findViewById(R.id.edit1);
        Button btnSubmit = findViewById(R.id.button5);
        CrudComplaint Crud = new CrudComplaint();
        btnSubmit.setOnClickListener(v->{
            NewComplaint NewComp = new NewComplaint(Edit1.getText().toString());
            Crud.add(NewComp).addOnSuccessListener(suc->{
                Toast.makeText(this, "Complaint is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, "failed insertion", Toast.LENGTH_SHORT).show();
            });
        });

    }
    public void onClickSubmit(){

    }
}