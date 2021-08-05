package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherOptionsToSignUp extends AppCompatActivity {
    TextView t1, t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_options_to_sign_up);

        t1=findViewById(R.id.OTPSignUp);
        t2=findViewById(R.id.realtimeDatabase);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OtherOptionsToSignUp.this, OTPActivity.class);
                startActivity(i);
                finish();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(OtherOptionsToSignUp.this, RealtimeDatabase.class);
                startActivity(j);
                finish();
            }
        });
    }
}