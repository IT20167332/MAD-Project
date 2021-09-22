package com.example.oppy.Database;

import com.example.oppy.DatabaseTable.Employee;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeDb {

    private DatabaseReference databaseReference;
    public EmployeeDb(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Employee.class.getSimpleName());
    }

    public Task<Void> add(Employee emp){
        return databaseReference.push().setValue(emp);
    }
}
