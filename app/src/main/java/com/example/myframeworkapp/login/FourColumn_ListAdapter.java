package com.example.myframeworkapp.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.myframeworkapp.R;

import java.util.ArrayList;

public class FourColumn_ListAdapter extends ArrayAdapter<Contact> {

    private LayoutInflater mInflater;
    private ArrayList<Contact> contacts;
    private int mViewResourceId;

    public FourColumn_ListAdapter(@NonNull Context context,int textViewresourceId,@NonNull ArrayList<Contact> contacts) {
        super(context, textViewresourceId, contacts);
        this.contacts=contacts;
        mInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId=textViewresourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       convertView=mInflater.inflate(mViewResourceId, null);
       Contact contact=contacts.get(position);

       if(contact != null){
           TextView nom=(TextView)convertView.findViewById(R.id.text_Nom);
           TextView prenom=(TextView)convertView.findViewById(R.id.text_Prenom);
           TextView email=(TextView)convertView.findViewById(R.id.text_email);
           TextView tel=(TextView)convertView.findViewById(R.id.text_tel);

           if(nom != null){
               nom.setText((contact.getNom()));
           }

           if(prenom != null){
               prenom.setText((contact.getPrénom()));
           }

           if(email != null){
               email.setText((contact.getEmail()));
           }

           if(tel != null){
               tel.setText((contact.getTelephone()));
           }
       }
        return convertView;

    }
}
