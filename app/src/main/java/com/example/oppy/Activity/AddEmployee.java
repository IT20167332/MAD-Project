package com.example.oppy.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.oppy.DatabaseTable.Employee;
import com.example.oppy.Database.EmployeeDb;
import com.example.oppy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class AddEmployee extends AppCompatActivity {


    EditText et_name;
    EditText et_password;
    EditText et_email;
    EditText et_phone;
    Button btn_submit;
    //EditText et_position;
    RadioButton rb_driver,rb_manager,rb_warehouse,rb_gate;
    String position = "noJob";
    RadioGroup rbg_position;

    //database object
    EmployeeDb dao = new EmployeeDb();
    String Emailvalidate = "^[A-Za-z0-9+_.-]+@(.+)$";
    ProgressDialog prd;

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        et_name = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        //et_position = findViewById(R.id.et_postion);
        btn_submit = findViewById(R.id.btn_submit);

        prd = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        rb_driver = findViewById(R.id.rb_driver);
        rb_gate = findViewById(R.id.rb_gate);
        rb_manager = findViewById(R.id.rb_manager);
        rb_warehouse = findViewById(R.id.rb_werehouse);
        rbg_position = findViewById(R.id.rbg_position);




    }


    public void onSubmit(View view){

        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String name = et_name.getText().toString();
        String phone = et_phone.getText().toString();
        //String position = et_position.getText().toString();

        if(rb_warehouse.isChecked()){
            position = "Warehouse Keeper";
        }else if(rb_manager.isChecked()){
            position = "Manager";
        }else if(rb_gate.isChecked()){
            position = "Gate Keeper";
        }else if(rb_driver.isChecked()){
            position = "Driver";
        }else{

        }




        if(!email.matches(Emailvalidate)){
            et_email.setError("Enter Connext Email");
        }else if(password.isEmpty()||password.length()<5){
            et_password.setError("Enter proper password");
        }else{
            prd.setMessage("Please Wait While Registration...");
            prd.setTitle("Registration");
            prd.setCanceledOnTouchOutside(false);
            prd.show();



            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Employee newEmployee = new Employee(
                                        name,
                                        password,
                                        email,
                                        Integer.parseInt(phone),
                                        position
                                );
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(newEmployee).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            prd.dismiss();
                                            Toast.makeText(AddEmployee.this,"Successful",Toast.LENGTH_SHORT).show();


                                        }else{
                                            prd.dismiss();
                                            Toast.makeText(AddEmployee.this,"Not Successful",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });


                            }else{
                                prd.dismiss();
                                Toast.makeText(AddEmployee.this,"Not Successful",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }


    }
}