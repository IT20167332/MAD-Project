package com.example.oppy.Activity.gatekeeperManagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oppy.Database.ComplaintDB;
import com.example.oppy.DatabaseTable.Complaint;
import com.example.oppy.DatabaseTable.Sehedules;
import com.example.oppy.R;

public class G_Complain extends AppCompatActivity {

    ComplaintDB comDb = new ComplaintDB();

    EditText D_et_description;
    TextView G_et_title2;
    Spinner Dspin;
    Button Submit,cansel;
    Sehedules newsehdu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcomplain);

        Intent getInten = getIntent();
        newsehdu = (Sehedules)getInten.getExtras().getParcelable("SendSch");

        D_et_description = findViewById(R.id.D_et_description);
        G_et_title2 = findViewById(R.id.G_et_title2);
        Dspin = findViewById(R.id.Dspinner);
        Submit = findViewById(R.id.G_submit);
        cansel = findViewById(R.id.G_cansel);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.priority,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Dspin.setAdapter(adapter);


        G_et_title2.setText(newsehdu.getTitle());

        Submit.setOnClickListener(v->{
            String description = D_et_description.getText().toString();
            if(TextUtils.isEmpty(D_et_description.getText())){
                D_et_description.setError("Description required!");
            }else if(!((description.length() >3)&&(description.length()<50))){
                D_et_description.setError("the description must contain letters in between 3 to 50");
            }else{
                String emid = "BRGzmN1orEe7YhuAtPtJAbBuuD53";//getInten.getExtras().getParcelable("empId");
                //String description = D_et_description.getText().toString();
                String priority = Dspin.getSelectedItem().toString();

                Complaint newCom = new Complaint(newsehdu.getKey(),emid,description,priority,newsehdu.getTitle());
                comDb.add(newCom);
            }



        });


    }

}