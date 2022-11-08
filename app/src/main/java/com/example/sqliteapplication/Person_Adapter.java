package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Person_Adapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Person> personArrayList = new ArrayList<Person>();

    public Person_Adapter(Context context, ArrayList<Person> personArrayList) {
        this.context = context;
        this.personArrayList = personArrayList;

    }

    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return personArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);
        View v = li.inflate(R.layout.customrow,null);

        TextView txtNom = (TextView) v.findViewById(R.id.txtNAME);
        TextView txtDesc = (TextView) v.findViewById(R.id.txtLAST);
        TextView txtAge = (TextView) v.findViewById(R.id.txtAGE);


        txtNom.setText(personArrayList.get(i).getName());
        txtDesc.setText(personArrayList.get(i).getLastname());
        txtAge.setText(personArrayList.get(i).getAge());

        return v;
    }
}
