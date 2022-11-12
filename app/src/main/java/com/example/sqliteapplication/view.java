package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    DataBaseClass DB;
    Button back,filter;
    EditText fltrName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        DB = new DataBaseClass(this);
        listview = (ListView) findViewById(R.id.listview);
        ListP.clear();

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


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Intent MyIntent1 = new Intent(view.this,update.class);
                MyIntent1.putExtra("name",ListP.get(i).getName());
                MyIntent1.putExtra("lastName",ListP.get(i).getLastname());
                MyIntent1.putExtra("age",ListP.get(i).getAge());


                startActivity(MyIntent1);
                view.this.finish();
//                pa.notifyDataSetChanged();






            }
        });


    }
}