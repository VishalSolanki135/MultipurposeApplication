package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class WifiActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    TextView t1;
    ImageView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        getSupportActionBar().hide();

        toggleButton=(ToggleButton) findViewById(R.id.toggleButtonWifi);
        t1=(TextView) findViewById(R.id.resultOfWifi);
        v1=findViewById(R.id.wifiId);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    t1.setText("Wifi Is On.");
                    v1.setImageResource(R.drawable.wifion);
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                } else {
                    t1.setText("Wifi is OFF.");
                    v1.setImageResource(R.drawable.wifioff);
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
            }
        });
        //For Initial
        if(toggleButton.isChecked()) {
            t1.setText("Wifi is On.");
            v1.setImageResource(R.drawable.wifion);
            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(true);
        } else {
            t1.setText("Wifi is OFF.");
            v1.setImageResource(R.drawable.wifioff);
            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(false);
        }
    }
}