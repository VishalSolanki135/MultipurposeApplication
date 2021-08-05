package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {
    TextView t1;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1=findViewById(R.id.score);
        int score = QuizApp.score + Quiz2.score1 + Quiz3.score2;
        t1.setText("You Score: " + score);
        b1=findViewById(R.id.playAgain);
        b2=findViewById(R.id.leaveQuiz);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Result.this, QuizApp.class);
                startActivity(i);
                finish();
                Toast.makeText(Result.this, "Starting the Quiz Again", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Result.this, Feed.class);
                startActivity(j);
            }
        });

    }
}