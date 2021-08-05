package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RealtimeDatabase extends AppCompatActivity {
    Button b1;
    FirebaseAuth firebaseAuth;
    EditText e1, e2, e3, e4, e5;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime_database);

        b1=findViewById(R.id.submitRealTimeDatabase);
        e1=findViewById(R.id.enterYourName);
        e2=findViewById(R.id.enterYourEmail);
        e3=findViewById(R.id.enterYourNumber);
        e4=findViewById(R.id.age);
        e5=findViewById(R.id.gender);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RealtimeDatabase.this, SignUp.class);
                startActivity(i);
                finish();

                databaseReference=firebaseDatabase.getReference("users");

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();

                if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()) {
                    Toast.makeText(RealtimeDatabase.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                if(s3.length()!=10) {
                    Toast.makeText(RealtimeDatabase.this, "Phone should be of 10 numbers.", Toast.LENGTH_SHORT).show();
                }

                users users = new users(s1, s2, s3, s4, s5);
                databaseReference.child(s3).setValue(users);
                Toast.makeText(RealtimeDatabase.this, "Database Saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}