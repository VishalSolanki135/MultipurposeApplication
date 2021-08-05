package com.example.vishal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class OTPActivity extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);


        e1=findViewById(R.id.number);
        ccp=findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e1);
        b1=findViewById(R.id.sendOTP);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OTPActivity.this, SecondActivity.class);
                i.putExtra("mobile", ccp.getFullNumberWithPlus());
                startActivity(i);
            }
        });
    }
}