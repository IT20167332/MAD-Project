package com.example.oppy.Activity.WarehouseManagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.Database.SpNoteDB;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.DatabaseTable.SpNote;
import com.example.oppy.R;

public class SPnotes extends AppCompatActivity {

    SpNoteDB db = new SpNoteDB();
    Sehedules newsehdu = null;
    TextView textView30,editTextDate;
    EditText editTextTextPersonName;
    Button W_button_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spnotes);

        textView30 = findViewById(R.id.textView30);
        editTextDate = findViewById(R.id.editTextDate);
        W_button_submit = findViewById(R.id.W_button_submit);
        editTextTextPersonName = findViewById(R.id.W_item);

        Intent getInten = getIntent();
        newsehdu = (Sehedules)getInten.getExtras().getParcelable("schduleObject");

        textView30.setText(newsehdu.getTitle());
        editTextDate.setText(newsehdu.getDate());
        String empId = "phIORbfRm2f07KNGlB5sIla36ed2";

        W_button_submit.setOnClickListener(v->{
        Toast.makeText(this,"Submit button click!",Toast.LENGTH_SHORT).show();
            String note = editTextTextPersonName.getText().toString();

            SpNote pnc = new SpNote(newsehdu.getDate(),newsehdu.getTitle(),empId,note,newsehdu.getKey());
            //Toast.makeText(this,"Note added!",Toast.LENGTH_SHORT).show();
            db.add(pnc);

        });
    }
}