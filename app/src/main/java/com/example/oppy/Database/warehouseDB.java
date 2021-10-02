package com.example.oppy.Database;

import com.example.oppy.DatabaseTable.SpNote;
import com.example.oppy.DatabaseTable.Warehouse;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class warehouseDB {

    private DatabaseReference databaseReference;

    public warehouseDB() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(warehouseDB.class.getSimpleName());
    }
    public Task<Void> add(Warehouse Spn){

        return databaseReference.push().setValue(Spn);
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
