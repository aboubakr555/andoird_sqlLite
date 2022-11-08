package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {
    EditText name;
    DBHelper DB;
    Button btndelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        name = (EditText)findViewById(R.id.nameToDelete);
        DB = new DBHelper(this);
        btndelete = (Button) findViewById(R.id.save_delete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();


                Boolean checkinsertdata = DB.deletedata(nameTXT);
                if(checkinsertdata==true)
                    Toast.makeText(delete.this, "Person Deleted", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(delete.this, "Person Not Deleted", Toast.LENGTH_SHORT).show();
                }

                delete.this.finish();
            }
        });

    }
}