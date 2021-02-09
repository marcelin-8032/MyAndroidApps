package com.example.myframeworkapp.login;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myframeworkapp.R;

import java.util.ArrayList;

import DAO.DatabaseHelper;

public class SecondActivity extends AppCompatActivity {

    ListView listContact;
    DatabaseHelper myDB;
    ArrayList<Contact> contactList;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_login);

        DatabaseHelper myDB= new DatabaseHelper(this);

        contactList=new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRow=data.getCount();

        if(numRow==0){
            Toast.makeText(SecondActivity.this,"No contact entered in the list",Toast.LENGTH_LONG).show();
        }else{
           // int i=0;
            while (data.moveToNext()){
                    contact =new Contact(data.getString(1),data.getString(2), data.getString(3), data.getString(4));
                   contactList.add(contact);
            }

            FourColumn_ListAdapter adapter= new  FourColumn_ListAdapter(this, R.layout.list_adapter_view, contactList);
            listContact = (ListView) findViewById(R.id.listView_Contact);
            listContact.setAdapter(adapter);
        }
    }
}

//
//        Intent listIntent = getIntent();
//        String nom = listIntent.getStringExtra("Nom");
//        String prenom=listIntent.getStringExtra("Prenom");
//        String email=listIntent.getStringExtra("Email");
//        String tel=listIntent.getStringExtra("Telephone");
//
//       List<String> listItems = new ArrayList<>();
//
//        listItems.add(nom);
//        listItems.add(prenom);
//        listItems.add(email);
//        listItems.add(tel);
//
//        String[] items={};
//
//        items = listItems.toArray(new String[listItems.size()]);
//        ArrayAdapter<String> adapter= new ArrayAdapter<String>(SecondActivity.this,android.R.layout.simple_list_item_1, items);
//        listContact.setAdapter(adapter);

