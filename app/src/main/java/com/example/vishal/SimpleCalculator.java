package com.example.vishal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class SimpleCalculator extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bC,b0,bDot,bAdd,bSub,bMul,bDiv,bSin,bCos,bTan,bX,bEq;
    EditText e1, e2;
    TextView tv;
    TextToSpeech ts;
    Double Res1, Res2;
    boolean Add, Sub, Mul, Div, Sin, Cos, Tan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        getSupportActionBar().hide();

        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        b3=findViewById(R.id.button5);
        b4=findViewById(R.id.button6);
        b5=findViewById(R.id.button7);
        b6=findViewById(R.id.button8);
        b7=findViewById(R.id.button9);
        b8=findViewById(R.id.button10);
        b9=findViewById(R.id.button11);
        bC=findViewById(R.id.button12);
        b0=findViewById(R.id.button13);
        bDot=findViewById(R.id.button14);
        bAdd=findViewById(R.id.button19);
        bSub=findViewById(R.id.button20);
        bMul=findViewById(R.id.button21);
        bDiv=findViewById(R.id.button22);
        bSin=findViewById(R.id.button15);
        bCos=findViewById(R.id.button16);
        bTan=findViewById(R.id.button17);
        bX=findViewById(R.id.button23);
        bEq=findViewById(R.id.button18);

        tv=findViewById(R.id.result);
        ts=new TextToSpeech(this, status -> {
            ts.setLanguage(Locale.ENGLISH);
            ts.setSpeechRate(1.0f);
        });

        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText() + "0");
            }
        });

        bSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sin=true;
                e1.setText(null);
                e2.setText("sin");
            }
        });

        bCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cos=true;
                e1.setText(null);
                e2.setText("cos");
            }
        });

        bTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tan=true;
                e1.setText(null);
                e2.setText("tan");
            }
        });

        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText() + ".");
            }
        });

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1==null) {
                    e1.setText("");
                } else {
                    Res1=Double.parseDouble(e1.getText().toString());
                    Add=true;
                    e1.setText("");
                }
            }
        });

        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1==null) {
                    e1.setText("");
                } else {
                    Res1=Double.parseDouble(e1.getText().toString());
                    Sub=true;
                    e1.setText("");
                }
            }
        });

        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1==null) {
                    e1.setText("");
                } else {
                    Res1=Double.parseDouble(e1.getText().toString());
                    Mul=true;
                    e1.setText("");
                }
            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1==null) {
                    e1.setText("");
                } else {
                    Res1=Double.parseDouble(e1.getText().toString());
                    Div=true;
                    e1.setText("");
                }
            }
        });

        bX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1==null){
                    e1.setText("");
                }else{
                    Res1=Double.parseDouble(e1.getText().toString());
                    StringBuffer s = new StringBuffer(e1.getText());
                    e1.setText(s.deleteCharAt(s.length()-1));
                }
            }
        });

        bEq.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.DONUT)
            @Override
            public void onClick(View view) {
                Res2=Double.parseDouble(e1.getText()+"");
                String s = "";
                if(Add==true) {
                    s=Res1+Res2+"";
                    tv.setText(s);
                    Add=false;
                }
                if(Sub==true){
                    s=Res1-Res2 + "";
                    tv.setText(s);
                    Sub=false;
                }
                if(Mul==true){
                    s=Res1*Res2 + "";
                    tv.setText(s);
                    Mul=false;
                }
                if(Div==true){
                    s=Res1/Res2+"";
                    tv.setText(s);
                    Div=false;
                }
                if(Sin==true) {
                    Res1 = Double.parseDouble(e1.getText().toString());
                    s = Math.sin(Math.toRadians(Res1)) + "";
                    tv.setText(s);
                    Sin=false;
                    e2.setText(null);
                }
                if(Cos==true) {
                    Res1 = Double.parseDouble(e1.getText().toString());
                    s = Math.cos(Math.toRadians(Res1)) + "";
                    tv.setText(s);
                    Cos=false;
                    e2.setText(null);
                }
                if(Tan==true) {

                    Res1 = Double.parseDouble(e1.getText().toString());
                    s = Math.tan(Math.toRadians(Res1)) + "";
                    tv.setText(s);
                    Tan=false;
                    e2.setText(null);
                }
                ts.speak("The Result is " + s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });
    }
}