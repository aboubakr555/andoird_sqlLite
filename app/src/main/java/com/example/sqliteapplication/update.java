package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {
    EditText name,lastname,age;
    DataBaseClass DB;
    Button btnupdate,back,btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = (EditText)findViewById(R.id.name);

        btndelete = (Button) findViewById(R.id.save_delete);
        btnupdate = (Button) findViewById(R.id.save_update);
        back = (Button) findViewById(R.id.back);

        name.setKeyListener(null);
        name.setEnabled(false);
        lastname = (EditText)findViewById(R.id.lastname);
        age = (EditText)findViewById(R.id.age);

        DB = new DataBaseClass(this);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        lastname.setText(intent.getStringExtra("lastName"));
        age.setText(intent.getStringExtra("age"));




        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();


                Boolean checkinsertdata = DB.deletePerson(nameTXT);
                if(checkinsertdata==true)
                    Toast.makeText(update.this, "Person Deleted", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(update.this, "Person Not Deleted", Toast.LENGTH_SHORT).show();
                }

                update.this.finish();
            }
        });






        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String lastnametTXT = lastname.getText().toString();
                String ageTXT = age.getText().toString();

                Boolean checkinsertdata = DB.updatePerson(nameTXT, lastnametTXT, ageTXT);
                if(checkinsertdata==true){

                    Toast.makeText(update.this, "Person Updated", Toast.LENGTH_SHORT).show();

                    update.this.finish();}
                else{
                    Toast.makeText(update.this, "Person Not Updated", Toast.LENGTH_SHORT).show();

                }


            }


        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update.this.finish();
            }
        });
    }
}