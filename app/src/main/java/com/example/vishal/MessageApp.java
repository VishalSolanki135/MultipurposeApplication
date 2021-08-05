package com.example.vishal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageApp extends AppCompatActivity {

    EditText mobileno, message;
    Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_app);
        getSupportActionBar().hide();

        mobileno=(EditText)findViewById(R.id.phoneNumber);
        message=(EditText)findViewById(R.id.message0);
        sendsms=(Button)findViewById(R.id.sendsms);

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MessageApp.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                    sendMessage();
                }
                else
                {
                    ActivityCompat.requestPermissions(MessageApp.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });
    }

    private void sendMessage() {
        String phone_no = mobileno.getText().toString().trim();
        String Message = message.getText().toString().trim();

        if (!phone_no.equals("") && !Message.equals(""))
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone_no,null,Message,null,null);
            Toast.makeText(getApplicationContext(),"SMS sent successfully!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Enter value first.",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0]
                == PackageManager.PERMISSION_GRANTED) {
            sendMessage();
        } else {
            Toast.makeText(getApplicationContext(),"Permission Denied!",Toast.LENGTH_SHORT).show();
        }
    }
}