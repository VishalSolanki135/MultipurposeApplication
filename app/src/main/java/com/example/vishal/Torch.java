package com.example.vishal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Torch extends AppCompatActivity {
    CameraManager cm;
    TextView t1, t2;
    private boolean camera;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        getSupportActionBar().hide();

        t1=findViewById(R.id.turnOn);
        t2=findViewById(R.id.turnOff);

        cm=(CameraManager) getSystemService(CAMERA_SERVICE);

        t1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                try{
                    String s1 = cm.getCameraIdList()[0];
                    cm.setTorchMode(s1, true);
                    camera=true;
                } catch (CameraAccessException e) {

                }
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                try{
                    String s2 = cm.getCameraIdList()[0];
                    cm.setTorchMode(s2, false);
                    camera=true;
                } catch (CameraAccessException e) {

                }
            }
        });

    }
}