package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insert extends AppCompatActivity {
    EditText name,lastname,age;
    DataBaseClass DB;
    Button btninsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        name = (EditText)findViewById(R.id.name);
        lastname = (EditText)findViewById(R.id.lastname);
        age = (EditText)findViewById(R.id.age);
        DB = new DataBaseClass(this);
        btninsert = (Button) findViewById(R.id.save_insert);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String lastnametTXT = lastname.getText().toString();
                String ageTXT = age.getText().toString();

                Boolean checkinsertdata = DB.insertPerson(nameTXT, lastnametTXT, ageTXT);
                if(checkinsertdata==true)
                    Toast.makeText(insert.this, "Person Inserted", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(insert.this, "Person Not Inserted", Toast.LENGTH_SHORT).show();
                     }

                insert.this.finish();
            }


        });
    }



}
