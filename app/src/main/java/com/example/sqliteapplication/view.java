package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class view extends AppCompatActivity {
    ListView listview;
    ArrayList<Person> ListP = new ArrayList<Person>();
    Person_Adapter pa;
    Cursor mCursor;
    DBHelper DB;
    Button back,filter;
    EditText fltrName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        DB = new DBHelper(this);
        listview = (ListView) findViewById(R.id.listview);

        mCursor = DB.getdata();


        mCursor.moveToFirst();
        while(!mCursor.isAfterLast()) {
            ListP.add(new Person(mCursor.getString(0),mCursor.getString(1),mCursor.getString(2))); //add the item
            mCursor.moveToNext();
        }


        pa = new Person_Adapter(getApplicationContext(),ListP);
        pa.notifyDataSetChanged();
        listview.setAdapter(pa);
        back = (Button) findViewById(R.id.backTo);
        filter = (Button) findViewById(R.id.filterbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.this.finish();

            }
        });
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListP.clear();
                fltrName = (EditText)findViewById(R.id.filter) ;
                if(fltrName.getText().toString().isEmpty()){
                    mCursor = DB.getdata();
                }
                else{
                    mCursor = DB.getdata(fltrName.getText().toString());
                }

                if(mCursor.getCount()>0){


                mCursor.moveToFirst();
                while(!mCursor.isAfterLast()) {
                    ListP.add(new Person(mCursor.getString(0),mCursor.getString(1),mCursor.getString(2))); //add the item
                    mCursor.moveToNext();
                }


                pa = new Person_Adapter(getApplicationContext(),ListP);
                pa.notifyDataSetChanged();
                listview.setAdapter(pa);}
                else{
                    Toast.makeText(view.this, "Person Not found", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}