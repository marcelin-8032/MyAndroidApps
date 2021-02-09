package com.example.myframeworkapp.calendar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myframeworkapp.OptionMenuActivity;
import com.example.myframeworkapp.R;

import java.util.Calendar;

public class CalendarActivity extends OptionMenuActivity {

    private DatePicker datePicker;
    private EditText editTextDate;
    private Button buttonDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        this.editTextDate = (EditText) this.findViewById(R.id.editText);
        this.buttonDate = (Button) this.findViewById(R.id.button2);
        this.datePicker = (DatePicker) this.findViewById(R.id.datePicker11);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        this.datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                datePickerChange(datePicker, year, month, dayOfMonth);
            }
        });

        this.buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });
    }

    private void datePickerChange(DatePicker datePicker, int year, int month, int dateOfMonth){
        Log.d("Date ", "Year= " + year + "Month= " + (month+1)+ "day=" + dateOfMonth);
        this.editTextDate.setText(dateOfMonth + "-" + (month + 1) + "- " + year);
    }

    private void showDate(){
        int year = this.datePicker.getYear();
        int month = this.datePicker.getMonth();
        int day= this.datePicker.getDayOfMonth();

        Toast.makeText(this, "Date: " + day + "-" + (month + 1) + "-" + year, Toast.LENGTH_LONG).show();

    }
}
