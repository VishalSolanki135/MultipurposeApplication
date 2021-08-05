package com.example.vishal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    TextView logIn, signUp;
    FirebaseAuth firebaseAuth;
    String s1, s2;
    TextView tv, otp;
    TextView googleSignIn;
    GoogleSignInClient googleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        otp=findViewById(R.id.otp);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        logIn = findViewById(R.id.button1);
        signUp = findViewById(R.id.signUp);
        tv = findViewById(R.id.text);
        googleSignIn = (TextView) findViewById(R.id.google);

        firebaseAuth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
                finish();
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = email.getText().toString();
                s2 = password.getText().toString();
                if (s1.isEmpty()) {
                    email.setError("Please enter your email");
                }
                if (s2.isEmpty()) {
                    password.setError("Please enter your password");
                }

                firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent j = new Intent(MainActivity.this, Feed.class);
                            startActivity(j);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Login not Successful", Toast.LENGTH_SHORT).show();
                            Intent k = new Intent(MainActivity.this, SignUp.class);
                            startActivity(k);
                            finish();
                        }
                    }
                });
            }
        });

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, OtherOptionsToSignUp.class);
                startActivity(a);
                finish();
            }
        });

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("1052622376207-uji9bdkr23q859itlci7judram1ka0a1.apps.googleusercontent.com").requestEmail().build();
        firebaseAuth= FirebaseAuth.getInstance();
        googleSignInClient=GoogleSignIn.getClient(MainActivity.this, googleSignInOptions);

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = googleSignInClient.getSignInIntent();
                startActivityForResult(i, 100);
            }
        });

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null) {
            Intent j = new Intent(MainActivity.this, Feed.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(j);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100) {
            Task<GoogleSignInAccount> signInAccountTask=GoogleSignIn.getSignedInAccountFromIntent(data);
            if(signInAccountTask.isSuccessful()) {
                Toast.makeText(this, "GoogleSign is done", Toast.LENGTH_SHORT).show();
                try{
                    GoogleSignInAccount googleSignInAccount=signInAccountTask.getResult(ApiException.class);
                    if(googleSignInAccount!=null) {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Firebase Signin is Successful!", Toast.LENGTH_SHORT).show();
                                    Intent j = new Intent(MainActivity.this, Feed.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(j);
                                } else {
                                    Toast.makeText(MainActivity.this, "Firebase Not Updated!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}