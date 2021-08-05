package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediaPlayer extends AppCompatActivity {
    Button b1,b2,b3;
    android.media.MediaPlayer m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        getSupportActionBar().hide();

        b1=(Button) findViewById(R.id.play);
        b2=(Button) findViewById(R.id.pause);
        b3=(Button) findViewById(R.id.choose);

        m1= android.media.MediaPlayer.create(this, R.raw.s);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(i);
            }
        });
    }
}