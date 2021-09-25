package com.example.oppy.Database;

import com.example.oppy.DatabaseTable.Sehedules;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Queue;

public class ScheduleDb {

    private DatabaseReference databaseReference;

    public ScheduleDb() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Sehedules.class.getSimpleName());
    }

    public Task<Void> add(Sehedules seh){

        return databaseReference.push().setValue(seh);
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