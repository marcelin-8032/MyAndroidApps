package com.example.myframeworkapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myframeworkapp.OptionMenuActivity;
import com.example.myframeworkapp.R;

import DAO.DatabaseHelper;

public class LoginActivity extends OptionMenuActivity{

    private EditText eTtextNom, eTtextPr, eTtextTel, eTtextEm;
    private ImageButton btnEnter;
    private Button btnview;
    DatabaseHelper myDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eTtextNom =(EditText) findViewById(R.id.Nom);
        eTtextPr =(EditText) findViewById(R.id.prenom);
        eTtextTel = (EditText )findViewById(R.id.Telephone);
        eTtextEm = (EditText)findViewById(R.id.email);
        btnEnter = (ImageButton) findViewById(R.id.imageButton1);
        btnview=(Button)findViewById(R.id.button_view);
        myDB = new DatabaseHelper(this);

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(LoginActivity.this, SecondActivity.class);
//                String nom= textNom.getText().toString();
//                String prenom=textPr.getText().toString();
//                String tel=String.valueOf(Integer.parseInt(textTel.getText().toString()));
//                String email=textEm.getText().toString();
//                listIntent.putExtra("Nom",  nom);
//                listIntent.putExtra("Prenom", prenom);
//                listIntent.putExtra("Telephone", tel);
//                listIntent.putExtra("Email", email);
               // startActivity(listIntent);
            }
        });

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FNom= eTtextNom.getText().toString();
                String IPrenom=eTtextPr.getText().toString();
                String Eeemail=eTtextEm.getText().toString();
                String Tttel=String.valueOf(Integer.parseInt(eTtextTel.getText().toString()));

              if (FNom.length() !=0 && IPrenom.length() !=0 && Tttel.length()!=0 && Eeemail.length()!=0){
                  AddData(FNom, IPrenom, Eeemail, Tttel);
                    eTtextNom.setText("");
                    eTtextPr.setText("");
                    eTtextTel.setText("");
                    eTtextEm.setText("");
               } else {
                    Toast.makeText(LoginActivity.this,"Please enter your data", Toast.LENGTH_SHORT).show();
                }
           }
            });
       }

        public void AddData(String LastN, String Fnam, String MyEmail, String MyTel){
        boolean insertData=myDB.addData(LastN,Fnam,MyEmail,MyTel);

        if(insertData==true){
            Toast.makeText(LoginActivity.this,"Data inserted into data base", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(LoginActivity.this,"Data is NOT inserted into the Database",
                    Toast.LENGTH_LONG).show();
        }
    }


}

