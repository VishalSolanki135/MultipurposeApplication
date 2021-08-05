package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuizApp extends AppCompatActivity {
    RadioButton r1, r2, r3, r4;
    Button b1;
    static int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);
        getSupportActionBar().hide();

        r1=findViewById(R.id.radio1);
        r2=findViewById(R.id.radio2);
        r3=findViewById(R.id.radio3);
        r4=findViewById(R.id.radio4);
        b1=findViewById(R.id.nextQuestion1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                score=0;
                if(r2.isChecked()) {
                    score=1;
                } else {
                    score=0;
                }
                Intent i = new Intent(QuizApp.this, Quiz2.class);
                startActivity(i);
                finish();
            }
        });
    }
}