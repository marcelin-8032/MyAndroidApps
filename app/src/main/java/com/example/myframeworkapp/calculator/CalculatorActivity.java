package com.example.myframeworkapp.calculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myframeworkapp.R;
import com.example.myframeworkapp.calendar.CalendarActivity;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnPlus, btnMoins, btnMul, btnDiv, btnEgal, btnResult, btnSquare, btnreset, btnPercent, btnInverse, btnReverse_num;
    private TextView result;
    private TextView info;
    //--------------------------------------------------------------------------------------------
    private char Action;
    private final char Addition = '+';
    private final char Soustraction = '-';
    private final char Multiplication = '*';
    private final char Division = '/';
    private final char Egal = 0;
    private final char Square = 'S';
    private final char Reverse_num = 'R';
    //----------------------------------------------------------------------------------------------------------
    double val1 = Double.NaN;
    double val2;
    //--------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        //----------------------------------------------------------------------------------------------------
        initclick();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalculatorStart.class);
                intent.putExtra("Calcule", result.getText().toString());
                startActivity(intent);
                finish();
            }
        });

//------------------------------------------------------------------------------------------------------------------------------------
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText() + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
                Action = Addition;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
            }
        });

        btnMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
                Action = Soustraction;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
                Action = Multiplication;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
                Action = Division;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });

        btnEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
                Action = Egal;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);

            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                result.setText(String.valueOf(val1) + "=>" + val1/100);
                info.setText(null);
            }
        });

        btnInverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                result.setText(String.valueOf(val1) + "=>" + 1/val1);
                info.setText(null);
            }
        });


        btnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                result.setText(String.valueOf(val1) + "=>" + Math.pow(val1, 2));
                info.setText(null);
            }
        });

        btnReverse_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                Action = Reverse_num;
                result.setText(String.valueOf(val1));
                info.setText(null);
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    private void initclick() {
        info = (TextView) findViewById(R.id.info);
        result = (TextView) findViewById(R.id.resultText);

        btnResult = (Button) findViewById(R.id.button_result);
        btnSquare = (Button) findViewById(R.id.button_power_2);
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnMoins = (Button) findViewById(R.id.buttonMoins);
        btnDiv = (Button) findViewById(R.id.buttonDivision);
        btnMul = (Button) findViewById(R.id.buttonMultiplier);
        btnEgal = (Button) findViewById(R.id.buttonEgal);
        btnreset = (Button) findViewById(R.id.button_reset);
        btnPercent = (Button) findViewById(R.id.button_percent);
        btnInverse = (Button) findViewById(R.id.button_inverse_x);
        btnReverse_num = (Button) findViewById(R.id.button_negative_positive);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    private void calculer() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());

            switch (Action) {
                case Addition:
                    val1 = val1 + val2;
                    break;
                case Soustraction:
                    val1 = val1 - val2;
                    break;
                case Multiplication:
                    val1 = val1 * val2;
                    break;
                case Division:
                    val1 = val1 / val2;
                    break;
                case Egal:
                    break;
                case Reverse_num:
                    if (val1 == val1) {
                        val1 = -val1;
                    } else {
                        val1 = +val1;
                    }
                    break;
                default:
                    break;
            }
        } else {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {

    }
}
