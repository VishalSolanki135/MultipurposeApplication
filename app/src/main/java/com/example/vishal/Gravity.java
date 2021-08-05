package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.widget.TextView;

public class Gravity extends AppCompatActivity implements SensorEventListener {
    MediaPlayer m1;
    SensorManager sm;
    Sensor s;
    Ringtone ringtone;

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        getSupportActionBar().hide();

        m1=MediaPlayer.create(this, R.raw.s);
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        t1=findViewById(R.id.textGravity);

        ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));

        sm.registerListener(this , s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>1) {
            ringtone.play();
            t1.setText("You just dropped your phone.");
        } else {
            ringtone.stop();
            t1.setText("Your phone is safe.");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}