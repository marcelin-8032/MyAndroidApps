package com.example.myframeworkapp.bluetooth;


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myframeworkapp.OptionMenuActivity;
import com.example.myframeworkapp.R;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends OptionMenuActivity {

    public final static String TAG="BluetoothActivity";

    CheckBox enable_bt, visible_bt;
    ImageView search_bt;
    TextView name_bt;
    ListView listView;

    private BluetoothAdapter mBleuthoothAdapter;
    private Set<BluetoothDevice> pairedDevice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        enable_bt = findViewById(R.id.enable_bt);
        visible_bt = findViewById(R.id.visible_bt);
        name_bt = findViewById(R.id.name_bt);
        search_bt = findViewById(R.id.search_bt);
        listView = findViewById(R.id.list_view);

        name_bt.setText(getLocalBluetoothName());
        mBleuthoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if ( mBleuthoothAdapter == null) {
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (mBleuthoothAdapter .isEnabled()) {
            enable_bt.setChecked(true);
        }

        enable_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    mBleuthoothAdapter.disable();
                    Log.d(TAG, "bleutooth "+ isChecked);
                    Toast.makeText(BluetoothActivity.this, " Bluetooth is Turned off", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intentOn, 0);
                    Toast.makeText(BluetoothActivity.this, "Bleutooth is Turned on", Toast.LENGTH_SHORT).show();
                }
            }
        });


        visible_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(getVisible, 0);
                    Toast.makeText(BluetoothActivity.this, "Visibile for 2min", Toast.LENGTH_SHORT).show();
                }
            }
        });


        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list();
            }
        });
    }

    private void list() {
        pairedDevice = mBleuthoothAdapter.getBondedDevices();

        ArrayList list= new ArrayList();

        for (BluetoothDevice bt: pairedDevice){
            list.add(bt.getName());
        }
        Toast.makeText(this, "Showing Devices", Toast.LENGTH_SHORT).show();
        ArrayAdapter adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @SuppressLint("HardwareIds")
    public String getLocalBluetoothName(){
        if (mBleuthoothAdapter ==null){
            mBleuthoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }

        String name= mBleuthoothAdapter.getName();
        if(name==null){
            name=mBleuthoothAdapter.getAddress();
        }
        return name;
    }

}

