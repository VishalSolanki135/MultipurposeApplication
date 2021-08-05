package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class BluetoothActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    TextView t1;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        getSupportActionBar().hide();
        toggleButton=(ToggleButton) findViewById(R.id.toggleButtonBluetooth);
        t1=(TextView) findViewById(R.id.resultOfBluetooth);
        i1=(ImageView) findViewById(R.id.bluetoothImage);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    t1.setText("Bluetooth is ON");
                    i1.setImageResource(R.drawable.bon);
                    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                    adapter.enable();
                } else {
                    t1.setText("Bluetooth is OFF");
                    i1.setImageResource(R.drawable.boff);
                    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                    adapter.disable();
                }
            }
        });

        if(toggleButton.isChecked()) {
            t1.setText("Bluetooth is ON");
            i1.setImageResource(R.drawable.bon);
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            adapter.enable();
        } else{
            t1.setText("Bluetooth is OFF");
            i1.setImageResource(R.drawable.boff);
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            adapter.disable();
        }
    }
}