package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void insert(View v){
        Intent MyIntent1 = new Intent(MainActivity.this,insert.class);
        startActivity(MyIntent1);

    }
//    public void update(View v){
//        Intent MyIntent1 = new Intent(MainActivity.this,update.class);
//        startActivity(MyIntent1);
//    }
//    public void delete(View v){
//        Intent MyIntent1 = new Intent(MainActivity.this,delete.class);
//        startActivity(MyIntent1);
//    }
    public void view(View v){
        Intent MyIntent1 = new Intent(MainActivity.this,view.class);
        startActivity(MyIntent1);
    }


}