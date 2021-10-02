package com.example.oppy.Database;

import com.example.oppy.DatabaseTable.Complaint;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class ComplaintDB {


    private DatabaseReference databaseReference;

    public ComplaintDB() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Complaint.class.getSimpleName());
    }

    public Task<Void> add(Complaint complaint){

        return databaseReference.push().setValue(complaint);
    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }

    public Query get(){
        return databaseReference.orderByKey();
    }
}
