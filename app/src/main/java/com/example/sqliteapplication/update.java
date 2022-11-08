package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {
    EditText name,lastname,age;
    DBHelper DB;
    Button btnupdate,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name = (EditText)findViewById(R.id.name);
        lastname = (EditText)findViewById(R.id.lastname);
        age = (EditText)findViewById(R.id.age);
        DB = new DBHelper(this);
        btnupdate = (Button) findViewById(R.id.save_update);
        back = (Button) findViewById(R.id.back);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String lastnametTXT = lastname.getText().toString();
                String ageTXT = age.getText().toString();

                Boolean checkinsertdata = DB.updateuserdata(nameTXT, lastnametTXT, ageTXT);
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