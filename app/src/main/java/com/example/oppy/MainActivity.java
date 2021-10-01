package com.example.oppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oppy.Activity.Sed_menu;
import com.example.oppy.Database.EmployeeDb;
import com.example.oppy.DatabaseTable.Employee;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity {


    EditText et_username,et_password;

    EmployeeDb db = new EmployeeDb();
    private ProgressDialog prd;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_User_name);
        et_password = findViewById(R.id.et_UPasssword);
        prd = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();



    }
    public void onadd(View view){
        String email = et_username.getText().toString();
        String password= et_password.getText().toString();

        if(password.isEmpty()){
            et_password.setError("Password is required");
            et_password.requestFocus();
            return;
        }
        if(email.isEmpty()){
            et_username.setError("Email is required");
            et_username.requestFocus();
            return;
        }
        prd.setMessage("Please Wait While Login.....");
        prd.setTitle("Login");
        prd.setCanceledOnTouchOutside(false);
        prd.show();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    prd.dismiss();
                    Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();

                    //rederect function
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    reference = FirebaseDatabase.getInstance().getReference("Users");
                    userID = user.getUid();

                    reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            Employee employee = snapshot.getValue(Employee.class);

                            if(employee != null){
                                //Toast.makeText(MainActivity.this,"position = ",Toast.LENGTH_SHORT).show();
                                LoadActivity(employee.getPosition());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {
                            Toast.makeText(MainActivity.this,"Not Successful get Employee",Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    prd.dismiss();
                    Toast.makeText(MainActivity.this,"Not Successful",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void LoadActivity(String position){

        if(position.equals("Manager")){
            Intent intent = new Intent(MainActivity.this,Sed_menu.class);
            startActivity(intent);
        }else if(position.equals("Warehouse Keeper")){
            Toast.makeText(MainActivity.this,"position = "+position,Toast.LENGTH_SHORT).show();
        }else if(position.equals("Gate Keeper")){
            Toast.makeText(MainActivity.this,"position = "+position,Toast.LENGTH_SHORT).show();



        }else if(position.equals("Driver")){
            Toast.makeText(MainActivity.this,"position = "+position,Toast.LENGTH_SHORT).show();

        }


    }



}

//    try{
//            String uname = et_username.getText().toString();
//
//            if(uname != null){
//            char Fletter = uname.charAt(0);
//
//            switch(Fletter){
//
//            case 'M':
//            Toast.makeText(this,"M",Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(this, Sed_menu.class);
//        startActivity(intent);
//
//        break;
//        case 'D':
//        Toast.makeText(this,"D",Toast.LENGTH_SHORT).show();
//        break;
//
//        case 'G':
//        Toast.makeText(this,"G",Toast.LENGTH_SHORT).show();
//        break;
//        case 'W':
//        Toast.makeText(this,"W",Toast.LENGTH_SHORT).show();
//        break;
//default:
//        Toast.makeText(this,"User Name incorrect!",Toast.LENGTH_SHORT).show();
//        }
//        }else {
//        Toast.makeText(this,"Please enter user name",Toast.LENGTH_SHORT).show();
//        }
//        }catch (Exception e){
//        Toast.makeText(this,"Please enter user name",Toast.LENGTH_SHORT).show();
//        }