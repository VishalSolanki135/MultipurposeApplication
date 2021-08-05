package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Quiz3 extends AppCompatActivity {
    EditText e1;
    Button b1;
    static int score2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        getSupportActionBar().hide();

        e1=findViewById(R.id.answer);
        b1=findViewById(R.id.result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().equals("Tomorrow") || e1.getText().toString().equals("tomorrow")) {
                    score2=1;
                } else {
                    score2=0;
                }
                Intent i = new Intent(Quiz3.this, Result.class);
                startActivity(i);
                finish();
            }
        });
    }
}