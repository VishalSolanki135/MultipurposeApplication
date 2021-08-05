package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vibration extends AppCompatActivity {
    Button b1;
    Vibrator v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);
        getSupportActionBar().hide();

        b1=findViewById(R.id.vibration);
        v1= (Vibrator) getSystemService(VIBRATOR_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               v1.vibrate(5000);
            }
        });
    }
}