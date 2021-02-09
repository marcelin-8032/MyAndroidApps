package com.example.myframeworkapp.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myframeworkapp.OptionMenuActivity;
import com.example.myframeworkapp.R;


public class CalculatorStart extends OptionMenuActivity {

    TextView Result;
    Button Click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_start);

        Result = findViewById(R.id.resultAct2);
        Click = (Button) findViewById(R.id.button_Clickici);

        Click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intentCalculatrice = new Intent(CalculatorStart.this, CalculatorActivity.class);
                System.out.println("Button Cliqué");
                startActivity(intentCalculatrice);
            }
        });

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String str1 = (String) extra.get("Calcule"); // get a object
            Result.setText("Result : " + str1 );
        }
    }
}

