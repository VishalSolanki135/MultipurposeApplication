package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz2 extends AppCompatActivity {
    RadioButton r1, r2, r3, r4;
    Button b1;
    static int score1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        getSupportActionBar().hide();

        r1=findViewById(R.id.radio5);
        r2=findViewById(R.id.radio6);
        r3=findViewById(R.id.radio7);
        r4=findViewById(R.id.radio8);
        b1=findViewById(R.id.nextQuestion2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r4.isChecked()) {
                    score1=1;
                } else {
                    score1=0;
                }
                Intent i = new Intent(Quiz2.this, Quiz3.class);
                startActivity(i);
                finish();
            }
        });
    }
}