package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Feed extends AppCompatActivity {
    TextView logOut;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        getSupportActionBar().hide();
        firebaseAuth=FirebaseAuth.getInstance();
        googleSignInClient= GoogleSignIn.getClient(Feed.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        ArrayList<IntentClass> list = new ArrayList<>();
        list.add(new IntentClass("Calculator", R.drawable.calculator));
        list.add(new IntentClass("Video Capture", R.drawable.video));
        list.add(new IntentClass("Camera", R.drawable.camera));
        list.add(new IntentClass("Wifi", R.drawable.wifi));
        list.add(new IntentClass("Bluetooth", R.drawable.bluetooth));
        list.add(new IntentClass("Media", R.drawable.music));
        list.add(new IntentClass("Quiz", R.drawable.quiz));
        list.add(new IntentClass("Send Message", R.drawable.sms));
        list.add(new IntentClass("Phone Gestures", R.drawable.gestrues));
        list.add(new IntentClass("Log Out", R.drawable.logout));

        SettingAdapter settingAdapter = new SettingAdapter(this, list);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(settingAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent i = new Intent(view.getContext(), SimpleCalculator.class);
                    startActivity(i);
                }
                if(position==1) {
                    Intent j = new Intent(view.getContext(), VideoCapture.class);
                    startActivity(j);
                }
                if(position==2) {
                    Intent k = new Intent(view.getContext(), CameraActivity.class);
                    startActivity(k);
                }
                if(position==3){
                    Intent l = new Intent(view.getContext(), WifiActivity.class);
                    startActivity(l);
                }
                if(position==4) {
                    Intent m = new Intent(view.getContext(), BluetoothActivity.class);
                    startActivity(m);
                }
                if(position==5) {
                    Intent n = new Intent(view.getContext(), MediaPlayer.class);
                    startActivity(n);
                }
                if(position==6) {
                    Intent o = new Intent(view.getContext(), QuizApp.class);
                    startActivity(o);
                }
                if(position==7) {
                    Intent p = new Intent(view.getContext(), MessageApp.class);
                    startActivity(p);
                }
                if(position==8) {
                    Intent q = new Intent(view.getContext(), Gestures.class);
                    startActivity(q);
                }
                if(position==9) {
                    googleSignInClient.signOut();
                    firebaseAuth.signOut();
                    Intent i = new Intent(Feed.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}