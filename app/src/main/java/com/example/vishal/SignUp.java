package com.example.vishal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText email, password;
    TextView signUp, logIn;
    FirebaseAuth firebaseAuth;
    String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        signUp = (TextView) findViewById(R.id.button2);
        logIn = (TextView) findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=email.getText().toString();
                s2=password.getText().toString();
                if(s1.isEmpty()) {
                    email.setError("Please enter the email");
                }
                if(s2.isEmpty()) {
                    password.setError("Please enter the password");
                }

                firebaseAuth.createUserWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "SignUp Successful.", Toast.LENGTH_SHORT).show();
                            Intent j = new Intent(SignUp.this, MainActivity.class);
                            startActivity(j);
                            finish();
                        } else {
                            Toast.makeText(SignUp.this, "SignUp not successful.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}