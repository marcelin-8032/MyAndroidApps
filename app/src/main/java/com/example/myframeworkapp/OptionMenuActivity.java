package com.example.myframeworkapp;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.MenuItemCompat;

import com.example.myframeworkapp.alarm.AlarmActivity;
import com.example.myframeworkapp.asyncTask.AsyncTaskActivity;
import com.example.myframeworkapp.bluetooth.BluetoothActivity;
import com.example.myframeworkapp.calculator.CalculatorActivity;
import com.example.myframeworkapp.calendar.CalendarActivity;
import com.example.myframeworkapp.callphone.CallActivity;
import com.example.myframeworkapp.compass.CompassActivity;
import com.example.myframeworkapp.contentprovider.ContentActivity;
import com.example.myframeworkapp.filemanager.FileManagerActivity;
import com.example.myframeworkapp.game.game1.Game_Main_Activity;
import com.example.myframeworkapp.game.game2.Game2MainActivity;
import com.example.myframeworkapp.gyroscope.GyroscopeActivity;
import com.example.myframeworkapp.login.LoginActivity;
import com.example.myframeworkapp.notfication.NotificationActivity;
import com.example.myframeworkapp.quiz.QuizActivity;
import com.example.myframeworkapp.wifi.Wifi_activity;

public class OptionMenuActivity extends AppCompatActivity {

    private static final String LOG_TAG = "OptionMenu";
    private SearchView searchView;
    private String lastquery;

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }


        @SuppressLint("ServiceCast")
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        this.searchView = (SearchView) menu.findItem(R.id.menuItem_search).getActionView();

        this.searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        this.searchView.setIconifiedByDefault(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String text) {
                Log.i(LOG_TAG, "onQueryTextChange: " + text);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                Log.i(LOG_TAG, "onQueryTextSubmit: " + query);
                return doSearch(query);
            }
        });

//        searchView.setOnQueryTextListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i(LOG_TAG, "SearchView.onSearchClickListener!" );
//            }
//        });
        return super.onCreateOptionsMenu(menu);
    }

    private boolean doSearch(String query) {
        if (query == null || query.isEmpty()) {
            return false;
        }
        this.lastquery = query;

        Toast.makeText(this, "search: " + query, Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_home:
                Intent intentHome = new Intent(getApplicationContext(), StartScreeningAcitivty.class);
                startActivity(intentHome);
                finish();
                return true;
            case R.id.item_profile:
                Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentLogin);
                return true;
            case R.id.item_call:
                Intent intentCall = new Intent(getApplicationContext(), CallActivity.class);
                startActivity(intentCall);
                return true;
            case R.id.item_bluetooth:
                Intent intentB = new Intent(getApplicationContext(), BluetoothActivity.class);
                startActivity(intentB);
                return true;
            case R.id.item_calculator:
                Intent intentCal = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(intentCal);
                return true;
            case R.id.item_calendar:
                Intent intentCalen = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intentCalen);
                return true;
            case R.id.item_compass:
                Intent intentCompass = new Intent(getApplicationContext(), CompassActivity.class);
                startActivity(intentCompass);
                return true;
            case R.id.item_content:
                Intent intentContent = new Intent(getApplicationContext(), ContentActivity.class);
                startActivity(intentContent);
                return true;
            case R.id.item_alarm:
                Intent intentAlarm = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivity(intentAlarm);
                return true;
            case R.id.item_filemange:
                Intent intentFileManager = new Intent(getApplicationContext(), FileManagerActivity.class);
                startActivity(intentFileManager);
                return true;
            case R.id.item_notif:
                Intent intentNotif = new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(intentNotif);
                return true;
            case R.id.item_download:
                Intent intentdowload = new Intent(getApplicationContext(), AsyncTaskActivity.class);
                startActivity(intentdowload);
                return true;
            case R.id.item_game1:
                Intent intentGame1 = new Intent(getApplicationContext(), Game_Main_Activity.class);
                startActivity(intentGame1);
                return true;
            case R.id.item_game2:
                Intent intentGame2 = new Intent(getApplicationContext(), Game2MainActivity.class);
                startActivity(intentGame2);
            case R.id.item_gyroscope:
                Intent intentgryscope = new Intent(getApplicationContext(), GyroscopeActivity.class);
                startActivity(intentgryscope);
                return true;
            case R.id.item_quiz:
                Intent intentQuiz = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intentQuiz);
                return true;
            case R.id.item_wifi:
                Intent intentWifii = new Intent(getApplicationContext(), Wifi_activity.class);
                startActivity(intentWifii);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
