package com.example.oppy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oppy.DatabaseTable.Employee;
import com.example.oppy.Database.EmployeeDb;
import com.example.oppy.R;

public class AddEmployee extends AppCompatActivity {


    EditText et_name;
    EditText et_password;
    EditText et_email;
    EditText et_phone;
    Button btn_submit;
    EditText et_position;

    //database object
    EmployeeDb dao = new EmployeeDb();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        et_name = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        et_position = findViewById(R.id.et_postion);
        btn_submit = findViewById(R.id.btn_submit);
    }


    public void onSubmit(View view){
        Employee newEmployee = new Employee(
                et_name.getText().toString(),
                et_password.getText().toString(),
                et_email.getText().toString(),
                Integer.parseInt(et_phone.getText().toString()),
                et_position.getText().toString()
        );
        dao.add(newEmployee).addOnSuccessListener(suc->{
            Toast.makeText(this,"recod is inserted",Toast.LENGTH_SHORT).show();

        }).addOnFailureListener(er->{
            Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
        });
    }
}