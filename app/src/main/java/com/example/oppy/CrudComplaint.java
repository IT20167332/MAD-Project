package com.example.oppy;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrudComplaint {
    private DatabaseReference databaseReference;
    public CrudComplaint(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(NewComplaint.class.getSimpleName());
    }
    public Task<Void> add(NewComplaint NewComp){
        return databaseReference.push().setValue(NewComp);
    }
}
