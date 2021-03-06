package com.example.vishal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {
    EditText e1;
    Button b1;
    FirebaseAuth firebaseAuth;
    String phone;
    String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        phone=getIntent().getStringExtra("mobile".toString());
        e1=findViewById(R.id.otpToBeSubmit);
        b1=findViewById(R.id.otpSubmit);
        firebaseAuth=FirebaseAuth.getInstance();

        genOTP();//this will generate the OTP

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()) {
                    Toast.makeText(SecondActivity.this, "OTP can't be empty.", Toast.LENGTH_SHORT).show();
                } else {
                    if(e1.getText().toString().length()!=6) {
                        Toast.makeText(SecondActivity.this, "Invalid OTP!", Toast.LENGTH_SHORT).show();
                    } else {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp, e1.getText().toString());
                        signInWithPhoneAuthCredential(credential);
                    }
                }
            }
        });
    }

    private void genOTP() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,//all the parameters regarding the OTP
                //these method will send otp and verify them!
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {
                        Toast.makeText(SecondActivity.this, "Enter a valid OTP", Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(SecondActivity.this, "Phone number registered.", Toast.LENGTH_SHORT).show();
                    Intent o = new Intent(SecondActivity.this, Feed.class);
                    startActivity(o);
                    finish();
                } else {
                    Toast.makeText(SecondActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}