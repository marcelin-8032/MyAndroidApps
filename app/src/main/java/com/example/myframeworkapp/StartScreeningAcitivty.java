package com.example.myframeworkapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myframeworkapp.alarm.AlarmActivity;
import com.example.myframeworkapp.asyncTask.AsyncTaskActivity;
import com.example.myframeworkapp.bluetooth.BluetoothActivity;
import com.example.myframeworkapp.calculator.CalculatorActivity;
import com.example.myframeworkapp.calculator.CalculatorStart;
import com.example.myframeworkapp.calendar.CalendarActivity;
import com.example.myframeworkapp.callphone.CallActivity;
import com.example.myframeworkapp.compass.CompassActivity;
import com.example.myframeworkapp.contentprovider.ContentActivity;
import com.example.myframeworkapp.filemanager.FileManagerActivity;
import com.example.myframeworkapp.game.Activity_game_board;
import com.example.myframeworkapp.game.game1.Game_Main_Activity;
import com.example.myframeworkapp.game.game2.Game2MainActivity;
import com.example.myframeworkapp.gyroscope.GyroscopeActivity;
import com.example.myframeworkapp.login.LoginActivity;
import com.example.myframeworkapp.notfication.NotificationActivity;
import com.example.myframeworkapp.quiz.QuizActivity;
import com.example.myframeworkapp.wifi.Wifi_activity;
import com.google.android.material.navigation.NavigationView;


public class StartScreeningAcitivty extends OptionMenuActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;

    ImageView imageView_log, imageVie_Bl, imageView_Calen,
            imageView_calcul, imageView_contentP, imageView_compass,
            imageView_callphone, imageView_notif, imageView_file, imageView_alarm, imageView_download11,
            imageView_game, imageView_gyr, imageView_quizzz, imageView_wifii;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_start);
//---------------------------hooks------------------------------------------------
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
        navigationView.setCheckedItem(R.id.nav_view);

//------------------Navigation Drawer menu------------------------------
//        Menu menu=navigationView.getMenu();
//        menu.findItem(R.id.nav_logout).setVisible(false);
//        menu.findItem(R.id.nav_profile).setVisible(false);

