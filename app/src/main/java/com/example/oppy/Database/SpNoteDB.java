package com.example.oppy.Database;

import com.example.oppy.DatabaseTable.SpNote;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class SpNoteDB {

    private DatabaseReference databaseReference;

    public SpNoteDB() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(SpNoteDB.class.getSimpleName());
    }
    public Task<Void> add(SpNote Spn){

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
