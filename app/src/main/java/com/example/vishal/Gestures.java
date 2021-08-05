package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Gestures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
        getSupportActionBar().hide();

        ArrayList<IntentClass> gestureList = new ArrayList<>();
        gestureList.add(new IntentClass("Gravity Gesture", R.drawable.gravity));
        gestureList.add(new IntentClass("Turn On Light", R.drawable.torch));
        gestureList.add(new IntentClass("Vibrator Gesture", R.drawable.vibrate));


        SettingAdapter gestureAdapter = new SettingAdapter(this, gestureList);
        ListView gestureView = (ListView) findViewById(R.id.list2);
        gestureView.setAdapter(gestureAdapter);

        gestureView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent j = new Intent(view.getContext(), Gravity.class);
                    startActivity(j);
                }
                if(position == 1) {
                    Intent k = new Intent(view.getContext(), Torch.class);
                    startActivity(k);
                }
                if(position == 2) {
                    Intent l = new Intent(view.getContext(), Vibration.class);
                    startActivity(l);
                }
            }
        });
    }
}