//---------------------------------------------------------------------------------------------
        imageView_log = findViewById(R.id.imageView_login);
        imageView_log.setOnClickListener(this);

        imageVie_Bl = findViewById(R.id.imageView_Bluetooth);
        imageVie_Bl.setOnClickListener(this);

        imageView_Calen = findViewById(R.id.imageView_Calender);
        imageView_Calen.setOnClickListener(this);

        imageView_calcul = findViewById(R.id.imageView_calcul);
        imageView_calcul.setOnClickListener(this);

        imageView_contentP = findViewById(R.id.imageView_contentProvider);
        imageView_contentP.setOnClickListener(this);

        imageView_compass = findViewById(R.id.imageView_Compass_start);
        imageView_compass.setOnClickListener(this);

        imageView_callphone = findViewById(R.id.imageView_call2);
        imageView_callphone.setOnClickListener(this);

        imageView_notif = findViewById(R.id.imageView_Notification);
        imageView_notif.setOnClickListener(this);

        imageView_file = findViewById(R.id.imageView_filemanager);
        imageView_file.setOnClickListener(this);

        imageView_alarm = findViewById(R.id.imageView_alarmclock);
        imageView_alarm.setOnClickListener(this);

        imageView_download11 = findViewById(R.id.imageView_download);
        imageView_download11.setOnClickListener(this);

        imageView_game = findViewById(R.id.imageView_game);
        imageView_game.setOnClickListener(this);

        imageView_gyr = findViewById(R.id.imageView_Gyrosocope);
        imageView_gyr.setOnClickListener(this);

        imageView_quizzz = findViewById(R.id.imageView_quiz);
        imageView_quizzz.setOnClickListener(this);

        imageView_wifii = findViewById(R.id.imageView_wifi);
        imageView_wifii.setOnClickListener(this);
    }

    //----------------------------------------------------navigation drawer------------------------------------------------------
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.nav_profile) {
            Intent intentLogin = new Intent(StartScreeningAcitivty.this, LoginActivity.class);
            startActivity(intentLogin);
        } else if (id == R.id.nav_Bluetooth) {
            Intent intentBlue = new Intent(StartScreeningAcitivty.this, BluetoothActivity.class);
            startActivity(intentBlue);
        } else if (id == R.id.nav_Calendar) {
            Intent intentCalender = new Intent(StartScreeningAcitivty.this, CalendarActivity.class);
            startActivity(intentCalender);
        } else if (id == R.id.nav_calculator) {
            Intent intentCalcule = new Intent(StartScreeningAcitivty.this, CalculatorStart.class);
            startActivity(intentCalcule);
        } else if (id == R.id.nav_content_provider) {
            Intent intentContent = new Intent(StartScreeningAcitivty.this, ContentActivity.class);
            startActivity(intentContent);
        } else if (id == R.id.nav_compass) {
            Intent intentCompass = new Intent(StartScreeningAcitivty.this, CompassActivity.class);
            startActivity(intentCompass);
        } else if (id == R.id.nav_call) {
            Intent intentCall = new Intent(StartScreeningAcitivty.this, CallActivity.class);
            startActivity(intentCall);
        } else if (id == R.id.nav_notification) {
            Intent intentNotif = new Intent(StartScreeningAcitivty.this, NotificationActivity.class);
            startActivity(intentNotif);
        } else if (id == R.id.nav_file_manager) {
            Intent intentfilemanager = new Intent(StartScreeningAcitivty.this, FileManagerActivity.class);
            startActivity(intentfilemanager);
        } else if (id == R.id.nav_alarm) {
            Intent intentAlarm = new Intent(StartScreeningAcitivty.this, AlarmActivity.class);
            startActivity(intentAlarm);
        } else if (id == R.id.nav_download) {
            Intent intentDowload = new Intent(StartScreeningAcitivty.this, AsyncTaskActivity.class);
            startActivity(intentDowload);
        } else if (id == R.id.nav_gyroscope) {
            Intent intentGyro = new Intent(StartScreeningAcitivty.this, GyroscopeActivity.class);
            startActivity(intentGyro);
        } else if (id == R.id.nav_wifi) {
            Intent intentWifi = new Intent(StartScreeningAcitivty.this, Wifi_activity.class);
            startActivity(intentWifi);
        } else if (id == R.id.nav_game1) {
            Intent intentBirdgame = new Intent(StartScreeningAcitivty.this, Game_Main_Activity.class);
            startActivity(intentBirdgame);
        } else if (id == R.id.nav_game2) {
            Intent intentTicToc = new Intent(StartScreeningAcitivty.this, Game2MainActivity.class);
            startActivity(intentTicToc);
        } else if (id == R.id.nav_Quiz) {
            Intent intentquiz = new Intent(StartScreeningAcitivty.this, QuizActivity.class);
            startActivity(intentquiz);
        }
        return true;
    }
    //--------------------------------------main_menu----------------------------------------------------

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageView_login:
                Intent intentLogin = new Intent(StartScreeningAcitivty.this, LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.imageView_Bluetooth:
                Intent intentBlue = new Intent(StartScreeningAcitivty.this, BluetoothActivity.class);
                startActivity(intentBlue);
                break;
            case R.id.imageView_Calender:
                Intent intentCalender = new Intent(StartScreeningAcitivty.this, CalendarActivity.class);
                startActivity(intentCalender);
                break;
            case R.id.imageView_calcul:
                Intent intentCalcule = new Intent(StartScreeningAcitivty.this, CalculatorStart.class);
                startActivity(intentCalcule);
                break;
            case R.id.imageView_contentProvider:
                Intent intentContent = new Intent(StartScreeningAcitivty.this, ContentActivity.class);
                startActivity(intentContent);
                break;
            case R.id.imageView_Compass_start:
                Intent intentCompass = new Intent(StartScreeningAcitivty.this, CompassActivity.class);
                startActivity(intentCompass);
                break;
            case R.id.imageView_call2:
                Intent intentCall = new Intent(StartScreeningAcitivty.this, CallActivity.class);
                startActivity(intentCall);
                break;
            case R.id.imageView_Notification:
                Intent intentNotif = new Intent(StartScreeningAcitivty.this, NotificationActivity.class);
                startActivity(intentNotif);
                break;
            case R.id.imageView_filemanager:
                Intent intentfilemanager = new Intent(StartScreeningAcitivty.this, FileManagerActivity.class);
                startActivity(intentfilemanager);
                break;
            case R.id.imageView_alarmclock:
                Intent intentAlarm = new Intent(StartScreeningAcitivty.this, AlarmActivity.class);
                startActivity(intentAlarm);
                break;
            case R.id.imageView_download:
                Intent intentDowload = new Intent(StartScreeningAcitivty.this, AsyncTaskActivity.class);
                startActivity(intentDowload);
                break;
            case R.id.imageView_game:
                Intent intentgame = new Intent(StartScreeningAcitivty.this, Activity_game_board.class);
                startActivity(intentgame);
                break;
            case R.id.imageView_Gyrosocope:
                Intent intentGyro = new Intent(StartScreeningAcitivty.this, GyroscopeActivity.class);
                startActivity(intentGyro);
                break;
            case R.id.imageView_quiz:
                Intent intentquiz = new Intent(StartScreeningAcitivty.this, QuizActivity.class);
                startActivity(intentquiz);
                break;
            case R.id.imageView_wifi:
                Intent intentWifi = new Intent(StartScreeningAcitivty.this, Wifi_activity.class);
                startActivity(intentWifi);
                break;

            default:
                break;
        }
    }

}
